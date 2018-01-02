package com.proxy.dataStore;

import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.proxy.utility;

public class countQuery extends cbDatabase {

    public void setCounter(String httpReq)
    {
        String key = utility.toHashValue(httpReq);
        bucket.counter(key, 1);
    }

    public void getCounter(String httpReq)
    {
       // String key =utility.toHashValue(httpReq);
        N1qlQueryResult result = getSelectQuery();
    }
}
