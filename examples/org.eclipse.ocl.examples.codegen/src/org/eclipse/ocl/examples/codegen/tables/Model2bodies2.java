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
 *
 * $Id$
 */
package org.eclipse.ocl.examples.codegen.tables;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.expression.OCLinEcore2JavaClass;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class Model2bodies2 //implements CodeGenHelper
{
	protected final @NonNull GenModel model;
	protected final @NonNull File targetFolder;
	protected final @NonNull MetaModelManager metaModelManager;

    public Model2bodies2(@NonNull GenModel model, @NonNull File targetFolder) throws IOException {
    	this.model = model;
    	this.targetFolder = targetFolder;
    	MetaModelManager findMetaModelManager = PivotUtil.findMetaModelManager(model);
    	assert findMetaModelManager != null;
		this.metaModelManager = findMetaModelManager; 
    }

	public void generate(Monitor monitor) {
		for (GenPackage genPackage : model.getGenPackages()) {
			EPackage ePackage = genPackage.getEcorePackage();
			@SuppressWarnings("null")@NonNull String packageName = ePackage.getName();
			for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
				EClassifier eClassifier = DomainUtil.nonNullModel(genClassifier.getEcoreClassifier());
//				@SuppressWarnings("null")@NonNull String className = eClassifier.getName();
//				String qualifiedName = packageName + "." + className;

				
				org.eclipse.ocl.examples.pivot.Class pivotClass = DomainUtil.nonNullState(metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Class.class, eClassifier));
				if (hasConstraints(pivotClass)) {
					OCLinEcore2JavaClass oclInEcore2Class = new OCLinEcore2JavaClass(metaModelManager, eClassifier);
					String className = eClassifier.getName() + "Bodies";
					CodeGenSnippet rootSnippet = oclInEcore2Class.generateClassFile(genClassifier, className, pivotClass);
					LinkedHashMap<CodeGenText, String> flatContents = rootSnippet.flatten();
					StringBuilder s = new StringBuilder();
					for (Map.Entry<CodeGenText, String> entry : flatContents.entrySet()) {
						@SuppressWarnings("null")@NonNull String value = entry.getValue();
						entry.getKey().toString(s, value);
					}
					String javaCodeSource = s.toString();
					File folder = new File(targetFolder, packageName.replace('.', '/'));
					folder.mkdirs();
					File file = new File(folder, className + ".java");
					try {
						Writer writer = new FileWriter(file);
						writer.append(javaCodeSource);
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
			}
		}	
	}
	
	public boolean hasConstraints(org.eclipse.ocl.examples.pivot.Class pivotClass) {
		if (pivotClass.getOwnedRule().size() > 0) {
			return true;
		}
		for (Operation operation : PivotQueries.getOperations(pivotClass)) {
			if (operation.getOwnedRule().size() > 0) {
				return true;
			}
		}
		for (Property property : PivotQueries.getProperties(pivotClass)) {
			if (property.getOwnedRule().size() > 0) {
				return true;
			}
		}
		return false;
	}
}
