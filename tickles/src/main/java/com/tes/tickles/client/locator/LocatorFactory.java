package com.tes.tickles.client.locator;

public class LocatorFactory {
    public static Locator getLocator(String locatorType){
        if("machine".equalsIgnoreCase(locatorType)) {
            return new MachineLocator();
        }
        else if("service".equalsIgnoreCase(locatorType)) {
            return new ServiceLocator();
        }
        return null;
    }
}
