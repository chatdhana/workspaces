/**
 * WebserviceProxyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws.proxy;

public interface WebserviceProxyService extends javax.xml.rpc.Service {
    public java.lang.String getWebserviceProxyAddress();

    public mine.ws.proxy.WebserviceProxy getWebserviceProxy() throws javax.xml.rpc.ServiceException;

    public mine.ws.proxy.WebserviceProxy getWebserviceProxy(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
