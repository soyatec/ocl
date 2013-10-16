package org.eclipse.ocl.examples.xtext.base.cs2as;

import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;


/**
 * Google Guice runtime module to define the bindings for the CS2AS framework
 * 
 * @author asbh
 */
public abstract class BaseCS2ASRuntimeModule extends AbstractGenericModule{

//	public Class<? extends Continuations> bindContinuations() {
//		return Continuations.class;
//	}
	
	
	public void configureFactory(Binder binder) {
		
		binder.install(new FactoryModuleBuilder()
				.implement(Continuations.class, Continuations.class)
//				.implement(BaseCSVisitor.class, Names.named("ContainmentVisitor"), BaseCSContainmentVisitor.class)
				.implement(BaseCSVisitor.class, Names.named("PreOrderVisitor"), BaseCSPreOrderVisitor.class)
//				.implement(BaseCSVisitor.class, Names.named("PostOrderVisitor"), BaseCSPostOrderVisitor.class)
//				.implement(BaseCSVisitor.class, Names.named("Left2RightVisitor"), BaseCSLeft2RightVisitor.class)				
				.build(ICS2ASFactory.class));
	}
}
