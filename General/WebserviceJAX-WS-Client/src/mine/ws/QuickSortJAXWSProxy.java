package mine.ws;

public class QuickSortJAXWSProxy implements mine.ws.QuickSortJAXWS {
  private String _endpoint = null;
  private mine.ws.QuickSortJAXWS quickSortJAXWS = null;
  
  public QuickSortJAXWSProxy() {
    _initQuickSortJAXWSProxy();
  }
  
  public QuickSortJAXWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initQuickSortJAXWSProxy();
  }
  
  private void _initQuickSortJAXWSProxy() {
    try {
      quickSortJAXWS = (new mine.ws.QuickSortJAXWSServiceLocator()).getQuickSortJAXWS();
      if (quickSortJAXWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)quickSortJAXWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)quickSortJAXWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (quickSortJAXWS != null)
      ((javax.xml.rpc.Stub)quickSortJAXWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mine.ws.QuickSortJAXWS getQuickSortJAXWS() {
    if (quickSortJAXWS == null)
      _initQuickSortJAXWSProxy();
    return quickSortJAXWS;
  }
  
  public int[] doQuickSort(int[] inArray) throws java.rmi.RemoteException{
    if (quickSortJAXWS == null)
      _initQuickSortJAXWSProxy();
    return quickSortJAXWS.doQuickSort(inArray);
  }
  
  
}