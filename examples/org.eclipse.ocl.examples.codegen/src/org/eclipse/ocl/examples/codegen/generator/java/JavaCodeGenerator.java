/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 **/
package org.eclipse.ocl.examples.codegen.generator.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.EmitQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaInliners;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public abstract class JavaCodeGenerator extends AbstractCodeGenerator
{
	private /*@LazyNonNull*/ String evaluatorName = null;
	private /*@LazyNonNull*/ CodeGenSnippet evaluatorSnippet = null;
	private /*@LazyNonNull*/ CodeGenSnippet standardLibraryName = null;

	public JavaCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		initInliners();
	}
	
	protected JavaCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager, @NonNull ConstantHelper constantHelper,
			@NonNull ImportManager importManager, @NonNull GenModelHelper genModelHelper,
			@NonNull Id2JavaSnippetVisitor idVisitor, @NonNull AST2JavaSnippetVisitor astVisitor) {
		super(metaModelManager, nameManager, constantHelper, importManager, genModelHelper, idVisitor, astVisitor);
		initInliners();
	}

	@Override
	protected @NonNull Visitor<CodeGenSnippet> createAST2SnippetVisitor() {
		return new AST2JavaSnippetVisitor(this);
	}

	public @NonNull JavaSnippet createCodeGenSnippet(@Nullable String indentation, int flags) {
		return new JavaSnippet(indentation != null ? indentation : getDefaultIndent(), this, flags);
	}

	@Override
	protected @NonNull ConstantHelper createConstantHelper() {
		return new JavaConstantHelper(this);
	}

	@Override
	protected @NonNull GenModelHelper createGenModelHelper() {
		return new AbstractGenModelHelper(metaModelManager);
	}

	@Override
	protected @NonNull IdVisitor<CodeGenSnippet> createId2SnippetVisitor() {
		return new Id2JavaSnippetVisitor(this);
	}

	@Override
	protected @NonNull ImportManager createImportManager() {
		return new JavaImportManager(EmitQueries.knownClasses);
	}

	@Override
	protected @NonNull NameManager createNameManager() {
		return new NameManager(metaModelManager);
	}

	public @NonNull Class<?> getBoxedClass(@NonNull TypeId typeId) {
		IdVisitor<Class<?>> id2BoxedClassVisitor = getId2BoxedClassVisitor();
		Class<?> javaClass = typeId.accept(id2BoxedClassVisitor);
		assert javaClass != null;
		return javaClass;
	}

	public @NonNull String getEvaluatorName() {
		String evaluatorName2 = evaluatorName;
		if (evaluatorName2 == null) {
			evaluatorName = evaluatorName2 = nameManager.reserveName("evaluator", null);
		}
		return evaluatorName2;
	}

	public @NonNull CodeGenSnippet getEvaluatorSnippet() {
		CodeGenSnippet evaluatorSnippet2 = evaluatorSnippet;
		if (evaluatorSnippet2 == null) {
			evaluatorSnippet2 = evaluatorSnippet = new JavaSnippet(getEvaluatorName(), TypeId.OCL_ANY, DomainEvaluator.class, this, "", CodeGenSnippet.FINAL | CodeGenSnippet.INLINE | CodeGenSnippet.LOCAL | CodeGenSnippet.NON_NULL);
		}
		return evaluatorSnippet2;
	}

	public @NonNull IdVisitor<Class<?>> getId2BoxedClassVisitor() {
		return Id2BoxedJavaClassVisitor.INSTANCE;
	}

	public @NonNull IdVisitor<Class<?>> getId2UnboxedClassVisitor() {
		return Id2UnboxedJavaClassVisitor.INSTANCE;
	}

	public @NonNull CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet) {
		CodeGenSnippet standardLibraryName2 = standardLibraryName;
		if (standardLibraryName2 == null) {
			String name = nameManager.reserveName("standardLibrary", null);
			standardLibraryName = standardLibraryName2 = new JavaSnippet(name, TypeId.OCL_ANY, DomainStandardLibrary.class, this, "", CodeGenSnippet.FINAL | CodeGenSnippet.INLINE | CodeGenSnippet.NON_NULL);
			standardLibraryName.append("final " + referringSnippet.atNonNull() + " " + referringSnippet.getImportedName(DomainStandardLibrary.class) + " " + name + " = " + getEvaluatorName() + ".getStandardLibrary();\n");
		}
		referringSnippet.addDependsOn(standardLibraryName2);
		return standardLibraryName2;
	}

	public @NonNull Class<?> getUnboxedClass(@NonNull Type type) {
		Class<?> typeIdClass = getUnboxedClass(type.getTypeId());
		Class<?> instanceClass = null;
		if (type instanceof DataType) {
			String instanceClassName = ((DataType)type).getInstanceClassName();
			if (instanceClassName != null) {
				try {
					if (!instanceClassName.contains(".")) {
						if ("boolean".equals(instanceClassName)) { return Boolean.class; }
						if ("byte".equals(instanceClassName)) { return Byte.class; }
						if ("char".equals(instanceClassName)) { return Character.class; }
						if ("double".equals(instanceClassName)) { return Double.class; }
						if ("float".equals(instanceClassName)) { return Float.class; }
						if ("int".equals(instanceClassName)) { return Integer.class; }
						if ("long".equals(instanceClassName)) { return Long.class; }
						if ("short".equals(instanceClassName)) { return Short.class; }
					}
					instanceClass = type.getClass().getClassLoader().loadClass(instanceClassName);
				} catch (Exception e) {
					
				}
			}
		}
		if ((instanceClass != null) && typeIdClass.isAssignableFrom(instanceClass)) {
			return instanceClass;
		}
		else {
			return typeIdClass;
		}
	}

	public @NonNull Class<?> getUnboxedClass(@NonNull TypeId typeId) {
		IdVisitor<Class<?>> id2UnboxedClassVisitor = getId2UnboxedClassVisitor();
		Class<?> javaClass = typeId.accept(id2UnboxedClassVisitor);
		assert javaClass != null;
		return javaClass;
	}

	protected void initInliners() {
		new JavaInliners(this);
	}
}
