package org.eclipse.ocl.examples.pivot.tests;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.dynamic.XtendGenModelCodeGenHelper;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class XtendCG extends PivotTestSuite
{    
	@Override
	protected Object evaluate(ExpressionInOCL expr, Object self) throws Exception {
		ProjectMap projectMap = getProjectMap();
		projectMap.initializeResourceSet(resourceSet);
		resourceSet.getPackageRegistry().put(org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);

		CodeGenHelper genModelHelper = getCodeGenHelper(metaModelManager);

		File targetFolder = new File("src-gen");
		targetFolder.mkdir();
		String packageName = getTestPackageName();			// FIXME need to create this
		String className = "TestClass" + testCounter++;
		File dir = new File(targetFolder, packageName);
		dir.mkdir();
		LibraryOperation testInstance = genModelHelper.loadClass(expr, targetFolder, packageName, className, true);
		DomainEvaluator evaluator = new EcoreExecutorManager(metaModelManager.getOclAnyType(), PivotTables.LIBRARY);
		OperationCallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();
		callExp.setType(expr.getType());
		Object result = testInstance.evaluate(evaluator, callExp, self);
		return result;
	}

	@Override
	public CodeGenHelper getCodeGenHelper(@NonNull MetaModelManager metaModelManager) throws IOException {
		URI genModelURI = URI.createPlatformResourceURI(
				"/org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel",
				true);
//		ResourceSet resourceSet = getResourceSet();
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		String errorsString = PivotUtil.formatResourceDiagnostics(
				genModelResource.getErrors(), "Loading " + genModelURI, "\n");
		if (errorsString != null) {
			// issues.addError(this, errorsString, null, null, null);
			return null;
		}
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		return new XtendGenModelCodeGenHelper(genModel, metaModelManager);
	}

	public void testXtendCG() {
		assertQueryEquals(getMetaclass("String"), "t", "'test'.substring(1, 1)");

//		ExpressionInOCL2Class expressionInOCL2Class = new ExpressionInOCL2Class(null);
//		String s = expressionInOCL2Class.generateClass(null, "p", "C");
//		System.out.println(s);
	}
}
