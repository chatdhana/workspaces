/**
 * CustomerSrvService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws;

public interface CustomerSrvService extends javax.xml.rpc.Service {
    public java.lang.String getCustomerSrvAddress();

    public mine.ws.CustomerSrv getCustomerSrv() throws javax.xml.rpc.ServiceException;

    public mine.ws.CustomerSrv getCustomerSrv(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
