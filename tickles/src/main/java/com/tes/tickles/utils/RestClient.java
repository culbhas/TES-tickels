package com.tes.tickles.utils;

import com.tes.tickles.client.data.Data;
import com.tes.tickles.client.feeder.RestFeeder;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {
    private static Logger logger = Logger.getLogger(RestClient.class);
    public boolean post(String restUrl, Object data) throws Exception {
        URL url = new URL(restUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        String requestBody = new ObjectMapper().writeValueAsString(data);

        OutputStream os = conn.getOutputStream();
        os.write(requestBody.getBytes());
        os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            logger.error("Response code: " + conn.getResponseCode());
            logger.error("Error :" + conn.getErrorStream());
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        logger.info("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            logger.info(output);
        }
        conn.disconnect();
        return true;
    }
}
