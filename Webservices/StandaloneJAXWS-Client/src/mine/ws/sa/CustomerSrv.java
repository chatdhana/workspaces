/**
 * CustomerSrv.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws.sa;

public interface CustomerSrv extends java.rmi.Remote {
    public java.lang.String createCustomer(mine.ws.sa.Customer arg0) throws java.rmi.RemoteException;
    public java.lang.String updateCustomer(mine.ws.sa.Customer arg0) throws java.rmi.RemoteException;
    public mine.ws.sa.Customer enquireCustomer(mine.ws.sa.Customer arg0) throws java.rmi.RemoteException;
    public mine.ws.sa.Customer findByAadhaarId(java.lang.String arg0) throws java.rmi.RemoteException;
}
