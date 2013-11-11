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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLinEcoreFormatter.java,v 1.14 2011/05/21 14:58:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.formatting;

import org.eclipse.ocl.examples.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AnnotationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AttributeCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ClassCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.CollectionTypeCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DataTypeCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DocumentationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumerationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumerationLiteralCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ImportCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.InvariantConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ModelElementRefCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.OperationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PackageCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ParameterCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PostconditionConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PreconditionConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ReferenceCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.SysMLCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.TemplateBindingCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.TemplateSignatureCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class OCLinEcoreFormatter extends AbstractEssentialOCLFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {

	    c.setAutoLinewrap(120);

	    OCLinEcoreGrammarAccess f = getGrammarAccess();
	    
		configureCollectionLiteralExpCS(c, f.getCollectionLiteralExpCSAccess());
//		configureCollectionTypeCS(c, f.getCollectionTypeCSAccess());
		{
			CollectionTypeCSElements a = f.getCollectionTypeCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_1_2());
		}
	    configureEssentialOCLNavigationOperatorCS(c, f.getEssentialOCLNavigationOperatorCSAccess());
		configureIfExpCS(c, f.getIfExpCSAccess());
		configureLetExpCS(c, f.getLetExpCSAccess());
		configureMultiplicityBoundsCS(c, f.getMultiplicityBoundsCSAccess());
		configureMultiplicityCS(c, f.getMultiplicityCSAccess());
		configureMultiplicityStringCS(c, f.getMultiplicityStringCSAccess());
	    configureNavigatingCommaArgCS(c, f.getNavigatingCommaArgCSAccess());
	    configureNavigatingSemiArgCS(c, f.getNavigatingSemiArgCSAccess());
	    configureNestedExpCS(c, f.getNestedExpCSAccess());
	    configurePathNameCS(c, f.getPathNameCSAccess());
	    configurePrimaryExpCS(c, f.getPrimaryExpCSAccess());
	    configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
	    configureTupleTypeCS(c, f.getTupleTypeCSAccess());
	    configureURIPathNameCS(c, f.getURIPathNameCSAccess());

	    c.setLinewrap(2).before(f.getML_COMMENTRule());
	    c.setLinewrap(1).after(f.getML_COMMENTRule());

	    c.setLinewrap(1).after(f.getTopLevelCSAccess().getNameAssignment_0_1());

	    c.setLinewrap(2).between(f.getImportCSRule(), f.getPackageCSRule());
	    c.setLinewrap(2).between(f.getPackageCSRule(), f.getPackageCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getEnumerationCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getEnumerationCSRule());
	    c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getEnumerationCSRule());

	    {	// AnnotationCS
			AnnotationCSElements a = f.getAnnotationCSAccess();
			setBraces(c, a.getLeftParenthesisKeyword_3_0(), a.getRightParenthesisKeyword_3_3());
//			setNoSpaceLineWrap(c, a.getLeftParenthesisKeyword_2_0());
			setNoSpaceLineWrap(c, a.getCommaKeyword_3_2_0());
//			c.setNoSpace().before(a.getRightParenthesisKeyword_2_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
//		    c.setIndentation(a.getLeftParenthesisKeyword_2_0(), a.getRightParenthesisKeyword_2_3());
	    }		
	    {	// AttributeCS
			AttributeCSElements a = f.getAttributeCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_2());
			c.setNoSpace().around(a.getCommaKeyword_5_1_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_6_0_2());
			//
			c.setNoSpace().before(a.getColonKeyword_6_0_1_1_2());
			c.setSpace(" ").after(a.getColonKeyword_6_0_1_1_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_0_1_1_4());
		    c.setIndentation(a.getColonKeyword_6_0_1_1_2(), a.getSemicolonKeyword_6_0_1_1_4());
		    //
			c.setNoSpace().before(a.getColonKeyword_6_0_1_1_2());
			c.setSpace(" ").after(a.getColonKeyword_6_0_1_1_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_0_1_2_4());
		    c.setIndentation(a.getColonKeyword_6_0_1_1_2(), a.getSemicolonKeyword_6_0_1_2_4());
	    }
	    {
			ClassCSElements a = f.getClassCSAccess();
			c.setNoSpace().around(a.getCommaKeyword_4_2_0());
				c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
	    }
	    {
			DataTypeCSElements a = f.getDataTypeCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
	    }
	    {
	    	DocumentationCSElements a = f.getDocumentationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3_0());	
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
			c.setNoSpace().before(a.getRightParenthesisKeyword_3_3());	
		    c.setIndentation(a.getLeftParenthesisKeyword_3_0(), a.getRightParenthesisKeyword_3_3());
	    }
	    {
			EnumerationCSElements a = f.getEnumerationCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
//			setBraces(c, a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
	    }
	    {
	    	EnumerationLiteralCSElements a = f.getEnumerationLiteralCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2_1());
	    }
	    {
	    	ImportCSElements a = f.getImportCSAccess();
			c.setNoSpace().around(a.getAllColonColonKeyword_3_0_0());	
			c.setNoSpace().around(a.getAsteriskKeyword_3_1());	
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
			InvariantConstraintCSElements a = f.getInvariantConstraintCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_2_1_0());
			c.setNoSpace().around(a.getRightParenthesisKeyword_2_1_2());
			c.setNoSpace().around(a.getColonKeyword_3_0_0());
			c.setSpace(" ").before(a.getSpecificationSpecificationCSParserRuleCall_3_0_1_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3_1());
		    c.setIndentation(a.getLeftParenthesisKeyword_2_1_0(), a.getRightParenthesisKeyword_2_1_2());
		    c.setIndentation(a.getColonKeyword_3_0_0(), a.getSemicolonKeyword_3_0_2());
	    }
	    {
	    	ModelElementRefCSElements a = f.getModelElementRefCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2());
	    }
	    {
			OperationCSElements a = f.getOperationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_4());	
			c.setNoSpace().before(a.getCommaKeyword_5_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_6());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_9_0(), a.getRightCurlyBracketKeyword_9_2());
			c.setNoSpace().around(a.getCommaKeyword_9_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_10_0_0(), a.getRightCurlyBracketKeyword_10_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_10_1());
		    c.setIndentation(a.getLeftParenthesisKeyword_4(), a.getRightParenthesisKeyword_6());
		    //
			c.setNoSpace().before(a.getColonKeyword_10_0_1_2_2());
			c.setSpace(" ").after(a.getColonKeyword_10_0_1_2_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_10_0_1_2_4());
		    c.setIndentation(a.getColonKeyword_10_0_1_2_2(), a.getSemicolonKeyword_10_0_1_2_4());
	    }
	    {
	    	PackageCSElements a = f.getPackageCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
	    }
	    {
			ParameterCSElements a = f.getParameterCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
			c.setNoSpace().around(a.getCommaKeyword_2_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0(), a.getRightCurlyBracketKeyword_3_2());
	    }
	    {
	    	PostconditionConstraintCSElements a = f.getPostconditionConstraintCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1_1_0());
			c.setNoSpace().around(a.getRightParenthesisKeyword_1_1_2());
			c.setNoSpace().around(a.getColonKeyword_2());
			c.setSpace(" ").before(a.getSpecificationSpecificationCSParserRuleCall_3_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
		    c.setIndentation(a.getColonKeyword_2(), a.getSemicolonKeyword_4());
	    }
	    {
	    	PreconditionConstraintCSElements a = f.getPreconditionConstraintCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1_1_0());
			c.setNoSpace().around(a.getRightParenthesisKeyword_1_1_2());
			c.setNoSpace().around(a.getColonKeyword_2());
			c.setSpace(" ").before(a.getSpecificationSpecificationCSParserRuleCall_3_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
		    c.setIndentation(a.getColonKeyword_2(), a.getSemicolonKeyword_4());
	    }
	    {
			ReferenceCSElements a = f.getReferenceCSAccess();
			c.setNoSpace().around(a.getNumberSignKeyword_3_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
			c.setNoSpace().around(a.getCommaKeyword_6_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
			c.setNoSpace().before(a.getCommaKeyword_7_0_1_1_2_0());
			//
		    setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_1_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
			//
			c.setNoSpace().before(a.getColonKeyword_7_0_1_2_2());
			c.setSpace(" ").after(a.getColonKeyword_7_0_1_2_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_2_4());
		    c.setIndentation(a.getColonKeyword_7_0_1_2_2(), a.getSemicolonKeyword_7_0_1_2_4());
		    //
			c.setNoSpace().before(a.getColonKeyword_7_0_1_3_2());
			c.setSpace(" ").after(a.getColonKeyword_7_0_1_3_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_3_4());
		    c.setIndentation(a.getColonKeyword_7_0_1_3_2(), a.getSemicolonKeyword_7_0_1_3_4());
	    }
	    {	// AnnotationCS
			SysMLCSElements a = f.getSysMLCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2_0_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2_1_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_2_1_0(), a.getRightCurlyBracketKeyword_2_1_2());
	    }		
	    {
			TemplateBindingCSElements a = f.getTemplateBindingCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_0_0());	
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_0_3());	
		    c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_3());
			c.setNoSpace().around(a.getLessThanSignKeyword_1_0());	
			c.setNoSpace().before(a.getCommaKeyword_1_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_1_3());	
		    c.setIndentation(a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());
	    }
	    {
			TemplateSignatureCSElements a = f.getTemplateSignatureCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_0_0());	
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_0_3());	
		    c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_3());
			c.setNoSpace().around(a.getLessThanSignKeyword_1_0());	
			c.setNoSpace().before(a.getCommaKeyword_1_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_1_3());	
		    c.setIndentation(a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());
	    }
	    {	// comments
	    	c.setNoLinewrap().before(f.getSL_COMMENTRule());
	    }
	}

	@Override
	public OCLinEcoreGrammarAccess getGrammarAccess() {
		return (OCLinEcoreGrammarAccess) super.getGrammarAccess();
	}
}
