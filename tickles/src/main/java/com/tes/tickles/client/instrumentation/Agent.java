package com.tes.tickles.client.instrumentation;

import com.tes.tickles.client.data.Asset;
import com.tes.tickles.client.feeder.Feeder;
import com.tes.tickles.client.feeder.FeederFactory;
import com.tes.tickles.client.locator.LocatorFactory;
import org.apache.log4j.Logger;

import java.lang.instrument.Instrumentation;

public class Agent {
    final static Logger logger = Logger.getLogger(Agent.class);
    public static void premain(String agentArgs, Instrumentation inst) throws Exception {
        Feeder feeder = FeederFactory.getFeeder();
        Asset machineDetails = LocatorFactory.getLocator("machine").locate();
        feeder.feed(machineDetails);
//        Asset serviceDetails = LocatorFactory.getLocator("service").locate();
//        feeder.feed(serviceDetails);
        inst.addTransformer(new Transformer());
    }
}
