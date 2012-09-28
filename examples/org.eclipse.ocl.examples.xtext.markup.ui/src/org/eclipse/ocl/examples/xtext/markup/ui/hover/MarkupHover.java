package org.eclipse.ocl.examples.xtext.markup.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

public class MarkupHover extends DispatchingEObjectTextHover
{
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	
	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		//
		// Overrides to return the CS node so that the MetaModelManager is accessible for documentation.
		//
		TextRegion textRegion = new TextRegion(offset, 0);
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null) {
			return null;
		}
		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), textRegion.getOffset());
		if (leaf == null) {
			return null;
		}
		EObject o = leaf.getSemanticElement();
		if (o != null) {
			ITextRegion region = locationInFileProvider.getSignificantTextRegion(o);
			final IRegion region2 = new Region(region.getOffset(), region.getLength());
			if (TextUtilities.overlaps(region2, new Region(offset, 0)))
				return Tuples.create(o, region2);
		}
		return super.getXtextElementAt(resource, offset);
	}
}
