/**
 * Caller.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.eclipse.bpel.sample;

public interface Caller extends javax.xml.rpc.Service {
    public java.lang.String getCallerPortAddress();

    public org.eclipse.bpel.sample.CallerPortType getCallerPort() throws javax.xml.rpc.ServiceException;

    public org.eclipse.bpel.sample.CallerPortType getCallerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
