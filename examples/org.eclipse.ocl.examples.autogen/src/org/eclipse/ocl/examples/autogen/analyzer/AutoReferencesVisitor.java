package org.eclipse.ocl.examples.autogen.analyzer;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;

/**
 * The ReferencesVisitor compute a list of objects referenced by (but not contained by or containing) the visited object
 * that contribute to that objects identity. The computed list may contain null elements to ensure that the returned lists
 * by two different objects exhibit positioanl equivalence.
 */
public class AutoReferencesVisitor extends ReferencesVisitor implements AutoCGModelVisitor<List<Object>>
{
	public static final @NonNull AutoReferencesVisitor INSTANCE = new AutoReferencesVisitor(new Object());
	
	protected AutoReferencesVisitor(@NonNull Object context) {
		super(context);
	}

	public @Nullable List<Object> visitCGASTCallExp(@NonNull CGASTCallExp object) {
		return visitCGOperationCallExp(object);
	}

	public @Nullable List<Object> visitCGContainmentBody(@NonNull CGContainmentBody object) {
		return visitCGValuedElement(object);
	}

	public @Nullable List<Object> visitCGContainmentPart(@NonNull CGContainmentPart object) {
		return visitCGValuedElement(object);
	}

	public @Nullable List<Object> visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		return visitCGOperation(object);
	}
}