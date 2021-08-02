package org.openobservatory.engine;

import oonimkall.WebConnectivityConfig;

public class Config {
    public Config() {
        WebConnectivityConfig config = new WebConnectivityConfig();
        config.setInput("https://www.google.com");
    }
}