package com.proxy;

import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class testServiceHandler {

    static serviceHandler sh;
    static serviceData sd;


    @BeforeClass
    public static void setUp() {
        sh= new serviceHandler();
        sd= new serviceData();

    }

    private String getResponseOutput(String fileName) {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Test
    public void testServiceHandler() {
        sd.setUrlRequest("http://webservices.nextbus.com/service/publicXMLFeed?command=agencyList");
        sh.urlHandler(sd);
        String output =sd.getUrlResponse();
        String expected= getResponseOutput("httpoutput.txt");
        assertEquals(expected, output);
    }
}
