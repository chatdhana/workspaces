/**
 * WebserviceProxyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws.proxy;

public class WebserviceProxyServiceLocator extends org.apache.axis.client.Service implements mine.ws.proxy.WebserviceProxyService {

    public WebserviceProxyServiceLocator() {
    }


    public WebserviceProxyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebserviceProxyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebserviceProxy
    private java.lang.String WebserviceProxy_address = "http://localhost:8080/WebserviceProxy/services/WebserviceProxy";

    public java.lang.String getWebserviceProxyAddress() {
        return WebserviceProxy_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebserviceProxyWSDDServiceName = "WebserviceProxy";

    public java.lang.String getWebserviceProxyWSDDServiceName() {
        return WebserviceProxyWSDDServiceName;
    }

    public void setWebserviceProxyWSDDServiceName(java.lang.String name) {
        WebserviceProxyWSDDServiceName = name;
    }

    public mine.ws.proxy.WebserviceProxy getWebserviceProxy() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebserviceProxy_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebserviceProxy(endpoint);
    }

    public mine.ws.proxy.WebserviceProxy getWebserviceProxy(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mine.ws.proxy.WebserviceProxySoapBindingStub _stub = new mine.ws.proxy.WebserviceProxySoapBindingStub(portAddress, this);
            _stub.setPortName(getWebserviceProxyWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebserviceProxyEndpointAddress(java.lang.String address) {
        WebserviceProxy_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mine.ws.proxy.WebserviceProxy.class.isAssignableFrom(serviceEndpointInterface)) {
                mine.ws.proxy.WebserviceProxySoapBindingStub _stub = new mine.ws.proxy.WebserviceProxySoapBindingStub(new java.net.URL(WebserviceProxy_address), this);
                _stub.setPortName(getWebserviceProxyWSDDServiceName());
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
        if ("WebserviceProxy".equals(inputPortName)) {
            return getWebserviceProxy();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://proxy.ws.mine", "WebserviceProxyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://proxy.ws.mine", "WebserviceProxy"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebserviceProxy".equals(portName)) {
            setWebserviceProxyEndpointAddress(address);
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
