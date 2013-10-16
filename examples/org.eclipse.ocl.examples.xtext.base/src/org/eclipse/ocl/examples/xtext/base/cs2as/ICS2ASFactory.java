package org.eclipse.ocl.examples.xtext.base.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;

import com.google.inject.name.Named;




/**
 * The CS2AS framework classes Factory
 * 
 * @author asbh
 */
public interface ICS2ASFactory {

	
	// PivotDependency createPivotDependency(PivotableElementCS pivotableCSElement);
	
	// PreVisitor 
	Continuations createContinuations();

	
	
	// **** CS2PivotConversion visitors ****
//	@NonNull @Named("ContainmentVisitor") BaseCSVisitor<Continuation<?>> createContainmentVisitor(CS2PivotConversion conversion);
	@NonNull @Named("PreOrderVisitor") BaseCSVisitor<Continuation<?>> createPreOrderVisitor(CS2PivotConversion conversion);
//	@NonNull @Named("PostOrderVisitor") BaseCSVisitor<Continuation<?>> createPostOrderVisitor(CS2PivotConversion conversion);
//	@NonNull @Named("Left2RightVisitor") BaseCSVisitor<Element> createLeft2RightVisitor(CS2PivotConversion conversion);
	
}
