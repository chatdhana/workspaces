/**
 * CustomerSrvNameLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws.sa;

public class CustomerSrvNameLocator extends org.apache.axis.client.Service implements mine.ws.sa.CustomerSrvName {

    public CustomerSrvNameLocator() {
    }


    public CustomerSrvNameLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerSrvNameLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerSrvPortName
    private java.lang.String CustomerSrvPortName_address = "http://localhost:9090/CustomerSrv1";

    public java.lang.String getCustomerSrvPortNameAddress() {
        return CustomerSrvPortName_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerSrvPortNameWSDDServiceName = "CustomerSrvPortName";

    public java.lang.String getCustomerSrvPortNameWSDDServiceName() {
        return CustomerSrvPortNameWSDDServiceName;
    }

    public void setCustomerSrvPortNameWSDDServiceName(java.lang.String name) {
        CustomerSrvPortNameWSDDServiceName = name;
    }

    public mine.ws.sa.CustomerSrv getCustomerSrvPortName() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerSrvPortName_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerSrvPortName(endpoint);
    }

    public mine.ws.sa.CustomerSrv getCustomerSrvPortName(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mine.ws.sa.CustomerSrvPortNameBindingStub _stub = new mine.ws.sa.CustomerSrvPortNameBindingStub(portAddress, this);
            _stub.setPortName(getCustomerSrvPortNameWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerSrvPortNameEndpointAddress(java.lang.String address) {
        CustomerSrvPortName_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mine.ws.sa.CustomerSrv.class.isAssignableFrom(serviceEndpointInterface)) {
                mine.ws.sa.CustomerSrvPortNameBindingStub _stub = new mine.ws.sa.CustomerSrvPortNameBindingStub(new java.net.URL(CustomerSrvPortName_address), this);
                _stub.setPortName(getCustomerSrvPortNameWSDDServiceName());
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
        if ("CustomerSrvPortName".equals(inputPortName)) {
            return getCustomerSrvPortName();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sa.ws.mine/", "CustomerSrvName");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sa.ws.mine/", "CustomerSrvPortName"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerSrvPortName".equals(portName)) {
            setCustomerSrvPortNameEndpointAddress(address);
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
