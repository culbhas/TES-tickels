package com.tes.tickles.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String TICKLES_SERVER_PROPERTIES = "tickles-server.properties";
    public static final String TES_TICKLES_SERVER_STAT_URL = "tes.tickles.server.stats.url";
    public static final String TES_TICKLES_SERVER_TYPE = "tes.tickles.server.type";
    private static Properties configProps;

    public static void loadConfig() throws IOException {
        String resourceName = TICKLES_SERVER_PROPERTIES;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        configProps = new Properties();
        InputStream resourceStream = loader.getResourceAsStream(resourceName);
        configProps.load(resourceStream);
    }
    public static String getProperty(String propertyName) throws IOException {
        if(configProps == null) {
            loadConfig();
        }
        return configProps.getProperty(propertyName);
    }
}
