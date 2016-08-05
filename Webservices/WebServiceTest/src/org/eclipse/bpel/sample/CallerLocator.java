/**
 * CallerLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.eclipse.bpel.sample;

public class CallerLocator extends org.apache.axis.client.Service implements org.eclipse.bpel.sample.Caller {

    public CallerLocator() {
    }


    public CallerLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CallerLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CallerPort
    private java.lang.String CallerPort_address = "http://localhost:8080/ode/processes/Caller.CallerPort/";

    public java.lang.String getCallerPortAddress() {
        return CallerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CallerPortWSDDServiceName = "CallerPort";

    public java.lang.String getCallerPortWSDDServiceName() {
        return CallerPortWSDDServiceName;
    }

    public void setCallerPortWSDDServiceName(java.lang.String name) {
        CallerPortWSDDServiceName = name;
    }

    public org.eclipse.bpel.sample.CallerPortType getCallerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CallerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCallerPort(endpoint);
    }

    public org.eclipse.bpel.sample.CallerPortType getCallerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.eclipse.bpel.sample.CallerBindingStub _stub = new org.eclipse.bpel.sample.CallerBindingStub(portAddress, this);
            _stub.setPortName(getCallerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCallerPortEndpointAddress(java.lang.String address) {
        CallerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.eclipse.bpel.sample.CallerPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.eclipse.bpel.sample.CallerBindingStub _stub = new org.eclipse.bpel.sample.CallerBindingStub(new java.net.URL(CallerPort_address), this);
                _stub.setPortName(getCallerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CallerPort".equals(inputPortName)) {
            return getCallerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://eclipse.org/bpel/sample", "Caller");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://eclipse.org/bpel/sample", "CallerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CallerPort".equals(portName)) {
            setCallerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
