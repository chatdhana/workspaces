/**
 * SendSMSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sms;

public class SendSMSLocator extends org.apache.axis.client.Service implements sms.SendSMS {

    public SendSMSLocator() {
    }


    public SendSMSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SendSMSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SendSMSPort
    private java.lang.String SendSMSPort_address = "http://www.aswinanand.com/sendsms.php";

    public java.lang.String getSendSMSPortAddress() {
        return SendSMSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SendSMSPortWSDDServiceName = "SendSMSPort";

    public java.lang.String getSendSMSPortWSDDServiceName() {
        return SendSMSPortWSDDServiceName;
    }

    public void setSendSMSPortWSDDServiceName(java.lang.String name) {
        SendSMSPortWSDDServiceName = name;
    }

    public sms.SendSMSPortType getSendSMSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SendSMSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSendSMSPort(endpoint);
    }

    public sms.SendSMSPortType getSendSMSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sms.SendSMSBindingStub _stub = new sms.SendSMSBindingStub(portAddress, this);
            _stub.setPortName(getSendSMSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSendSMSPortEndpointAddress(java.lang.String address) {
        SendSMSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (sms.SendSMSPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sms.SendSMSBindingStub _stub = new sms.SendSMSBindingStub(new java.net.URL(SendSMSPort_address), this);
                _stub.setPortName(getSendSMSPortWSDDServiceName());
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
        if ("SendSMSPort".equals(inputPortName)) {
            return getSendSMSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:sms", "SendSMS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:sms", "SendSMSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SendSMSPort".equals(portName)) {
            setSendSMSPortEndpointAddress(address);
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
