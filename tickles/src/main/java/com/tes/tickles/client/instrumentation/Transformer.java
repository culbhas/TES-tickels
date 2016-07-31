package com.tes.tickles.client.instrumentation;

import com.tes.tickles.client.data.Asset;
import com.tes.tickles.client.locator.LocatorFactory;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Transformer implements ClassFileTransformer {
    final static Logger logger = Logger.getLogger(Transformer.class);
    public byte[] transform(ClassLoader loader, String className,
                            Class classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] byteCode = classfileBuffer;

        if (className.equals("com/tes/tickles/utils/Utility")) {
            try {
                ClassPool classPool = ClassPool.getDefault();
                CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(
                        classfileBuffer));
                CtMethod[] methods = ctClass.getDeclaredMethods();
                for (CtMethod method : methods) {
                    method.addLocalVariable("startTime", CtClass.longType);
                    method.insertBefore("startTime = System.nanoTime();");
                    method.insertAfter("com.tes.tickles.client.data.Data data = new com.tes.tickles.client.data.Data();" +
                            "com.tes.tickles.client.data.Asset machineDetails = com.tes.tickles.client.locator.LocatorFactory.getLocator(\"machine\").locate();"+
                            "data.addKeyPart(machineDetails.getName());" +
                            "data.addKeyPart(\""+ctClass.getName()+"\");"+
                            "data.addKeyPart(\""+method.getName()+"\");"+
                            "data.setValue(String.valueOf((System.nanoTime() - startTime)));" +
                            "com.tes.tickles.client.feeder.FeederFactory.getFeeder().feed(data);");
                }
                byteCode = ctClass.toBytecode();
                ctClass.detach();
            } catch (Throwable ex) {
                logger.info("Exception: " + ex);
                ex.printStackTrace();
            }
        }
        return byteCode;
    }
}
