
package mine.ws.sa.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "enquireCustomerResponse", namespace = "http://sa.ws.mine/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enquireCustomerResponse", namespace = "http://sa.ws.mine/")
public class EnquireCustomerResponse {

    @XmlElement(name = "return", namespace = "")
    private mine.bean.Customer _return;

    /**
     * 
     * @return
     *     returns Customer
     */
    public mine.bean.Customer getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(mine.bean.Customer _return) {
        this._return = _return;
    }

}
