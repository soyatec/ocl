The crontab.txt file contains the commands that must be daily executed (via cron) to promote our last successful build.

This is a release engineer task. To configure that:
1. Connect to build.eclipse.org via an ssh connection.
2. Create a "logs" folder in your home directory (if you haven't done it, yet).
3. Type "crontab -e" and copy-paste the contents of the aforementioned file.


A new milestone build may be explicitly promoted by:

logon to build.eclipse.org
ant -f /shared/jobs/buckminster-mdt-ocl-core-kepler-master/lastSuccessful/archive/publishroot/publisher.ant -Dbuild.archives=/shared/jobs/buckminster-mdt-ocl-core-kepler-master/lastSuccessful/archive &> logs/mdt-ocl-publishing-kepler.log 
or
ant -f /shared/jobs/buckminster-mdt-ocl-tools-kepler-master/lastSuccessful/archive/publishroot/publisher.ant -Dbuild.archives=/shared/jobs/buckminster-mdt-ocl-tools-kepler-master/lastSuccessful/archive &> logs/mdt-ocl-publishing-kepler.log 

A new milestone build can be added to the composite repository by:

logon to build.eclipse.org
cd downloads/modeling/mdt/ocl/updates/milestones/4.1.0/core
or
cd downloads/modeling/mdt/ocl/updates/milestones/4.1.0/tools
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=S201210020848

The Kepler aggregator is configured by GIT\org.eclipse.simrel.build\mdt-ocl.b3aggrcon to use the milestones repo
so ... ??