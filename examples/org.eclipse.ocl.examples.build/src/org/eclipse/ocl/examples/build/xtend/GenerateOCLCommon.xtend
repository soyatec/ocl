/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.build.xtend

import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.ocl.examples.pivot.AnyType
import org.eclipse.ocl.examples.pivot.CollectionType
import org.eclipse.ocl.examples.pivot.Comment
import org.eclipse.ocl.examples.pivot.Constraint
import org.eclipse.ocl.examples.pivot.Element
import org.eclipse.ocl.examples.pivot.Enumeration
import org.eclipse.ocl.examples.pivot.EnumerationLiteral
import org.eclipse.ocl.examples.pivot.Iteration
import org.eclipse.ocl.examples.pivot.LambdaType
import org.eclipse.ocl.examples.pivot.Library
import org.eclipse.ocl.examples.pivot.Metaclass
import org.eclipse.ocl.examples.pivot.NamedElement
import org.eclipse.ocl.examples.pivot.OpaqueExpression
import org.eclipse.ocl.examples.pivot.Operation
import org.eclipse.ocl.examples.pivot.Package
import org.eclipse.ocl.examples.pivot.Parameter
import org.eclipse.ocl.examples.pivot.Precedence
import org.eclipse.ocl.examples.pivot.PrimitiveType
import org.eclipse.ocl.examples.pivot.Property
import org.eclipse.ocl.examples.pivot.Root
import org.eclipse.ocl.examples.pivot.TemplateBinding
import org.eclipse.ocl.examples.pivot.TemplateParameter
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution
import org.eclipse.ocl.examples.pivot.TemplateSignature
import org.eclipse.ocl.examples.pivot.TemplateableElement
import org.eclipse.ocl.examples.pivot.TupleType
import org.eclipse.ocl.examples.pivot.Type
import org.eclipse.xtext.util.Strings
import org.eclipse.ocl.examples.pivot.utilities.AS2Moniker

public abstract class GenerateOCLCommon extends GenerateMetamodelWorkflowComponent
{
	private var Map<Element, String> element2moniker = new HashMap<Element, String>();
	 
	protected def String declareCollectionTypes(Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedCollectionTypes()»
				protected final @NonNull «type.eClass.name» «type.getPrefixedSymbolName("_" + type.partialName())» = create«type.
				eClass.name»("«type.name»"/*«type.elementType.name»*/, "«type.lower.toString()»", "«type.upper.toString()»");
			«ENDFOR»
		'''
	}

	protected def String declareEnumerations(Package pkg) {
		'''
			«FOR enumeration : pkg.getRootPackage().getSortedEnumerations()»
				«var enumerationName = enumeration.getPrefixedSymbolName("_" + enumeration.partialName())»
				protected final @NonNull Enumeration «enumerationName» = createEnumeration("«enumeration.name»");
				«FOR enumerationLiteral : enumeration.ownedLiteral»
					protected final @NonNull EnumerationLiteral «enumerationLiteral.getPrefixedSymbolName(
				"el_" + enumerationName + "_" + enumerationLiteral.name)» = createEnumerationLiteral("«enumerationLiteral.name»");
				«ENDFOR»
			«ENDFOR»
		'''
	}

	protected def String declareMetaclasses(Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedMetaclasses()»
				protected final @NonNull Metaclass<?> «type.getPrefixedSymbolName("_" + type.partialName())» = createMetaclass("«type.
				name»");
			«ENDFOR»
		'''
	}

	protected def String declareOclTypes(Package pkg) {
		'''
			«FOR type : pkg.getSortedOclTypes()»
				protected final @NonNull «type.eClass.name» «type.getPrefixedSymbolName("_" + type.partialName())» = create«type.
				eClass.name»("«type.name»");
			«ENDFOR»
		'''
	}

	protected def String declareParameterTypes(Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedParameterTypes()»
				protected final @NonNull Class «type.getPrefixedSymbolName("_" + type.partialName())» = createClass("«type.name»");
			«ENDFOR»
		'''
	}

	protected def String declarePrimitiveTypes(Package pkg) {'''
		«FOR type : pkg.getRootPackage().getSortedPrimitiveTypes()»
		protected final @NonNull PrimitiveType «type.getPrefixedSymbolName("_" + type.partialName())» = createPrimitiveType("«type.name»");
		«ENDFOR»
	'''}

	protected def String declareProperties(Package pkg) {
		var allProperties = getAllProperties(pkg.getRootPackage());
		'''
			«FOR property : allProperties»
				protected final @NonNull Property «property.getPrefixedSymbolName("pr_" + property.partialName())» = createProperty("«property.name»", «property.type.getSymbolName()»);
			«ENDFOR»
		'''
	}

	protected def String declareTupleTypes(Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedTupleTypes()»
				protected final @NonNull TupleType «type.getPrefixedSymbolName("_" + type.partialName())» = createTupleType("«type.name»",
				«FOR property : type.getSortedTupleParts() BEFORE ("\t") SEPARATOR (",\n\t")»
				createProperty("«property.name»", «property.type.getSymbolName()»)«ENDFOR»);
			«ENDFOR»
		'''
	}

	protected def String defineCollectionTypes(Package pkg) {
		var Package orphanPackage = pkg.getOrphanPackage();
		'''
			protected void installCollectionTypes() {
				final List<Type> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				«IF orphanPackage != null»
				final List<Type> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				«ENDIF»
				CollectionType type;
				List<Type> superClasses;
				«FOR type : pkg.getRootPackage().getSortedCollectionTypes()»
				«IF type.unspecializedElement == null»
				ownedTypes.add(type = «type.getSymbolName()»);
				«ELSE»
				orphanTypes.add(type = «type.getSymbolName()»);
				type.setUnspecializedElement(«type.unspecializedElement.getSymbolName()»);
				«ENDIF»
				type.setElementType(«type.elementType.getSymbolName()»);
				«type.emitSuperClasses()»
			«ENDFOR»
			}
		'''
	}

	protected def String defineComments(Package pkg) {
		'''
			protected void installComments() {
				«FOR pElement : pkg.getRootPackage().getSortedCommentedElements()»
				«FOR pComment : pElement.getSortedComments()»
					installComment(«pElement.getSymbolName()», "«pComment.javaString()»");
				«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineEnumerations(Package pkg) {
		'''
			protected void installEnumerations() {
				final List<Type> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				Enumeration type;
				List<EnumerationLiteral> enumerationLiterals;
				«FOR enumeration : pkg.getRootPackage().getSortedEnumerations()»
					ownedTypes.add(type = «enumeration.getSymbolName()»);
					enumerationLiterals = type.getOwnedLiteral();
					«FOR enumerationLiteral : enumeration.ownedLiteral»
						enumerationLiterals.add(«enumerationLiteral.getSymbolName()»);
					«ENDFOR»
					type.getSuperClass().add(_Enumeration);
				«ENDFOR»
			}
		'''
	}

	protected def String defineIterations(Package pkg) {
		var List<Iteration> allIterations = pkg.getRootPackage().getSortedIterations();
		'''
			«IF allIterations.size() > 0»
				«FOR iteration : allIterations»
					protected final @NonNull Iteration «iteration.getPrefixedSymbolName("it_" + iteration.partialName())» = createIteration("«iteration.
					name»", «iteration.type.getSymbolName()», «IF iteration.implementationClass != null»"«iteration.
					implementationClass»", «iteration.implementationClass».INSTANCE«ELSE»null, null«ENDIF»);
				«ENDFOR»

			«ENDIF»
			protected void installIterations() {
				List<Operation> ownedIterations;
				List<Parameter> ownedParameters;
				Iteration iteration;
				Parameter parameter;
				«FOR type : allIterations.getSortedOwningTypes()»
					ownedIterations = «type.getSymbolName()».getOwnedOperation();
					«FOR iteration : type.getSortedIterations(allIterations)»
						ownedIterations.add(iteration = «iteration.getSymbolName()»);
						«IF iteration.isInvalidating»
							iteration.setIsInvalidating(true);
						«ENDIF»
						«IF !iteration.isRequired»
							iteration.setIsRequired(false);
						«ENDIF»
						«IF iteration.isStatic»
							iteration.setIsStatic(true);
						«ENDIF»
						«IF iteration.ownedIterator.size() > 0»
							ownedParameters = iteration.getOwnedIterator();
							«FOR parameter : iteration.ownedIterator»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.
				isRequired»));
								«IF !parameter.isRequired»
									parameter.setIsRequired(false);
								«ENDIF»
							«ENDFOR»
						«ENDIF»
						«IF iteration.ownedAccumulator.size() > 0»
							ownedParameters = iteration.getOwnedAccumulator();
							«FOR parameter : iteration.ownedAccumulator»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.
				isRequired»));
								«IF !parameter.isRequired»
									parameter.setIsRequired(false);
								«ENDIF»
							«ENDFOR»
						«ENDIF»
						«IF iteration.ownedParameter.size() > 0»
							ownedParameters = iteration.getOwnedParameter();
							«FOR parameter : iteration.ownedParameter»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.
				isRequired»));
								«IF !parameter.isRequired»
									parameter.setIsRequired(false);
								«ENDIF»
							«ENDFOR»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineLambdaTypes(Package pkg) {
		var allLambdaTypes = pkg.getRootPackage().getSortedLambdaTypes();
		var orphanPackage = pkg.getOrphanPackage();
		'''
			«FOR type : allLambdaTypes»
				protected final @NonNull LambdaType «type.getPrefixedSymbolName("_" + type.partialName())» = createLambdaType("«type.
				name»");
			«ENDFOR»
			
			protected void installLambdaTypes() {
				final List<Type> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				LambdaType type;
				List<Type> superClasses;
				«FOR type : allLambdaTypes»
					orphanTypes.add(type = «type.getSymbolName()»);
					type.setContextType(«type.contextType.getSymbolName()»);
					«FOR parameterType : type.parameterType»
						type.getParameterType().add(«parameterType.getSymbolName()»);
					«ENDFOR»
					type.setResultType(«type.resultType.getSymbolName()»);
					«type.emitSuperClasses()»
				«ENDFOR»
			}
		'''
	}

	protected def String defineMetaclasses(Package pkg) {
		var allMetaclasses = pkg.getRootPackage().getSortedMetaclasses();
		var orphanPackage = pkg.getOrphanPackage();
		'''
			protected void installMetaclasses() {
				final List<Type> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				«IF orphanPackage != null»
					final List<Type> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				«ENDIF»
				Metaclass<?> type;
				List<Type> superClasses;
				«FOR type : allMetaclasses»
					«IF type.unspecializedElement == null»
						ownedTypes.add(type = «type.getSymbolName()»);
					«ELSE»
						orphanTypes.add(type = «type.getSymbolName()»);
						type.setUnspecializedElement(«type.unspecializedElement.getSymbolName()»);
					«ENDIF»
					type.setInstanceType(«type.instanceType.getSymbolName()»);
					«type.emitSuperClasses()»
				«ENDFOR»
			}
		'''
	}

	protected def String defineOclTypes(Package pkg) {
		var allOclTypes = pkg.getSortedOclTypes();
		'''
			protected void installOclTypes() {
				final List<Type> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				Type type;
				List<Type> superClasses;
				«FOR type : allOclTypes»
					ownedTypes.add(type = «type.getSymbolName()»);
					«IF !(type instanceof AnyType)»
						«type.emitSuperClasses()»
					«ENDIF»
				«ENDFOR»
			}
		'''
	}

	protected def String defineOperations(Package pkg) {
		var allOperations = pkg.getRootPackage().getSortedOperations();
		'''
			«FOR operation : allOperations»
				protected final @NonNull Operation «operation.getPrefixedSymbolName("op_" + operation.partialName())» = createOperation("«operation.
				name»", «operation.type.getSymbolName()», «IF operation.implementationClass != null»"«operation.
				implementationClass»", «operation.implementationClass».INSTANCE«ELSE»null, null«ENDIF»);
			«ENDFOR»
			
			protected void installOperations() {
				List<Operation> ownedOperations;
				List<Parameter> ownedParameters;
				Operation operation;
				Parameter parameter;
				«FOR type : allOperations.getSortedOwningTypes()»
					ownedOperations = «type.getSymbolName()».getOwnedOperation();
					«FOR operation : type.getSortedOperations(allOperations)»
						ownedOperations.add(operation = «operation.getSymbolName()»);
						«IF operation.isInvalidating»
							operation.setIsInvalidating(true);
						«ENDIF»
						«IF !operation.isRequired»
							operation.setIsRequired(false);
						«ENDIF»
						«IF operation.isStatic»
							operation.setIsStatic(true);
						«ENDIF»
						«IF operation.isValidating»
							operation.setIsValidating(true);
						«ENDIF»
						«IF operation.bodyExpression != null»
							operation.setBodyExpression(createOpaqueExpression(«operation.type.getSymbolName()», "«operation.bodyExpression.javaString()»"));
						«ENDIF»
						«IF operation.ownedParameter.size() > 0»
							ownedParameters = operation.getOwnedParameter();
							«FOR parameter : operation.ownedParameter»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.isRequired»));
							«ENDFOR»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String definePackages(Package pkg0) {
		var rootPackage = pkg0.getRootPackage();
		var allPackages = rootPackage.getSortedPackages();
		var morePackages = new HashSet<Package>(allPackages);
		morePackages.remove(pkg0);
		'''
			«IF morePackages.size() > 0»
				«FOR pkg1 : morePackages»
					protected final @NonNull «pkg1.eClass().name» «pkg1.getPrefixedSymbolName("pk_" + pkg1.partialName())» = create«pkg1.eClass().name»("«pkg1.name»", «IF pkg1.nsPrefix != null»"«pkg1.nsPrefix»"«ELSE»null«ENDIF», «IF pkg1.nsURI != null»"«pkg1.nsURI»"«ELSE»null«ENDIF»);
				«ENDFOR»

			«ENDIF»
			protected void installPackages() {
				«emitRoot(rootPackage)»
				«IF allPackages.size() > 0»
				«FOR pkg2 : allPackages»
				«emitPackage(pkg2)»
				«ENDFOR»
				«ENDIF»
			}
		'''
	}

	protected def String defineParameterTypes(Package pkg) {
		'''
			protected void installParameterTypes() {
			}
		'''
	}

	protected def String definePrecedences(Package pkg) {
		var allLibraries = pkg.getRootPackage().getSortedLibraries();
		var allOperations = pkg.getRootPackage().getSortedOperationsWithPrecedence();
		'''
			«IF allLibraries.size() > 0»
				protected void installPrecedences() {
					«FOR lib : allLibraries»
						«var allPrecedences = lib.getSortedPrecedences()»
						«FOR precedence : allPrecedences»
							final Precedence «precedence.getPrefixedSymbolName("prec_" + precedence.partialName())» = createPrecedence("«precedence.name»", AssociativityKind.«precedence.associativity.toString().toUpperCase()»);
						«ENDFOR»

						final List<Precedence> ownedPrecedences = «lib.getSymbolName()».getOwnedPrecedence();
						«FOR precedence : lib.ownedPrecedence»
							ownedPrecedences.add(«precedence.getSymbolName()»);
						«ENDFOR»
					«ENDFOR»

					«FOR operation : allOperations»
						«operation.getSymbolName()».setPrecedence(«operation.precedence.getSymbolName()»);
					«ENDFOR»
				}
			«ENDIF»
		'''
	}

	protected def String definePrimitiveTypes(Package pkg) {
		var allTypes = pkg.getRootPackage().getSortedPrimitiveTypes();
		'''
			protected void installPrimitiveTypes() {
				final List<Type> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				PrimitiveType type;
				«FOR type : allTypes»
					«var superClasses = type.getSuperclassesInPackage()»
					ownedTypes.add(type = «type.getSymbolName()»);
					«FOR superClass : superClasses»
						type.getSuperClass().add(«superClass.getSymbolName()»);
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineProperties(Package pkg) {
		var allProperties = getAllProperties(pkg.getRootPackage());
		'''
			protected void installProperties() {
				List<Property> ownedProperties;
				Property property;
				«FOR type : allProperties.getSortedOwningTypes2()»
					ownedProperties = «type.getSymbolName()».getOwnedAttribute();
					«FOR property : type.getSortedProperties(allProperties)»
						ownedProperties.add(property = «property.getSymbolName()»);
						«IF property.isComposite»
							property.setIsComposite(true);
						«ENDIF»
						«IF property.isDerived»
							property.setIsDerived(true);
						«ENDIF»
						«IF property.isID»
							property.setIsID(true);
						«ENDIF»
						«IF property.implicit»
							property.setImplicit(true);
						«ENDIF»
						«IF property.isReadOnly»
							property.setIsReadOnly(true);
						«ENDIF»
						«IF !property.isRequired»
							property.setIsRequired(false);
						«ENDIF»
						«IF property.isResolveProxies»
							property.setIsResolveProxies(true);
						«ENDIF»
						«IF property.isStatic»
							property.setIsStatic(true);
						«ENDIF»
						«IF property.isTransient»
							property.setIsTransient(true);
						«ENDIF»
						«IF property.isUnsettable»
							property.setIsUnsettable(true);
						«ENDIF»
						«IF property.isVolatile»
							property.setIsVolatile(true);
						«ENDIF»
						«IF property.opposite != null»
							property.setOpposite(«property.opposite.getSymbolName()»);
						«ENDIF»
						«IF property.implementationClass != null»
							property.setImplementationClass("«property.implementationClass»");
							property.setImplementation(«property.implementationClass».INSTANCE);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineTemplateBindings(Package pkg) {
		var allTemplateableElements = pkg.getRootPackage().getSortedTemplateableElements();
		'''
			protected void installTemplateBindings() {
				«FOR templateableElement : allTemplateableElements»
					«FOR templateBinding : templateableElement.templateBinding»
						«templateableElement.getSymbolName()».getTemplateBinding().add(createTemplateBinding(«templateBinding.signature.getSymbolName()»,
							«FOR templateParameterSubstitution : templateBinding.parameterSubstitution SEPARATOR (",\n")»
							createTemplateParameterSubstitution(«templateParameterSubstitution.formal.getSymbolName()», «templateParameterSubstitution.actual.getSymbolName()»)«ENDFOR»));
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineTemplateSignatures(Package pkg) {
		var allTemplateParameters = pkg.getRootPackage().getSortedTemplateParameters();
		var allTemplateSignatures = pkg.getRootPackage().getSortedTemplateSignatures();
		'''
			«FOR templateParameter : allTemplateParameters»
			protected final @NonNull TypeTemplateParameter «templateParameter.getPrefixedSymbolName(
						"tp_" + templateParameter.partialName())» = createTypeTemplateParameter(«templateParameter.
						ownedParameteredElement.getSymbolName()»);
			«ENDFOR»
			
			«FOR templateSignature : allTemplateSignatures»
			protected final @NonNull TemplateSignature «templateSignature.getPrefixedSymbolName(
						"ts_" + templateSignature.partialName())» = createTemplateSignature(«templateSignature.template.getSymbolName()»«FOR templateParameter : templateSignature.
						ownedParameter», «templateParameter.getSymbolName()»«ENDFOR»);
			«ENDFOR»
			
			protected void installTemplateSignatures() {
			}
		'''
	}

	protected def String defineTupleTypes(Package pkg) {
		var allTupleTypes = pkg.getRootPackage().getSortedTupleTypes();
		var orphanPackage = pkg.getOrphanPackage();
		'''
			protected void installTupleTypes() {
				final List<Type> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				TupleType type;
				List<Type> superClasses;
				«FOR type : allTupleTypes»
					orphanTypes.add(type = «type.getSymbolName()»);
					«FOR property : type.getSortedProperties()»
						«IF property.implementationClass != null»
							«property.getSymbolName()».setImplementationClass("«property.implementationClass»");
							«property.getSymbolName()».setImplementation(«property.implementationClass».INSTANCE);
						«ENDIF»
					«ENDFOR»
					«type.emitSuperClasses()»
				«ENDFOR»
			}
		'''
	}

	protected def String emitCreateProperty(Property property) {
		return "createProperty(" + property.name + ", " + property.type.getSymbolName() + ")";
	}

	protected def String emitPackage(Package pkg) {
		'''
			«FOR nestedPackage : pkg.getSortedPackages()»
				«IF nestedPackage.nestedPackage.size() > 0»
					«emitPackage(nestedPackage)»
				«ENDIF»
				«pkg.getSymbolName()».getNestedPackage().add(«nestedPackage.getSymbolName()»);
			«ENDFOR»
		'''
	}

	protected def String emitRoot(Root pkg) {
		'''
			«FOR nestedPackage : pkg.getSortedPackages()»
				«IF nestedPackage.nestedPackage.size() > 0»
					«emitPackage(nestedPackage)»
				«ENDIF»
				«pkg.getSymbolName()».getNestedPackage().add(«nestedPackage.getSymbolName()»);
			«ENDFOR»
		'''
	}

	protected def String emitSuperClasses(Type type) {
		var superClasses = type.getSuperclassesInPackage();
		'''
			«IF superClasses.size() > 0»
				superClasses = type.getSuperClass();
				«FOR superClass : superClasses»
					superClasses.add(«superClass.getSymbolName()»);
				«ENDFOR»
			«ELSEIF !(type instanceof AnyType)»
				superClasses = type.getSuperClass();
				superClasses.add(_OclElement);
			«ENDIF»
		'''
	}

	protected def Set<CollectionType> getAllCollectionTypes(Root root) {
		var Set<CollectionType> allElements = new HashSet<CollectionType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof CollectionType) {
				allElements.add(eObject as CollectionType);
			}
		}
		return allElements;
	}

	protected def Set<Enumeration> getAllEnumerations(Root root) {
		var Set<Enumeration> allElements = new HashSet<Enumeration>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Enumeration) {
				allElements.add(eObject as Enumeration);
			}
		}
		return allElements;
	}

	protected def Set<LambdaType> getAllLambdaTypes(Root root) {
		var Set<LambdaType> allElements = new HashSet<LambdaType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof LambdaType) {
				allElements.add(eObject as LambdaType);
			}
		}
		return allElements;
	}

	protected def Set<Metaclass<?>> getAllMetaclasses(Root root) {
		var Set<Metaclass<?>> allElements = new HashSet<Metaclass<?>>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Metaclass<?>) {
				allElements.add(eObject as Metaclass<?>);
			}
		}
		return allElements;
	}

	protected def List<Package> getAllPackages(Root root) {
		var Set<Package> allElements = new HashSet<Package>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Package) {
				allElements.add(eObject as Package);
			}
		}
		var List<Package> sortedElements = new ArrayList<Package>(allElements);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.getMoniker(); var m2 = t2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def Set<Precedence> getAllPrecedences(Root root) {
		var Set<Precedence> allElements = new HashSet<Precedence>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Precedence) {
				allElements.add(eObject as Precedence);
			}
		}
		return allElements;
	}

	protected def Set<PrimitiveType> getAllPrimitiveTypes(Root root) {
		var Set<PrimitiveType> allElements = new HashSet<PrimitiveType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof PrimitiveType) {
				allElements.add(eObject as PrimitiveType);
			}
		}
		return allElements;
	}

	protected def List<Property> getAllProperties(Root root) {
		var List<Property> allElements = new ArrayList<Property>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if ((eObject instanceof Property) && !(eObject.eContainer() instanceof TupleType) &&
				((eObject as Property).owningType != null)) {
				allElements.add(eObject as Property);
			}
		}
		return allElements;
	}

	protected def Set<TemplateBinding> getAllTemplateBindings(Root root) {
		var Set<TemplateBinding> allElements = new HashSet<TemplateBinding>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof TemplateBinding) {
				allElements.add(eObject as TemplateBinding);
			}
		}
		return allElements;
	}

	protected def Set<TemplateSignature> getAllTemplateSignatures(Root root) {
		var Set<TemplateSignature> allElements = new HashSet<TemplateSignature>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof TemplateSignature) {
				allElements.add(eObject as TemplateSignature);
			}
		}
		return allElements;
	}

	protected def Set<TupleType> getAllTupleTypes(Root root) {
		var Set<TupleType> allElements = new HashSet<TupleType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof TupleType) {
				allElements.add(eObject as TupleType);
			}
		}
		return allElements;
	}

	protected def Set<Type> getAllTypes(Root root) {
		var Set<Type> allElements = new HashSet<Type>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Type) {
				allElements.add(eObject as Type);
			}
		}
		return allElements;
	}

	protected def String getMoniker(Element elem) {
		var String moniker = element2moniker.get(elem);
		if (moniker == null) {
			moniker = AS2Moniker.toString(elem);
			element2moniker.put(elem, moniker);
		}
		return moniker;
	}

	protected def Collection<Type> getOclTypes(Root root) {
		var Map<String, Type> allElements = new HashMap<String, Type>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if ((eObject instanceof Type) && !(eObject instanceof Enumeration) && !(eObject instanceof LambdaType) &&
				!(eObject instanceof CollectionType) && !(eObject instanceof PrimitiveType) &&
				!(eObject instanceof Metaclass<?>) && !(eObject instanceof TupleType) &&
				((eObject as Type).owningTemplateParameter == null)) {
				allElements.put((eObject as Type).name, eObject as Type);
			}
		}
		if (allElements.containsKey("Boolean")) {
			allElements.remove("Boolean");
			allElements.remove("Integer");
			allElements.remove("OclElement");
			allElements.remove("Real");
			allElements.remove("String");
			allElements.remove("UnlimitedNatural");
		}
		return allElements.values();
	}

	protected def Package getOrphanPackage(Package elem) {
		return getOrphanPackage(elem.getRootPackage());
	}

	protected def Package getOrphanPackage(Root elem) {
		for (pkg : elem.getAllPackages()) {
			if ("$$".equals(pkg.name)) {
				return pkg;
			}
		}
		return null;
	}

	protected def Root getRootPackage(Package elem) {
		var EObject eObject = elem;
		while (eObject != null) {
			if (eObject instanceof Root) {
				return eObject as Root;
			}
			eObject = eObject.eContainer();
		}
		return null;
	}

	protected def String getSignature(NamedElement elem) {
		var EObject parent = elem.eContainer();
		if (parent != null) {
			return (parent as NamedElement).getSignature() + "::" + elem.name;
		} else {
			return elem.name;
		}
	}

	protected def String getSignature(Operation elem) {
		var EObject parent = elem.eContainer();
		if (parent != null) {
			return (parent as NamedElement).getSignature() + "::" + elem.name + "()";
		} else {
			return elem.name + "()";
		}
	}

	protected def String getPrefixedSymbolName(EObject elem, String prefix) {
		return NameQueries.getPrefixedSymbolName(prefix, elem);
	}

	protected def ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	protected def List<CollectionType> getSortedCollectionTypes(Root root) {
		var Set<CollectionType> allElements = new HashSet<CollectionType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof CollectionType) {
				allElements.add(eObject as CollectionType);
			}
		}
		var List<CollectionType> sortedElements = new ArrayList<CollectionType>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Element> getSortedCommentedElements(Root root) {
		var Collection<Type> oclTypes = root.getOclTypes();
		var Set<Element> allElements = new HashSet<Element>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if ((eObject instanceof Element) && !(eObject instanceof Constraint) &&
				!((eObject instanceof Property) && ((eObject as Property).owningType == null)) &&
				!((eObject instanceof Type) && !oclTypes.contains(eObject))) {
				var Element t = eObject as Element;
				if (t.ownedComment.size() > 0) {
					allElements.add(t);
				}
			}
		}
		var List<Element> sortedElements = new ArrayList<Element>(allElements);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.getMoniker(); var m2 = t2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Comment> getSortedComments(Element element) {
		var List<Comment> sortedElements = new ArrayList<Comment>(element.ownedComment);
		Collections.sort(sortedElements, [c1, c2|var n1 = c1.body var n2 = c2.body; n1.compareTo(n2)]);
		return sortedElements;
	}

	protected def List<Enumeration> getSortedEnumerations(Root root) {
		var Set<Enumeration> allElements = new HashSet<Enumeration>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Enumeration) {
				allElements.add(eObject as Enumeration);
			}
		}
		var List<Enumeration> sortedElements = new ArrayList<Enumeration>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Iteration> getSortedIterations(Root root) {
		var Set<Iteration> allElements = new HashSet<Iteration>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Iteration) {
				allElements.add(eObject as Iteration);
			}
		}
		var List<Iteration> sortedElements = new ArrayList<Iteration>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Iteration> getSortedIterations(Type type, List<Iteration> allIterations) {
		var Set<Iteration> allElements = new HashSet<Iteration>();
		for (Operation operation : type.ownedOperation) {
			if (allIterations.contains(operation)) {
				allElements.add(operation as Iteration);
			}
		}
		var List<Iteration> sortedElements = new ArrayList<Iteration>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<LambdaType> getSortedLambdaTypes(Root root) {
		var Set<LambdaType> allElements = new HashSet<LambdaType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof LambdaType) {
				allElements.add(eObject as LambdaType);
			}
		}
		var List<LambdaType> sortedElements = new ArrayList<LambdaType>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Library> getSortedLibraries(Root root) {
		var Set<Library> allElements = new HashSet<Library>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Library) {
				allElements.add(eObject as Library);
			}
		}
		var List<Library> sortedElements = new ArrayList<Library>(allElements);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.getMoniker(); var m2 = t2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Metaclass<?>> getSortedMetaclasses(Root root) {
		var Set<Metaclass<?>> allElements = new HashSet<Metaclass<?>>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Metaclass<?>) {
				allElements.add(eObject as Metaclass<?>);
			}
		}
		var List<Metaclass<?>> sortedElements = new ArrayList<Metaclass<?>>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Type> getSortedOclTypes(Package pkg) {
		var List<Type> sortedElements = new ArrayList<Type>(pkg.getRootPackage().getOclTypes());
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.getMoniker(); var m2 = t2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Operation> getSortedOperations(Root root) {
		var Set<Operation> allElements = new HashSet<Operation>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if ((eObject instanceof Operation) && !(eObject instanceof Iteration) &&
				!(eObject as Operation).isEcoreConstraint()) {
				allElements.add(eObject as Operation);
			}
		}
		var List<Operation> sortedElements = new ArrayList<Operation>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Operation> getSortedOperations(Type type, List<Operation> allOperations) {
		var Set<Operation> allElements = new HashSet<Operation>();
		for (Operation operation : type.ownedOperation) {
			if (allOperations.contains(operation)) {
				allElements.add(operation);
			}
		}
		var List<Operation> sortedElements = new ArrayList<Operation>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Operation> getSortedOperationsWithPrecedence(Root root) {
		var Set<Operation> allElements = new HashSet<Operation>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if ((eObject instanceof Operation) && !(eObject instanceof Iteration) &&
				!(eObject as Operation).isEcoreConstraint()) {
				var operation = eObject as Operation;
				if (!(operation instanceof Iteration) && !operation.isEcoreConstraint() &&
					(operation.precedence != null)) {
					allElements.add(operation);
				}
			}
		}
		var List<Operation> sortedElements = new ArrayList<Operation>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Type> getSortedOwningTypes(List<? extends Operation> operations) {
		var Set<Type> allElements = new HashSet<Type>();
		for (Operation operation : operations) {
			if (operation.owningType != null) {
				allElements.add(operation.owningType);
			}
		}
		var List<Type> sortedElements = new ArrayList<Type>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Type> getSortedOwningTypes2(List<? extends Property> properties) {
		var Set<Type> allElements = new HashSet<Type>();
		for (Property property : properties) {
			if (property.owningType != null) {
				allElements.add(property.owningType);
			}
		}
		var List<Type> sortedElements = new ArrayList<Type>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Package> getSortedPackages(Root root) {
		var Set<Package> allElements = new HashSet<Package>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Package) {
				allElements.add(eObject as Package);
			}
		}
		var List<Package> sortedElements = new ArrayList<Package>(allElements);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.name; var m2 = t2.name; m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Package> getSortedPackages(Package pkg) {
		var List<Package> sortedElements = new ArrayList<Package>(pkg.nestedPackage);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.name; var m2 = c2.name; m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Type> getSortedParameterTypes(Root root) {
		var Set<Type> allElements = new HashSet<Type>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Type) {
				var Type t = eObject as Type;
				if (t.owningTemplateParameter != null) {
					allElements.add(t);
				}
			}
		}
		var List<Type> sortedElements = new ArrayList<Type>(allElements);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.getMoniker(); var m2 = t2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Precedence> getSortedPrecedences(Library library) {
		var List<Precedence> sortedElements = new ArrayList<Precedence>(library.ownedPrecedence);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.name; var m2 = t2.name; m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<PrimitiveType> getSortedPrimitiveTypes(Root root) {
		var Set<PrimitiveType> allElements = new HashSet<PrimitiveType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof PrimitiveType) {
				allElements.add(eObject as PrimitiveType);
			}
		}
		var List<PrimitiveType> sortedElements = new ArrayList<PrimitiveType>(allElements);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.getMoniker(); var m2 = t2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Property> getSortedProperties(Root root) {
		var List<Property> allElements = new ArrayList<Property>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if ((eObject instanceof Property) && !(eObject.eContainer() instanceof TupleType) &&
				((eObject as Property).owningType != null)) {
				allElements.add(eObject as Property);
			}
		}
		var List<Property> sortedElements = new ArrayList<Property>(allElements);
		Collections.sort(sortedElements, [t1, t2|var m1 = t1.getMoniker(); var m2 = t2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Property> getSortedProperties(Type type) {
		var List<Property> sortedElements = new ArrayList<Property>(type.ownedAttribute);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.name; var m2 = c2.name; m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Property> getSortedProperties(Type type, List<Property> allProperties) {
		var Set<Property> allElements = new HashSet<Property>();
		for (Property property : type.ownedAttribute) {
			if (allProperties.contains(property)) {
				allElements.add(property);
			}
		}
		var List<Property> sortedElements = new ArrayList<Property>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<TemplateParameter> getSortedTemplateParameters(Root root) {
		var Set<TemplateParameter> allElements = new HashSet<TemplateParameter>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof TemplateParameter) {
				allElements.add(eObject as TemplateParameter);
			}
		}
		var List<TemplateParameter> sortedElements = new ArrayList<TemplateParameter>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<TemplateSignature> getSortedTemplateSignatures(Root root) {
		var Set<TemplateSignature> allElements = new HashSet<TemplateSignature>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof TemplateSignature) {
				allElements.add(eObject as TemplateSignature);
			}
		}
		var List<TemplateSignature> sortedElements = new ArrayList<TemplateSignature>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<TemplateableElement> getSortedTemplateableElements(Root root) {
		var Set<TemplateableElement> allElements = new HashSet<TemplateableElement>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if ((eObject instanceof TemplateableElement) &&
				((eObject as TemplateableElement).templateBinding.size() > 0)) {
				allElements.add(eObject as TemplateableElement);
			}
		}
		var List<TemplateableElement> sortedElements = new ArrayList<TemplateableElement>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Property> getSortedTupleParts(TupleType tupleType) {
		var List<Property> sortedElements = new ArrayList<Property>(tupleType.ownedAttribute);
		Collections.sort(sortedElements, [c1, c2|var n1 = c1.name var n2 = c2.name; n1.compareTo(n2)]);
		return sortedElements;
	}

	protected def List<TupleType> getSortedTupleTypes(Root root) {
		var Set<TupleType> allElements = new HashSet<TupleType>();
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof TupleType) {
				allElements.add(eObject as TupleType);
			}
		}
		var List<TupleType> sortedElements = new ArrayList<TupleType>(allElements);
		Collections.sort(sortedElements, [c1, c2|var m1 = c1.getMoniker(); var m2 = c2.getMoniker(); m1.compareTo(m2)]);
		return sortedElements;
	}

	protected def List<Type> getSuperclassesInPackage(Type type) {
		var List<Type> allElements = new ArrayList<Type>();
		for (Type superclass : type.superClass) {
			if (superclass.getPackage().getRootPackage() == type.getPackage().getRootPackage()) {
				allElements.add(superclass);
			}
		}
		return allElements;
	}

	protected def List<TemplateParameterSubstitution> getTemplateParameterSubstitutions(TemplateableElement element) {
		var List<TemplateParameterSubstitution> allElements = new ArrayList<TemplateParameterSubstitution>();
		for (TemplateBinding templateBinding : element.templateBinding) {
			allElements.addAll(templateBinding.parameterSubstitution);
		}
		return allElements;
	}

	protected def String getSymbolName(EObject elem) {
		return NameQueries.getSymbolName(elem);
	}

	protected def Boolean isEcoreConstraint(Operation operation) {
		for (Parameter p : operation.ownedParameter) {
			if (p.name.equals("diagnostics") && p.type.name.equals("EDiagnosticChain")) {
				return true;
			}
		}
		return false;
	}

	protected def String javaName(NamedElement element) {
		return NameQueries.rawEncodeName(element.name, 0);
	}

	protected def String javaName(Object element, String string) {
		return NameQueries.rawEncodeName(string, 0);
	}

	protected def String javaString(Comment aComment) {
		return Strings.convertToJavaString(aComment.body.trim());
	}

	protected def String javaString(OpaqueExpression anExpression) {
		return Strings.convertToJavaString(anExpression.body.get(0).trim());
	}

	protected def String partialName(EObject element) {
		switch element {
			CollectionType case element.elementType == null: return element.javaName()
			CollectionType: return element.javaName() + "_" + element.elementType.partialName()
//			InvalidType: return "invalid"		
			LambdaType case element.contextType == null: return "null"
			LambdaType: return element.javaName() + "_" + element.contextType.partialName()
//			VoidType: return "void"		
			Type case element.templateParameter != null: return element.templateParameter.simpleName() + "_" + element.javaName()
			Type case element.templateBinding.size() > 0: return '''«element.javaName()»«FOR TemplateParameterSubstitution tps : element.getTemplateParameterSubstitutions()»_«tps.actual.simpleName()»«ENDFOR»'''
			Type: return element.javaName()
			Comment case element.body == null: return "null"
			Comment: return element.javaName(element.body.substring(0, Math.min(11, element.body.length() - 1)))
			EnumerationLiteral case element.enumeration == null: return "null"
			EnumerationLiteral: return element.enumeration.partialName() + "_" + element.javaName()
			Operation case element.owningType == null: return "null_" + element.javaName()
			Operation: return element.owningType.partialName() + "_" + element.javaName()
			Package: return element.javaName()
			Parameter case element.eContainer() == null: return "null_" + element.javaName()
			Parameter: return element.eContainer().partialName() + "_" + element.javaName()
			Precedence: return element.javaName()
			Property case element.owningType == null: return "null_" + element.javaName()
			Property: return element.owningType.partialName() + "_" + element.javaName()
			TemplateBinding case element.signature.template == null: return "null"
			TemplateBinding: return element.boundElement.partialName()
			TemplateParameter case element.signature.template == null: return "[" + element.signature.partialName() + "]"
			TemplateParameter case element.parameteredElement == null: return element.signature.template.partialName()
			TemplateParameter case true: return element.signature.template.partialName()
			TemplateParameter: return element.signature.template.partialName() + "_" + element.parameteredElement.simpleName()
			TemplateParameterSubstitution case element.templateBinding == null: return "null"
			TemplateParameterSubstitution case element.templateBinding.boundElement == null: return "null"
			TemplateParameterSubstitution: return element.templateBinding.boundElement.partialName()
			TemplateSignature case element.template == null: return "null"
			TemplateSignature: return element.template.partialName()
			default: return "xyzzy" + element.eClass().name
		}		
	}

	protected def String simpleName(EObject element) {
		switch element {
//			InvalidType: return "invalid"		
//			VoidType: return "void"		
			TemplateParameter case element.signature.template == null: return "null"
			TemplateParameter: return element.signature.template.simpleName()
			TemplateParameterSubstitution case element.templateBinding == null: return "null"
			TemplateParameterSubstitution case element.templateBinding.boundElement == null: return "null"
			TemplateParameterSubstitution: return element.templateBinding.boundElement.simpleName()
			Type case element.templateParameter == null: return element.javaName()
			Type: return element.templateParameter.simpleName() + "_" + element.javaName()
			Operation case element.owningType == null: return "null_" + element.javaName()
			Operation: return element.owningType.simpleName() + "_" + element.javaName()
			default: return "xyzzy" + element.eClass().name
		}		
	}
}
