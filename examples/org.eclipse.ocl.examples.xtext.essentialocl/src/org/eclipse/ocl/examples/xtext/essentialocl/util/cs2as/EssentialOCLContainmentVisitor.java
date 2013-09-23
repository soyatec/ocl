/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.essentialocl.util.cs2as;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractEssentialOCLContainmentVisitor;

public class EssentialOCLContainmentVisitor extends AbstractEssentialOCLContainmentVisitor
{
	private static final Logger logger = Logger.getLogger(EssentialOCLContainmentVisitor.class);

	private static final class NotOperationFilter implements ScopeFilter
	{
		public static NotOperationFilter INSTANCE = new NotOperationFilter();
		
		public int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull DomainElement match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1,
				@NonNull DomainElement match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2) {
			return 0;
		}

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull DomainElement eObject) {
			return !(eObject instanceof Operation);
		}
	}

	public EssentialOCLContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitBooleanLiteralExpCS(@NonNull BooleanLiteralExpCS csElement) {
		BooleanLiteralExp pivotElement = context.refreshModelElement(BooleanLiteralExp.class, PivotPackage.Literals.BOOLEAN_LITERAL_EXP, csElement);
		if (pivotElement != null) {
			pivotElement.setBooleanSymbol(Boolean.valueOf(csElement.getName()));
		}
		return null;
	}

	@Override
	public Continuation<?> visitCollectionLiteralExpCS(@NonNull CollectionLiteralExpCS csElement) {
		CollectionLiteralExp pivotElement = context.refreshModelElement(CollectionLiteralExp.class, PivotPackage.Literals.COLLECTION_LITERAL_EXP, csElement);
		if (pivotElement != null) {
			context.refreshPivotList(CollectionLiteralPart.class, pivotElement.getPart(), csElement.getOwnedParts());
		}
		return null;
	}

	@Override
	public Continuation<?> visitCollectionLiteralPartCS(@NonNull CollectionLiteralPartCS csElement) {
		if (csElement.getLastExpressionCS() == null) {
			context.refreshModelElement(CollectionItem.class, PivotPackage.Literals.COLLECTION_ITEM, csElement);	
		}
		else {
			context.refreshModelElement(CollectionRange.class, PivotPackage.Literals.COLLECTION_RANGE, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csElement) {
		Constraint asConstraint = refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csElement);
		if (asConstraint != null) {
			ExpSpecificationCS csStatusSpecification = (ExpSpecificationCS)csElement.getSpecification();
			ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS)csElement.getMessageSpecification();
			if (csMessageSpecification == null) {
				OpaqueExpression asSpecification = PivotUtil.getPivot(OpaqueExpression.class, csStatusSpecification);
				asConstraint.setSpecification(asSpecification);
			}
			else {
				Map<String, Type> tupleParts = new HashMap<String, Type>();
				tupleParts.put(PivotConstants.MESSAGE_PART_NAME, metaModelManager.getStringType());
				tupleParts.put(PivotConstants.STATUS_PART_NAME, metaModelManager.getBooleanType());
				TupleType tupleType = metaModelManager.getTupleManager().getTupleType("Tuple", tupleParts);
				Property statusProperty = DomainUtil.getNamedElement(tupleType.getOwnedAttribute(), PivotConstants.STATUS_PART_NAME);
				OpaqueExpression asSpecification = asConstraint.getSpecification();
				//
				ExpressionInOCL asExpressionInOCL;
				if (asSpecification instanceof ExpressionInOCL) {
					asExpressionInOCL = (ExpressionInOCL) asSpecification;	
				}
				else {
					asExpressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
					asConstraint.setSpecification(asExpressionInOCL);
				}
				OCLExpression asExpression = asExpressionInOCL.getBodyExpression();
				//
				PropertyCallExp asTuplePartExp;
				if (asExpression instanceof PropertyCallExp) {
					asTuplePartExp = (PropertyCallExp) asExpression;	
				}
				else {
					asTuplePartExp = PivotFactory.eINSTANCE.createPropertyCallExp();
					asExpressionInOCL.setBodyExpression(asTuplePartExp);
				}
				asTuplePartExp.setReferredProperty(statusProperty);
				asTuplePartExp.setType(statusProperty.getType());
				asTuplePartExp.setIsRequired(true);
				asExpression = asTuplePartExp.getSource();
				//
				TupleLiteralExp asTupleLiteralExp;
				if (asExpression instanceof TupleLiteralExp) {
					asTupleLiteralExp = (TupleLiteralExp) asExpression;	
				}
				else {
					asTupleLiteralExp = PivotFactory.eINSTANCE.createTupleLiteralExp();
					asTuplePartExp.setSource(asTupleLiteralExp);
				}
				asTupleLiteralExp.setType(tupleType);
				asTupleLiteralExp.setIsRequired(true);
				List<TupleLiteralPart> parts = new ArrayList<TupleLiteralPart>();
				TupleLiteralPart asStatusPart = PivotUtil.getPivot(TupleLiteralPart.class, csStatusSpecification);
				TupleLiteralPart asMessagePart = PivotUtil.getPivot(TupleLiteralPart.class, csMessageSpecification);
				if ((asMessagePart != null) && (asStatusPart != null)) {
					parts.add(asMessagePart);
					parts.add(asStatusPart);
				}
				context.refreshList(asTupleLiteralExp.getPart(), parts);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitConstructorExpCS(@NonNull ConstructorExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		if (pathName != null) {
			CS2Pivot.setElementType(pathName, PivotPackage.Literals.TYPE, csElement, null);
		}
		ConstructorExp pivotElement = context.refreshModelElement(ConstructorExp.class, PivotPackage.Literals.CONSTRUCTOR_EXP, csElement);
		if (pivotElement != null) {
			pivotElement.setValue(csElement.getValue());
			context.refreshPivotList(ConstructorPart.class, pivotElement.getPart(), csElement.getOwnedParts());
		}
		return null;
	}

	@Override
	public Continuation<?> visitConstructorPartCS(@NonNull ConstructorPartCS csElement) {
		context.refreshModelElement(ConstructorPart.class, PivotPackage.Literals.CONSTRUCTOR_PART, csElement);	
		return null;
	}

	@Override
	public Continuation<?> visitContextCS(@NonNull ContextCS csElement) {
		ExpressionInOCL pivotElement = context.refreshModelElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, csElement);
		if (pivotElement != null) {
			PivotUtil.setBody(pivotElement, null, null);
			Resource resource = csElement.eResource();
			if (resource instanceof BaseResource) {	
				ParserContext parserContext = ((BaseResource)resource).getParserContext();
				if (parserContext != null) {
					parserContext.initialize(context, pivotElement);
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitExpCS(@NonNull ExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS csElement) {
		EObject eContainer = csElement.eContainer();
		if (eContainer instanceof ConstraintCS) {
			ConstraintCS csConstraint = (ConstraintCS) eContainer;
			SpecificationCS csStatusSpecification = csConstraint.getSpecification();
			SpecificationCS csMessageSpecification = csConstraint.getMessageSpecification();
			if ((csStatusSpecification != null) && (csMessageSpecification != null)) {
				TupleLiteralPart csTupleLiteralPart = context.refreshModelElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csElement);
				if (csTupleLiteralPart != null) {
					EStructuralFeature eContainingFeature = csElement.eContainingFeature();
					if (eContainingFeature == BaseCSTPackage.Literals.CONSTRAINT_CS__SPECIFICATION) {
						csTupleLiteralPart.setName(PivotConstants.STATUS_PART_NAME);
						csTupleLiteralPart.setType(metaModelManager.getBooleanType());
					}
					else if (eContainingFeature == BaseCSTPackage.Literals.CONSTRAINT_CS__MESSAGE_SPECIFICATION) {
						csTupleLiteralPart.setName(PivotConstants.MESSAGE_PART_NAME);
						csTupleLiteralPart.setType(metaModelManager.getStringType());
					}
					else {
						logger.error("unknown ExpSpecificationCS.eContainingFeature" + eContainingFeature);
					}
				}
				return null;
			}
		}
		if (csElement.getOwnedExpression() != null) {
			context.refreshModelElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, csElement);
		}
		else {
			context.refreshModelElement(OpaqueExpression.class, PivotPackage.Literals.OPAQUE_EXPRESSION, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitIfExpCS(@NonNull IfExpCS csElement) {
		context.refreshModelElement(IfExp.class, PivotPackage.Literals.IF_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitIndexExpCS(@NonNull IndexExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitInfixExpCS(@NonNull InfixExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitInvalidLiteralExpCS(@NonNull InvalidLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitInvocationExpCS(@NonNull InvocationExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.OPERATION, csElement, null);
		return null;
	}

	@Override
	public Continuation<?> visitLiteralExpCS(@NonNull LiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNameExpCS(@NonNull NameExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.ELEMENT, csElement, NotOperationFilter.INSTANCE);
		return null;
	}

	@Override
	public Continuation<?> visitNavigatingArgCS(@NonNull NavigatingArgCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNestedExpCS(@NonNull NestedExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNullLiteralExpCS(@NonNull NullLiteralExpCS csElement) {
		context.refreshModelElement(NullLiteralExp.class, PivotPackage.Literals.NULL_LITERAL_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitNumberLiteralExpCS(@NonNull NumberLiteralExpCS csElement) {
		Number number = csElement.getName();
		if ((number instanceof BigDecimal) || (number instanceof Double) || (number instanceof Float)) {
			RealLiteralExp pivotElement = context.refreshModelElement(RealLiteralExp.class, PivotPackage.Literals.REAL_LITERAL_EXP, csElement);
			if (pivotElement != null) {
				pivotElement.setRealSymbol(number);
			}
		}
		else {
			boolean isNegative;
			if (number instanceof BigInteger) {
				BigInteger bigInteger = (BigInteger) number;
				isNegative = bigInteger.signum() < 0;
				if (isNegative) {
					if (bigInteger.compareTo(ValuesUtil.INTEGER_MIN_VALUE) >= 0) {
						number = Integer.valueOf(bigInteger.intValue());
					}
					else if (bigInteger.compareTo(ValuesUtil.LONG_MIN_VALUE) >= 0) {
						number = Long.valueOf(bigInteger.longValue());
					}
				}
				else {
					if (bigInteger.compareTo(ValuesUtil.INTEGER_MAX_VALUE) <= 0) {
						number = Integer.valueOf(bigInteger.intValue());
					}
					else if (bigInteger.compareTo(ValuesUtil.LONG_MAX_VALUE) <= 0) {
						number = Long.valueOf(bigInteger.longValue());
					}
				}
			}
			else {
				long longValue = number.longValue();
				isNegative = longValue < 0;
				if (isNegative) {
					if (longValue >= Integer.MIN_VALUE) {
						number = Integer.valueOf((int)longValue);
					}
					else {
						number = Long.valueOf(longValue);
					}
				}
				else {
					if (longValue <= Integer.MAX_VALUE) {
						number = Integer.valueOf((int)longValue);
					}
					else {
						number = Long.valueOf(longValue);
					}
				}
			}				
			if (isNegative) {
				IntegerLiteralExp pivotElement = context.refreshModelElement(IntegerLiteralExp.class, PivotPackage.Literals.INTEGER_LITERAL_EXP, csElement);
				if (pivotElement != null) {
					pivotElement.setIntegerSymbol(number);
				}
			}
			else {
				UnlimitedNaturalLiteralExp pivotElement = context.refreshModelElement(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csElement);
				if (pivotElement != null) {
					pivotElement.setUnlimitedNaturalSymbol(number);
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperatorCS(@NonNull OperatorCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrefixExpCS(@NonNull PrefixExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveLiteralExpCS(@NonNull PrimitiveLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitSelfExpCS(@NonNull SelfExpCS csElement) {
		context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitStringLiteralExpCS(@NonNull StringLiteralExpCS csElement) {
		StringLiteralExp pivotElement = context.refreshModelElement(StringLiteralExp.class, PivotPackage.Literals.STRING_LITERAL_EXP, csElement);
		if (pivotElement != null) {
			List<String> names = csElement.getName();
			if (names.size() == 0) {
				pivotElement.setStringSymbol("");
			}
			else if (names.size() == 1) {
				pivotElement.setStringSymbol(names.get(0));
			}
			else {
				StringBuilder s = new StringBuilder();
				for (String name : names) {
					s.append(name);
				}
				pivotElement.setStringSymbol(s.toString());
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitTupleLiteralExpCS(@NonNull TupleLiteralExpCS csElement) {
		TupleLiteralExp pivotElement = context.refreshModelElement(TupleLiteralExp.class, PivotPackage.Literals.TUPLE_LITERAL_EXP, csElement);	
		if (pivotElement != null) {
			context.refreshPivotList(TupleLiteralPart.class, pivotElement.getPart(), csElement.getOwnedParts());
		}
		return null;
	}

	@Override
	public Continuation<?> visitTupleLiteralPartCS(@NonNull TupleLiteralPartCS csElement) {
		refreshNamedElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csElement);	
		return null;
	}

	@Override
	public Continuation<?> visitTypeLiteralExpCS(@NonNull TypeLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.TYPE, csElement, null);
		return null;
	}

	@Override
	public Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull UnlimitedNaturalLiteralExpCS csElement) {
		UnlimitedNaturalLiteralExp pivotElement = context.refreshModelElement(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csElement);
		if (pivotElement != null) {
			pivotElement.setName("*");
			pivotElement.setUnlimitedNaturalSymbol(Unlimited.INSTANCE);
		}
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csElement) {
		refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}