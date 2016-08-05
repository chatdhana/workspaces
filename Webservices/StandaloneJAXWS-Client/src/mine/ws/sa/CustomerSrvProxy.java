package mine.ws.sa;

public class CustomerSrvProxy implements mine.ws.sa.CustomerSrv {
  private String _endpoint = null;
  private mine.ws.sa.CustomerSrv customerSrv = null;
  
  public CustomerSrvProxy() {
    _initCustomerSrvProxy();
  }
  
  public CustomerSrvProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomerSrvProxy();
  }
  
  private void _initCustomerSrvProxy() {
    try {
      customerSrv = (new mine.ws.sa.CustomerSrvNameLocator()).getCustomerSrvPortName();
      if (customerSrv != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customerSrv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customerSrv)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customerSrv != null)
      ((javax.xml.rpc.Stub)customerSrv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mine.ws.sa.CustomerSrv getCustomerSrv() {
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv;
  }
  
  public java.lang.String createCustomer(mine.ws.sa.Customer arg0) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.createCustomer(arg0);
  }
  
  public java.lang.String updateCustomer(mine.ws.sa.Customer arg0) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.updateCustomer(arg0);
  }
  
  public mine.ws.sa.Customer enquireCustomer(mine.ws.sa.Customer arg0) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.enquireCustomer(arg0);
  }
  
  public mine.ws.sa.Customer findByAadhaarId(java.lang.String arg0) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.findByAadhaarId(arg0);
  }
  
  
}