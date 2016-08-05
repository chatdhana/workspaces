
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
 *         &lt;element name="findByAadhaarIdReturn" type="{http://bean.mine}Customer"/>
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
    "findByAadhaarIdReturn"
})
@XmlRootElement(name = "findByAadhaarIdResponse")
public class FindByAadhaarIdResponse {

    @XmlElement(required = true)
    protected Customer findByAadhaarIdReturn;

    /**
     * Gets the value of the findByAadhaarIdReturn property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getFindByAadhaarIdReturn() {
        return findByAadhaarIdReturn;
    }

    /**
     * Sets the value of the findByAadhaarIdReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setFindByAadhaarIdReturn(Customer value) {
        this.findByAadhaarIdReturn = value;
    }

}
