package com.proxy.cloud;

public class awsProperty {

      private String   aws_access_key;
      private String   aws_secret_key;
      private String  region;
      private String s3_bucket;
      private String service_endpount;


    public String getService_endpount() {
        return service_endpount;
    }

    public void setService_endpount(String service_endpount) {
        this.service_endpount = service_endpount;
    }

    public String getAws_access_key() {
        return aws_access_key;
    }

    public void setAws_access_key(String aws_access_key) {
        this.aws_access_key = aws_access_key;
    }

    public String getAws_secret_key() {
        return aws_secret_key;
    }

    public void setAws_secret_key(String aws_secret_key) {
        this.aws_secret_key = aws_secret_key;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getS3_bucket() {
        return s3_bucket;
    }

    public void setS3_bucket(String s3_bucket) {
        this.s3_bucket = s3_bucket;
    }



}
