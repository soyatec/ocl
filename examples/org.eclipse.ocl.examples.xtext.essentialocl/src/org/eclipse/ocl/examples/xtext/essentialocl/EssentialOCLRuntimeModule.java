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
 * $Id: EssentialOCLRuntimeModule.java,v 1.6 2011/05/15 20:22:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl;

import org.antlr.runtime.TokenSource;
import org.eclipse.ocl.examples.xtext.base.InjectorProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.EssentialOCLParser;
import org.eclipse.ocl.examples.xtext.essentialocl.services.RetokenizingTokenSource;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EssentialOCLRuntimeModule extends org.eclipse.ocl.examples.xtext.essentialocl.AbstractEssentialOCLRuntimeModule
{	
	public static final String LANGUAGE_ID = "org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCL";
		
	@Override
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return RetokenizingEssentialOCLParser.class;
	}

	public static long enterRuleCounter = 0;
	
	public static class RetokenizingEssentialOCLParser extends EssentialOCLParser
	{		
		@Override
		protected org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.internal.InternalEssentialOCLParser createParser(XtextTokenStream stream) {
			return new org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.internal.InternalEssentialOCLParser(stream, getGrammarAccess())
			{				
				@Override
				protected void enterRule() {
					enterRuleCounter++;
					super.enterRule();
				}
				
			};
		}

		@Override
		protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
			return super.createTokenStream(new RetokenizingTokenSource(tokenSource, getTokenDefProvider().getTokenDefMap()));
		}
	}
	
	/**
	 * @return the language injector provider
	 */
	public Class<? extends InjectorProvider> bindInjectorProvider() {
		return EssentialOCLInjectorProvider.class;
	}
	
	public void configureEObjectValidation(Binder binder) {
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}
	
//	public void configureCS2PivotResourceAdapter(Binder binder) {
//		binder.bind(CS2PivotResourceAdapter.class);
//	}
}
