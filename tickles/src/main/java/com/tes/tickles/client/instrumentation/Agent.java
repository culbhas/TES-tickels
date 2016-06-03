package com.tes.tickles.client.instrumentation;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Executing premain.........");
        inst.addTransformer(new Transformer());
    }
}
