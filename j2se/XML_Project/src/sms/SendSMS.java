/**
 * SendSMS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sms;

public interface SendSMS extends javax.xml.rpc.Service {
    public java.lang.String getSendSMSPortAddress();

    public sms.SendSMSPortType getSendSMSPort() throws javax.xml.rpc.ServiceException;

    public sms.SendSMSPortType getSendSMSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
