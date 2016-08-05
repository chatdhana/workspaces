package mine.ws;

public class CustomerSrvProxy implements mine.ws.CustomerSrv {
  private String _endpoint = null;
  private mine.ws.CustomerSrv customerSrv = null;
  
  public CustomerSrvProxy() {
    _initCustomerSrvProxy();
  }
  
  public CustomerSrvProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomerSrvProxy();
  }
  
  private void _initCustomerSrvProxy() {
    try {
      customerSrv = (new mine.ws.CustomerSrvServiceLocator()).getCustomerSrv();
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
  
  public mine.ws.CustomerSrv getCustomerSrv() {
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv;
  }
  
  public java.lang.String createCustomer(mine.bean.Customer cust) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.createCustomer(cust);
  }
  
  public java.lang.String updateCustomer(mine.bean.Customer cust) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.updateCustomer(cust);
  }
  
  public mine.bean.Customer enquireCustomer(mine.bean.Customer cust) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.enquireCustomer(cust);
  }
  
  public mine.bean.Customer findByAadhaarId(java.lang.String aadhaarId) throws java.rmi.RemoteException{
    if (customerSrv == null)
      _initCustomerSrvProxy();
    return customerSrv.findByAadhaarId(aadhaarId);
  }
  
  
}