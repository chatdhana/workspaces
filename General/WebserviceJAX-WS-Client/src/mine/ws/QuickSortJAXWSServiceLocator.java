/**
 * QuickSortJAXWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws;

public class QuickSortJAXWSServiceLocator extends org.apache.axis.client.Service implements mine.ws.QuickSortJAXWSService {

    public QuickSortJAXWSServiceLocator() {
    }


    public QuickSortJAXWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public QuickSortJAXWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for QuickSortJAXWS
    private java.lang.String QuickSortJAXWS_address = "http://localhost:8080/WebserviceJAX-WS/services/QuickSortJAXWS";

    public java.lang.String getQuickSortJAXWSAddress() {
        return QuickSortJAXWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String QuickSortJAXWSWSDDServiceName = "QuickSortJAXWS";

    public java.lang.String getQuickSortJAXWSWSDDServiceName() {
        return QuickSortJAXWSWSDDServiceName;
    }

    public void setQuickSortJAXWSWSDDServiceName(java.lang.String name) {
        QuickSortJAXWSWSDDServiceName = name;
    }

    public mine.ws.QuickSortJAXWS getQuickSortJAXWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(QuickSortJAXWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getQuickSortJAXWS(endpoint);
    }

    public mine.ws.QuickSortJAXWS getQuickSortJAXWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mine.ws.QuickSortJAXWSSoapBindingStub _stub = new mine.ws.QuickSortJAXWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getQuickSortJAXWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setQuickSortJAXWSEndpointAddress(java.lang.String address) {
        QuickSortJAXWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mine.ws.QuickSortJAXWS.class.isAssignableFrom(serviceEndpointInterface)) {
                mine.ws.QuickSortJAXWSSoapBindingStub _stub = new mine.ws.QuickSortJAXWSSoapBindingStub(new java.net.URL(QuickSortJAXWS_address), this);
                _stub.setPortName(getQuickSortJAXWSWSDDServiceName());
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
        if ("QuickSortJAXWS".equals(inputPortName)) {
            return getQuickSortJAXWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.mine", "QuickSortJAXWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.mine", "QuickSortJAXWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("QuickSortJAXWS".equals(portName)) {
            setQuickSortJAXWSEndpointAddress(address);
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
