package org.openobservatory.engine;

import oonimkall.WebConnectivityConfig;
import oonimkall.WebConnectivityResults;

/**
 * OONISession contains shared state for running experiments and/or other
 * related task (e.g. geolocation). Note that a OONISession is not meant to
 * be a long running instance. The expected usage is that you create a new
 * session, use it immediately, and then forget about it.
 */
public interface OONISession {
    /** geolocate returns the probe geolocation. */
    OONIGeolocateResults geolocate(OONIContext ctx) throws Exception;

    /** maybeUpdateResources updates resources if needed. */
    void maybeUpdateResources(OONIContext ctx) throws Exception;

    /** newContext creates a new OONIContext instance. */
    OONIContext newContext();

    /**
     * newContextWithTimeout creates a new OONIContext instance that times
     * out after the specified number of seconds. A zero or negative timeout
     * is equivalent to create a OONIContext without a timeout.
     */
    OONIContext newContextWithTimeout(long timeout);

    /** submit submits a measurement and returns the submission results. */
    OONISubmitResults submit(OONIContext ctx, String measurement) throws Exception;

    /** checkIn function is called by probes asking if there are tests to be run. */
    OONICheckInResults checkIn(OONIContext ctx, OONICheckInConfig config) throws Exception;

    /** FetchURLList fetches the list of URLs to test */
    OONIURLListResult fetchURLList(OONIContext ctx, OONIURLListConfig config) throws Exception;

    /** webConnectivity runs a WebConnectivity test and returns WebConnectivityResults */
    WebConnectivityResults webConnectivity(OONIContext ctx, WebConnectivityConfig config) throws Exception;
}
