package org.eclipse.ocl.examples.xtext.oclinecore.cs2as;

import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuations;
import org.eclipse.ocl.examples.xtext.base.cs2as.ICS2ASFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2ASRuntimeModule;

import com.google.inject.Binder;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import com.google.inject.TypeLiteral;


public class OCLinEcoreCS2ASRuntimeModule extends EssentialOCLCS2ASRuntimeModule {

//	public Class<? extends ICS2ASFactory> bindICS2ASFactory() {
//		return OCLinEcoreCS2ASFactory.class;
//	}
	
	@Override
	public void configureFactory(Binder binder) {
		
		binder.install(new FactoryModuleBuilder()
				.implement(Continuations.class, Continuations.class)
//				.implement(BaseCSVisitor.class, Names.named("ContainmentVisitor"), OCLinEcoreCSContainmentVisitor.class)
				.implement(new TypeLiteral<BaseCSVisitor<? extends Continuation<?>>>() {}, Names.named("PreOrderVisitor"), OCLinEcoreCSPreOrderVisitor.class)
//				.implement(BaseCSVisitor.class, Names.named("PostOrderVisitor"), OCLinEcoreCSPostOrderVisitor.class)
//				.implement(BaseCSVisitor.class, Names.named("Left2RightVisitor"), OCLinEcoreCSLeft2RightVisitor.class)				
				.build(ICS2ASFactory.class));
	}
}