/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.autogen.java;

/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.AutoCodeGenOptions;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAS2CGVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalysisVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoBoxingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoCG2StringVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoDependencyVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoFieldingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoReferencesVisitor;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGenModelGeneratorAdapter;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotStandaloneSetup;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * AutoCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a Auto transformation.
 */
public class AutoCodeGenerator extends JavaCodeGenerator
{
//	private static final Logger logger = Logger.getLogger(AutoCodeGenerator.class);
	
	public static void generate(@NonNull EPackage ePackage, @Nullable String superProjectPrefix) {
		PivotStandaloneSetup.doSetup();		// FIXME
		OCLstdlib.install();
		AutoCG2StringVisitor.FACTORY.getClass();
		Resource eResource = DomainUtil.nonNullState(ePackage.eResource());
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(eResource);
		org.eclipse.ocl.examples.pivot.Package asPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Package.class, ePackage);
		if (asPackage != null) {
			GenModelHelper genModelHelper = new AbstractGenModelHelper(metaModelManager);
			GenPackage genPackage = DomainUtil.nonNullState(genModelHelper.getGenPackage(asPackage));
			GenPackage superGenPackage = null;
			org.eclipse.ocl.examples.pivot.Package asSuperPackage = null;
			if (superProjectPrefix != null) {
				for (GenPackage gPackage : genPackage.getGenModel().getAllUsedGenPackagesWithClassifiers()) {
					String name = gPackage.getPrefix();
					if (name.startsWith(superProjectPrefix)) {
						superGenPackage = gPackage;
						EPackage eSuperPackage = gPackage.getEcorePackage();
						asSuperPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Package.class, eSuperPackage);
						break;
					}
				}
				if (superGenPackage == null) {
					throw new IllegalStateException("No super-GenPackage found in UsedGenPackages for " + superProjectPrefix);
				}
			}
			AutoCodeGenerator autoCodeGenerator = new AutoCodeGenerator(metaModelManager, asPackage, asSuperPackage, genPackage, superGenPackage);
			autoCodeGenerator.saveSourceFile();
		}
	}
	
	protected final @NonNull AutoAnalyzer cgAnalyzer;
	protected final @NonNull org.eclipse.ocl.examples.pivot.Package asPackage;
	protected final @Nullable org.eclipse.ocl.examples.pivot.Package asSuperPackage;
	protected final @NonNull GenModel genModel;
	protected final @NonNull GenPackage genPackage;
	protected final @Nullable GenPackage superGenPackage;
	protected final @NonNull Map<String, CGPackage> externalPackages = new HashMap<String, CGPackage>();

	public AutoCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@NonNull org.eclipse.ocl.examples.pivot.Package asPackage,
			@Nullable org.eclipse.ocl.examples.pivot.Package asSuperPackage,
			@NonNull GenPackage genPackage, @Nullable GenPackage superGenPackage) {
		super(metaModelManager);
		this.genModel = DomainUtil.nonNullState(genPackage.getGenModel());
		getOptions().setUseNullAnnotations(OCLinEcoreGenModelGeneratorAdapter.useNullAnnotations(genModel));
		cgAnalyzer = new AutoAnalyzer(this);
		this.asPackage = asPackage;
		this.asSuperPackage = asSuperPackage;
		this.genPackage = genPackage;
		this.superGenPackage = superGenPackage;
	}

	@Override
	public @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new AutoAnalysisVisitor(cgAnalyzer);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new AutoBoxingAnalyzer(cgAnalyzer);
	}

	@Override
	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new AutoCG2JavaPreVisitor(getGlobalContext());
	}

	protected @NonNull CGPackage createCGPackage() {
		String prefix = genPackage.getPrefix();
		String trimmedPrefix = prefix.endsWith("CST") ? prefix.substring(0, prefix.length()-3) : "FIXME";
		String packageName = genPackage.getBasePackage() + ".util";
		String className = prefix + "AutoContainmentVisitor";
		AS2CGVisitor as2cgVisitor = new AutoAS2CGVisitor(cgAnalyzer, getGlobalContext());
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packageName);
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		cgClass.setName(className);
		GenPackage superGenPackage2 = superGenPackage;
		if (superGenPackage2 != null) {
			String superPackageName = superGenPackage2.getBasePackage() + ".util";
			String superClassName = superGenPackage2.getPrefix() + "AutoContainmentVisitor";
			String superInterfaceName = trimmedPrefix + "CSVisitor";
			CGClass superClass = getExternalClass(superPackageName, superClassName, false);
			cgClass.getSuperTypes().add(superClass);
			CGClass superInterface = getExternalClass(packageName, superInterfaceName, true);
			superInterface.getTemplateParameters().add(getExternalClass(Continuation.class, (CGClass)null));
			cgClass.getSuperTypes().add(superInterface);
		}
		else {
			String superClassName = "Abstract" + trimmedPrefix + "CSVisitor";
			CGClass superClass = getExternalClass(packageName, superClassName, false);
			superClass.getTemplateParameters().add(getExternalClass(Continuation.class, (CGClass)null));
			superClass.getTemplateParameters().add(getExternalClass(CS2PivotConversion.class));
			cgClass.getSuperTypes().add(superClass);
		}
		cgPackage.getClasses().add(cgClass);
		for (Type asType : asPackage.getOwnedType()) {
			Operation astOperation = DomainUtil.getNamedElement(asType.getOwnedOperation(), "ast");
			if (astOperation != null) {
				CGContainmentVisit cgOperation = AutoCGModelFactory.eINSTANCE.createCGContainmentVisit();
				cgOperation.setName("visit" + asType.getName());
				cgOperation.setAst(asType);
				cgClass.getOperations().add(cgOperation);
				ConstructorExp constructorExp = (ConstructorExp) astOperation.getBodyExpression();
				for (ConstructorPart constructorPart : constructorExp.getPart()) {
					CGContainmentPart cgPart = AutoCGModelFactory.eINSTANCE.createCGContainmentPart();
	//				cgPart.setName("visit" + asType.getName());
					cgPart.setAst(constructorPart);
					cgPart.setInit((CGValuedElement) constructorPart.accept(as2cgVisitor));
					cgOperation.getParts().add(cgPart);
				}
			}
			else {
				CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGEcoreOperation();
				cgOperation.setName("visit" + asType.getName());
				cgOperation.setAst(asType);
				cgClass.getOperations().add(cgOperation);
			}
		}
		return cgPackage;
	}

	@Override
	public @NonNull DependencyVisitor createDependencyVisitor() {
		return new AutoDependencyVisitor(cgAnalyzer, getGlobalContext(),
			getGlobalPlace());
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new AutoFieldingAnalyzer(cgAnalyzer);
	}

	@Override
	protected @NonNull AutoGlobalContext createGlobalContext() {
		return new AutoGlobalContext(this);
	}

	@Override
	protected @NonNull AutoCodeGenOptions createOptions() {
		return new AutoCodeGenOptions();
	}

	@Override
	public @NonNull ReferencesVisitor createReferencesVisitor() {
		return AutoReferencesVisitor.INSTANCE;
	}

	public @NonNull String generateClassFile() {
		CGPackage cgPackage = createCGPackage();
		optimize(cgPackage);
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		AutoCG2JavaVisitor generator = new AutoCG2JavaVisitor(this, cgPackage, sortedGlobals);
		generator.safeVisit(cgPackage);
		Set<String> allImports = generator.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
	}

	public @NonNull AutoAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}

	protected @NonNull CGClass getExternalClass(@NonNull Class<?> javaClass, CGClass... javaGenerics) {
		String packageName = javaClass.getPackage().getName();
		@SuppressWarnings("null")@NonNull String className = javaClass.getSimpleName();
		CGClass externalClass = getExternalClass(packageName, className, javaClass.isInterface());
		if (javaGenerics != null) {
			for (CGClass javaGeneric : javaGenerics) {
				if (javaGeneric == null) {
					javaGeneric = getExternalClass(null, "?", true);
				}
				externalClass.getTemplateParameters().add(javaGeneric);
			}
		}
		return externalClass;
	}

	protected @NonNull CGClass getExternalClass(@Nullable String packageName, @NonNull String className, boolean isInterface) {
		CGPackage cgPackage = externalPackages.get(packageName);
		if (cgPackage == null) {
			cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
			cgPackage.setName(packageName);
			externalPackages.put(packageName, cgPackage);
		}
		CGClass cgClass = DomainUtil.getNamedElement(cgPackage.getClasses(), className);
		if (cgClass == null) {
			cgClass = CGModelFactory.eINSTANCE.createCGClass();
			cgClass.setName(className);
			cgClass.setInterface(isInterface);
			cgPackage.getClasses().add(cgClass);
		}
		return cgClass;
	}

	@Override
	public @NonNull AutoGlobalContext getGlobalContext() {
		return (AutoGlobalContext) super.getGlobalContext();
	}

	@Override
	public @NonNull AutoCodeGenOptions getOptions() {
		return (AutoCodeGenOptions) super.getOptions();
	}

	public @NonNull String getQualifiedName() {
		String className = DomainUtil.nonNullState(asPackage.getName());
		String packagePrefix = getOptions().getPackagePrefix();
		if (packagePrefix != null) {
			return packagePrefix + "." + className;
		} else {
			return className;
		}
	}

	public void saveSourceFile() {
		String utilDir = genModel.getModelDirectory() + "/" + genPackage.getBasePackage().replace('.', '/') +"/util/" + genPackage.getPrefix() + "AutoContainmentVisitor.java";
		URI uri = URI.createPlatformResourceURI(utilDir, true);
		String javaCodeSource = generateClassFile();
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(uri);
			Writer writer = new OutputStreamWriter(outputStream);
			writer.append(javaCodeSource);
			writer.close();
			outputStream.close();
		} catch (IOException e) {
			throw new IllegalStateException("Failed to save '" + uri + "'");
		}
	}
}
