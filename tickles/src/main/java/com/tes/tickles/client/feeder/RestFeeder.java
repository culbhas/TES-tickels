package com.tes.tickles.client.feeder;

import com.tes.tickles.client.data.Data;
import org.apache.log4j.Logger;

public class RestFeeder implements Feeder{
    private static Logger logger = Logger.getLogger(RestFeeder.class);
    public boolean feed(Data data) {
        // this log will soon be replaced by restClient.call()
        logger.info(data.toString());
        return false;
    }
}
