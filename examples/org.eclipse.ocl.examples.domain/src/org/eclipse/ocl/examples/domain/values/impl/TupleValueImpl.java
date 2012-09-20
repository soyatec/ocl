/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TupleValueImpl.java,v 1.6 2011/03/14 17:04:44 ewillink Exp $
 */

package org.eclipse.ocl.examples.domain.values.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * UML implementation of a tuple value.
 * 
 * @author Christian W. Damus (cdamus)
 * @generated NOT
 */
public class TupleValueImpl extends ValueImpl implements TupleValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.TUPLE_VALUE;
	}

//	protected final @NonNull ValueFactory valueFactory;
	protected final @NonNull TupleTypeId typeId;
    private final @NonNull Map<String, Object> parts = new java.util.HashMap<String, Object>();
    private Integer hashCode = null;

    /**
     * Initializes me with a map of part values.
     * 
     * @param type my type
     * @param values my parts
     */
    public TupleValueImpl(@NonNull TupleTypeId typeId, @NonNull Map<? extends DomainTypedElement, Object> values) {
		this.typeId = typeId;
        for (Map.Entry<? extends DomainTypedElement, Object> entry : values.entrySet()) {
            parts.put(entry.getKey().getName(), entry.getValue());
        }
    }
    
    /**
     * Convenience constructor to initialize me with a pair of part values as
     * required by the Collection::product() operation.
     * 
     * @param type my type
     * @param firstValue my first value
     * @param secondValue my second value
     */
    public TupleValueImpl(@NonNull TupleTypeId typeId, @NonNull Object firstValue, @NonNull Object secondValue) {
		this.typeId = typeId;
        parts.put("first", firstValue);			// FIXME define "first" elsewhere
        parts.put("second", secondValue);
    }

	public @NonNull Object asObject() {
		return parts;
	}

    @Override
	public @NonNull TupleValue asTupleValue() {
        return this;
    }

    // overrides the inherited implementation
    @Override
    public boolean equals(Object o) {
    	if (this == o) {
    		return true;
    	}
    	if (!(o instanceof TupleValueImpl)) {
    		return false;
    	}
    	TupleValueImpl that = (TupleValueImpl)o;
    	if (this.typeId != that.typeId) {
    		return false;
    	}
    	return this.parts.equals(that.parts);
    }

	public @NonNull TupleTypeId getTypeId() {
		return typeId;
	}

    // implements the inherited specification
    public @Nullable Object getValue(@NonNull String partName) {
        return parts.get(partName);
    }

    // implements the inherited specification
    public @Nullable Object getValue(@NonNull DomainTypedElement part) {
        String name = part.getName();
		return name != null ? getValue(name) : null;
    }

    // overrides the inherited implementation
    @Override
    public int hashCode() {
    	if (hashCode == null) {
            int typeHashCode = typeId.hashCode();
    		int partsHashCode = parts.hashCode();
    		hashCode = 37 * typeHashCode + 17 * partsHashCode;
    	}
		return hashCode;
    }

	@Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Tuple{"); //$NON-NLS-1$       
        String[] partNames = typeId.getPartNames();
        TypeId[] partTypeIds = typeId.getPartTypeIds();
		for (int i = 0; i < partNames.length; i++) {
            String partName = partNames[i];
            if (i != 0) {
                result.append(", "); //$NON-NLS-1$
            }
			result.append(partName);
            result.append(" : ");
            result.append(partTypeIds[i]);
            result.append(" = "); //$NON-NLS-1$
            ValuesUtil.toString(parts.get(partName), result, 40);
        }       
        result.append("}"); //$NON-NLS-1$
        return result.toString();
    }
    
/*    private String toString(Object o) {
        / *if (o instanceof String) {
            return "'" + (String) o + "'"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if (o instanceof NullValue) {
            return o.toString();
        } else if (o instanceof CollectionValue) {
            return toString((CollectionValue) o);
        } else* / if (o == null) {
            return "null"; //$NON-NLS-1$
        } else {
            return o.toString();
        }
    } */
}
