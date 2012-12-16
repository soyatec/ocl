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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.EmitQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaInliners;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
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
	public static Map<Class<?>, Class<?>> javaPrimitiveClasses = new HashMap<Class<?>, Class<?>>();
	public static Map<String, Class<?>> javaPrimitiveNames = new HashMap<String, Class<?>>();
	{
		initPrimitive(boolean.class, Boolean.class);
		initPrimitive(byte.class, Byte.class);
		initPrimitive(char.class, Character.class);
		initPrimitive(double.class, Double.class);
		initPrimitive(float.class, Float.class);
		initPrimitive(int.class, Integer.class);
		initPrimitive(long.class, Long.class);
		initPrimitive(short.class, Short.class);
	}
	
	public static void initPrimitive(Class<?> class1, Class<?> class2) {
		javaPrimitiveClasses.put(class1, class2);
		javaPrimitiveNames.put(class1.getName(), class2);		
	}
	
	private String evaluatorName = null;
	private CodeGenSnippet evaluatorSnippet = null;
	private CodeGenSnippet standardLibraryName = null;
	private CodeGenSnippet idResolverName = null;

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
		return new NameManager();
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
//			System.out.println("evaluatorSnippet " + DomainUtil.debugSimpleName(evaluatorSnippet2));
		}
		return evaluatorSnippet2;
	}

	public @NonNull IdVisitor<Class<?>> getId2BoxedClassVisitor() {
		return Id2BoxedJavaClassVisitor.INSTANCE;
	}

	public @NonNull IdVisitor<Class<?>> getId2UnboxedClassVisitor() {
		return Id2UnboxedJavaClassVisitor.INSTANCE;
	}

	public @NonNull CodeGenSnippet getIdResolver() {
		CodeGenSnippet idResolverName2 = idResolverName;
		if (idResolverName2 == null) {
			String name = nameManager.reserveName("idResolver", null);
			idResolverName = idResolverName2 = new JavaSnippet(name, TypeId.OCL_ANY, IdResolver.class, this, "", CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.NON_NULL);
//			CodeGenText text = idResolverName.append("final " + referringSnippet.atNonNull() + " " + referringSnippet.getImportedName(DomainStandardLibrary.class) + " " + name + " = ");
			return idResolverName.appendText("", new AbstractTextAppender()
			{			
				public void appendToBody(@NonNull CodeGenText text) {
					text.appendReferenceTo(getEvaluatorSnippet());
					text.append(".getIdResolver()");
				}
			});
//			System.out.println("idResolverName " + DomainUtil.debugSimpleName(idResolverName));
		}
//		referringSnippet.addDependsOn(idResolverName2);
		return idResolverName2;
	}

	public @NonNull CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet) {
		CodeGenSnippet standardLibraryName2 = standardLibraryName;
		if (standardLibraryName2 == null) {
			String name = nameManager.reserveName("standardLibrary", null);
			standardLibraryName = standardLibraryName2 = new JavaSnippet(name, TypeId.OCL_ANY, DomainStandardLibrary.class, this, "", CodeGenSnippet.FINAL | CodeGenSnippet.INLINE | CodeGenSnippet.NON_NULL);
			standardLibraryName.append("final " + referringSnippet.atNonNull() + " " + referringSnippet.getImportedName(DomainStandardLibrary.class) + " " + name + " = " + getEvaluatorName() + ".getStandardLibrary();\n");
		}
		referringSnippet.addDependsOn(standardLibraryName2);
		addDependency(CodeGenerator.LOCAL_ROOT, standardLibraryName2);
		return standardLibraryName2;
	}

	public @NonNull Class<?> getUnboxedClass(@NonNull Type type) {
		Class<?> typeIdClass = getUnboxedClass(type.getTypeId());
		Class<?> instanceClass = null;
		if (type instanceof DataType) {
			String instanceClassName = ((DataType)type).getInstanceClassName();
			if (instanceClassName != null) {
				try {
					Class<?> primitiveClass = javaPrimitiveNames.get(instanceClassName);
					if (primitiveClass != null) {
						return primitiveClass;
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

	@Override
	protected void resetLocals() {
		evaluatorName = null;
		evaluatorSnippet = null;
		idResolverName = null;
		standardLibraryName = null;
	}
}
