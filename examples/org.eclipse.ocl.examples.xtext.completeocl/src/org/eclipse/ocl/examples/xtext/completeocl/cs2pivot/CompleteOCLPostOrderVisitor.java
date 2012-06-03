/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: CompleteOCLPostOrderVisitor.java,v 1.9 2011/05/20 19:51:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import java.util.List;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;

public class CompleteOCLPostOrderVisitor extends AbstractCompleteOCLPostOrderVisitor
{
	public static final CS2PivotConversion.CacheKey<Map<NamedElement, List<ContextConstraintCS>>> rulesKey = new CS2PivotConversion.CacheKey<Map<NamedElement, List<ContextConstraintCS>>>("rules");
	
	public static class ContextConstraintCSCompletion extends SingleContinuation<ContextConstraintCS>
	{
		public ContextConstraintCSCompletion(CS2PivotConversion context, ContextConstraintCS csElement) {		// FIXME Share code with ConstraintCSCompletion
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csElement);
			ExpSpecificationCS csSpecification = (ExpSpecificationCS) csElement.getSpecification();
			ExpCS csExpression = csSpecification.getOwnedExpression();
			if (csExpression != null) {
				ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csSpecification);
				pivotConstraint.setSpecification(pivotSpecification);
				String selfVariableName = Environment.SELF_VARIABLE_NAME;
				ContextDeclCS contextDecl = csElement.getContextDecl();
				if (contextDecl instanceof ClassifierContextDeclCS) {
					ClassifierContextDeclCS csClassifierContextDecl = (ClassifierContextDeclCS)contextDecl;
					String selfName = csClassifierContextDecl.getSelfName();
					if (selfName != null) {
						selfVariableName = selfName;
					}
				}
				context.setContextVariable(pivotSpecification, selfVariableName, null);
				if (contextDecl instanceof ClassifierContextDeclCS) {
					ClassifierContextDeclCS csClassifierContextDecl = (ClassifierContextDeclCS)contextDecl;
					Type contextType = csClassifierContextDecl.getClassifier();
					context.setClassifierContext(pivotSpecification, contextType);
				}
				else if (contextDecl instanceof PropertyContextDeclCS) {
					PropertyContextDeclCS csPropertyContextDecl = (PropertyContextDeclCS)contextDecl;
					Property contextProperty = csPropertyContextDecl.getProperty();
					context.setPropertyContext(pivotSpecification, contextProperty);
				}
				else if (contextDecl instanceof OperationContextDeclCS) {
					OperationContextDeclCS csOperationContextDecl = (OperationContextDeclCS)contextDecl;
					Operation contextOperation = csOperationContextDecl.getOperation();
					String resultVariableName = csElement instanceof PostCS ? Environment.RESULT_VARIABLE_NAME : null;
			        context.setOperationContext(pivotSpecification, contextOperation, resultVariableName);
				}
				OCLExpression bodyExpression = context.visitLeft2Right(OCLExpression.class, csExpression);		
				pivotSpecification.setBodyExpression(bodyExpression);
				pivotSpecification.setType(bodyExpression.getType());
				ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS) csElement.getMessageSpecification();
				if (csMessageSpecification != null) {
					context.installPivotUsage(csMessageSpecification, pivotSpecification);		//WIP
					ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
					if (csMessageExpression != null) {
						OCLExpression messageExpression = context.visitLeft2Right(OCLExpression.class, csMessageExpression);		
						pivotSpecification.setMessageExpression(messageExpression);
					}
				}
			}
			return null;
		}
	}
	
	protected static class DefCSCompletion extends SingleContinuation<DefCS>
	{
		public DefCSCompletion(CS2PivotConversion context, DefCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Feature contextFeature = PivotUtil.getPivot(Feature.class, csElement.getFeature());
			ExpSpecificationCS csSpecification = (ExpSpecificationCS) csElement.getSpecification();
			ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csSpecification);
			Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csElement);
			pivotConstraint.setSpecification(pivotSpecification);

			Variable contextVariable = pivotSpecification.getContextVariable();
			if (contextVariable == null) {
				contextVariable = PivotFactory.eINSTANCE.createVariable();
				pivotSpecification.setContextVariable(contextVariable);
			}
			context.refreshName(contextVariable, Environment.SELF_VARIABLE_NAME);
			if (contextFeature instanceof Operation) {
				Operation contextOperation = (Operation) contextFeature;
				context.setType(contextVariable, contextOperation.getOwningType());
		        pivotSpecification.getParameterVariable().clear();
		        for (Parameter parameter : contextOperation.getOwnedParameter()) {
			        Variable param = PivotFactory.eINSTANCE.createVariable();
			        param.setName(parameter.getName());
			        param.setType(parameter.getType());
			        param.setRepresentedParameter(parameter);
			        pivotSpecification.getParameterVariable().add(param);
		        }
			}
			else if (contextFeature instanceof Property) {
				Property contextProperty = (Property) contextFeature;
				context.setType(contextVariable, contextProperty.getOwningType());
			}
			ExpCS csExpression = csSpecification.getOwnedExpression();
			OCLExpression bodyExpression = context.visitLeft2Right(OCLExpression.class, csExpression);		
			pivotSpecification.setBodyExpression(bodyExpression);
			context.setType(pivotSpecification, bodyExpression != null ? bodyExpression.getType() : null);
			if (contextFeature != null) {
				contextFeature.getOwnedRule().add(pivotConstraint);
			}
			return null;
		}
	}

	public CompleteOCLPostOrderVisitor(CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(CompleteOCLDocumentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitContextConstraintCS(ContextConstraintCS csNewConstraint) {
		NamedElement constrainedElement = PivotUtil.getPivot(NamedElement.class, csNewConstraint.getContextDecl());
		if ((constrainedElement != null) && !constrainedElement.eIsProxy()) {
			if (csNewConstraint.getSpecification() != null) {
				return new ContextConstraintCSCompletion(context, csNewConstraint);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitContextDeclCS(ContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDefCS(DefCS csDef) {
		if (csDef.getSpecification() != null) {
			return new DefCSCompletion(context, csDef);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitDefOperationCS(DefOperationCS csElement) {
		Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
		contextOperation.setType(PivotUtil.getPivot(Type.class, csElement.getOwnedType()));		// FIXME type consistency check
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(DefPropertyCS csElement) {
		Property contextProperty = PivotUtil.getPivot(Property.class, csElement);
		contextProperty.setType(PivotUtil.getPivot(Type.class, csElement.getOwnedType()));		// FIXME type consistency check
		return null;
	}

	@Override
	public Continuation<?> visitIncludeCS(IncludeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(OperationContextDeclCS csElement) {
		Operation modelOperation = csElement.getOperation();
		if ((modelOperation != null) && !modelOperation.eIsProxy()) {
			Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
			contextOperation.setName(modelOperation.getName());
			contextOperation.setType(modelOperation.getType());		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(PackageDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(PropertyContextDeclCS csElement) {
		return null;
	}
}