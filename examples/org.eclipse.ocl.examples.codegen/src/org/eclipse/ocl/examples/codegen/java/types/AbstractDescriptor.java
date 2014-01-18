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
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainNamespace;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * An AbstractDescriptor provides the most fundamental capabilities of any type description: the correspondence to a pivot ElementId.
 */
public abstract class AbstractDescriptor implements TypeDescriptor
{
	/**
	 * NamedFuture is a placeholder for classes that have yet to be created. It should never have any real instances or references.
	 *
	 */
	protected static class NamedFuture {
		private NamedFuture() {}
	}
	
	/**
	 * Convert an AS javaClass to its underlying Domain interface.
	 * FIXME Avoid two-level AS interfaces
	 */
	protected static @NonNull Class<?> reClass(@NonNull Class<?> javaClass) {
		if (javaClass == Constraint.class) {
			javaClass = DomainConstraint.class;
		}
		else if (javaClass == NamedElement.class) {
			javaClass = DomainNamedElement.class;
		}
		else if (javaClass == Namespace.class) {
			javaClass = DomainNamespace.class;
		}
		else if (javaClass == OCLExpression.class) {
			javaClass = DomainExpression.class;
		}
		else if (javaClass == OpaqueExpression.class) {
			javaClass = DomainExpression.class;
		}
		else if (javaClass == Operation.class) {
			javaClass = DomainOperation.class;
		}
		else if (javaClass == org.eclipse.ocl.examples.pivot.Package.class) {
			javaClass = DomainPackage.class;
		}
		else if (javaClass == Parameter.class) {
			javaClass = DomainTypedElement.class;
		}
		else if (javaClass == Property.class) {
			javaClass = DomainProperty.class;
		}
		else if (javaClass == Type.class) {
			javaClass = DomainType.class;
		}
		return javaClass;
	}

	protected final @NonNull ElementId elementId;
	
	public AbstractDescriptor(@NonNull ElementId elementId) {
		this.elementId = elementId;
	}

	@Override
	public void appendCast(@NonNull JavaStream js, @Nullable Class<?> actualJavaClass, @Nullable SubStream subStream) {
		js.append("(");
		append(js);
		js.append(")");
		if (subStream != null) {
			subStream.append();
		}
	}

	@Override
	public void appendNotEqualsTerm(@NonNull JavaStream js, @NonNull CGValuedElement thisValue, @NonNull TypeDescriptor thatTypeDescriptor, @NonNull String thatName) {
		js.append("(");
		js.appendValueName(thisValue);
		js.append(" != ");
		js.append(thatName);
		js.append(") && (");
		js.appendValueName(thisValue);
		js.append(" == null || !");
		js.appendValueName(thisValue);
		js.append(".equals(");
		js.append(thatName);
		js.append("))");
	}

	protected boolean zzisBoxedElement(@NonNull CGValuedElement cgValue) {
		TypeId typeId = cgValue.getASTypeId();
		if (typeId instanceof EnumerationLiteralId) {
			return true;
		}
		if (typeId instanceof EnumerationId) {
			return true;
		}
		if (typeId instanceof ClassId) {
			return true;
		}
		return false;
	}

	protected boolean zzisBoxedType(@NonNull MetaModelManager metaModelManager, @NonNull CGValuedElement cgValue) {
		Element ast = cgValue.getAst();
		if (!(ast instanceof TypedElement)) {
			return false;
		}
		Type type = ((TypedElement)ast).getType();
		if (type == null) {
			return false;
		}
		if (type instanceof DomainEnumeration) {
			return false;
		}
		Type oclTypeType = metaModelManager.getOclTypeType();
		return metaModelManager.conformsTo(type, oclTypeType, null);
	}

	@Override
	public void appendEqualsValue(@NonNull JavaStream js, @NonNull CGValuedElement thisValue, @NonNull CGValuedElement thatValue, boolean notEquals) {
		MetaModelManager metaModelManager = js.getCodeGenerator().getMetaModelManager();
		if (zzisBoxedType(metaModelManager, thisValue) && zzisBoxedType(metaModelManager, thatValue)) {
			boolean nullSafe = thisValue.isNonNull() && thatValue.isNonNull();
			if (!nullSafe) {
				String prefix = "";
				if (!thisValue.isNonNull()) {
					js.append("(");
					js.appendValueName(thisValue);
					js.append(" != null)");
					prefix = " && ";
				}
				if (!thatValue.isNonNull()) {
					js.append(prefix);
					js.append("(");
					js.appendValueName(thatValue);
					js.append(" != null)");
				}
				js.append(" ? (");
			}
			js.appendValueName(thisValue);
			js.append(".getTypeId()");
			js.append(notEquals ? " != " : " == ");
			js.appendValueName(thatValue);
			js.append(".getTypeId()");
			if (!nullSafe) {
				js.append(") : ");
				js.appendThrowBooleanInvalidValueException("null equal input");
			}
		}
		else if (zzisBoxedElement(thisValue) && zzisBoxedElement(thatValue)) {		// FIXME Is this needed ?
			js.appendValueName(thisValue);
			js.append(notEquals ? " != " : " == ");
			js.appendValueName(thatValue);
		}
		else if (thisValue.isNonNull()) {
			if (notEquals) {
				js.append("!");
			}
			js.appendValueName(thisValue);
			js.append(".equals(");
			js.appendValueName(thatValue);
			js.append(")");
		}
		else if (thatValue.isNonNull()) {
			if (notEquals) {
				js.append("!");
			}
			js.appendValueName(thatValue);
			js.append(".equals(");
			js.appendValueName(thisValue);
			js.append(")");
		}
		else {
			js.append("(");
			js.appendValueName(thisValue);
			js.append(" != null) ? ");
			if (notEquals) {
				js.append("!");
			}
			js.appendValueName(thisValue);
			js.append(".equals(");
			js.appendValueName(thatValue);
			js.append(") : (");
			js.appendValueName(thatValue);
			js.append(notEquals ? " != " : " == ");
			js.append("null)");
		}
	}

	@Override
	public @Nullable CollectionDescriptor asCollectionDescriptor() {
		return null;
	}

	@Override
	public @Nullable EClassifier getEClassifier() {
		return null;
	}
	
	public @NonNull ElementId getElementId() {
		return elementId;
	}

	@Override
	public  @NonNull TypeDescriptor getPrimitiveDescriptor() {
		return this;
	}

	@Override
	public boolean isAssignableTo(@NonNull Class<?> javaClass) {
		return javaClass == Object.class;
	}

	@Override
	public @NonNull String toString() {
		return elementId + " => " + getClassName();
	}
}
