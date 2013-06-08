/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitors;

@SuppressWarnings("all")
public class GenerateXtextVisitors extends GenerateVisitors {
  public void generateVisitors(final EPackage ePackage) {
    int _length = this.superVisitorClassName.length();
    boolean _equals = (_length == 0);
    if (_equals) {
      this.generateVisitableInterface(ePackage);
      this.generateAbstractDelegatingVisitor(ePackage);
      this.generateAbstractExtendingVisitor(ePackage);
    } else {
      this.generateAbstractDelegatingVisitor(ePackage);
      this.generateAbstractExtendingVisitor(ePackage);
      this.generateAbstractExtendingDelegatingVisitor(ePackage);
    }
    this.generateVisitorInterface(ePackage);
    this.generateDecorableVisitorInterface(ePackage, "org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor");
    this.generateAbstractVisitor(ePackage);
    this.generateAbstractNullVisitor(ePackage);
  }
}
