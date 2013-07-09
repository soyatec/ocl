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
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - bug397429
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitors;

@SuppressWarnings("all")
public class GeneratePivotVisitors extends GenerateVisitors {
  public void generateVisitors(final EPackage ePackage) {
    String _superVisitorClassName = this.getSuperVisitorClassName();
    boolean _equals = Objects.equal(_superVisitorClassName, null);
    if (_equals) {
      this.generateVisitableInterface(ePackage);
      this.generateAbstractDelegatingVisitor(ePackage);
      this.generateAbstractExtendingVisitor(ePackage);
    } else {
      this.generateAbstractDelegatingVisitor(ePackage);
      this.generateAbstractExtendingVisitor(ePackage);
    }
    this.generateVisitorInterface(ePackage);
    this.generateAbstractVisitor(ePackage);
    this.generateAbstractNullVisitor(ePackage);
  }
}
