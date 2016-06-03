step to run very first test of instrumentation
1. To create instrumentation jar :
   -> gradle instrumentationJar
   this would create '{project.base}/build/lib/tickles.instrumentation.jar'
2. Run Agent.java as java application with below VM option
   -javaagent:build/libs/tickles.instrumentation-1.0-SNAPSHOT.jar