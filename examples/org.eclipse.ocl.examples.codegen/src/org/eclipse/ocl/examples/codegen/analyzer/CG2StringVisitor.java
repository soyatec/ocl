/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModel;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Type;
//import org.eclipse.ocl.examples.pivot.FeatureCallExp;
//import org.eclipse.ocl.examples.pivot.PivotPackage;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class CG2StringVisitor extends AbstractExtendingCGModelVisitor<String, Object>
{	
	private static final Logger logger = Logger.getLogger(CG2StringVisitor.class);

	public static interface Factory {
		@NonNull CG2StringVisitor createToStringVisitor();
		@NonNull EPackage getEPackage();
	}
	
	private static @NonNull Map<EPackage, Factory> factoryMap = new HashMap<EPackage, Factory>();
	
	public static synchronized void addFactory(@NonNull Factory factory) {
		factoryMap.put(factory.getEPackage(), factory);
	}

	public static @Nullable CG2StringVisitor create(@NonNull EObject eObject) {
		EPackage ePackage = eObject.eClass().getEPackage();
		Factory factory = factoryMap.get(ePackage);
		if (factory != null) {
			return factory.createToStringVisitor();
		}
		logger.error("No ToStringVisitor Factory registered for " + ePackage.getName());
		return null;
	}

	private static final class MyFactory implements CG2StringVisitor.Factory
	{
		private MyFactory() {
			CG2StringVisitor.addFactory(this);
		}

		public @NonNull CG2StringVisitor createToStringVisitor() {
			return new CG2StringVisitor();
		}

		public @NonNull EPackage getEPackage() {
			CGModelPackage eInstance = CGModelPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static @NonNull CG2StringVisitor.Factory FACTORY = new MyFactory();
	
	/**
	 * Indicates where a required element in the AST was <code>null</code>, so
	 * that it is evident in the debugger that something was missing. We don't
	 * want just <code>"null"</code> because that would look like the OclVoid
	 * literal.
	 */
	protected static @NonNull String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	protected @NonNull StringBuilder result = new StringBuilder();

	/**
	 * Initializes me.
	 */
	protected CG2StringVisitor() {
        super(Object.class);						// Useless dummy object as context
	}

	/*
	 * protected List<? extends EObject> getConstrainedElements(Constraint
	 * constraint) { if (uml == null) { return Collections.emptyList(); } else {
	 * return uml.getConstrainedElements(constraint); } }
	 * 
	 * protected String getStereotype(Constraint constraint) { return (uml ==
	 * null)? null : uml.getStereotype(constraint); }
	 * 
	 * @Override protected ExpressionInOCL getSpecification(Constraint
	 * constraint) { return (uml == null)? null :
	 * uml.getSpecification(constraint); }
	 */

	protected void append(Number number) {
		if (number != null) {
			result.append(number.toString());
		}
		else {
			result.append(NULL_PLACEHOLDER);
		}
	}

	protected void append(String string) {
		if (string != null) {
			result.append(string);
		}
		else {
			result.append(NULL_PLACEHOLDER);
		}
	}

/*	protected void appendAtPre(FeatureCallExp mpc) {
		if (mpc.isPre()) {
			append("@pre"); //$NON-NLS-1$
		}
	} */

	protected void appendElementType(@Nullable CGTypedElement cgTypedElement) {
		if (cgTypedElement == null) {
			append(NULL_PLACEHOLDER);
		}
		else {
			safeVisit(cgTypedElement.getTypeId());
			if (!cgTypedElement.isRequired()) {
				append("[?]");
			}
		}
	}

	protected void appendName(CGNamedElement cgNamedElement) {
		if (cgNamedElement == null) {
			result.append(NULL_PLACEHOLDER);
		}
		else {
			result.append(cgNamedElement.getName());
		}
	}

	protected void appendName(NamedElement namedElement) {
		if (namedElement == null) {
			result.append(NULL_PLACEHOLDER);
		}
		else {
			result.append(namedElement.getName());
		}
	}

	protected void appendOperationSignature(CGOperation cgOperation) {
		appendName(cgOperation);
		append("(");
		boolean comma = false;
		for (java.util.Iterator<CGParameter> iter = cgOperation.getParameters().iterator(); iter.hasNext();) {
			CGParameter parm = iter.next();

			if (comma) {
				append(", "); //$NON-NLS-1$
			} else {
				comma = true;
			}

			appendName(parm);
			append(" : "); //$NON-NLS-1$

			if (parm.getTypeId() != null) {
				appendElementType(parm);
			} else {
				append(TypeId.OCL_VOID_NAME);
			}
		}

		append(") :"); //$NON-NLS-1$
		if (cgOperation.getTypeId() != null) {
			append(" ");
			appendElementType(cgOperation);
		}
	}

	protected void appendPropertySignature(CGTypedElement cgElement) {
		appendName(cgElement);
		if (cgElement.getTypeId() != null) {
			append(" : ");
			appendElementType(cgElement);
		}
	}

	protected void appendQualifiedName(CGNamedElement parent, String separator, CGNamedElement child) {
		if (parent != null) {
			appendQualifiedName(parent);
			append(separator);
		}
		appendName(child);
	}

	protected void appendQualifiedName(@Nullable CGNamedElement object) {
		if (object == null) {
			result.append(NULL_PLACEHOLDER);
		}
		else {
			EObject container = object.eContainer();
			if (container instanceof CGNamedElement) {
				appendQualifiedName((CGNamedElement) container);
				append("::"); //$NON-NLS-1$
			}
			appendName(object);
//			if (object instanceof TemplateableElement) {
//				TemplateableElement templateableElement = (TemplateableElement) object;
//				appendTemplateBindings(templateableElement.getTemplateBinding());
//				appendTemplateSignature(templateableElement.getOwnedTemplateSignature());
//			}
		}
	}

/*	protected void appendTemplateBindings(List<TemplateBinding> templateBindings) {
		if (templateBindings.size() > 0) {
			append("(");
			String prefix = ""; //$NON-NLS-1$
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitution()) {
					append(prefix);
					safeVisit(templateParameterSubstitution.getActual());
					prefix = ",";
				}
			}
			append(")");
		}
	}

	protected void appendTemplateSignature(TemplateSignature templateSignature) {
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
			if (!templateParameters.isEmpty()) {
				append("(");
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameter templateParameter : templateParameters) {
					append(prefix);
					safeVisit(templateParameter.getParameteredElement());
					prefix = ",";
				}
				append(")");
			}
		}
	} */

/*	protected void appendType(CGType type) {
		if ((type != null)
				 && (type.eClass() == PivotPackage.Literals.CLASS)	// i.e. by pass AnyType, PrimitiveType, ...
				 && (type.eContainer() instanceof NamedElement)) {
			appendQualifiedName((NamedElement) type.eContainer());
			append("::");
		}
		appendName(type);
	} */

	@Override
	public String toString() {
		return result.toString();
	}
	
	@Override
	public @Nullable String visitCGBoxExp(@NonNull CGBoxExp cgBoxExp) {
		append("box("); //$NON-NLS-1$
		safeVisit(cgBoxExp.getSource());
		append(")"); //$NON-NLS-1$
		return null;
	}
	
	@Override
	public @Nullable String visitCGCastParameter(@NonNull CGCastParameter cgCastParameter) {
		append("cast("); //$NON-NLS-1$
		safeVisit(cgCastParameter.getReferredParameter());
		append(")"); //$NON-NLS-1$
		return null;
	}
	
	@Override
	public @Nullable String visitCGCatchExp(@NonNull CGCatchExp cgCatchExp) {
		append("catch("); //$NON-NLS-1$
		safeVisit(cgCatchExp.getSource());
		append(")"); //$NON-NLS-1$
		return null;
	}

	@Override
	public String visitCGClass(@NonNull CGClass cgClass) {
/*		TemplateParameter owningTemplateParameter = cls.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			appendName(cls);
		}
		else {
			org.eclipse.ocl.examples.pivot.Package pkg = cls.getPackage();
			if (pkg == null) {
				append("null::");
				appendName(cls);
			}
			else if (!(pkg.eContainer() instanceof Root) || !PivotConstants.OCL_NAME.equals(pkg.getName())) {
				appendQualifiedName(pkg, "::", cls);
			}
			else {
				appendName(cls);
			}
			appendTemplateBindings(cls.getTemplateBinding());
			appendTemplateSignature(cls.getOwnedTemplateSignature());
		} */
		appendQualifiedName(cgClass);
		return null;
	}

	@Override
	public @Nullable String visitCGCollectionExp(@NonNull CGCollectionExp cgCollectionExp) {
		append(cgCollectionExp.getName() + "{");//$NON-NLS-1$
        boolean isFirst = true;
		for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
			if (!isFirst) {
				append(", ");
			}
            safeVisit(cgPart);
			isFirst = false;
		}
		append("}");
		return null;
	}
    
    @Override
	public @Nullable String visitCGCollectionPart(@NonNull CGCollectionPart cgCollectionPart) {
        safeVisit(cgCollectionPart.getFirst());
        if (cgCollectionPart.isRange()) {
        	append(" .. ");
    		safeVisit(cgCollectionPart.getLast());
        }
        return null;
    }

	@Override
	public @Nullable String visitCGConstant(@NonNull CGConstant cgConstant) {
		super.visitCGConstant(cgConstant);
		append(" = ");
		append(cgConstant.getConstantValue().toString());
		return null;
	}

	@Override
	public @Nullable String visitCGConstantExp(@NonNull CGConstantExp cgConstantExp) {
		CGValuedElement cgVariable = cgConstantExp.getValue();
		appendName(cgVariable);
		CGTypeId type = cgVariable.getTypeId();
		if (type != null) {
			append(" : ");
			appendElementType(cgVariable);
		}
		append(" = ");
		CGValuedElement referredConstant = cgConstantExp.getReferredConstant();
		if (referredConstant != null) {
			referredConstant.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable String visitCGConstraint(@NonNull CGConstraint cgConstraint) {
		appendName(cgConstraint);
		append(": ");
		safeVisit(cgConstraint.getBody());
		return null;
	}

	/**
	 * Renders a constraint with its context and expression.
	 *
	@Override
	public String visitConstraint(@NonNull Constraint constraint) {
		List<? extends EObject> constrained = constraint.getConstrainedElement();
		if (!constrained.isEmpty()) {
			EObject elem = constrained.get(0);
			append("context "); //$NON-NLS-1$
			if (elem instanceof Type) {
				appendName((NamedElement) elem);
			} else if (elem instanceof Operation) {
				Operation oper = (Operation) elem;
				appendOperationSignature(oper);
			} else if (elem instanceof Property) {
				Property prop = (Property) elem;
				appendPropertySignature(prop);
			}
			append(" ");
		}

		String stereo = constraint.getStereotype();
		append(stereo); //$NON-NLS-1$
		String name = constraint.getName();
		if (name != null) {
			append(" "); //$NON-NLS-1$
			append(name);
		}
		append(": "); //$NON-NLS-1$
/* FIXME def context
		EObject elem = constrained.get(1);
		if (elem instanceof Operation) {
			appendOperationSignature((Operation) elem);
		} else if (elem instanceof Property) {
			appendPropertySignature((Property) elem);
		}
		append(" = "); //$NON-NLS-1$
* /
		safeVisit(constraint.getSpecification());
		return null;
	} */

	/**
	 * Callback for a ConstructorExp visit.
	 * 
	 * @param constructorExp
	 *            constructor expression
	 * @return the string representation
	 *
	@Override
	public String visitConstructorExp(@NonNull ConstructorExp constructorExp) {
		appendQualifiedName(constructorExp.getType());
		append("{");//$NON-NLS-1$
		String prefix = "";
		for (ConstructorPart part : constructorExp.getPart()) {
			append(prefix);
            safeVisit(part);
			prefix = ", ";//$NON-NLS-1$
		}
		append("}");
		return null;
	} */
	
    /**
     * Visits the tuple constructor part's value, if any.
     *
	@Override
	public String visitConstructorPart(@NonNull ConstructorPart part) {
		appendName(part.getReferredProperty());
		OCLExpression initExpression = part.getInitExpression();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	} */

	/**
	 * Renders an ExpressionInOCL with its context variables and body.
	 *
	@Override
	public String visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
		return safeVisit(expression.getBodyExpression());
	} */

    /**
     * Visits the expressions context variable, its parameter variables (if any),
     * its result variable (if any), and finally its body expression.
     * 
     * Returns the result of
     * {@link #handleExpressionInOCL(ExpressionInOCL, Object, Object, List, Object)}.
     *
    @Override
	public T visitExpressionInOCL(ExpressionInOCL expression) {
        T contextResult = safeVisit(expression.getContextVariable());
        
        Variable resultVar = expression.getResultVariable();
        T resultResult = safeVisit(resultVar);
        
        List<T> parameterResults;
        List<Variable> parameters = expression.getParameterVariable();
        
        if (parameters.isEmpty()) {
            parameterResults = Collections.emptyList();
        } else {
            parameterResults = new java.util.ArrayList<T>(parameters.size());
            for (Variable iterVar : parameters) {
                parameterResults.add(safeVisit(iterVar));
            }
        }
        
        T bodyResult = safeVisit(expression.getBodyExpression());
        
        return handleExpressionInOCL(expression, contextResult, resultResult,
            parameterResults, bodyResult);
    } */
	
	@Override
	public @Nullable String visitCGGuardExp(@NonNull CGGuardExp cgGuardExp) {
		append("guard("); //$NON-NLS-1$
		safeVisit(cgGuardExp.getSource());
		append(")"); //$NON-NLS-1$
		return null;
	}

	@Override
	public @Nullable String visitCGIfExp(@NonNull CGIfExp cgExp) {
		append("if ");  //$NON-NLS-1$
		safeVisit(cgExp.getCondition());
		append(" then "); //$NON-NLS-1$
		safeVisit(cgExp.getThenExpression());
		append(" else "); //$NON-NLS-1$
		safeVisit(cgExp.getElseExpression());
		append(" endif"); //$NON-NLS-1$
		return null;
	}

	/**
	 * Callback for an IterateExp visit.
	 * 
	 * @param callExp
	 *            an iterate expression
	 * @return the string representation
	 *
	@Override
	public String visitIterateExp(@NonNull IterateExp callExp) {
		safeVisit(callExp.getSource());
		append("->");
		appendName(callExp.getReferredIteration());
		append("("); //$NON-NLS-1$
		boolean isFirst = true;
		for (Variable variable : callExp.getIterator()) {
			if (!isFirst) {
				append(", ");
			}
            safeVisit(variable);
			isFirst = false;
		}
		append("; ");
		safeVisit(callExp.getResult());
		append(" | ");
		safeVisit(callExp.getBody());
		append(")");//$NON-NLS-1$
		return null;        
	} */

	/*
	@Override
	public String visitIteration(@NonNull Iteration iteration) {
		appendQualifiedName(iteration.getOwningType(), ".", iteration);
		appendTemplateBindings(iteration.getTemplateBinding());
		appendTemplateSignature(iteration.getOwnedTemplateSignature());
		append("(");
		boolean isFirst = true;
		for (Parameter parameter : iteration.getOwnedIterator()) {
			if (!isFirst) {
				append(", ");
			}
			appendElementType(parameter);
			isFirst = false;
		}
		isFirst = true;
		for (Parameter parameter : iteration.getOwnedAccumulator()) {
			if (!isFirst) {
				append(", ");
			}
			else {
				append("; ");
			}
			appendElementType(parameter);
			isFirst = false;
		}
		append(")");
		return null;
	} */

	/**
	 * Callback for an IteratorExp visit.
	 * 
	 * @param callExp
	 *            an iterator expression
	 * @return the string representation
	 *
	@Override
	public String visitIteratorExp(@NonNull IteratorExp callExp) {
		safeVisit(callExp.getSource());
		append("->");
		appendName(callExp.getReferredIteration());
		append("("); //$NON-NLS-1$
		boolean isFirst = true;
		for (Variable variable : callExp.getIterator()) {
			if (!isFirst) {
				append(", ");
			}
            safeVisit(variable);
			isFirst = false;
		}
		append(" | ");
		safeVisit(callExp.getBody());
		append(")");//$NON-NLS-1$
		return null;        
	} */
	
	@Override
	public @Nullable String visitCGLetExp(@NonNull CGLetExp cgLetExp) {
		append("let "); //$NON-NLS-1$
		safeVisit(cgLetExp.getInit());
		append(" in "); //$NON-NLS-1$
		safeVisit(cgLetExp.getIn());
		return null;
	}

	@Override
	public @Nullable String visitCGLocalVariable(@NonNull CGLocalVariable cgVariable) {
		appendName(cgVariable);
		CGTypeId type = cgVariable.getTypeId();
		if (type != null) {
			append(" : ");
			appendElementType(cgVariable);
		}
		CGValuedElement initExpression = cgVariable.getInit();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public @Nullable String visitCGModel(@NonNull CGModel cgModel) {
		appendName(cgModel);
		return null;
	}

	@Override
	public @Nullable String visitCGOperation(@NonNull CGOperation cgOperation) {
		appendQualifiedName(cgOperation.getContainingClass(), ".", cgOperation);
//		appendTemplateBindings(cgOperation.getTemplateBinding());
//		appendTemplateSignature(cgOperation.getOwnedTemplateSignature());
		append("(");
		boolean isFirst = true;
		for (CGParameter cgParameter : cgOperation.getParameters()) {
			if (!isFirst) {
				append(",");
			}
			appendElementType(cgParameter);
			isFirst = false;
		}
		append(") : ");
		appendElementType(cgOperation);
		return null;
	}

	@Override
	public @Nullable String visitCGOperationCallExp(@NonNull CGOperationCallExp oc) {
		CGValuedElement source = oc.getSource();
		safeVisit(source);
		OperationCallExp operationCallExp = (OperationCallExp) oc.getPivot();
		Operation oper = operationCallExp.getReferredOperation();
	        Type sourceType = source != null ? operationCallExp.getSource().getType() : null;
			append(sourceType instanceof CollectionType
					? PivotConstants.COLLECTION_NAVIGATION_OPERATOR
					: PivotConstants.OBJECT_NAVIGATION_OPERATOR);
			appendName(oper);
		append("(");
		String prefix = "";//$NON-NLS-1$
		for (CGValuedElement argument : oc.getArguments()) {
			append(prefix);
			safeVisit(argument);
			prefix = ", ";//$NON-NLS-1$
		}
		append(")");
//		appendAtPre(oc);
		return null;
	}

	@Override
	public @Nullable String visitCGPackage(@NonNull CGPackage cgPackage) {
		appendQualifiedName(cgPackage);
		return null;
	}

	@Override
	public @Nullable String visitCGPropertyCallExp(@NonNull CGPropertyCallExp pc) {
        // source is null when the property call expression is an
        //    association class navigation qualifier
        CGValuedElement source = pc.getSource();
		safeVisit(source);
		PropertyCallExp propertyCallExp = (PropertyCallExp) pc.getPivot();
		Property property = propertyCallExp.getReferredProperty();
        Type sourceType = source != null ? propertyCallExp.getSource().getType() : null;
		result.append(sourceType instanceof CollectionType
				? PivotConstants.COLLECTION_NAVIGATION_OPERATOR
				: PivotConstants.OBJECT_NAVIGATION_OPERATOR);
		appendName(property);
/*		appendAtPre(pc);
        List<CGValuedElement> qualifiers = pc.getQualifier();
		if (!qualifiers.isEmpty()) {
			append("["); //$NON-NLS-1$
			String prefix = ""; //$NON-NLS-1$
			for (OCLExpression qualifier : qualifiers) {
				append(prefix);
				safeVisit(qualifier);
				prefix = ", "; //$NON-NLS-1$
			}
			append("]");
		} */
		return null;
	}
	
	@Override
	public @Nullable String visitCGThrowExp(@NonNull CGThrowExp cgThrowExp) {
		append("throw("); //$NON-NLS-1$
		safeVisit(cgThrowExp.getSource());
		append(")"); //$NON-NLS-1$
		return null;
	}

	@Override
	public @Nullable String visitCGTupleExp(@NonNull CGTupleExp cgTupleExp) {
		append("Tuple{");//$NON-NLS-1$
		String prefix = "";
		for (CGTuplePart part : cgTupleExp.getParts()) {
			append(prefix);
            safeVisit(part);
			prefix = ", ";//$NON-NLS-1$
		}
		append("}");
		return null;
	}
	
	@Override
	public @Nullable String visitCGTuplePart(@NonNull CGTuplePart cgTuplePart) {
		appendName(cgTuplePart);
		CGTypeId type = cgTuplePart.getTypeId();
		if (type != null) {
			append(" : ");
			appendElementType(cgTuplePart);
		}
		CGValuedElement initExpression = cgTuplePart.getInit();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}
	
	@Override
	public @Nullable String visitCGUnboxExp(@NonNull CGUnboxExp cgUnboxExp) {
		append("unbox("); //$NON-NLS-1$
		safeVisit(cgUnboxExp.getSource());
		append(")"); //$NON-NLS-1$
		return null;
	}

	@Override
	public @Nullable String visitCGValuedElement(@NonNull CGValuedElement cgElement) {
		appendName(cgElement);
		CGTypeId type = cgElement.getTypeId();
		append(" : ");
		if (type != null) {
			appendElementType(cgElement);
		}
		return null;
	}

	@Override
	public @Nullable String visitCGVariableExp(@NonNull CGVariableExp v) {
		appendName(v.getReferredVariable());
		return null;
	}

	@Override
	public @Nullable String visitCGWhileExp(@NonNull CGWhileExp cgExp) {
		append("while ");  //$NON-NLS-1$
		safeVisit(cgExp.getCondition());
		append(" do "); //$NON-NLS-1$
		safeVisit(cgExp.getBodyExpression());
		append(" finally "); //$NON-NLS-1$
		safeVisit(cgExp.getFinallyExpression());
		append(" endwhile"); //$NON-NLS-1$
		return null;
	}

	public @Nullable String visiting(@NonNull CGElement visitable) {
		append(visitable.getClass().getName());
		return null;
	}
}
