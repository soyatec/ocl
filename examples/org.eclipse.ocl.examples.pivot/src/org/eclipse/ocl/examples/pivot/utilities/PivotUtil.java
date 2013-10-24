/**
 * <copyright>
 * 
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.context.ClassContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.AbstractMetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.scoping.NullAttribution;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class PivotUtil extends DomainUtil
{	
	private static final Logger logger = Logger.getLogger(PivotUtil.class);

	/**
	 * 'Highest' precedence first
	 */
	public static class PrecedenceComparator implements Comparator<Precedence>
	{
		public static final PrecedenceComparator INSTANCE = new PrecedenceComparator();

		public int compare(Precedence p1, Precedence p2) {
			int o1 = p1 != null ? p1.getOrder().intValue() : -1;
			int o2 = p2 != null ? p2.getOrder().intValue() : -1;
			return o1 - o2; // NB least positive is highest precedence
		}
	}

	/**
	 * In TemplateSignature order.
	 */
	public static class TemplateParameterSubstitutionComparator
		implements Comparator<TemplateParameterSubstitution>
	{
		public static Comparator<? super TemplateParameterSubstitution> INSTANCE =
			new TemplateParameterSubstitutionComparator();

		public int compare(TemplateParameterSubstitution o1, TemplateParameterSubstitution o2) {
			TemplateParameter f1 = o1.getFormal();
			TemplateParameter f2 = o2.getFormal();
			int i1 = f1.getSignature().getParameter().indexOf(f1);
			int i2 = f2.getSignature().getParameter().indexOf(f2);
			return i1 - i2;
		}
	}

	public static void appendMultiplicity(@NonNull StringBuilder s, long lower, long upper) {
		if (upper < 0) {
			if (lower == 0) {
				s.append("[*]");
			}
			else if (lower == 1) {
				s.append("[+]");
			}
			else {
				s.append("[" + lower + "..*]");
			}
		}
		else if (upper == 1) {
			if (lower == 0) {
				s.append("[?]");
			}
			else {
				//;
			}
		}
		else if (upper == lower) {
			s.append("[" + lower + "]");
		}
		else {
			s.append("[" + lower + ".." + upper + "]");
		}
	}

	public static void checkResourceErrors(@NonNull String message, @NonNull Resource resource) throws ParserException {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			throw new SemanticException(formatResourceDiagnostics(DomainUtil.nonNullEMF(resource.getErrors()), message, "\n"));
		}
	}

	public static boolean conformsTo(@Nullable EStructuralFeature eStructuralFeature, @NonNull EClassifier contentType) {
		if (eStructuralFeature == null) {			// Wildcard match all
			return true;
		}
		EClassifier targetType = eStructuralFeature.getEType();
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return conformsTo(targetType, contentType);
	}

	public static boolean conformsTo(@Nullable EClassifier targetType, @NonNull EClassifier contentType) {
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return ((EClass) targetType).isSuperTypeOf((EClass) contentType);
	}

	@Deprecated
	public static@NonNull  String convertFromOCLString(@NonNull String javaString) {
		return DomainUtil.convertFromOCLString(javaString);
	}

	@Deprecated
	public static String convertToOCLString(String theString) {
		return DomainUtil.convertToOCLString(theString);
	}

	public static @NonNull ExpressionInOCL createExpressionInOCLError(@NonNull String string) {
		@SuppressWarnings("null")@NonNull ExpressionInOCL expressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
		StringLiteralExp stringLiteral = PivotFactory.eINSTANCE.createStringLiteralExp();
		stringLiteral.setStringSymbol(string); //createTupleValuedConstraint("false", null, string));
		expressionInOCL.setBodyExpression(stringLiteral);
		expressionInOCL.setType(stringLiteral.getType());
		return expressionInOCL;
	}

	public static @NonNull String createTupleValuedConstraint(@NonNull String statusText, @Nullable Integer severity, @Nullable String messageText) {
		if ((severity == null) && (messageText == null)) {
			return statusText;
		}
		StringBuilder s = new StringBuilder();
		s.append("Tuple {");
		if (messageText != null) {
			s.append("\n\t" + PivotConstants.MESSAGE_PART_NAME + " : String = " + messageText + ",");
		}
		if (severity != null) {
			s.append("\n\t" + PivotConstants.SEVERITY_PART_NAME + " : Integer = " + severity + ",");
		}
		s.append("\n\t" + PivotConstants.STATUS_PART_NAME + " : Boolean = " + statusText);		// NB parts in alphabetical order
		s.append("\n}."+ PivotConstants.STATUS_PART_NAME);
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}

	public static void debugObjectUsage(String prefix, EObject element) {
		StringBuilder s = new StringBuilder();
		s.append(prefix);
		if (element != null) {
			s.append(element.eClass().getName());
			s.append("@");
			s.append(Integer.toHexString(element.hashCode()));
			Resource eResource = element.eResource();
			if (eResource != null) {
				if (element instanceof Element) {
					s.append(" ");
					s.append(AS2Moniker.toString((Element) element));
				}
				s.append(" ");
				s.append(eResource.getURI());
			}
			else if (element instanceof NamedElement) {
				s.append(" ");
				s.append(String.valueOf(((NamedElement) element).getName()));
			}
		}
		else {
			s.append("null");
		}
		System.out.println(s.toString());
	}

	public static boolean debugWellContainedness(Type type) {
		if (type.eResource() == null) {
			PivotUtil.debugObjectUsage("Badly contained ", type);
			return false;
		}
		if (type instanceof CollectionType) {
			Type elementType = ((CollectionType)type).getElementType();
			if ((elementType != null) && !debugWellContainedness(elementType)) {
				PivotUtil.debugObjectUsage("Badly contained ", type);
				return false;
			}
		}
		return true;
	}
	
	public static @Nullable MetaModelManager findMetaModelManager(@NonNull EObject eObject) {
		EObject eRoot = EcoreUtil.getRootContainer(eObject);
		if (eRoot != null) {
			Resource resource = eRoot.eResource();
			if (resource != null) {
//				if (eObject instanceof ElementCS) {
					AbstractMetaModelManagerResourceAdapter<?> adapter = AbstractMetaModelManagerResourceAdapter.findAdapter(resource);
					if (adapter != null) {
						return adapter.getMetaModelManager();
					}
//				}
				return findMetaModelManager(resource);
			}
		}
		return null;
	}

	public static @Nullable MetaModelManager findMetaModelManager(@NonNull Resource resource) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof AbstractMetaModelManagerResourceAdapter) {
				return ((AbstractMetaModelManagerResourceAdapter<?>)adapter).getMetaModelManager();
			}
		}
		ResourceSet resourceSet = resource.getResourceSet();
		return resourceSet != null ? findMetaModelManager(resourceSet) : null;
	}

	public static MetaModelManager findMetaModelManager(@NonNull ResourceSet resourceSet) {
		MetaModelManager metaModelManager = MetaModelManager.findAdapter(resourceSet);
		if (metaModelManager != null) {
			return metaModelManager;
		}
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
		if (adapter != null) {
			return adapter.getMetaModelManager();
		}
		return null;
	}

	public static Type findTypeOf(@NonNull MetaModelManager metaModelManager, @NonNull EClassifier eClass) {
		Resource resource = eClass.eResource();
		if (resource != null) {
			Ecore2Pivot adapter = Ecore2Pivot.findAdapter(resource, metaModelManager);
			if (adapter != null) {
				Type type = adapter.getCreated(Type.class, eClass);
				if (type != null) {
					return type;
				}
			}
		}
		return null;
	}

	public static String formatDiagnostics(@NonNull Diagnostic diagnostic, @NonNull String newLine) {
		StringBuilder s = new StringBuilder();
		formatDiagnostic(s, diagnostic, newLine);
		return s.toString();
	}

	private static void formatDiagnostic(@NonNull StringBuilder s, @NonNull Diagnostic diagnostic, @NonNull String newLine) {
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			s.append(newLine);
			s.append(diagnostic.getSeverity() + " - ");
			String location = diagnostic.getSource();
			if (location != null) {
				s.append(location);
				s.append(": ");
			}
			s.append(diagnostic.getMessage());
			for (Object obj : diagnostic.getData()) {
				s.append(newLine);
				s.append("\t");
//				if (obj instanceof Throwable) {
//					s.append(((Throwable)obj).getMessage());
//				}
//				else {
					s.append(obj);
//				}
			}
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				if (childDiagnostic != null) {
					formatDiagnostic(s, childDiagnostic, newLine + "\t");
				}
			}
		}
	}

	public static String formatResourceDiagnostics(@NonNull List<Resource.Diagnostic> diagnostics, @NonNull String messagePrefix, @NonNull String newLine) {
		if (diagnostics.size() <= 0) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		s.append(messagePrefix);
		for (Resource.Diagnostic diagnostic : diagnostics) {
			s.append(newLine);
			String location = diagnostic.getLocation();
			if (location != null) {
				s.append(location);
				s.append(":");
			}
			s.append(diagnostic.getLine());
			try {
				int column = diagnostic.getColumn();
				s.append(":");
				s.append(column);
			} catch (Exception e) {}	// UnsupportedOperationException is normal
			s.append(": ");
			s.append(diagnostic.getMessage());
		}
		return s.toString();
	}

	public static <T> T getAdapter(@NonNull Class<T> adapterClass, @NonNull Notifier notifier) {
		List<Adapter> eAdapters = DomainUtil.nonNullEMF(notifier.eAdapters());
		return getAdapter(adapterClass, eAdapters);
	}

	@SuppressWarnings("null")
	public static @NonNull URI getASURI(@NonNull URI uri) {
		URI asURI = uri.appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION);
		if (!isASURI(asURI)) {
			asURI = uri.appendSegment(PivotConstants.DOT_OCL_AS_FILE_EXTENSION);
		}
		assert isASURI(asURI);
		return asURI;
	}

	public static <T> T getAdapter(@NonNull Class<T> adapterClass, @NonNull List<Adapter> eAdapters) {
		Adapter adapter = EcoreUtil.getAdapter(eAdapters, adapterClass);
		if (adapter == null) {
			return null;
		}
		if (!adapterClass.isAssignableFrom(adapter.getClass())) {
			throw new ClassCastException(adapter.getClass().getName() + " is not assignable to " + adapterClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castAdapter = (T) adapter;
		return castAdapter;
	}

	public static List<TemplateParameter> getAllTemplateParameters(Collection<TemplateBinding> templateBindings) {
		List<TemplateParameter> list = null;
		for (TemplateBinding templateBinding : templateBindings) {	// FIXME Establish ordering
			TemplateSignature templateSignature = templateBinding.getSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameter();
				if (templateParameters.size() > 0) {
					if (list == null) {
						list = new ArrayList<TemplateParameter>();
					}
					list.addAll(templateParameters);
				}
			}
		}
		return list != null ? list : Collections.<TemplateParameter>emptyList();
	}

	public static List<List<TemplateParameter>> getAllTemplateParameterLists(EObject eObject) {
		List<List<TemplateParameter>> result = null;
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			result = getAllTemplateParameterLists(eContainer);
		}
		if (eObject instanceof TemplateableElement) {
			TemplateableElement unspecializedTemplateableElement = (TemplateableElement)eObject;
			if (eObject instanceof Type) {
				eObject = getUnspecializedTemplateableElement((Type)eObject);
			}
			TemplateSignature templateSignature = unspecializedTemplateableElement.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameter();
				if (templateParameters.size() > 0) {
					if (result == null) {
						result = new ArrayList<List<TemplateParameter>>();
					}
					result.add(templateParameters);
				}
			}
		}
		return result;
	}

	public static List<TemplateParameter> getAllTemplateParameters(EObject eObject) {
		List<TemplateParameter> result = null;
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			result = getAllTemplateParameters(eContainer);
		}
		if (eObject instanceof TemplateableElement) {
			TemplateableElement unspecializedTemplateableElement = (TemplateableElement)eObject;
			if (eObject instanceof Type) {
				eObject = getUnspecializedTemplateableElement((Type)eObject);
			}
			TemplateSignature templateSignature = unspecializedTemplateableElement.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameter();
				if (templateParameters.size() > 0) {
					if (result == null) {
						result = new ArrayList<TemplateParameter>();
					}
					result.addAll(templateParameters);
				}
			}
		}
		return result;
	}

	public static @Nullable Map<TemplateParameter, ParameterableElement> getAllTemplateParametersAsBindings(@NonNull EObject eObject) {
		if (eObject instanceof Type) {
			eObject = getUnspecializedTemplateableElement((Type)eObject);
		}
		Map<TemplateParameter, ParameterableElement> result = null;
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			result = getAllTemplateParametersAsBindings(eContainer);
		}
		if (eObject instanceof TemplateableElement) {
//			TemplateableElement unspecializedTemplateableElement = getUnspecializedTemplateableElement((TemplateableElement)eObject);
			TemplateSignature templateSignature = ((TemplateableElement)eObject).getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameter();
				if (templateParameters.size() > 0) {
					if (result == null) {
						result = new HashMap<TemplateParameter, ParameterableElement>();
					}
					for (TemplateParameter templateParameter : templateSignature.getParameter()) {
						result.put(templateParameter, null);
					}
				}
			}
		}
		return result;
	}

	public static @Nullable Map<TemplateParameter, ParameterableElement> getAllTemplateParameterSubstitutions(@Nullable Map<TemplateParameter, ParameterableElement> map,
			@Nullable TemplateableElement templateableElement) {
		for (EObject eObject = templateableElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				for (TemplateBinding templateBinding : ((TemplateableElement) eObject).getTemplateBinding()) {
					for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitution()) {
						if (map == null) {
							map = new HashMap<TemplateParameter, ParameterableElement>();
						}
						map.put(templateParameterSubstitution.getFormal(), templateParameterSubstitution.getActual());
					}
				}
			}
			if (eObject instanceof Type) {
				for (Type superType : ((Type)eObject).getSuperClass()) {
					map = getAllTemplateParameterSubstitutions(map, superType);
				}		
			}
		}
		return map;
	}

	public static Map<TemplateParameter, ParameterableElement> getAllTemplateParameterSubstitutions(Map<TemplateParameter, ParameterableElement> bindings,
		Type argumentType, LambdaType lambdaType) {
		Type resultType = lambdaType.getResultType();
		if (resultType != null) {
			TemplateParameter resultTemplateParameter = resultType.getOwningTemplateParameter();
			if (resultTemplateParameter != null) {
				if (bindings == null) {
					bindings = new HashMap<TemplateParameter, ParameterableElement>();
				}
				bindings.put(resultTemplateParameter, argumentType);
			}
		}
		// FIXME There is much more to do
		// FIXME Conflict checking
		return bindings;
	}

	public static @NonNull Attribution getAttribution(@NonNull EObject eObject) {
		if (eObject.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			logger.warn("getAttribution for proxy " + eObject);
			return NullAttribution.INSTANCE;
		}
		else {
			EClass eClass = eObject.eClass();
			Attribution attribution = Attribution.REGISTRY.get(eClass);
			if (attribution == null) {
				for (EClass superClass = eClass; superClass.getESuperTypes().size() > 0;) {
					superClass = superClass.getESuperTypes().get(0);
					attribution = Attribution.REGISTRY.get(superClass);
					if (attribution != null) {
						break;
					}
				}
				if (attribution == null) {
					attribution = NullAttribution.INSTANCE;
				}
				Attribution.REGISTRY.put(eClass, attribution);
			}
			return attribution;
		}
	}

	@Deprecated // Use getType
	public static @NonNull Type getBehavioralType(@NonNull Type type) {		// FIXME fold this into normal code
		if (type instanceof DataType) {
			DataType dataType = (DataType)type;
			Type behavioralType = dataType.getBehavioralType();
			if (behavioralType != null) {
				return behavioralType;
			}
		}
		return type;
	}

	@Deprecated // Use getType
	public static @NonNull Type getBehavioralType(@NonNull TypedElement element) {
		return PivotUtil.getBehavioralType(DomainUtil.nonNullState(element.getType()));
	}

	public static String getBody(OpaqueExpression specification) {
		List<String> bodies = specification.getBody();
		List<String> languages = specification.getLanguage();
		if ((bodies == null) || (languages == null)) {
			return null;
		}
		int iMax = Math.min(bodies.size(), languages.size());
		for (int i = 0; i < iMax; i++) {
			if (PivotConstants.OCL_LANGUAGE.equalsIgnoreCase(languages.get(i))) {
				return bodies.get(i);
			}
		}
		return null;
	}

	/**
	 * Trim a surrounding "result=(...)" to convert a UML BodyCondition to an OCL BodyExpression.
	 */
	@SuppressWarnings("null")
	public static @NonNull String getBodyExpression(@NonNull String umlBody) {
		String s = umlBody.trim();
		if (s.startsWith("result")) {
			s = s.substring(6).trim();
			if (s.startsWith("=")) {
				s = s.substring(1).trim();
				if (s.startsWith("(") && s.endsWith(")")) {
					s = s.substring(1, s.length()-1).trim();
				}
				return s;
			}
		}
		return umlBody;
	}

	public static CollectionKind getCollectionKind(CollectionType collectionType) {
		if (collectionType instanceof OrderedSetType) {
			return CollectionKind.ORDERED_SET;
		}
		else if (collectionType instanceof SequenceType) {
			return CollectionKind.SEQUENCE;
		}
		else if (collectionType instanceof SetType) {
			return CollectionKind.SET;
		}
		else if (collectionType instanceof BagType) {
			return CollectionKind.BAG;
		}
		else {
			return CollectionKind.COLLECTION;
		}
	}

	/**
	 * Return the expression to be evaluated for a constraintSpecification, which is the constraintSpecification.bodyExpression
	 * unless that is a status TuplePart PropertyCallExp in which case it is the source of the TuplePart PropertyCallExp enabling the
	 * evaluation to compute the enriched Tuple of invariant results.
	 */
	public static OCLExpression getConstraintExpression(@NonNull ExpressionInOCL constraintSpecification) {
		OCLExpression body = constraintSpecification.getBodyExpression();
		if (body instanceof PropertyCallExp) {
			PropertyCallExp propertyCallExp = (PropertyCallExp)body;
			Property referredProperty = propertyCallExp.getReferredProperty();
			if ((referredProperty != null) && (referredProperty.getOwningType() instanceof TupleType) && PivotConstants.STATUS_PART_NAME.equals(referredProperty.getName())) {
				return propertyCallExp.getSource();
			}
		}
		return body;
	}

	/**
	 * Return the message of result, which is null
	 * unless result is a Tuple with a more informative severity part.
	 */
	public static @Nullable String getConstraintResultMessage(Object result) {
		if (result instanceof TupleValue) {
			TupleValue tupleValue = (TupleValue)result;
			TupleTypeId tupleTypeId = tupleValue.getTypeId();
			TuplePartId messagePartId = tupleTypeId.getPartId(PivotConstants.MESSAGE_PART_NAME);
			if (messagePartId != null) {
				return String.valueOf(tupleValue.getValue(messagePartId));
			}
		}
		return null;
	}

	/**
	 * Return the org.eclipse.emf.common.util.Diagnostic severity of result, which is ERROR
	 * unless result is a Tuple with a more informative severity part.
	 */
	public static int getConstraintResultSeverity(Object result) {
		if (result instanceof TupleValue) {
			TupleValue tupleValue = (TupleValue)result;
			TupleTypeId tupleTypeId = tupleValue.getTypeId();
			TuplePartId severityPartId = tupleTypeId.getPartId(PivotConstants.SEVERITY_PART_NAME);
			if (severityPartId != null) {
				IntegerValue value = ValuesUtil.integerValueOf(tupleValue.getValue(severityPartId));
				int signum = value.signum();
				if (signum < 0) {
					return Diagnostic.ERROR;
				}
				else if (signum == 0) {
					return Diagnostic.INFO;
				}
				else {
					return Diagnostic.WARNING;
				}
			}
			else {
				TuplePartId statusPartId = tupleTypeId.getPartId(PivotConstants.STATUS_PART_NAME);
				if (statusPartId != null) {
					result = tupleValue.getValue(statusPartId);
				}
			}
		}
		return result == null ? Diagnostic.ERROR : Diagnostic.WARNING;
	}

	/**
	 * Return true if result represents a successful constraint evaluation result.
	 * Anything else leads to a false return (no null or exception).
	 */
	public static boolean getConstraintResultStatus(Object result) {
		if (result == Boolean.TRUE) {
			return true;
		}
		if (result instanceof TupleValue) {
			TupleValue tupleValue = (TupleValue)result;
			TupleTypeId tupleTypeId = tupleValue.getTypeId();
			TuplePartId statusPartId = tupleTypeId.getPartId(PivotConstants.STATUS_PART_NAME);
			if (statusPartId == null) {
				return false;
			}
			Object value = tupleValue.getValue(statusPartId);
			if (value == Boolean.TRUE){
				return true;
			}
		}
		return false;
	}

	/**
	 * Return null message if the result type of the constraintName query is a
	 * BooleanType or a TupleType with a part name status with a BooleanType. 
	 * Return a non-null message diagnosing the anomally otherwise.
	 */
	public static @Nullable String getConstraintResultTypeErrorMessage(String constraintName, @NonNull ExpressionInOCL query) {
		TypeId typeId = query.getTypeId();
		if (typeId == TypeId.BOOLEAN) {
			return null;
		}
		else {
			String objectLabel = DomainUtil.getLabel(query.getContextVariable().getType());
			String constraintTypeName = getConstraintTypeName(query);
			return DomainUtil.bind(OCLMessages.ValidationConstraintIsNotBooleanType_ERROR_, constraintTypeName, constraintName, objectLabel);
		}
	}

	public static String getConstraintTypeName(@NonNull OpaqueExpression expression) {
		return ((NamedElement) expression.eContainer().eContainer()).getName();
	}

	public static String getConstraintTypeName(@NonNull Constraint constraint) {
		return ((NamedElement) constraint.eContainer()).getName();
	}

	public static @Nullable ExpressionInOCL getContainingExpressionInOCL(@Nullable Element element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ExpressionInOCL) {
				return (ExpressionInOCL)eObject;
			}
		}
		return null;
	}

	public static @Nullable Namespace getContainingNamespace(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Namespace) {
				return (Namespace)eObject;
			}
		}
		return null;
	}
	
	public static @Nullable org.eclipse.ocl.examples.pivot.Package getContainingPackage(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				return (org.eclipse.ocl.examples.pivot.Package)eObject;
			}
		}
		return null;
	}
	
	public static @Nullable Root getContainingRoot(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Root) {
				return (Root)eObject;
			}
		}
		return null;
	}
	
	public static @Nullable Type getContainingType(@Nullable EObject element) {
		if (element != null) {
			EObject eObject = element;
			while (true) {
				if (eObject instanceof Type) {
					return (Type)eObject;
				}
				EObject eContainer = eObject.eContainer();
				if (eContainer == null) {
					if (eObject instanceof ExpressionInOCL) {
						return ((ExpressionInOCL)eObject).getContextVariable().getType();
					}
					break;
				}
				eObject = eContainer;
			}
		}
		return null;
	}

	/**
	 * Return the number of containers of eObject, 0 if eObject is a root.
	 */
	public static int getContainmentDepth(EObject eObject) {
		int depth = 0;
		for (EObject eContainer = eObject.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			depth++;
			if (depth > 100000) {
				return depth;
			}
		}
		return depth;
	}

	/**
	 * Return an OCL AST from a ValueSpecification in the context of a NamedElement. If it is necessary
	 * to parse OCL concrete syntax and errors result an ExpressionInOCL is returned with a null
	 * contextVariable, a null bodyExpression, and a StringLiteral messageExpression
	 * containing the error messages.
	 */
	public static @Nullable ExpressionInOCL getExpressionInOCL(@NonNull NamedElement contextElement, @NonNull OpaqueExpression specification) {
		if (specification instanceof ExpressionInOCL) {
			return (ExpressionInOCL) specification;
		}
		Resource resource = contextElement.eResource();
		ResourceSet resourceSet = DomainUtil.nonNullState(resource.getResourceSet());
		MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
		ClassContext parserContext = (ClassContext)metaModelManager.getParserContext(contextElement);
		if (parserContext == null) {
			logger.error("Unknown context type for " + contextElement.eClass().getName());
			return null;
		}
		String expression = PivotUtil.getBody(specification);
		if (expression == null) {
			return createExpressionInOCLError("Missing expression");
		}
		ExpressionInOCL expressionInOCL = null;
		try {
			expressionInOCL = parserContext.parse(expression);
		} catch (Exception e) {
			String message = e.getMessage();
			if (message == null) {
				message = "";
			}
			logger.error(message);
			return createExpressionInOCLError(message);
		}
		return expressionInOCL;
	}

	/**
	 * Return an OCL AST from a string in the context of a NamedElement. If it is necessary
	 * to parse OCL concrete syntax and errors result an ExpressionInOCL is returned with a null
	 * contextVariable, a null bodyExpression, and a StringLiteral messageExpression
	 * containing the error messages.
	 */
	public static @Nullable ExpressionInOCL getExpressionInOCL(@NonNull NamedElement contextElement, @NonNull String expression) {
			Resource resource = contextElement.eResource();
			ResourceSet resourceSet = DomainUtil.nonNullState(resource.getResourceSet());
			MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
			ParserContext parserContext = metaModelManager.getParserContext(contextElement);
			if (parserContext == null) {
				logger.error("Unknown context type for " + contextElement.eClass().getName());
				return null;
			}
			ExpressionInOCL expressionInOCL = null;
			try {				
				expressionInOCL = parserContext.parse(expression);
			} catch (ParserException e) {
				String message = e.getMessage();
				if (message == null) {
					message = "";
				}
				logger.error(message);
				return createExpressionInOCLError(message);
			}
			return expressionInOCL;
	}

	@Deprecated
	public static <T extends DomainNamedElement> T getNamedElement(Iterable<T> elements, String name) {
		return DomainUtil.getNamedElement(elements, name);
	}

	public static @NonNull Type getOwningType(@NonNull Feature feature) {
		Type owner = null;
		if (feature instanceof Property) {
			owner = ((Property)feature).getOwningType();
		}
		else if (feature instanceof Operation) {
			owner = ((Operation)feature).getOwningType();
		}
		else {
			throw new IllegalStateException("Unknown feature " + feature.eClass().getName());
		}
		if (owner == null) {
			throw new IllegalStateException("Orphan feature " + feature.eClass().getName());
		}
		return owner;
	}

	public static @Nullable org.eclipse.ocl.examples.pivot.Package getPackage(@NonNull EObject object) {
		for (EObject eObject = object; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				return (org.eclipse.ocl.examples.pivot.Package)eObject;
			}
		}
		return null;
	}

	/**
	 * Return the lower bound for scope resolution lookups in element. This is element
	 * unless element is an UnspecifiedType in which case the derived type is returned.
	 */
	public static @NonNull Element getLowerBound(@NonNull Element element) {
		if (element instanceof UnspecifiedType) {
			Type lowerBound = ((UnspecifiedType)element).getLowerBound();
			if (lowerBound != null) {
				return lowerBound;
			}
		}
		return element;
	}

	@Deprecated		// messages now encoded with Tuple
	public static @Nullable String getMessage(@NonNull OpaqueExpression specification) {
		return null;
	}

	public static @NonNull MetaModelManager getMetaModelManager(@NonNull Resource resource) {
		MetaModelManager metaModelManager = findMetaModelManager(resource);
		if (metaModelManager == null) {
			MetaModelManagerResourceAdapter adapter = MetaModelManagerResourceAdapter.getAdapter(resource, null);
			metaModelManager = adapter.getMetaModelManager();
			assert metaModelManager != null;
			ResourceSet resourceSet = resource.getResourceSet();
			if ((resourceSet != null) && (findMetaModelManager(resourceSet) == null)) {
				MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
			}
		}
		return metaModelManager;
	}

	public static @Nullable Namespace getNamespace(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Root) {
				return null;
			}
			if (eObject instanceof Type) {
				return (Namespace) eObject;
			}
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				return (Namespace) eObject;
			}
		}
		return null;
	}

	@SuppressWarnings("null")
	public static @NonNull URI getNonASURI(@NonNull URI uri) {
		assert isASURI(uri);
		return uri.trimFileExtension();
	}

	public static @NonNull <T extends Element> T getNonNullAst(@NonNull Class<T> pivotClass, @NonNull Pivotable pivotableElement) {
//		if (pivotableElement == null) {
//			return null;
//		}
		Element pivotElement = pivotableElement.getPivot();
		if (pivotElement == null) {
			throw new IllegalStateException("Null pivotElementfor a " + pivotClass.getName());
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	@Deprecated	// Use getNonASURI
	public static @NonNull URI getNonPivotURI(@NonNull URI uri) {
		return getNonASURI(uri);
	}

	/**
	 * Return a URI based on the nsURI of the immediate parent package.
	 */
	public static String getNsURI(@NonNull EModelElement element) {
		if (element instanceof EPackage) {
			String nsURI = ((EPackage)element).getNsURI();
			if (nsURI != null) {
				return nsURI;
			}
		}
		StringBuilder s = new StringBuilder();
		getNsURI(s, element);
		return s.toString();
	}

	/**
	 * Return a URI based on the nsURI of the immediate parent package.
	 */
	public static String getNsURI(@NonNull DomainElement element) {
		if (element instanceof DomainPackage) {
			String nsURI = ((DomainPackage)element).getNsURI();
			if (nsURI != null) {
				return nsURI;
			}
		}
		StringBuilder s = new StringBuilder();
		s.append("u_r_i:");
		if (element instanceof Element) {
			getNsURI(s, (Element)element);
		}
		else {
			s.append(element.hashCode());
		}
		return s.toString();
	}

	private static void getNsURI(@NonNull StringBuilder s, @NonNull EObject element) {
		if (element instanceof org.eclipse.ocl.examples.pivot.Package) {
			String nsURI = ((org.eclipse.ocl.examples.pivot.Package)element).getNsURI();
			if (nsURI != null) {
				s.append(nsURI);
				return;
			}
		}
		else if (element instanceof Root) {
			String nsURI = ((Root)element).getExternalURI();
			if (nsURI != null) {
				s.append(nsURI);
				return;
			}
		}
		else if (element instanceof EPackage) {
			String nsURI = ((EPackage)element).getNsURI();
			if (nsURI != null) {
				s.append(nsURI);
				return;
			}
		}
		EObject eContainer = element.eContainer();
		if ((eContainer instanceof org.eclipse.ocl.examples.pivot.Package) || (eContainer instanceof Root)) {
			String nsURI = ((org.eclipse.ocl.examples.pivot.Package)element).getNsURI();
			if (nsURI != null) {
				s.append(nsURI);
				s.append("#/");
			}
			else {
				@SuppressWarnings("null")
				@NonNull EObject eContainer2 = eContainer;
				getNsURI(s, eContainer2);
			}
		}
		else if (eContainer instanceof EPackage) {
			String nsURI = ((EPackage)element).getNsURI();
			if (nsURI != null) {
				s.append(nsURI);
				s.append("#/");
			}
			else {
				getNsURI(s, eContainer);
			}
		}
		else if (eContainer == null) {
			String name = null;
			if (element instanceof org.eclipse.ocl.examples.pivot.Package) {
				name = ((org.eclipse.ocl.examples.pivot.Package)element).getName();
			}
			else if (element instanceof EPackage) {
				name = ((EPackage)element).getName();
			}
			if (name == null) {
				name = "$null$";
			}
			s.append(name);
			return;
		}
		else {
			getNsURI(s, eContainer);
		}
		EReference eFeature = element.eContainmentFeature();
		s.append("@");
		s.append(eFeature.getName());
		if (eFeature.isMany()) {
			int index = ((List<?>) eContainer.eGet(element.eContainingFeature())).indexOf(element);
			s.append(".");
			s.append(index);
		}
	}

	public static @Nullable <T extends Element> T getPivot(@NonNull Class<T> pivotClass, @Nullable Pivotable pivotableElement) {
		if (pivotableElement == null) {
			return null;
		}
		Element pivotElement = pivotableElement.getPivot();
		if (pivotElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	@Deprecated	// Use getASURI
	public static @NonNull URI getPivotURI(@NonNull URI uri) {
		return getASURI(uri);
	}

	public static Feature getReferredFeature(CallExp callExp) {
		Feature feature = null;
		if (callExp instanceof LoopExp) {
			feature = ((LoopExp)callExp).getReferredIteration();
		}
		else if (callExp instanceof OperationCallExp) {
			feature = ((OperationCallExp)callExp).getReferredOperation();
		}
		else if (callExp instanceof OppositePropertyCallExp) {
			Property referredOppositeProperty = ((OppositePropertyCallExp)callExp).getReferredProperty();
			feature = referredOppositeProperty != null ? referredOppositeProperty.getOpposite() : null;
		}
		else if (callExp instanceof PropertyCallExp) {
			feature = ((PropertyCallExp)callExp).getReferredProperty();
		}
		return feature;
	}

	public static Operation getReferredOperation(CallExp callExp) {
		Operation operation = null;
		if (callExp instanceof LoopExp) {
			operation = ((LoopExp)callExp).getReferredIteration();
		}
		else if (callExp instanceof OperationCallExp) {
			operation = ((OperationCallExp)callExp).getReferredOperation();
		}
		return operation;
	}

	public static List<TemplateParameter> getTemplateParameters(TemplateableElement templateableElement) {
		if (templateableElement != null) {
			TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				return ownedTemplateSignature.getParameter();
			}
		}
		return Collections.emptyList();
	}

	public static String getStereotype(@NonNull Constraint object) {
		EStructuralFeature eContainingFeature = object.eContainingFeature();
		if (eContainingFeature == PivotPackage.Literals.TYPE__OWNED_INVARIANT) {
			return UMLReflection.INVARIANT;
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
			return UMLReflection.BODY;
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__POSTCONDITION) {
			return UMLReflection.POSTCONDITION;
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__PRECONDITION) {
			return UMLReflection.PRECONDITION;
		}
		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__DEFAULT_EXPRESSION) {
			return UMLReflection.DERIVATION;
		}
		return "";
	}

	public static List<ParameterableElement> getTemplateParameterables(TemplateableElement templateableElement) {
		if (templateableElement == null) {
			return Collections.emptyList();
		}
		TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
		if (ownedTemplateSignature == null) {
			return Collections.emptyList();
		}
		List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameter();
		if (templateParameters.size() == 0) {
			return Collections.emptyList();
		}
		if (templateParameters.size() == 1) {
			return Collections.singletonList(templateParameters.get(0).getParameteredElement());
		}
		List<ParameterableElement> results = new ArrayList<ParameterableElement>(templateParameters.size());
		for (TemplateParameter templateParameter : templateParameters) {
			results.add(templateParameter.getParameteredElement());
		}
		return results;
	}

	public static @Nullable Type getType(@Nullable TypedElement typedElement) {
		if (typedElement == null) {
			return null;
		}
		Type type = typedElement.getType();
		if (type == null) {
			return null;
		}
		type = getType(type);
		if (type instanceof SelfType) {
			if (typedElement instanceof Parameter) {
				Operation operation = ((Parameter)typedElement).getOperation();
				if (operation != null) {
					Type selfType = operation.getOwningType();
					if (selfType != null) {
						type = selfType;
					}
				}
			}
		}
		return type;
	}

	public static @NonNull Type getType(@NonNull Type type) {
		if (type instanceof LambdaType) {
			Type resultType = ((LambdaType)type).getResultType();
			if (resultType != null) {
				type = resultType;
			}
		}
		else if (type instanceof DataType) {
			Type behavioralType = ((DataType)type).getBehavioralType();
			if (behavioralType != null) {
				type = behavioralType;
			}
		}
		return type;
	}

	public static @NonNull List<Type> getTypeTemplateParameterables(@NonNull TemplateableElement templateableElement) {
//		if (templateableElement == null) {
//			return MetaModelManager.EMPTY_TYPE_LIST;
//		}
		TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
		if (ownedTemplateSignature == null) {
			return MetaModelManager.EMPTY_TYPE_LIST;
		}
		List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameter();
		if (templateParameters.size() == 0) {
			return MetaModelManager.EMPTY_TYPE_LIST;
		}
		if (templateParameters.size() == 1) {
			TemplateParameter templateParameter = templateParameters.get(0);
			if (templateParameter == null) {
				return MetaModelManager.EMPTY_TYPE_LIST;
			}
			ParameterableElement parameteredElement = templateParameter.getParameteredElement();
			if (!(parameteredElement instanceof Type)) {
				return MetaModelManager.EMPTY_TYPE_LIST;
			}
			@SuppressWarnings("null") @NonNull List<Type> singletonList = Collections.singletonList((Type)parameteredElement);
			return singletonList;
		}
		List<Type> results = new ArrayList<Type>(templateParameters.size());
		for (TemplateParameter templateParameter : templateParameters) {
			results.add((Type) templateParameter.getParameteredElement());
		}
		return results;
	}

	public static @NonNull <T extends TemplateableElement> T getUnspecializedTemplateableElement(@NonNull T templateableElement) {
//		if (templateableElement == null) {
//			return null;
//		}
		TemplateableElement unspecializedElement = templateableElement.getUnspecializedElement();
		if (unspecializedElement == null) {
			return templateableElement;
		}
		@SuppressWarnings("unchecked")
		T castUnspecializedElement = (T) unspecializedElement;
		return castUnspecializedElement;
	}

	public static boolean isASURI(@Nullable String uri) {
		return (uri != null) && uri.endsWith("as");
	}

	public static boolean isASURI(@Nullable URI uri) {
		return (uri != null) && isASURI(uri.toString());
	}

	public static boolean isLibraryType(@NonNull Type type) {
		if (type instanceof LambdaType) {
			return false;
		}
		else if (type instanceof TupleType) {
			return false;			
		}
		else {
			return type.getTemplateBinding().isEmpty();			
		}
	}

	@Deprecated	// Use isASURI
	public static boolean isPivotURI(@NonNull URI uri) {
		return isASURI(uri);
	}
	
	public static boolean isValidIdentifier(@Nullable String value) {
		if (value == null) {
			return false;
		}
		int iMax = value.length();
		for (int i = 0; i < iMax; i++) {
			char c = value.charAt(i);
			if (('A' <= c) && (c <= 'Z')) {					
			}
			else if (('a' <= c) && (c <= 'z')) {					
			}
			else if (c == '_') {					
			}
			else if (('0' <= c) && (c <= '9') && (i > 0)) {					
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static <T extends EObject> void refreshList(@Nullable List<? super T> oldElements, @Nullable List<? extends T> newElements) {
		if (oldElements == null) {
			return;			// Never happens but avoids need for null validation in caller
		}
		if (newElements == null) {
			if (oldElements.size() > 0) {
				oldElements.clear();
			}
			return;
		}
		for (int k = newElements.size(); k-- > 0; ) {
			T newElement = newElements.get(k);
			if (newElement.eIsProxy()) {
				oldElements.remove(newElement);			// Lose oldContent before adding possible 'duplicates'
			}
		}
		for (int k = oldElements.size(); k-- > 0; ) {
			Object oldElement = oldElements.get(k);
			if (!newElements.contains(oldElement)) {
				oldElements.remove(k);			// Lose oldContent before adding possible 'duplicates'
			}
		}
		int newMax = newElements.size();
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			T newElement = newElements.get(i);
			int oldMax = oldElements.size();
			boolean reused = false;;
			for (int j = i; j < oldMax; j++) {
				Object oldElement = oldElements.get(j);
				if (oldElement == newElement) {
					if (j != i) {
						oldElements.remove(j);
						oldElements.add(i, newElement);
					}
					reused = true;
					break;
				}
			}
			if (!reused) {
				if (i < oldMax) {
					oldElements.add(i, newElement);
				}
				else {
					oldElements.add(newElement);
				}
			}
			assert newElements.get(i) == oldElements.get(i);
		}
		for (int k = oldElements.size(); k > newMax; ) {
			oldElements.remove(--k);
		}
		assert newElements.size() == oldElements.size();
	}

	public static <T extends EObject> void refreshSet(@Nullable List<? super T> oldElements, @Nullable Collection<? extends T> newElements) {
		if (oldElements == null) {
			return;			// Never happens but avoids need for null validation in caller
		}
		if (newElements == null) {
			oldElements.clear();
			return;
		}
		for (int i = oldElements.size(); i-- > 0;) {	// Remove any oldElements not in newElements
			Object oldElement = oldElements.get(i);
			if (!newElements.contains(oldElement)) {
				oldElements.remove(i);
			}
		}
		for (T newElement : newElements) {				// Add any newElements not in oldElements
			if (!newElement.eIsProxy() && !oldElements.contains(newElement)) {
				oldElements.add(newElement);
			}
		}
	}

	/**
	 * Define oclExpression as the bodyExpression of an expressionInOCL, and if non-null
	 * also define stringExpression as the OCL-languaged body.
	 */
	public static void setBody(@NonNull ExpressionInOCL expressionInOCL, @Nullable OCLExpression oclExpression, @Nullable String stringExpression) {
		setBody(expressionInOCL, stringExpression);
		expressionInOCL.setBodyExpression(oclExpression);
	}

	/**
	 * Define oclExpression as the bodyExpression of an expressionInOCL, and if non-null
	 * also define stringExpression as the OCL-languaged body.
	 */
	public static void setBody(@NonNull OpaqueExpression opaqueExpression, @Nullable String stringExpression) {
		opaqueExpression.getBody().clear();
		opaqueExpression.getLanguage().clear();
		if (stringExpression != null) {
			opaqueExpression.getBody().add(stringExpression);
			opaqueExpression.getLanguage().add(PivotConstants.OCL_LANGUAGE);
		}
	}

	/**
	 * Define oclExpression as the bodyExpression of an expressionInOCL, and if non-null
	 * also define stringExpression as the OCL-languaged body.
	 */
	@Deprecated // Rich invariants now represented by Tuples
	public static void setMessage(@NonNull ExpressionInOCL expressionInOCL, @Nullable OCLExpression oclExpression, @Nullable String stringExpression) {
//		expressionInOCL.getBody().clear();
//		expressionInOCL.getLanguage().clear();
//		if (stringExpression != null) {
//			expressionInOCL.getBody().add(stringExpression);
//			expressionInOCL.getLanguage().add(PivotConstants.OCL_LANGUAGE);
//		}
//		expressionInOCL.setMessageExpression(oclExpression);
	}

	/**
	 * Configure resource to support parsing in the context of an eObject. Throws a ParserException
	 * if a pivot element cannot be identified for eObject.eClass(). Return false if a pivot element
	 * can be identified, but it is not one that supports constraint parsing.
	 *
	 * @throws ParserException if eObject cannot be converted to a Pivot element
	 */
	public static boolean setParserContext(@NonNull BaseResource resource, @NonNull EObject eObject, Object... todoParameters) throws ParserException {
		ResourceSet resourceSet = DomainUtil.nonNullState(resource.getResourceSet());
		MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
		Element pivotElement;
		if (eObject instanceof Element) {
			pivotElement = (Element) eObject;
		}
		else {
			pivotElement = metaModelManager.getPivotOf(Element.class, eObject);
			if ((eObject instanceof org.eclipse.uml2.uml.Constraint) && (pivotElement instanceof Constraint) && (pivotElement.eContainer() == null)) {
				pivotElement = metaModelManager.getPivotOf(Element.class, ((org.eclipse.uml2.uml.Constraint)eObject).getSpecification());
			}
		}
		if (pivotElement == null) {
			return false;
		}
		ParserContext parserContext = metaModelManager.getParserContext(pivotElement, todoParameters);
		if (parserContext == null) {
			return false;
		}
		else {
			resource.setParserContext(parserContext);
			return true;
		}
	}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	@Deprecated
	public static char toHex(int nibble) {
		return DomainUtil.toHex(nibble);
	}
}
