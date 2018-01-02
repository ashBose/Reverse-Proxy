package com.proxy.cloud;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class sqsHandler {

    AmazonSQS sqs = null;

    public sqsHandler() {
        sqs = awsClient.createSQSClient();
    }

    public void sendMsg(String msg)
    {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withMessageBody(msg)
                .withMessageGroupId("log")
                .withMessageDeduplicationId("1");
        sqs.sendMessage(send_msg_request);
    }

    public static void main(String[] args)
    {
        sqsHandler sq= new sqsHandler();
        sq.sendMsg("Hello World 67");
    }
}
