package com.tes.tickles.client.locator;

public class LocatorFactory {
    private static MachineLocator machineLocator;
    private static ServiceLocator serviceLocator;
    public static Locator getLocator(String locatorType){
        if("machine".equalsIgnoreCase(locatorType)) {
            if(machineLocator == null) {
                machineLocator = new MachineLocator();
            }
            return machineLocator;
        }
        else if("service".equalsIgnoreCase(locatorType)) {
            if(serviceLocator == null){
                serviceLocator = new ServiceLocator();
            }
            return serviceLocator;
        }
        return null;
    }
}
