/**
 * BankWebServices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _38._80._5._10.axis.services.new_banking;

public interface BankWebServices extends java.rmi.Remote {
    public java.lang.String transaction(java.lang.String type, java.lang.String number, int pin, java.lang.String date, int amount) throws java.rmi.RemoteException;
}
