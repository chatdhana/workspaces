package sms;

public class SendSMSPortTypeProxy implements sms.SendSMSPortType {
  private String _endpoint = null;
  private sms.SendSMSPortType sendSMSPortType = null;
  
  public SendSMSPortTypeProxy() {
    _initSendSMSPortTypeProxy();
  }
  
  public SendSMSPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSendSMSPortTypeProxy();
  }
  
  private void _initSendSMSPortTypeProxy() {
    try {
      sendSMSPortType = (new sms.SendSMSLocator()).getSendSMSPort();
      if (sendSMSPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sendSMSPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sendSMSPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sendSMSPortType != null)
      ((javax.xml.rpc.Stub)sendSMSPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sms.SendSMSPortType getSendSMSPortType() {
    if (sendSMSPortType == null)
      _initSendSMSPortTypeProxy();
    return sendSMSPortType;
  }
  
  public java.lang.String sendSMSToMany(java.lang.String uid, java.lang.String pwd, java.lang.String phone, java.lang.String msg) throws java.rmi.RemoteException{
    if (sendSMSPortType == null)
      _initSendSMSPortTypeProxy();
    return sendSMSPortType.sendSMSToMany(uid, pwd, phone, msg);
  }
  
  
}