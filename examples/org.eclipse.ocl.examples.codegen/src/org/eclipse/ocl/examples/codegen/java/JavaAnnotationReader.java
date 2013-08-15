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
package org.eclipse.ocl.examples.codegen.java;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

/**
 * JavaAnnotationReader supports determination of the declared @NonNull, @Nullable state of a method .
 */
public class JavaAnnotationReader
{
	private static final Logger logger = Logger.getLogger(JavaAnnotationReader.class);

	private final @NonNull Map<String, Boolean> desc2state = new HashMap<String, Boolean>();
	private final @NonNull Set<String> readClasses = new HashSet<String>();
	private final @SuppressWarnings("null")@NonNull String nonNullDesc = Type.getDescriptor(NonNull.class);
	private final @SuppressWarnings("null")@NonNull String nullableDesc = Type.getDescriptor(Nullable.class);

	public JavaAnnotationReader() {}

	/**
	 * Return true for an @NonNull annotation, false for an @Nullable annotation, null otherwise.
	 */
	public Boolean getIsNonNull(@NonNull Method method) {
		final String className = method.getDeclaringClass().getName();
		final String requiredDesc = className + ";" + method.getName() + Type.getMethodDescriptor(method);
		Boolean state = desc2state.get(requiredDesc);
		if (state != null) {
			return state;
		}
		if (!readClasses.add(className)) {
			return null;
		}
		System.out.println("getIsNonNull: " + requiredDesc);
		try {
			final int flags = ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES | ClassReader.SKIP_CODE;
			final ClassReader cr = new ClassReader(className);
			ClassVisitor cv = new ClassVisitor()
			{
				public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
					final String methodDesc = className + ";" + name + desc;
					System.out.println("  ClassVisitor.visitMethod: " + methodDesc);
					desc2state.put(methodDesc, null);
					return new MethodVisitor()
					{
						public AnnotationVisitor visitAnnotation(String annotationDesc, boolean visible) {
							System.out.println("    MethodVisitor:" + annotationDesc + " " + true);
							if (annotationDesc.equals(nonNullDesc)) {
								desc2state.put(methodDesc, true);
							}
							else if (annotationDesc.equals(nullableDesc)) {
								desc2state.put(methodDesc, false);
							}
							return null;
						}

						public AnnotationVisitor visitAnnotationDefault() {
							return null;
						}

						public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
							return null;
						}

						public void visitAttribute(Attribute attr) {}

						public void visitCode() {}

						public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
						}

						public void visitInsn(int opcode) {
						}

						public void visitIntInsn(int opcode, int operand) {}

						public void visitVarInsn(int opcode, int var) {}

						public void visitTypeInsn(int opcode, String type) {}

						public void visitFieldInsn(int opcode, String owner, String name, String desc) {}

						public void visitMethodInsn(int opcode, String owner, String name, String desc) {}

						public void visitJumpInsn(int opcode, Label label) {}

						public void visitLabel(Label label) {}

						public void visitLdcInsn(Object cst) {}

						public void visitIincInsn(int var, int increment) {}

						public void visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels) {}

						public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {}

						public void visitMultiANewArrayInsn(String desc, int dims) {}

						public void visitTryCatchBlock(Label start, Label end,Label handler, String type) {}

						public void visitLocalVariable(String name,
								String desc, String signature, Label start,
								Label end, int index) {}

						public void visitLineNumber(int line, Label start) {}

						public void visitMaxs(int maxStack, int maxLocals) {}

						public void visitEnd() {}				
					};
				}

				public void visit(int version, int access, String name,
						String signature, String superName, String[] interfaces) {
				}

				public void visitSource(String source, String debug) {}

				public void visitOuterClass(String owner, String name, String desc) {}

				public AnnotationVisitor visitAnnotation(String desc,boolean visible) {
					return null;
				}

				public void visitAttribute(Attribute attr) {}

				public void visitInnerClass(String name, String outerName,String innerName, int access) {}

				public FieldVisitor visitField(int access, String name,String desc, String signature, Object value) {
					return null;
				}

				public void visitEnd() {}
			};
			cr.accept(cv, flags);
		} catch (IOException e) {
			logger.error("Failed to read '" + className + "'", e);
		}
		return desc2state.get(requiredDesc);
	}
}
