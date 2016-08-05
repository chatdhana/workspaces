package org.eclipse.bpel.sample;

public class CallerPortTypeProxy implements org.eclipse.bpel.sample.CallerPortType {
  private String _endpoint = null;
  private org.eclipse.bpel.sample.CallerPortType callerPortType = null;
  
  public CallerPortTypeProxy() {
    _initCallerPortTypeProxy();
  }
  
  public CallerPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCallerPortTypeProxy();
  }
  
  private void _initCallerPortTypeProxy() {
    try {
      callerPortType = (new org.eclipse.bpel.sample.CallerLocator()).getCallerPort();
      if (callerPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)callerPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)callerPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (callerPortType != null)
      ((javax.xml.rpc.Stub)callerPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.eclipse.bpel.sample.CallerPortType getCallerPortType() {
    if (callerPortType == null)
      _initCallerPortTypeProxy();
    return callerPortType;
  }
  
  public org.eclipse.bpel.sample.CallerResponse process(org.eclipse.bpel.sample.CallerRequest payload) throws java.rmi.RemoteException{
    if (callerPortType == null)
      _initCallerPortTypeProxy();
    return callerPortType.process(payload);
  }
  
  
}