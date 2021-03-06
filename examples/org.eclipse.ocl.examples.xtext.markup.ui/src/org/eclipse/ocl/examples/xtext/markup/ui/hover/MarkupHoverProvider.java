/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.xtext.markup.ui.hover;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.HTMLBuffer;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.markup.Markup;
import org.eclipse.ocl.examples.xtext.markup.MarkupUtils;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;

public class MarkupHoverProvider extends DefaultEObjectHoverProvider
{
	@Override
	protected String getDocumentation(EObject o) {
		Resource resource = o.eResource();
		if (resource == null) {
			return null;
		}
		if (o instanceof Pivotable) {
			EObject o1 = ((Pivotable)o).getPivot();
			if (o1 != null) {
				o = o1;
			}
			if (o instanceof ReferringElement) {
				EObject o2 = ((ReferringElement)o).getReferredElement();
				if (o2 != null) {
					o = o2;
				}
			}
			if (o instanceof TemplateableElement) {
				EObject o3 = ((TemplateableElement)o).getUnspecializedElement();
				if (o3 != null) {
					o = o3;
				}
			}
		}
		String documentation = super.getDocumentation(o);
		if (documentation == null) {
			return null;
		}
		IParseResult parseResult = MarkupUtils.decode(documentation);
		if (parseResult == null) {
			return null;
		}
		Markup markup = (Markup) parseResult.getRootASTElement();
		if (markup == null) {
			return null;
		}
		Iterable<INode> parseErrors = parseResult.getSyntaxErrors();
		Map<Integer, Integer> errorMap = getErrorMap(parseErrors);
		if (errorMap != null) {
			HTMLBuffer htmlBuffer = new HTMLBuffer();
			int i = 0;
			List<Integer> starts = new ArrayList<Integer>(errorMap.keySet());
			Collections.sort(starts);
			for (int start : starts) {
				int end = errorMap.get(start);
				while (i < start) {
					htmlBuffer.append(documentation.charAt(i++));
				}
				htmlBuffer.startFontColor("red"); 
				htmlBuffer.startUnderline();
				while (i < end) {
					htmlBuffer.append(documentation.charAt(i++));
				}
				htmlBuffer.endUnderline();
				htmlBuffer.endFontColor(); 
			}
			htmlBuffer.startFontColor("red"); 
			htmlBuffer.startParagraph();
			htmlBuffer.endParagraph();
			for (INode parseError :parseErrors) {
				htmlBuffer.startParagraph();
				htmlBuffer.append(parseError.getSyntaxErrorMessage().getMessage());
				htmlBuffer.endParagraph();
			}
			htmlBuffer.endFontColor(); 
			return htmlBuffer.toString();
		}
		if (o instanceof Pivotable) {
			o = ((Pivotable)o).getPivot();
		}
		if (o == null) {
			return null;
		}
		try {
			MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(resource);
			if (metaModelManager == null) {
				return null;
			}
			return MarkupUtils.toHTML(metaModelManager, o, markup);
		} catch (Exception e) {
			StringWriter s = new StringWriter();
			e.printStackTrace(new PrintWriter(s));
			return s.toString().replace("\n", "\n<br>");
		}
	}

	protected Map<Integer, Integer> getErrorMap(Iterable<INode> parseErrors) {
		Map<Integer, Integer> errorMap = null;
		for (INode parseError : parseErrors) {
			if (errorMap == null) {
				errorMap = new HashMap<Integer, Integer>();
			}
			int start = parseError.getOffset();
			errorMap.put(start, start + parseError.getLength());
		}
		if (errorMap != null) {
			List<Integer> starts = new ArrayList<Integer>(errorMap.keySet());
			Collections.sort(starts);
			Integer currentStart = null;
			int currentEnd = 0;
			for (int i = 0; i < starts.size(); i++) {
				Integer start = starts.get(i);
				if (currentStart == null) {
					currentStart = start;
					currentEnd = errorMap.get(start);
				}
				else {
					currentEnd = errorMap.get(start);
					if (start > currentEnd) {
						currentStart = start;
					}
					else {
						errorMap.remove(start);
						errorMap.put(currentStart, currentEnd);
					}
				}
			}
		}
		return errorMap;
	}

	@Override
	protected String getFirstLine(EObject eObject) {
//		System.out.println("getFirstLine " + eObject.eClass().getName());
		Element pivotElement = null;
		if (eObject instanceof Pivotable) {
			pivotElement = PivotUtil.getPivot(Element.class, (Pivotable)eObject);
		}
		else if (eObject instanceof Element) {
			pivotElement = (Element)eObject;
		}
		if (pivotElement != null) {
			Namespace namespace = getNamespace(pivotElement);
			if ((namespace != null) && (namespace.eContainer() instanceof Namespace)) {
				namespace = (Namespace) namespace.eContainer();
			}
			String description = null;
			PrettyPrintOptions.Global prettyPrintOptions = new PrettyPrintOptions.Global(namespace)
			{
				@Override
				public @Nullable Set<String> getReservedNames() {
					return null;
				}

				@Override
				public @Nullable Set<String> getRestrictedNames() {
					return null;
				}				
			};
			if (namespace != null) {
				MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(namespace);
				if (metaModelManager != null) {
					prettyPrintOptions.setMetaModelManager(metaModelManager);
				}
			}
			if (pivotElement instanceof CallExp) {
				description = PrettyPrinter.printType(pivotElement, prettyPrintOptions);
			}
			else if (pivotElement instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)pivotElement).getReferredVariable();
				if (referredVariable != null) {
					description = PrettyPrinter.print(referredVariable, prettyPrintOptions);
				}
			}
			else if (pivotElement instanceof OCLExpression) {
				Type type = ((OCLExpression)pivotElement).getType();
				if (type != null) {
					description = PrettyPrinter.printType(type, prettyPrintOptions);
				}
			}
			if (description == null) {
				description = PrettyPrinter.print(pivotElement, prettyPrintOptions);
			}
//			System.out.println(" => " + description);
			return pivotElement.eClass().getName() + " <b>" + description + "</b>";
		}
		else {
			String firstLine = super.getFirstLine(eObject);
//			System.out.println(" => " + firstLine);
			return firstLine + "\n<br>" + eObject.eClass().getName();		// FIXME do better					
		}
	}

	public static Namespace getNamespace(EObject element) {
		int count = 0;
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Namespace) {
				if (count++ >= 2) {
					return (Namespace) eObject;
				}
			}
			if (eObject instanceof Type) {
				count++;
			}
		}
		return null;
	}

	@Override
	protected boolean hasHover(EObject o) {
		if (o instanceof Element) {
			return true;
		}
		if (o instanceof ElementCS) {
			return true;
		}
		return super.hasHover(o);
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		// TODO Auto-generated method stub
		return super.getHoverControlCreator();
	}

	@Override
	public IInformationControlCreatorProvider getHoverInfo(final EObject object, final ITextViewer viewer, final IRegion region) {
		return new IInformationControlCreatorProvider() {

			public IInformationControlCreator getHoverControlCreator() {
				return MarkupHoverProvider.this.getHoverControlCreator();
			}

			public Object getInfo() {
//				return getHoverInfo(object, region, null);
				return getHoverInfo(object, viewer, region, null);
			}};
	}

	protected XtextBrowserInformationControlInput getHoverInfo(EObject element,
			ITextViewer viewer, IRegion hoverRegion, XtextBrowserInformationControlInput previous) {
//		IXtextDocument xtextDocument = XtextDocumentUtil.get(viewer);
		return super.getHoverInfo(element, hoverRegion, previous);
	}
}
