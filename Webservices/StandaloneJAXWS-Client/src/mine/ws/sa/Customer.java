/**
 * Customer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mine.ws.sa;

public class Customer  implements java.io.Serializable {
    private java.lang.String aadhaarId;

    private java.lang.Long annualIncome;

    private java.lang.String countryOfBirth;

    private java.util.Calendar dob;

    private java.lang.String name;

    public Customer() {
    }

    public Customer(
           java.lang.String aadhaarId,
           java.lang.Long annualIncome,
           java.lang.String countryOfBirth,
           java.util.Calendar dob,
           java.lang.String name) {
           this.aadhaarId = aadhaarId;
           this.annualIncome = annualIncome;
           this.countryOfBirth = countryOfBirth;
           this.dob = dob;
           this.name = name;
    }


    /**
     * Gets the aadhaarId value for this Customer.
     * 
     * @return aadhaarId
     */
    public java.lang.String getAadhaarId() {
        return aadhaarId;
    }


    /**
     * Sets the aadhaarId value for this Customer.
     * 
     * @param aadhaarId
     */
    public void setAadhaarId(java.lang.String aadhaarId) {
        this.aadhaarId = aadhaarId;
    }


    /**
     * Gets the annualIncome value for this Customer.
     * 
     * @return annualIncome
     */
    public java.lang.Long getAnnualIncome() {
        return annualIncome;
    }


    /**
     * Sets the annualIncome value for this Customer.
     * 
     * @param annualIncome
     */
    public void setAnnualIncome(java.lang.Long annualIncome) {
        this.annualIncome = annualIncome;
    }


    /**
     * Gets the countryOfBirth value for this Customer.
     * 
     * @return countryOfBirth
     */
    public java.lang.String getCountryOfBirth() {
        return countryOfBirth;
    }


    /**
     * Sets the countryOfBirth value for this Customer.
     * 
     * @param countryOfBirth
     */
    public void setCountryOfBirth(java.lang.String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }


    /**
     * Gets the dob value for this Customer.
     * 
     * @return dob
     */
    public java.util.Calendar getDob() {
        return dob;
    }


    /**
     * Sets the dob value for this Customer.
     * 
     * @param dob
     */
    public void setDob(java.util.Calendar dob) {
        this.dob = dob;
    }


    /**
     * Gets the name value for this Customer.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Customer.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aadhaarId==null && other.getAadhaarId()==null) || 
             (this.aadhaarId!=null &&
              this.aadhaarId.equals(other.getAadhaarId()))) &&
            ((this.annualIncome==null && other.getAnnualIncome()==null) || 
             (this.annualIncome!=null &&
              this.annualIncome.equals(other.getAnnualIncome()))) &&
            ((this.countryOfBirth==null && other.getCountryOfBirth()==null) || 
             (this.countryOfBirth!=null &&
              this.countryOfBirth.equals(other.getCountryOfBirth()))) &&
            ((this.dob==null && other.getDob()==null) || 
             (this.dob!=null &&
              this.dob.equals(other.getDob()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAadhaarId() != null) {
            _hashCode += getAadhaarId().hashCode();
        }
        if (getAnnualIncome() != null) {
            _hashCode += getAnnualIncome().hashCode();
        }
        if (getCountryOfBirth() != null) {
            _hashCode += getCountryOfBirth().hashCode();
        }
        if (getDob() != null) {
            _hashCode += getDob().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://sa.ws.mine/", "customer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aadhaarId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aadhaarId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annualIncome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "annualIncome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryOfBirth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "countryOfBirth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dob");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dob"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
