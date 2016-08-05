/**
 * BankWebServicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _38._80._5._10.axis.services.new_banking;

public class BankWebServicesServiceLocator extends org.apache.axis.client.Service implements _38._80._5._10.axis.services.new_banking.BankWebServicesService {

    public BankWebServicesServiceLocator() {
    }


    public BankWebServicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankWebServicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for new_banking
    private java.lang.String new_banking_address = "http://10.5.80.38:8080/axis/services/new_banking";

    public java.lang.String getnew_bankingAddress() {
        return new_banking_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String new_bankingWSDDServiceName = "new_banking";

    public java.lang.String getnew_bankingWSDDServiceName() {
        return new_bankingWSDDServiceName;
    }

    public void setnew_bankingWSDDServiceName(java.lang.String name) {
        new_bankingWSDDServiceName = name;
    }

    public _38._80._5._10.axis.services.new_banking.BankWebServices getnew_banking() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(new_banking_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getnew_banking(endpoint);
    }

    public _38._80._5._10.axis.services.new_banking.BankWebServices getnew_banking(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            _38._80._5._10.axis.services.new_banking.New_bankingSoapBindingStub _stub = new _38._80._5._10.axis.services.new_banking.New_bankingSoapBindingStub(portAddress, this);
            _stub.setPortName(getnew_bankingWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setnew_bankingEndpointAddress(java.lang.String address) {
        new_banking_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (_38._80._5._10.axis.services.new_banking.BankWebServices.class.isAssignableFrom(serviceEndpointInterface)) {
                _38._80._5._10.axis.services.new_banking.New_bankingSoapBindingStub _stub = new _38._80._5._10.axis.services.new_banking.New_bankingSoapBindingStub(new java.net.URL(new_banking_address), this);
                _stub.setPortName(getnew_bankingWSDDServiceName());
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
        if ("new_banking".equals(inputPortName)) {
            return getnew_banking();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://10.5.80.38:8080/axis/services/new_banking", "BankWebServicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://10.5.80.38:8080/axis/services/new_banking", "new_banking"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("new_banking".equals(portName)) {
            setnew_bankingEndpointAddress(address);
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
