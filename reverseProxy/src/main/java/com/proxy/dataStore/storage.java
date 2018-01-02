package com.proxy.dataStore;

public interface storage {
    void connect(String user, String pass, String hostName);
    void  setter(String key, Object value);
    Object getter(String key);
    void disconnect();
}
