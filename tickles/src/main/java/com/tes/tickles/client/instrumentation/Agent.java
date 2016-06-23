package com.tes.tickles.client.instrumentation;

import org.apache.log4j.Logger;

import java.lang.instrument.Instrumentation;

public class Agent {
    final static Logger logger = Logger.getLogger(Agent.class);
    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new Transformer());
    }
}
