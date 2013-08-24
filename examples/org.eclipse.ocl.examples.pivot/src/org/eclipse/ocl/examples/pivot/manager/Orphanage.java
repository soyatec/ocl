/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotResourceImpl;

/**
 * An Orphanage provides a Package that weakly contains elements such as type specializations that
 * should require a container for the purposes of validation, but which should be eligible for
 * garbage collection whenever no longer in use.
 */
public class Orphanage extends PackageImpl
{
	protected static class OrphanResource extends PivotResourceImpl
	{
		protected OrphanResource(URI uri) {
			super(uri);
		}

		@Override
		protected void doUnload() {
			if (contents != null) {
				for (EObject aContent : contents) {
					if (aContent instanceof Orphanage) {
						((Orphanage)aContent).dispose();
					}
				}
				contents = null;
			}
//			super.doUnload();
		}
	}

	/**
	 * WeakEList makes a WeakHashMap look like an EList for use as Package.ownedType.
	 * <br>
	 * Only the minimal suupport necessary to make aType.setPackage() and subsequent usage is provided.
	 * Additional list functionality could be provided exploiting the weakList cache.
	 */
	private static class WeakEList<T> extends AbstractEList<T> implements InternalEList<T>
	{
		private final @NonNull WeakHashMap<T, Integer> weakMap = new WeakHashMap<T, Integer>();
		private int counter = 0;
		private @Nullable List<Entry<T, Integer>> weakList = null;

//		@Override
//		public boolean add(T o) {
//			return weakList.put(o, null) == null;
//		}

		@Override
		public boolean addAllUnique(Object[] objects, int start, int end) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAllUnique(int index, Object[] objects, int start, int end) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAllUnique(Collection<? extends T> collection) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAllUnique(int index, Collection<? extends T> collection) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void addUnique(T object) {
			throw new UnsupportedOperationException();
//			weakList = null;
//			weakMap.put(object, Integer.valueOf(counter++));
		}

		@Override
		public void addUnique(int index, T object) {
			throw new UnsupportedOperationException();
		}

		public NotificationChain basicAdd(T object, NotificationChain notifications) {
			weakList = null;
			weakMap.put(object, Integer.valueOf(counter++));
			return notifications;
		}

		@Override
		public ListIterator<T> basicListIterator() {
			return Collections.<T>emptyList().listIterator();
//			throw new UnsupportedOperationException();
/*			List<Entry<T, Integer>> weakList2 = weakList;
			if (weakList2 != null) {
				List<T> list = new ArrayList<T>(weakList2.size());
				for (Entry<T, Integer> entry : weakList2) {
					list.add(entry.getKey());
				}
				return list.listIterator();
			}
			else {
				return Collections.<T>emptyList().listIterator();
			} */
		}

		public boolean basicContains(Object object) {
			throw new UnsupportedOperationException();
		}

		public boolean basicContainsAll(Collection<?> collection) {
			throw new UnsupportedOperationException();
		}

		@Override
		public T basicGet(int index) {
			throw new UnsupportedOperationException();
		}

		public int basicIndexOf(Object object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator<T> basicIterator() {
			throw new UnsupportedOperationException();
		}

		public int basicLastIndexOf(Object object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public List<T> basicList() {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator<T> basicListIterator(int index) {
			throw new UnsupportedOperationException();
		}

		public NotificationChain basicRemove(Object object, NotificationChain notifications) {
			throw new UnsupportedOperationException();
		}

		public Object[] basicToArray() {
			throw new UnsupportedOperationException();
		}

		public <T2> T2[] basicToArray(T2[] array) {
			throw new UnsupportedOperationException();
		}

//		@Override
//		protected boolean isUnique() {
//			return true;		-- imp[l;ementing this makes things really really slow.
//		}
		
		private List<Entry<T, Integer>> createList() {
			List<Entry<T, Integer>> weakList2 = weakList = new ArrayList<Entry<T, Integer>>(weakMap.entrySet());
			Collections.sort(weakList2, new Comparator<Entry<T, Integer>>()
			{
				public int compare(Entry<T, Integer> o1, Entry<T, Integer> o2) {
					return o1.getValue().compareTo(o2.getValue());
				}
			});
			return weakList2;
		}

		public void dispose() {
			weakList = null;
			weakMap.clear();
		}

		@Override
		public T get(int index) {
			List<Entry<T, Integer>> weakList2 = weakList;
			if (weakList2 == null) {
				weakList2 = createList();
			}
			return weakList2.get(index).getKey();
		}

//		public void move(int newPosition, T object) {
//			throw new UnsupportedOperationException();
//		}

		@Override
		public T move(int newPosition, int oldPosition) {
			throw new UnsupportedOperationException();
		}

		@Override
			protected T primitiveGet(int index) {
				throw new UnsupportedOperationException();
			}

		@Override
		public T remove(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public T setUnique(int index, T object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int size() {
			return weakMap.size();
		}

		@Override
		public String toString() {
			return weakMap.toString();
		}
	}

	public static final @NonNull URI ORPHANAGE_URI = DomainUtil.nonNullEMF(URI.createURI(PivotConstants.ORPHANAGE_URI));
	private static Orphanage INSTANCE = null;
	
	public static void disposeInstance() {
		if (INSTANCE != null) {
			INSTANCE.dispose();
			INSTANCE = null;
		}
	}

	/**
	 * Return the Orphanage for an eObject, which is the Orphanage resource in the same ResourceSet as
	 * the eObject, else the global Orphanage.
	 */
	public static @Nullable Orphanage getOrphanage(@NonNull EObject eObject) {
//		if (eObject == null) {
//			return null;
//		}
		Resource resource = eObject.eResource();
		if (resource == null) {
			return null;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		return getOrphanage(resourceSet);
	}

	/**
	 * Return the Orphanage for an eObject, which is the Orphanage resource in the resourceSet
	 * if non-null, else the global Orphanage.
	 */
	public static @NonNull Orphanage getOrphanage(@Nullable ResourceSet resourceSet) {
		if (resourceSet == null) {
			Orphanage instance2 = INSTANCE;
			if (instance2 == null) {
				instance2 = INSTANCE = new Orphanage(PivotConstants.ORPHANAGE_NAME, PivotConstants.ORPHANAGE_URI);
			}
			return instance2;
		}
		for (Resource aResource : resourceSet.getResources()) {
			for (EObject aContent : aResource.getContents()) {
				if (aContent instanceof Orphanage) {
					return (Orphanage) aContent;
				}
			}
		}
		Orphanage orphanage = new Orphanage(PivotConstants.ORPHANAGE_NAME, PivotConstants.ORPHANAGE_URI);
		Resource orphanageResource = new OrphanResource(ORPHANAGE_URI);
		orphanageResource.getContents().add(orphanage);
		resourceSet.getResources().add(orphanageResource);
		return orphanage;
	}

	/**
	 * Return true if asPackage is an orphanage for synthesized types.
	 */
	public static boolean isTypeOrphanage(@Nullable DomainPackage asPackage) {
		if (asPackage == null) {
			return false;
		}
		else {
			return PivotConstants.ORPHANAGE_URI.equals(asPackage.getNsURI());
		}
	}
	
	public Orphanage(@NonNull String name, @NonNull String nsURI) {
//		super(uri);
//		setLoaded(true);
		setName(name);
		setNsURI(nsURI);
	}

	public void dispose() {
		if (ownedType != null) {
			((WeakEList<?>)ownedType).dispose();
		}
	}
	
	@Override
	public @NonNull EList<Type> getOwnedType() {
		EList<Type> ownedType2 = ownedType;
		if (ownedType2 == null)
		{
			ownedType2 = ownedType = new WeakEList<Type>(/*WeakReference.class, this, PivotPackage.PACKAGE__OWNED_TYPE, PivotPackage.TYPE__PACKAGE*/);
		}
		return ownedType2;
	}
}