package com.proxy;

public class serviceData {

    int sessionID;
    String urlRequest;
    String urlResponse;

    void setSessionID(int sessionID)
    {
        this.sessionID=sessionID;
    }

    void setUrlRequest(String urlRequest)
    {
        this.urlRequest=urlRequest;
    }

    void setUrlResponse(String urlResponse)
    {
        this.urlResponse=urlResponse;
    }

    int getSessionID()
    {
        return sessionID;
    }

    String getUrlRequest()
    {
        return urlRequest;
    }

    String getUrlResponse()
    {
        return urlResponse;
    }
}
