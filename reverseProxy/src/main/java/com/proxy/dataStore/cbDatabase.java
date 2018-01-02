package com.proxy.dataStore;

import com.couchbase.client.java.*;
import com.couchbase.client.java.document.*;
import com.couchbase.client.java.document.json.*;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;

public class cbDatabase implements storage{
    Cluster cluster = null;
    Bucket bucket = null;
    final int expiryTime = 10;
    String bucketName;

    private static cbDatabase instance = null;
    cbDatabase() {}

    cbDatabase (final String bucket_name,
                                         final String password,
                                         final String host) {

        bucketName = bucket_name;
        connect(bucket_name, password, host);
    }

    public Bucket getBucket() {
        return bucket;
    }


    public void connect(final String bucket_name,
                        final String password,
                        final String host) {
        cluster = CouchbaseCluster.create(host);
        bucket = cluster.openBucket(bucket_name, password);
    }

    public void setter(String key, Object document) {
        JsonDocument doc = JsonDocument.create(key, (JsonObject)document);
        JsonDocument response = (JsonDocument) bucket.upsert(doc);
    }

    public JsonDocument getter(String key) {
        return bucket.get(key);
    }

    public void createIndex()
    {
        bucket.bucketManager().createN1qlPrimaryIndex(true,false);
    }

    public N1qlQueryResult getSelectQuery() {
        return bucket.query(N1qlQuery.simple("SELECT * FROM  "+ bucketName));
    }

    public void disconnect() {
        if (bucket != null) {
            bucket.close();
            cluster.disconnect();
            bucket = null;
            cluster = null;
        }
    }
}
