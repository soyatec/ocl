/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IteratorExp.java,v 1.2 2011/01/24 20:42:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIteratorExp()
 * @model
 * @generated
 */
public interface IteratorExp extends LoopExp, ReferringElement
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\ntrue\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ClosureBodyTypeIsConformanttoIteratorType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ClosureBodyTypeIsConformanttoIteratorType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateClosureBodyTypeIsConformanttoIteratorType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\ntrue\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_SortedByIteratorTypeIsComparable.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"SortedByIteratorTypeIsComparable\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateSortedByIteratorTypeIsComparable(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'any\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_AnyHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"AnyHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__ANY_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateAnyHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type is the same as the source element type
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'any\' implies type = source.type.oclAsType(CollectionType).elementType\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_AnyTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"AnyTypeIsSourceElementType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__ANY_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateAnyTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the body must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'any\' implies body.type = \'Boolean\'\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_AnyBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"AnyBodyTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__ANY_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateAnyBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'closure\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ClosureHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ClosureHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__CLOSURE_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateClosureHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The collection type for an OrderedSet or a Sequence source type is OrderedSet.
	 * For any other source the collection type is Set.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'closure\' implies\nif\n  source.type.oclIsKindOf(SequenceType) or\n  source.type.oclIsKindOf(OrderedSetType)\nthen type.oclIsKindOf(OrderedSetType)\nelse type.oclIsKindOf(SetType)\nendif\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ClosureTypeIsUniqueCollection.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ClosureTypeIsUniqueCollection\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__CLOSURE_TYPE_IS_UNIQUE_COLLECTION, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateClosureTypeIsUniqueCollection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source element type is the same as type of the body elements or element.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'closure\' implies\nsource.type.oclAsType(CollectionType).elementType =\nif body.type.oclIsKindOf(CollectionType)\nthen body.type.oclAsType(CollectionType).elementType\nelse body.type\nendif\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ClosureSourceElementTypeIsBodyElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ClosureSourceElementTypeIsBodyElementType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateClosureSourceElementTypeIsBodyElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element type is the same as the source element type.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'closure\' implies\ntype.oclAsType(CollectionType).elementType =\nsource.type.oclAsType(CollectionType).elementType\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ClosureElementTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ClosureElementTypeIsSourceElementType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateClosureElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'collect\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_CollectHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"CollectHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__COLLECT_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateCollectHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'collect\' implies\nif\n  source.type.oclIsKindOf(SequenceType) or\n  source.type.oclIsKindOf(OrderedSetType)\nthen type.oclIsKindOf(SequenceType)\nelse type.oclIsKindOf(BagType)\nendif\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_CollectTypeIsUnordered.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"CollectTypeIsUnordered\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__COLLECT_TYPE_IS_UNORDERED, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateCollectTypeIsUnordered(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element type is the type of the body elements.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'collect\' implies\ntype.oclAsType(CollectionType).elementType =\nbody.type.oclAsType(CollectionType).elementType\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_CollectElementTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"CollectElementTypeIsSourceElementType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateCollectElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'collectNested\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_CollectNestedHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"CollectNestedHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__COLLECT_NESTED_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateCollectNestedHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type is a Bag.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'collectNested\' implies type.oclIsKindOf(BagType)\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_CollectNestedTypeIsBag.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"CollectNestedTypeIsBag\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BAG, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateCollectNestedTypeIsBag(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type is the type of source.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'collectNested\' implies type = body.type\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_CollectNestedTypeIsBodyType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"CollectNestedTypeIsBodyType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BODY_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateCollectNestedTypeIsBodyType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'exists\' implies type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ExistsTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ExistsTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__EXISTS_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateExistsTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the body must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'exists\' implies body.type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ExistsBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ExistsBodyTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__EXISTS_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateExistsBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'forAll\' implies type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ForAllTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ForAllTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__FOR_ALL_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateForAllTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the body must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'forAll\' implies body.type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_ForAllBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"ForAllBodyTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__FOR_ALL_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateForAllBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'isUnique\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_IsUniqueHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"IsUniqueHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__IS_UNIQUE_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateIsUniqueHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'isUnique\' implies type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_IsUniqueTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"IsUniqueTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__IS_UNIQUE_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateIsUniqueTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'one\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_OneHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"OneHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__ONE_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateOneHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type is Boolean
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'one\' implies type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_OneTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"OneTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__ONE_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateOneTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the body must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'one\' implies body.type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_OneBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"OneBodyTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__ONE_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateOneBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'reject\' or name = \'select\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_RejectOrSelectHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"RejectOrSelectHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__REJECT_OR_SELECT_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateRejectOrSelectHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type is the same as the source.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'reject\' or name = \'select\' implies type = source.type\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_RejectOrSelectTypeIsSourceType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"RejectOrSelectTypeIsSourceType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateRejectOrSelectTypeIsSourceType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the body must be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'reject\' or name = \'select\' implies type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_RejectOrSelectTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"RejectOrSelectTypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_BOOLEAN, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateRejectOrSelectTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'sortedBy\' implies iterator->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_SortedByHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"SortedByHasOneIterator\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__SORTED_BY_HAS_ONE_ITERATOR, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateSortedByHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The collection type for an OrderedSet or a Sequence type is a Sequence, the result type for any other collection type is Bag.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'sortedBy\' implies\nif\n  source.type.oclIsKindOf(SequenceType) or\n  source.type.oclIsKindOf(BagType)\nthen type.oclIsKindOf(SequenceType)\nelse type.oclIsKindOf(OrderedSetType)\nendif\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_SortedByIsOrderedIfSourceIsOrdered.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"SortedByIsOrderedIfSourceIsOrdered\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateSortedByIsOrderedIfSourceIsOrdered(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element type is the type of the body elements.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nname = \'sortedBy\' implies\ntype.oclAsType(CollectionType).elementType =\nbody.type.oclAsType(CollectionType).elementType\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_SortedByElementTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"SortedByElementTypeIsSourceElementType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateSortedByElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of each iterator variable must be the type of the elements of the source collection.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nself.iterator->forAll(type =\n  source.type.oclAsType(CollectionType).elementType)\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies%>._invariant_IteratorTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);\n\tfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\n\tif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\t\treturn true;\n\t}\n\tif (diagnostics != null) {\n\t\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\t\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"IteratorExp\", \"IteratorTypeIsSourceElementType\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n\t    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ITERATOR_EXP__ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));\n\t}\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\t\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%>(e);\n}\nreturn false;'"
	 * @generated
	 */
	boolean validateIteratorTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);
} // IteratorExp
