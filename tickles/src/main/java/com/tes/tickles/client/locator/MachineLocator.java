package com.tes.tickles.client.locator;

import com.tes.tickles.client.data.Asset;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class MachineLocator implements Locator {
    public Asset locate() throws Exception {
        InetAddress ip;
        ip = InetAddress.getLocalHost();
        String name = ip.getHostName();

        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("ip", ip.getHostAddress());
        attributes.put("os", System.getProperty("os.name"));
        attributes.put("osType", System.getProperty("os.arch"));
        attributes.put("osVersion", System.getProperty("osVersion"));
        attributes.put("PROCESSOR_IDENTIFIER", System.getenv("PROCESSOR_IDENTIFIER"));
        attributes.put("PROCESSOR_ARCHITECTURE", System.getenv("PROCESSOR_ARCHITECTURE"));
        attributes.put("PROCESSOR_ARCHITEW6432", System.getenv("PROCESSOR_ARCHITEW6432"));
        attributes.put("NUMBER_OF_PROCESSORS", System.getenv("NUMBER_OF_PROCESSORS"));

        attributes.put("processorsCount", String.valueOf(Runtime.getRuntime().availableProcessors()));
        attributes.put("freeMemoryInBytes", String.valueOf(Runtime.getRuntime().freeMemory()));
        long maxMemory = Runtime.getRuntime().maxMemory();
        attributes.put("maxMemoryInBytes", String.valueOf(maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        Asset machine = new Asset();
        machine.setName(name);
        machine.setAttributes(attributes);

        return machine;
    }
}
