package com.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class serviceHandler {

    public void urlHandler(serviceData nextBusUrl)
    {
        try {
            URL url = new URL(nextBusUrl.getUrlRequest());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder sb=new StringBuilder("");
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                sb.append(output+'\n');
            }
             nextBusUrl.setUrlResponse(sb.toString());
             conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        serviceHandler sh= new serviceHandler();
        serviceData sd= new serviceData();
        sd.setUrlRequest("http://webservices.nextbus.com/service/publicXMLFeed?command=agencyList");
        sh.urlHandler(sd);

        System.out.println(sd.getUrlResponse());

    }
}
