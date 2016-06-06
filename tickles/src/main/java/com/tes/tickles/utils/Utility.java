package com.tes.tickles.utils;

import org.apache.log4j.Logger;

public class Utility {
    final static Logger logger = Logger.getLogger(Utility.class);
    public void sleeping() throws InterruptedException {
        logger.info("going to sleep........");
        Thread.sleep(2000L);
    }
}
