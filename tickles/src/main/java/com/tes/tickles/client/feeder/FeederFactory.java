package com.tes.tickles.client.feeder;

import com.tes.tickles.utils.Config;

import java.io.IOException;

public class FeederFactory {
    private static Config config;

    public static Feeder getFeeder() throws IOException {
        config = new Config();
        Feeder feeder = null;
        if("rest".equals(config.getProperty(Config.TES_TICKLES_SERVER_TYPE))){
            feeder = new RestFeeder();
        }
        return feeder;
    }

}
