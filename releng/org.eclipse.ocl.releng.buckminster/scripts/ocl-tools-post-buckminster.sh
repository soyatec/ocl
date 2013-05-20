#*******************************************************************************
# Copyright (c) 2013 E.D.Willink and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#*******************************************************************************
#!/bin/bash

mv buildroot/buckminster.output/org.eclipse.ocl.releng.tools.build_*-eclipse.feature/site.p2 MDT-OCL.p2.repository
mv buildroot/buckminster.output/org.eclipse.ocl.releng.tools.build_*-eclipse.feature/zips MDT-OCL.downloads

if [ ${MANAGE_JAVADOC} = "true" ]
then
  mkdir MDT-OCL.javadoc
  mv buildroot/buckminster.output/org.eclipse.ocl.releng.buckminster_*-buckminster/javadoc/MDT-OCL-javadoc.zip MDT-OCL.javadoc/MDT-OCL-javadoc.zip
  rm -rf buildroot/buckminster.output/org.eclipse.ocl.releng.buckminster_*-buckminster/javadoc
fi
