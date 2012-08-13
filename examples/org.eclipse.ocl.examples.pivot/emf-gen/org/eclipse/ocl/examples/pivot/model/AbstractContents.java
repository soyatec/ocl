/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package	org.eclipse.ocl.examples.pivot.model;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.VoidType;

public class AbstractContents
{
	protected @NonNull AnyType createAnyType(@NonNull String name) {
		AnyType pivotType = PivotFactory.eINSTANCE.createAnyType();
		pivotType.setName(name);
		return pivotType;
	}

	protected @NonNull BagType createBagType(@NonNull String name, @Nullable String lower, @Nullable String upper) {
		BagType pivotType = PivotFactory.eINSTANCE.createBagType();
		pivotType.setName(name);
		pivotType.setLower(lower != null ? new BigInteger(lower) : BigInteger.valueOf(0));
		pivotType.setUpper(upper != null ? new BigInteger(upper) : BigInteger.valueOf(-1));
		return pivotType;
	}

	protected @NonNull Class createClass(@NonNull String name) {
		Class pivotType = PivotFactory.eINSTANCE.createClass();
		pivotType.setName(name);
		return pivotType;
	}

	protected @NonNull ClassifierType createClassifierType(@NonNull String name) {
		ClassifierType pivotType = PivotFactory.eINSTANCE.createClassifierType();
		pivotType.setName(name);
		return pivotType;
	}

	protected @NonNull CollectionType createCollectionType(@NonNull String name, @Nullable String lower, @Nullable String upper) {
		CollectionType pivotType = PivotFactory.eINSTANCE.createCollectionType();
		pivotType.setName(name);
		pivotType.setLower(lower != null ? new BigInteger(lower) : BigInteger.valueOf(0));
		pivotType.setUpper(upper != null ? new BigInteger(upper) : BigInteger.valueOf(-1));
		return pivotType;
	}

	protected @NonNull DataType createDataType(@NonNull String name) {
		DataType pivotType = PivotFactory.eINSTANCE.createDataType();
		pivotType.setName(name);
		return pivotType;
	}
	
	protected @NonNull Enumeration createEnumeration(@NonNull String name) {
		Enumeration pivotType = PivotFactory.eINSTANCE.createEnumeration();
		pivotType.setName(name);
		return pivotType;
	}

	protected @NonNull EnumerationLiteral createEnumerationLiteral(@NonNull String name) {
		EnumerationLiteral pivotEnumerationLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		pivotEnumerationLiteral.setName(name);
		return pivotEnumerationLiteral;
	}
	
	protected @NonNull Iteration createIteration(@NonNull String name, Type type, String implementationClass, @NonNull LibraryFeature implementation) {
		Iteration pivotIteration = PivotFactory.eINSTANCE.createIteration();
		pivotIteration.setName(name);
		pivotIteration.setType(type);
		pivotIteration.setImplementationClass(implementationClass);
		pivotIteration.setImplementation(implementation);
		return pivotIteration;
	}

	protected @NonNull InvalidType createInvalidType(@NonNull String name) {
		InvalidType pivotType = PivotFactory.eINSTANCE.createInvalidType();
		pivotType.setName(name);
		return pivotType;
	}
	
	protected @NonNull LambdaType createLambdaType(@NonNull String name) {
		LambdaType pivotType = PivotFactory.eINSTANCE.createLambdaType();
		pivotType.setName(name);
		return pivotType;
	}

	protected @NonNull Library createLibrary(@NonNull String name, String nsPrefix, @NonNull String nsURI) {
		Library pivotLibrary = PivotFactory.eINSTANCE.createLibrary();
		pivotLibrary.setName(name);
		pivotLibrary.setNsPrefix(nsPrefix);
		pivotLibrary.setNsURI(nsURI);
		return pivotLibrary;
	}
	
	protected @NonNull Operation createOperation(@NonNull String name, @NonNull Type type, @Nullable String implementationClass, @Nullable LibraryFeature implementation) {
		Operation pivotOperation = PivotFactory.eINSTANCE.createOperation();
		pivotOperation.setName(name);
		pivotOperation.setType(type);
		pivotOperation.setImplementationClass(implementationClass);
		pivotOperation.setImplementation(implementation);
		return pivotOperation;
	}

	protected @NonNull OrderedSetType createOrderedSetType(@NonNull String name, @Nullable String lower, @Nullable String upper) {
		OrderedSetType pivotType = PivotFactory.eINSTANCE.createOrderedSetType();
		pivotType.setName(name);
		pivotType.setLower(lower != null ? new BigInteger(lower) : BigInteger.valueOf(0));
		pivotType.setUpper(upper != null ? new BigInteger(upper) : BigInteger.valueOf(-1));
		return pivotType;
	}

	protected @NonNull Package createPackage(@NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
		Package pivotPackage = PivotFactory.eINSTANCE.createPackage();
		pivotPackage.setName(name);
		pivotPackage.setNsPrefix(nsPrefix);
		pivotPackage.setNsURI(nsURI);
		return pivotPackage;
	}
	
	protected @NonNull Parameter createParameter(@NonNull String name, @NonNull Type type) {
		Parameter pivotParameter = PivotFactory.eINSTANCE.createParameter();
		pivotParameter.setName(name);
		pivotParameter.setType(type);
		return pivotParameter;
	}
	
	protected @NonNull Precedence createPrecedence(@NonNull String name, /*@NonNull*/ AssociativityKind kind) {
		assert kind != null;
		Precedence pivotPrecedence = PivotFactory.eINSTANCE.createPrecedence();
		pivotPrecedence.setName(name);
		pivotPrecedence.setAssociativity(kind);
		return pivotPrecedence;
	}
	
	protected @NonNull PrimitiveType createPrimitiveType(@NonNull String name) {
		PrimitiveType pivotType = PivotFactory.eINSTANCE.createPrimitiveType();
		pivotType.setName(name);
		return pivotType;
	}
	
	protected @NonNull Property createProperty(@NonNull String name, @NonNull Type type) {
		Property pivotProperty = PivotFactory.eINSTANCE.createProperty();
		pivotProperty.setName(name);
		pivotProperty.setType(type);
		return pivotProperty;
	}

	protected @NonNull Root createRoot(@NonNull String name, @NonNull String externalURI) {
		Root pivotRoot = PivotFactory.eINSTANCE.createRoot();
		pivotRoot.setName(name);
		pivotRoot.setExternalURI(externalURI);
		return pivotRoot;
	}

	protected @NonNull SelfType createSelfType(@NonNull String name) {
		SelfType pivotType = PivotFactory.eINSTANCE.createSelfType();
		pivotType.setName(name);
		return pivotType;
	}

	protected @NonNull SequenceType createSequenceType(@NonNull String name, @Nullable String lower, @Nullable String upper) {
		SequenceType pivotType = PivotFactory.eINSTANCE.createSequenceType();
		pivotType.setName(name);
		pivotType.setLower(lower != null ? new BigInteger(lower) : BigInteger.valueOf(0));
		pivotType.setUpper(upper != null ? new BigInteger(upper) : BigInteger.valueOf(-1));
		return pivotType;
	}

	protected @NonNull SetType createSetType(@NonNull String name, @Nullable String lower, @Nullable String upper) {
		SetType pivotType = PivotFactory.eINSTANCE.createSetType();
		pivotType.setName(name);
		pivotType.setLower(lower != null ? new BigInteger(lower) : BigInteger.valueOf(0));
		pivotType.setUpper(upper != null ? new BigInteger(upper) : BigInteger.valueOf(-1));
		return pivotType;
	}

	protected @NonNull TemplateBinding createTemplateBinding(@NonNull TemplateSignature templateSignature, TemplateParameterSubstitution... templateParameterSubstitutions) {
		TemplateBinding pivotTemplateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		List<TemplateParameterSubstitution> parameterSubstitutions = pivotTemplateBinding.getParameterSubstitution();
		for (TemplateParameterSubstitution templateParameterSubstitution : templateParameterSubstitutions) {
			parameterSubstitutions.add(templateParameterSubstitution);
		}
		pivotTemplateBinding.setSignature(templateSignature);
		return pivotTemplateBinding;
	}

	protected @NonNull TemplateParameterSubstitution createTemplateParameterSubstitution(@NonNull TemplateParameter formal, ParameterableElement actual) {
		TemplateParameterSubstitution pivotTemplateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		pivotTemplateParameterSubstitution.setFormal(formal);
		pivotTemplateParameterSubstitution.setActual(actual);
		return pivotTemplateParameterSubstitution;
	}

	protected @NonNull TemplateSignature createTemplateSignature(@NonNull TemplateableElement templateableElement, TemplateParameter... templateParameters) {
		TemplateSignature pivotTemplateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
		List<TemplateParameter> parameters = pivotTemplateSignature.getOwnedParameter();
		for (TemplateParameter templateParameter : templateParameters) {
			parameters.add(templateParameter);
		}
		pivotTemplateSignature.setTemplate(templateableElement);
		return pivotTemplateSignature;
	}
	
	protected @NonNull TupleType createTupleType(@NonNull String name, Property... properties) {
		TupleType pivotType = PivotFactory.eINSTANCE.createTupleType();
		pivotType.setName(name);
		List<Property> ownedProperties = pivotType.getOwnedAttribute();
		for (Property property : properties) {
			ownedProperties.add(property);
		}
		return pivotType;
	}

	protected @NonNull TypeTemplateParameter createTypeTemplateParameter(Type type) {
		TypeTemplateParameter pivotTypeTemplateParameter = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		pivotTypeTemplateParameter.setOwnedParameteredElement(type);
		return pivotTypeTemplateParameter;
	}

	protected @NonNull VoidType createVoidType(@NonNull String name) {
		VoidType pivotType = PivotFactory.eINSTANCE.createVoidType();
		pivotType.setName(name);
		return pivotType;
	}

	protected void installComment(Element element, @NonNull String body) {
		Comment pivotComment = PivotFactory.eINSTANCE.createComment();
		pivotComment.setBody(body);
		element.getOwnedComment().add(pivotComment);
	}
}
