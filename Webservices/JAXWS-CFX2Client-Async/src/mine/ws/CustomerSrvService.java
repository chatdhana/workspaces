package mine.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-11-22T15:54:28.977+05:30
 * Generated source version: 2.7.7
 * 
 */
@WebServiceClient(name = "CustomerSrvService", 
                  wsdlLocation = "http://localhost:8080/JAXWS/services/CustomerSrv?wsdl",
                  targetNamespace = "http://ws.mine") 
public class CustomerSrvService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.mine", "CustomerSrvService");
    public final static QName CustomerSrv = new QName("http://ws.mine", "CustomerSrv");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/JAXWS/services/CustomerSrv?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerSrvService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/JAXWS/services/CustomerSrv?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerSrvService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerSrvService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerSrvService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns CustomerSrv
     */
    @WebEndpoint(name = "CustomerSrv")
    public CustomerSrv getCustomerSrv() {
        return super.getPort(CustomerSrv, CustomerSrv.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerSrv
     */
    @WebEndpoint(name = "CustomerSrv")
    public CustomerSrv getCustomerSrv(WebServiceFeature... features) {
        return super.getPort(CustomerSrv, CustomerSrv.class, features);
    }

}
