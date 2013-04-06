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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
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
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
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
		public ContextConstraintCSCompletion(@NonNull CS2PivotConversion context, @NonNull ContextConstraintCS csElement) {		// FIXME Share code with ConstraintCSCompletion
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csElement);
			if (pivotConstraint != null) {
				ExpSpecificationCS csSpecification = (ExpSpecificationCS) csElement.getSpecification();
				ExpCS csExpression = csSpecification.getOwnedExpression();
				if (csExpression != null) {
					ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csSpecification);
					if (pivotSpecification != null) {
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
							if (contextType != null) {
								context.setClassifierContext(pivotSpecification, contextType);
							}
						}
						else if (contextDecl instanceof PropertyContextDeclCS) {
							PropertyContextDeclCS csPropertyContextDecl = (PropertyContextDeclCS)contextDecl;
							Property contextProperty = csPropertyContextDecl.getProperty();
							if (contextProperty != null) {
								context.setPropertyContext(pivotSpecification, contextProperty);
							}
						}
						else if (contextDecl instanceof OperationContextDeclCS) {
							OperationContextDeclCS csOperationContextDecl = (OperationContextDeclCS)contextDecl;
							Operation contextOperation = csOperationContextDecl.getOperation();
							if (contextOperation != null) {
								String resultVariableName = csElement instanceof PostCS ? Environment.RESULT_VARIABLE_NAME : null;
						        context.setOperationContext(pivotSpecification, contextOperation, resultVariableName);
							}
						}
						OCLExpression bodyExpression = context.visitLeft2Right(OCLExpression.class, csExpression);		
						PivotUtil.setBody(pivotSpecification, bodyExpression, ElementUtil.getExpressionText(csExpression));
						if (bodyExpression != null) {
							context.setType(pivotSpecification, bodyExpression.getType(), bodyExpression.isRequired());
						}
						else {
							context.setType(pivotSpecification, null, true);
						}
						ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS) csElement.getMessageSpecification();
						if (csMessageSpecification != null) {
							context.installPivotUsage(csMessageSpecification, pivotSpecification);		//WIP
							ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
							if (csMessageExpression != null) {
								OCLExpression messageExpression = context.visitLeft2Right(OCLExpression.class, csMessageExpression);		
								PivotUtil.setMessage(pivotSpecification, messageExpression, ElementUtil.getExpressionText(csMessageExpression));
							}
						}
					}
				}
			}
			return null;
		}
	}
	
	protected static class DefCSCompletion extends SingleContinuation<DefCS>
	{
		public DefCSCompletion(@NonNull CS2PivotConversion context, @NonNull DefCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Feature contextFeature = PivotUtil.getPivot(Feature.class, csElement.getFeature());
			ExpSpecificationCS csSpecification = (ExpSpecificationCS) csElement.getSpecification();
			ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csSpecification);
			if (pivotSpecification != null) {
				Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csElement);
				if (pivotConstraint != null) {
					pivotConstraint.setSpecification(pivotSpecification);
					Variable contextVariable = pivotSpecification.getContextVariable();
					if (contextVariable == null) {
						contextVariable = PivotFactory.eINSTANCE.createVariable();
						assert contextVariable != null;
						pivotSpecification.setContextVariable(contextVariable);
					}
					context.refreshName(contextVariable, Environment.SELF_VARIABLE_NAME);
					if (contextFeature instanceof Operation) {
						Operation contextOperation = (Operation) contextFeature;
						context.setType(contextVariable, contextOperation.getOwningType(), contextOperation.isRequired());
				        pivotSpecification.getParameterVariable().clear();
				        for (Parameter parameter : contextOperation.getOwnedParameter()) {
					        @SuppressWarnings("null")@NonNull Variable param = PivotFactory.eINSTANCE.createVariable();
					        context.refreshName(param, DomainUtil.nonNullModel(parameter.getName()));
					        context.setType(param, parameter.getType(), parameter.isRequired());
					        param.setRepresentedParameter(parameter);
					        pivotSpecification.getParameterVariable().add(param);
				        }
					}
					else if (contextFeature instanceof Property) {
						Property contextProperty = (Property) contextFeature;
						context.setType(contextVariable, contextProperty.getOwningType(), contextProperty.isRequired());
					}
					ExpCS csExpression = csSpecification.getOwnedExpression();
					if (csExpression != null) {
						OCLExpression bodyExpression = context.visitLeft2Right(OCLExpression.class, csExpression);		
						PivotUtil.setBody(pivotSpecification, bodyExpression, ElementUtil.getExpressionText(csExpression));
						if (bodyExpression != null) {
							context.setType(pivotSpecification, bodyExpression.getType(), bodyExpression.isRequired());
						}
						else {
							context.setType(pivotSpecification, null, true);
						}
						if (contextFeature != null) {
							contextFeature.getOwnedRule().add(pivotConstraint);
						}
					}
				}
			}
			return null;
		}
	}

	public CompleteOCLPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitContextConstraintCS(@NonNull ContextConstraintCS csNewConstraint) {
		NamedElement constrainedElement = PivotUtil.getPivot(NamedElement.class, csNewConstraint.getContextDecl());
		if ((constrainedElement != null) && !constrainedElement.eIsProxy()) {
			if (csNewConstraint.getSpecification() != null) {
				return new ContextConstraintCSCompletion(context, csNewConstraint);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitContextDeclCS(@NonNull ContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDefCS(@NonNull DefCS csDef) {
		if (csDef.getSpecification() != null) {
			return new DefCSCompletion(context, csDef);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitDefOperationCS(@NonNull DefOperationCS csElement) {
		Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
		if (contextOperation != null) {
			context.refreshRequiredType(contextOperation, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS csElement) {
		Property contextProperty = PivotUtil.getPivot(Property.class, csElement);
		if (contextProperty != null) {
			context.refreshRequiredType(contextProperty, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitIncludeCS(@NonNull IncludeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		Operation modelOperation = csElement.getOperation();
		if ((modelOperation != null) && !modelOperation.eIsProxy()) {
			Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
			if (contextOperation != null) {
				context.refreshName(contextOperation, DomainUtil.nonNullModel(modelOperation.getName()));
				context.setType(contextOperation, modelOperation.getType(), modelOperation.isRequired());		// FIXME type consistency check
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS csElement) {
		return null;
	}
}