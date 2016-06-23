package com.tes.tickles.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String TICKLES_SERVER_PROPERTIES = "tickles-server.properties";
    public static final String TES_TICKLES_SERVER_TYPE = "tes.tickles.server.type";
    private Properties configProps;
    public Config() throws IOException {
        loadConfig();
    }

    public void loadConfig() throws IOException {
        String resourceName = TICKLES_SERVER_PROPERTIES;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        configProps = new Properties();
        InputStream resourceStream = loader.getResourceAsStream(resourceName);
        configProps.load(resourceStream);
    }
    public String getProperty(String propertyName) throws IOException {
        if(configProps == null) {
            loadConfig();
        }
        return configProps.getProperty(propertyName);
    }
}
