/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.domain.types;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;

/**
 * IdResolver supports discovery/creation of rich Pivot-based objects from limited
 * descriptors such as ElementIds, or from Ecore objects or from Java objects.
 */
public interface IdResolver extends IdVisitor<DomainElement>
{
	@NonNull BagValue createBagValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects);

	@NonNull BagValue createBagValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects);

	@NonNull OrderedSetValue createOrderedSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects);

	@NonNull OrderedSetValue createOrderedSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects);

	@NonNull SequenceValue createSequenceValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects);

	@NonNull SequenceValue createSequenceValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects);

	@NonNull SetValue createSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects);

	@NonNull SetValue createSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects);

	void dispose();

	@NonNull DomainType getCollectionType(@NonNull CollectionTypeId typeId);

	@NonNull DomainType getDynamicTypeOf(@Nullable Object value);

	@Nullable DomainType getDynamicTypeOf(@NonNull Object... values);

	@Nullable DomainType getDynamicTypeOf(@NonNull Iterable<?> values);

	@NonNull DomainEnumerationLiteral getEnumerationLiteral( @NonNull EnumerationLiteralId enumerationLiteralId, @Nullable DomainElement context);

	@NonNull DomainType getMetaclass(@NonNull MetaclassId metaclassId);

	@NonNull DomainStandardLibrary getStandardLibrary();

	@NonNull DomainType getStaticTypeOf(@Nullable Object value);

	@NonNull DomainType getStaticTypeOf(@Nullable Object value, Object... values);

	@NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values);

	@NonNull DomainTypedElement getTuplePart(@NonNull String name, @NonNull TypeId typeId);

	@NonNull DomainTupleType getTupleType(@NonNull TupleTypeId typeId);

	@NonNull DomainType getType(@NonNull EClassifier eClassifier);

	@NonNull DomainType getType(@NonNull TypeId typeId, @Nullable DomainElement context);

	@Nullable Object valueOf(@Nullable Object object);
}