
package mine.ws.sa.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "enquireCustomer", namespace = "http://sa.ws.mine/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enquireCustomer", namespace = "http://sa.ws.mine/")
public class EnquireCustomer {

    @XmlElement(name = "arg0", namespace = "")
    private mine.bean.Customer arg0;

    /**
     * 
     * @return
     *     returns Customer
     */
    public mine.bean.Customer getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(mine.bean.Customer arg0) {
        this.arg0 = arg0;
    }

}
