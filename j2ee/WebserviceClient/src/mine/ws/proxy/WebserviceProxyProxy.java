package mine.ws.proxy;

public class WebserviceProxyProxy implements mine.ws.proxy.WebserviceProxy {
  private String _endpoint = null;
  private mine.ws.proxy.WebserviceProxy webserviceProxy = null;
  
  public WebserviceProxyProxy() {
    _initWebserviceProxyProxy();
  }
  
  public WebserviceProxyProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebserviceProxyProxy();
  }
  
  private void _initWebserviceProxyProxy() {
    try {
      webserviceProxy = (new mine.ws.proxy.WebserviceProxyServiceLocator()).getWebserviceProxy();
      if (webserviceProxy != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webserviceProxy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webserviceProxy)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webserviceProxy != null)
      ((javax.xml.rpc.Stub)webserviceProxy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mine.ws.proxy.WebserviceProxy getWebserviceProxy() {
    if (webserviceProxy == null)
      _initWebserviceProxyProxy();
    return webserviceProxy;
  }
  
  public void redirectWebserviceCall(mine.ws.entity.DataEntity obj) throws java.rmi.RemoteException{
    if (webserviceProxy == null)
      _initWebserviceProxyProxy();
    webserviceProxy.redirectWebserviceCall(obj);
  }
  
  
}