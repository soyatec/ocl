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
package org.eclipse.ocl.examples.codegen.oclinecore;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * A JavaLocalContext maintains the Java-specific context for generation of coide from a CGOperation.
 */
public class OCLinEcoreLocalContext extends JavaLocalContext
{
	private /*LazyNonNull*/ CGText evaluatorParameter;
	protected final @Nullable String contextName;
	protected final @Nullable String diagnosticsName;
	protected final @Nullable String messageName;
	protected final @Nullable String severityName;

	public OCLinEcoreLocalContext(@NonNull JavaGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext, cgScope);
		if (cgScope instanceof CGConstraint) {
			this.contextName = nameManagerContext.getSymbolName(null, "context");
			this.diagnosticsName = nameManagerContext.getSymbolName(null, "diagnostics");
			this.messageName = nameManagerContext.getSymbolName(null, "message");
			this.severityName = nameManagerContext.getSymbolName(null, "severity");
		}
		else {
			this.contextName = null;
			this.diagnosticsName = null;
			this.messageName = null;
			this.severityName = null;
		}
	}
	
	public OCLinEcoreLocalContext(@NonNull OCLinEcoreLocalContext parentContext, @NonNull CGElement cgScope) {
		super(parentContext, cgScope);
		this.contextName = null;
		this.diagnosticsName = null;
		this.messageName = null;
		this.severityName = null;
	}

	@Override
	public @NonNull OCLinEcoreLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new OCLinEcoreLocalContext(this, cgScope);
	}

	@Override
	public @NonNull CGParameter getCastParameter(@NonNull CGParameter cgParameter) {
		if (cgParameter instanceof CGTextParameter) {
			return cgParameter;
		}
		if (cgParameter instanceof CGIterator) {
			return super.getCastParameter(cgParameter);
		}
		if (JavaConstants.SELF_NAME.equals(cgParameter.getName())) {
			JavaLocalContext parentContext2 = parentContext;
			if (parentContext2 != null) {
				return parentContext2.getCastParameter(cgParameter);
			}
			else {
				CGParameter cgCastParameter = basicGetCastParameter(cgParameter);
				if (cgCastParameter == null) {
					Variable pivotParameter = (Variable)cgParameter.getPivot();
					CGTextParameter cgTextParameter = CGModelFactory.eINSTANCE.createCGTextParameter();
					cgTextParameter.setName(cgParameter.getName());
					cgTextParameter.setValueName(globalContext.getSelfName());
					cgTextParameter.setPivot(pivotParameter);
					cgTextParameter.setTextValue("this");
					cgTextParameter.setNonInvalid();
					cgTextParameter.setNonNull();
					cgTextParameter.setTypeId(analyzer.getTypeId(pivotParameter.getTypeId()));
					addCastParameter(cgParameter, cgTextParameter);
					cgCastParameter = cgTextParameter;
				}
				return cgCastParameter;
			}
		}
		return cgParameter;
	}

	public @Nullable String getContextName() {
		return contextName;
	}

	public @Nullable String getDiagnosticsName() {
		return diagnosticsName;
	}

	@Override
	public @NonNull CGValuedElement getEvaluatorParameter() {
		if (parentContext != null) {
			return parentContext.getEvaluatorParameter();
		}
		CGText evaluatorParameter2 = evaluatorParameter;
		if (evaluatorParameter2 == null) {
			evaluatorParameter = evaluatorParameter2 = CGModelFactory.eINSTANCE.createCGText();
			setNames(evaluatorParameter2, JavaConstants.EVALUATOR_NAME, JavaConstants.EVALUATOR_TYPE_ID);
			String managerClassName = ImportUtils.getAffixedName(EcoreExecutorManager.class);
			evaluatorParameter2.setTextValue("new " + managerClassName + "(this, " + getGlobalContext().getTablesClassName() + ".LIBRARY)");
			addLocalVariable(evaluatorParameter2);
		}
		return evaluatorParameter2;
	}

	@Override
	public @NonNull OCLinEcoreGlobalContext getGlobalContext() {
		return (OCLinEcoreGlobalContext) globalContext;
	}

	public @Nullable String getMessageName() {
		return messageName;
	}

	public @Nullable String getSeverityName() {
		return severityName;
	}
}
