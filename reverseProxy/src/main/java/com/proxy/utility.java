package com.proxy;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.InetAddress;

public class utility {

    public static String getResponseOutput(String fileName) {
        String result = "";

        ClassLoader classLoader = utility.class.getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String createLog(String query,
                                   int statusCode,
                                   String error) throws IOException
    {
        logObject log=new logObject();
        log.setHostName(InetAddress.getLocalHost().getHostName());
        log.setStatusCode(statusCode);
        log.setQuery(query);
        log.setError(error);
        return new Gson().toJson(log);


    }

    public static String toHashValue(final String httpReq) {
        return String.valueOf(httpReq.hashCode());
    }


}
