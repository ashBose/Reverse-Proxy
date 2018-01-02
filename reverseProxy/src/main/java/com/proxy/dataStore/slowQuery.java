package com.proxy.dataStore;

import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.proxy.utility;

public class slowQuery extends cbDatabase{

    public void setSlowQuery(String httpReq,int timeTaken)
    {
        String key = utility.toHashValue(httpReq);
        JsonObject user = JsonObject.empty()
                .put("response_time", timeTaken);
        setter(key,user);
    }

    public void getSlowQuery() {
        N1qlQueryResult result = getSelectQuery();
    }
}
