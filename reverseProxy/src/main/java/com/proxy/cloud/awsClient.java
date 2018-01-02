package com.proxy.cloud;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.google.gson.Gson;
import com.proxy.utility;

public class awsClient {
    static Gson mapper;
    static awsProperty credentials = null;

    static
    {
        mapper= new Gson();
        credentials= mapper.fromJson(
                utility.getResponseOutput("parameters.json"),
                awsProperty.class);
    }

    public  static AmazonS3 createS3Client() {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(credentials.getAws_access_key(),
                                              credentials.getAws_secret_key())))
                .withRegion(credentials.getRegion())
                .build();
    }

    public static AmazonSQS createSQSClient() {
        return AmazonSQSClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                        credentials.getAws_access_key(),
                        credentials.getAws_secret_key())))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        credentials.getService_endpount(),
                        credentials.getRegion()))
                .build();
    }

    public static String getBucket() {
        return credentials.getS3_bucket();
    }
}
