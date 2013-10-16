package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2ASRuntimeModule;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuations;
import org.eclipse.ocl.examples.xtext.base.cs2as.ICS2ASFactory;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;


public class CompleteOCLCS2ASRuntimeModule extends BaseCS2ASRuntimeModule {
		 
//	public Class<? extends ICS2ASFactory> bindICS2ASFactory() {
//		return CompleteOCLCS2ASFactory.class;
//	}
	
	@Override
	public void configureFactory(Binder binder) {
		
		binder.install(new FactoryModuleBuilder()
				.implement(Continuations.class, Continuations.class)
//				.implement(BaseCSVisitor.class, Names.named("ContainmentVisitor"), CompleteOCLCSContainmentVisitor.class)
				.implement(new TypeLiteral<BaseCSVisitor<? extends Continuation<?>>>() {}, Names.named("PreOrderVisitor"), CompleteOCLCSPreOrderVisitor.class)
				
//				.implement(BaseCSVisitor.class, Names.named("PostOrderVisitor"), CompleteOCLCSPostOrderVisitor.class)
//				.implement(BaseCSVisitor.class, Names.named("Left2RightVisitor"), CompleteOCLCSLeft2RightVisitor.class)
				.build(ICS2ASFactory.class));
	}
}