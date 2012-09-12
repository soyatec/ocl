package org.eclipse.ocl.examples.domain.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInvalidType;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.domain.typeids.Typeid;

public class InvalidTypeImpl extends AbstractType implements DomainInvalidType
{
	protected final @NonNull String message;

	public InvalidTypeImpl(@NonNull DomainStandardLibrary standardLibrary, @NonNull String message) {
		super(standardLibrary, "Invalid");
		this.message = message;
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType) {
		return false;
	}

	@Override
	public @NonNull DomainType getCommonType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return this;
	}	

	public @NonNull Typeid getTypeid() {
		return Typeid.OCL_INVALID;
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType) {
		return false;
	}

	@Override
	public boolean isInvalid() {
		return true;
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation staticOperation) {
		return UnsupportedOperation.INSTANCE;
	}
}
