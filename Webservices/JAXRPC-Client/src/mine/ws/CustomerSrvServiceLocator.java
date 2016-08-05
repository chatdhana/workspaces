/**
 * CustomerSrvServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws;

public class CustomerSrvServiceLocator extends org.apache.axis.client.Service implements mine.ws.CustomerSrvService {

    public CustomerSrvServiceLocator() {
    }


    public CustomerSrvServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerSrvServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerSrv
    private java.lang.String CustomerSrv_address = "http://localhost:8080/JAXWS/services/CustomerSrv";

    public java.lang.String getCustomerSrvAddress() {
        return CustomerSrv_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerSrvWSDDServiceName = "CustomerSrv";

    public java.lang.String getCustomerSrvWSDDServiceName() {
        return CustomerSrvWSDDServiceName;
    }

    public void setCustomerSrvWSDDServiceName(java.lang.String name) {
        CustomerSrvWSDDServiceName = name;
    }

    public mine.ws.CustomerSrv getCustomerSrv() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerSrv_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerSrv(endpoint);
    }

    public mine.ws.CustomerSrv getCustomerSrv(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mine.ws.CustomerSrvSoapBindingStub _stub = new mine.ws.CustomerSrvSoapBindingStub(portAddress, this);
            _stub.setPortName(getCustomerSrvWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerSrvEndpointAddress(java.lang.String address) {
        CustomerSrv_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mine.ws.CustomerSrv.class.isAssignableFrom(serviceEndpointInterface)) {
                mine.ws.CustomerSrvSoapBindingStub _stub = new mine.ws.CustomerSrvSoapBindingStub(new java.net.URL(CustomerSrv_address), this);
                _stub.setPortName(getCustomerSrvWSDDServiceName());
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
        if ("CustomerSrv".equals(inputPortName)) {
            return getCustomerSrv();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.mine", "CustomerSrvService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.mine", "CustomerSrv"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerSrv".equals(portName)) {
            setCustomerSrvEndpointAddress(address);
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
