/**
 * <copyright>
 * 
 * Copyright (c) 2012,2013 CEA LIST and others.
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
package org.eclipse.ocl.examples.codegen.cse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * A ControlPlace is associated with a location in the CG AST such as the then or else (but not condition) ig a CGIfExp
 * at which child nodes cannot be hoisted without violating control dependencies.
 */
public class ControlPlace extends LocalPlace
{
	public static @NonNull AbstractPlace createControlPlace(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGValuedElement cgElement) {
		if (cgElement.isGlobal()) {
			return DomainUtil.nonNullState(element2place.get(null));
		}
		CGElement cgParent = cgElement.getParent();
		AbstractPlace parentPlace = element2place.get(cgParent);
		if (parentPlace instanceof ControlPlace) {
			return parentPlace;
		}
		else {
			return new ControlPlace(getLocalPlace(element2place, cgParent), cgElement);
		}
	}

	public static @NonNull ControlPlace getControlPlace(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGValuedElement cgElement) {
		AbstractPlace place = element2place.get(cgElement);
		if (place instanceof ControlPlace) {
			return (ControlPlace) place;
		}
		else if (place != null) {
			throw new IllegalStateException("Non-ControlPlace " + place.getClass().getName() + " for " + cgElement);
		}
		else {
			ControlPlace controlPlace;
			CGElement cgParent = cgElement.getParent();
			AbstractPlace parentPlace = element2place.get(cgParent);
			if (parentPlace instanceof ControlPlace) {
				controlPlace = (ControlPlace) parentPlace;
			}
			else {
				controlPlace = new ControlPlace(getLocalPlace(element2place, cgParent), cgElement);
			}
			element2place.put(cgElement, controlPlace);
			return controlPlace;
		}
	}

	protected final @NonNull LocalPlace parentPlace;
	protected final @NonNull CGValuedElement placedElement;
	private /*@LazyNonNull*/ SimpleAnalysis controlAnalysis = null;
	protected final @NonNull HashedAnalyses hashedAnalyses = new HashedAnalyses();

	public ControlPlace(@NonNull LocalPlace parentPlace, @NonNull CGValuedElement cgElement) {
		super(parentPlace.getGlobalPlace());
		this.parentPlace = parentPlace;
		this.placedElement = cgElement;
		parentPlace.addControlPlace(this);
	}

	public void addAnalysis(@NonNull AbstractAnalysis anAnalysis) {
		hashedAnalyses.add(anAnalysis);
	}

	public int getDepth() {
		return controlAnalysis.getDepth();
	}

	public @NonNull HashedAnalyses getHashedAnalyses() {
		return hashedAnalyses;
	}
	
	@Override
	public @NonNull LocalPlace getParentPlace() {
		return parentPlace;
	}

	public @NonNull SimpleAnalysis getSimpleAnalysis() {
		SimpleAnalysis controlAnalysis2 = controlAnalysis;
		if (controlAnalysis2 == null) {
//			System.out.println(DomainUtil.debugSimpleName(placedElement));
			controlAnalysis2 = globalPlace.getSimpleAnalysis(placedElement);
			assert controlAnalysis2 != null;
			controlAnalysis = controlAnalysis2;
		}
		return controlAnalysis2;
	}

	@Override
	public @NonNull StackPlace getStackPlace() {
		return parentPlace.getStackPlace();
	}
	
	@Override
	public void printHierarchy(@NonNull Appendable appendable, @NonNull String indentation) {
		TracingOption.println(appendable, indentation + this);
		if (!hashedAnalyses.isEmpty()) {
			for (AbstractAnalysis analysis : hashedAnalyses) {
				TracingOption.println(appendable, indentation + "    " + analysis.getStructuralHashCode() + "," + analysis);
			}
		}
		else {
			TracingOption.println(appendable, indentation + "    <empty>");
		}
		super.printHierarchy(appendable, indentation + "  ");
	}

	/**
	 * Filter the element analyses to discard non-SharedAnalysis and to return a partitioning of the results by minimum depth.
	 */
	@Override
	public void prune() {
		if (!hashedAnalyses.isEmpty()) {
			List<AbstractAnalysis> removals = null;
			@SuppressWarnings("null")@NonNull Multimap<Integer, CommonAnalysis> depth2commonAnalyses = HashMultimap.create();
			for (AbstractAnalysis analysis : hashedAnalyses) {
				if (analysis instanceof CommonAnalysis) {
					CommonAnalysis commonAnalysis = (CommonAnalysis)analysis;
					int depth = commonAnalysis.getMinDepth();
					depth2commonAnalyses.put(depth, commonAnalysis);
				}
				else {
					if (removals == null) {
						removals = new ArrayList<AbstractAnalysis>();
					}
					removals.add(analysis);
				}
			}
			if (removals != null) {
				for (@SuppressWarnings("null")@NonNull AbstractAnalysis removal : removals) {
					hashedAnalyses.remove(removal);
				}
			}
		}
	}

	@Override
	public void pullUp() {
		List<AbstractAnalysis> removals = null;
		for (@SuppressWarnings("null")@NonNull AbstractAnalysis analysis : hashedAnalyses) {
			for (AbstractPlace localPlace = this; !((localPlace = localPlace.getParentPlace()) instanceof GlobalPlace); ) {
				if (localPlace instanceof ControlPlace) {
					ControlPlace controlPlace = (ControlPlace) localPlace;
					HashedAnalyses controlAnalyses = controlPlace.getHashedAnalyses();
					AbstractAnalysis parentAnalysis = controlAnalyses.get(analysis);
					if (parentAnalysis != null) {
						controlPlace.addAnalysis(analysis);
						if (removals == null) {
							removals = new ArrayList<AbstractAnalysis>();
						}
						removals.add(analysis);
						break;
					}
				}
			}
		}
		if (removals != null) {
			for (@SuppressWarnings("null")@NonNull AbstractAnalysis removal : removals) {
				hashedAnalyses.remove(removal);
			}
		}
		super.pullUp();
	}

	@Override
	public void rewrite() {
		super.rewrite();
		CodeGenAnalyzer analyzer = globalPlace.getAnalyzer();
		if (!hashedAnalyses.isEmpty()) {
			Map<CGValuedElement, AbstractAnalysis> locals = new HashMap<CGValuedElement, AbstractAnalysis>();
			for (AbstractAnalysis analysis : hashedAnalyses) {
				locals.put(analysis.getPrimaryElement(), analysis);
			}
			DependencyVisitor dependencyVisitor = analyzer.getCodeGenerator().createDependencyVisitor();
			HashSet<CGValuedElement> allElements = new HashSet<CGValuedElement>(locals.keySet());
			dependencyVisitor.visitAll(allElements);
			List<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies(false);
			for (CGValuedElement primaryElement : sortedDependencies) {
				AbstractAnalysis abstractAnalysis = locals.get(primaryElement);
				if (abstractAnalysis instanceof CommonAnalysis) {
					((CommonAnalysis)abstractAnalysis).rewrite(analyzer, placedElement);
				}
			}
 		}
	}

	@Override
	public String toString() {
		SimpleAnalysis controlAnalysis2 = controlAnalysis;
		if (controlAnalysis2 == null) {
//			System.out.println(DomainUtil.debugSimpleName(placedElement));
			controlAnalysis2 = globalPlace.getSimpleAnalysis(placedElement);
		}
		return getClass().getSimpleName() + ": " + String.valueOf(controlAnalysis2);
	}
}