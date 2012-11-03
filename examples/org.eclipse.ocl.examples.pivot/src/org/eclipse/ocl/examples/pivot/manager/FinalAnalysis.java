/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.pivot.Type;

public class FinalAnalysis
{
	private Map<DomainInheritance, Set<DomainInheritance>> type2subTypes = new HashMap<DomainInheritance, Set<DomainInheritance>>();
	private Map<DomainOperation, Set<DomainOperation>> operation2overrides = new HashMap<DomainOperation, Set<DomainOperation>>();

	public FinalAnalysis(PackageManager packageManager) {
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		for (PackageServer packageServer :  packageManager.getAllPackages()) {
			for (TypeServer typeServer :  packageServer.getMemberTypes()) {
				Type subType = typeServer.getPivotType();
				DomainInheritance subInheritance = subType.getInheritance(metaModelManager);
				for (DomainInheritance superType : typeServer.getAllSuperClasses()) {
					Set<DomainInheritance> subInheritances = type2subTypes.get(superType);
					if (subInheritances == null) {
						subInheritances = new HashSet<DomainInheritance>();
						type2subTypes.put(superType, subInheritances);
					}
					subInheritances.add(subInheritance);
				}
			}
		}
		for (DomainInheritance domainInheritance : type2subTypes.keySet()) {
			Set<DomainInheritance> subInheritances = type2subTypes.get(domainInheritance);
			for (DomainOperation domainOperation : domainInheritance.getLocalOperations()) {
				String opName = domainOperation.getName();
				DomainParameterTypes parameterTypes = domainOperation.getParameterTypes();
				LibraryFeature domainImplementation = domainOperation.getImplementation();
				Set<DomainOperation> overrides = null;
				for (DomainInheritance subInheritance : subInheritances) {
					if (subInheritance != domainInheritance) {
						for (DomainOperation subOperation : subInheritance.getLocalOperations()) {
							if (opName.equals(subOperation.getName()) && parameterTypes.equals(subOperation.getParameterTypes())) {
								LibraryFeature subImplementation = subOperation.getImplementation();
								if (domainImplementation != subImplementation) {
									if (overrides == null) {
										overrides = new HashSet<DomainOperation>();
									}
									overrides.add(subOperation);
								}
							}
						}
					}
				}
				operation2overrides.put(domainOperation, overrides);
			}
		}
//		StringBuilder s = new StringBuilder();
//		print(s);
//		System.out.println(s);
	}
	
	public boolean isFinal(DomainInheritance domainInheritance) {
		Set<DomainInheritance> subInheritances = type2subTypes.get(domainInheritance);
		return subInheritances.size() <= 1;
	}
	
	public boolean isFinal(DomainOperation operation) {
		Set<DomainOperation> overrides = operation2overrides.get(operation);
		return overrides == null;
	}
	
	public void print(StringBuilder s) {
		List<DomainInheritance> allInheritances = new ArrayList<DomainInheritance>(type2subTypes.keySet());
		Collections.sort(allInheritances, new Comparator<DomainInheritance>()
		{
			public int compare(DomainInheritance o1, DomainInheritance o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		s.append("Final types");
		for (DomainInheritance anInheritance : allInheritances) {
			if (isFinal(anInheritance)) {
				s.append("\n\t");
				s.append(anInheritance.getName());
			}
		}
		s.append("\nNon-final types");
		for (DomainInheritance anInheritance : allInheritances) {
			if (!isFinal(anInheritance)) {
				s.append("\n\t");
				s.append(anInheritance.getName());
			}
		}	
	}

}
