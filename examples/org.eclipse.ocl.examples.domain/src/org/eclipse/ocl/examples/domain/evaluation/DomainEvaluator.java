/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Bag.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;

public interface DomainEvaluator
{
	<T> T asEcoreObject(@Nullable T example, @NonNull Object value);

	@NonNull DomainEvaluator createNestedEvaluator();
	@NonNull Object evaluate(@NonNull DomainExpression body);
	@NonNull DomainType getDynamicTypeOf(@NonNull Object value);
	@NonNull DomainEvaluationEnvironment getEvaluationEnvironment();

	/**
	 * Return the manager of all model instances for use by allInstances() and hidden opposite support.
	 */
	@NonNull DomainModelManager getModelManager();

	@NonNull DomainStandardLibrary getStandardLibrary();

	@NonNull DomainType getStaticTypeOf(@NonNull Object value);
	@NonNull DomainType getStaticTypeOf(@NonNull Object value, @NonNull Object... values);
	@NonNull DomainType getStaticTypeOf(@NonNull Object value, @NonNull Iterable<?> values);
	
	/**
	 * Return true if the evaluation has been canceled.
	 */
	boolean isCanceled();
	
	/**
	 * Request cancelation of the current the evaluation, or reset the request for a new evaluation.
	 * Cancelation occurs by throwing an {@link EvaluationHaltedException} when {@link #getValuefactory()}
	 * is next invoked. 
	 */
	void setCanceled(boolean isCanceled);
}
