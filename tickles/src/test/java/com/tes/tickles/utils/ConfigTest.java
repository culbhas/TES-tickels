package com.tes.tickles.utils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.tes.tickles.utils.Config.TICKLES_SERVER_PROPERTIES;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ConfigTest {
    private Config config;

    @Before
    public void setUp() throws IOException {
        config =  new Config();
    }

    @Test
    public void loadConfig() throws Exception {
        String resourceName = TICKLES_SERVER_PROPERTIES;
        ClassLoader mockClassLoader = mock(ClassLoader.class);
        InputStream mockStream = mock(InputStream.class);
        Thread.currentThread().setContextClassLoader(mockClassLoader);

        when(mockClassLoader.getResourceAsStream(resourceName)).thenReturn(mockStream);
        config.loadConfig();
    }
    @Test
    public void getProperty() throws Exception {

    }

}