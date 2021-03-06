/*******************************************************************************
 * Copyright (c) 2009, 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.framework.LogicalOperationFilterImpl;


/**
 * Is an {@link LogicalOperationFilter} and implements the not-operator.
 * Not applies only for one {@link EventFilter} so the {@link NotFilter} 
 * can only contain one operand.
 * 
 * @author Philipp Berger, Axel Uhl
 *
 */
public class NotFilter extends LogicalOperationFilterImpl {
    public NotFilter() {
        super();
    }

    /**
     * The standard constructor
     * @param subTypeFilterTree the filter to negate
     */
    public NotFilter(EventFilter subTypeFilterTree) {
        super(subTypeFilterTree);
    }

    public boolean matchesFor(Notification event) {
        if (getOperands().isEmpty())
            return true;
        return !(getOperands().iterator().next().matchesFor(event));
    }

    @Override
    public NotFilter clone() {
        return new NotFilter(cloneContents()[0]);

    }
    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        for (EventFilter f : getOperands()) {
            bld.append("NOT(");
            bld.append(f.toString());
            bld.append(")");
        }

        return bld.toString();
    }
}
