/**
 * SendSMSPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.virtusa.placement.sms;

public interface SendSMSPortType extends java.rmi.Remote {

    /**
     * Sends the same SMS to multiple phone numbers. Separate each
     * phone number with a semicolon(';').
     */
    public java.lang.String sendSMSToMany(java.lang.String uid, java.lang.String pwd, java.lang.String phone, java.lang.String msg) throws java.rmi.RemoteException;
}
