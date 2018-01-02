package com.proxy.dataStore;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.proxy.utility;

public class CacheStore extends cbDatabase {

    public void setCache(String httpReq,String value)
    {
        String key = utility.toHashValue(httpReq);
        JsonObject user = JsonObject.empty()
                .put("response", value);
        setter(key,user);
        bucket.touch(key, expiryTime);
    }

    public String getCache(String httpReq) {
        String key = utility.toHashValue(httpReq);
        JsonDocument response = getter(key);
        if (response != null) {
            return response.content().getString("response");
        }
        return null;
    }
}
