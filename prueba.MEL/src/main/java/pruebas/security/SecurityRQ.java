//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.01 at 10:12:37 AM COT 
//


package pruebas.security;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://nequi.co/services/util/SecurityManager}securityRequest"/>
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
    "securityRequest"
})
@XmlRootElement(name = "securityRQ")
public class SecurityRQ
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected SecurityRequestType securityRequest;

    /**
     * Gets the value of the securityRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityRequestType }
     *     
     */
    public SecurityRequestType getSecurityRequest() {
        return securityRequest;
    }

    /**
     * Sets the value of the securityRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityRequestType }
     *     
     */
    public void setSecurityRequest(SecurityRequestType value) {
        this.securityRequest = value;
    }

}
