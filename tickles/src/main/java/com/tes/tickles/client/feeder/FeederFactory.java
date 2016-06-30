package com.tes.tickles.client.feeder;

import com.tes.tickles.utils.Config;

import java.io.IOException;

public class FeederFactory {

    public static Feeder getFeeder() throws IOException {
        Feeder feeder = null;
        if("rest".equals(Config.getProperty(Config.TES_TICKLES_SERVER_TYPE))){
            feeder = new RestFeeder();
        }
        return feeder;
    }

}
