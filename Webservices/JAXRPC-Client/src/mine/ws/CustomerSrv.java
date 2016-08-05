/**
 * CustomerSrv.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws;

public interface CustomerSrv extends java.rmi.Remote {
    public java.lang.String createCustomer(mine.bean.Customer cust) throws java.rmi.RemoteException;
    public java.lang.String updateCustomer(mine.bean.Customer cust) throws java.rmi.RemoteException;
    public mine.bean.Customer enquireCustomer(mine.bean.Customer cust) throws java.rmi.RemoteException;
    public mine.bean.Customer findByAadhaarId(java.lang.String aadhaarId) throws java.rmi.RemoteException;
}
