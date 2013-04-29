package org.eclipse.ocl.examples.codegen.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

public class UnboxedOppositeNavigationProperty extends AbstractProperty
{
	protected @NonNull PropertyId oppositePropertyId;
	
	public UnboxedOppositeNavigationProperty(@NonNull PropertyId oppositePropertyId) {
		this.oppositePropertyId = oppositePropertyId;
	}
	
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		IdResolver idResolver = evaluator.getIdResolver();
		DomainProperty oppositeProperty = idResolver.getProperty(oppositePropertyId);		
		DomainModelManager modelManager = evaluator.getModelManager();
		DomainType thatType = DomainUtil.nonNullModel(oppositeProperty.getType());
		if (thatType instanceof DomainCollectionType) {
			thatType = ((DomainCollectionType)thatType).getElementType();
		}
		List<Object> results = new ArrayList<Object>();
		if (thatType != null) {
			for (EObject eObject : modelManager.get(thatType)) {	// FIXME Use a cache
				EClass eClass = eObject.eClass();
				EStructuralFeature eFeature = eClass.getEStructuralFeature(oppositeProperty.getName());
				Object eGet = eObject.eGet(eFeature);
				if (eGet == sourceValue) {
					results.add(eObject);
				}
			}
		}
		return results;
	}
}
