package com.proxy.cloud;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.proxy.utility;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;
import java.util.List;

public class S3Handler {
    static final AmazonS3 s3 = awsClient.createS3Client();

    public static Bucket getBucket(String bucket_name) {
        Bucket named_bucket = null;
        List<Bucket> buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            if (b.getName().equals(bucket_name)) {
                named_bucket = b;
            }
        }
        return named_bucket;
    }

    public static Bucket createBucket(String bucket_name) {
        Bucket b = null;
        if (s3.doesBucketExist(bucket_name)) {
            System.out.format("Bucket %s already exists.\n", bucket_name);
            b = getBucket(bucket_name);
        } else {
            try {
                b = s3.createBucket(bucket_name);
            } catch (AmazonS3Exception e) {
                System.err.println(e.getErrorMessage());
            }
        }
        return b;
    }

    public static void writeToBucket(String logObject)
    {
        String key = new DateTime( DateTimeZone.UTC ).toString();
        s3.putObject(awsClient.getBucket(),key, logObject);

    }

    public static void main(String[] args) throws IOException
    {
        final String USAGE = "\n" +
                "CreateBucket - create an S3 bucket\n\n" +
                "Usage: CreateBucket <bucketname>\n\n" +
                "Where:\n" +
                "  bucketname - the name of the bucket to create.\n\n" +
                "The bucket name must be unique, or an error will result.\n";


        Bucket b = createBucket(awsClient.getBucket());
        if (b == null) {
            System.out.println("Error creating bucket!\n");
        } else {
            System.out.println("Done!\n");
        }
        writeToBucket(utility.createLog("hello",202,"null"));
    }
}

