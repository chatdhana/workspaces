package _38._80._5._10.axis.services.new_banking;

public class BankWebServicesProxy implements _38._80._5._10.axis.services.new_banking.BankWebServices {
  private String _endpoint = null;
  private _38._80._5._10.axis.services.new_banking.BankWebServices bankWebServices = null;
  
  public BankWebServicesProxy() {
    _initBankWebServicesProxy();
  }
  
  public BankWebServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankWebServicesProxy();
  }
  
  private void _initBankWebServicesProxy() {
    try {
      bankWebServices = (new _38._80._5._10.axis.services.new_banking.BankWebServicesServiceLocator()).getnew_banking();
      if (bankWebServices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankWebServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankWebServices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankWebServices != null)
      ((javax.xml.rpc.Stub)bankWebServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public _38._80._5._10.axis.services.new_banking.BankWebServices getBankWebServices() {
    if (bankWebServices == null)
      _initBankWebServicesProxy();
    return bankWebServices;
  }
  
  public java.lang.String transaction(java.lang.String type, java.lang.String number, int pin, java.lang.String date, int amount) throws java.rmi.RemoteException{
    if (bankWebServices == null)
      _initBankWebServicesProxy();
    return bankWebServices.transaction(type, number, pin, date, amount);
  }
  
  
}