
package mine.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import mine.bean.Customer;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enquireCustomerReturn" type="{http://bean.mine}Customer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "enquireCustomerReturn"
})
@XmlRootElement(name = "enquireCustomerResponse")
public class EnquireCustomerResponse {

    @XmlElement(required = true)
    protected Customer enquireCustomerReturn;

    /**
     * Gets the value of the enquireCustomerReturn property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getEnquireCustomerReturn() {
        return enquireCustomerReturn;
    }

    /**
     * Sets the value of the enquireCustomerReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setEnquireCustomerReturn(Customer value) {
        this.enquireCustomerReturn = value;
    }

}
