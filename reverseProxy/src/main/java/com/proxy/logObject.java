package com.proxy;

public class logObject {

    String hostName;
    String query;
    int statusCode;
    String error;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getQuery() {
        return query;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
