package com.tes.tickles.client.feeder;

import com.tes.tickles.client.data.Asset;
import com.tes.tickles.client.data.Data;
import com.tes.tickles.utils.Config;
import com.tes.tickles.utils.RestClient;
import org.apache.log4j.Logger;

public class RestFeeder implements Feeder{
    private static Logger logger = Logger.getLogger(RestFeeder.class);
    private RestClient restClient = new RestClient();
    public boolean feed(Object data) throws Exception {
        String restStatUrl = null;
        if(data instanceof Data) {
           restStatUrl = Config.getProperty(Config.TES_TICKLES_SERVER_STAT_URL);
        }else if (data instanceof Asset){
            restStatUrl = Config.getProperty(Config.TES_TICKLES_SERVER_ASSET_URL);
        }
        logger.info("Posting data :" + data.toString() + " to " + restStatUrl);
        return restClient.post(restStatUrl, data);
    }
}
