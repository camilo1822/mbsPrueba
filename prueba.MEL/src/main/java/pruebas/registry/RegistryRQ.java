//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.30 at 09:59:14 AM COT 
//


package pruebas.registry;

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
 *         &lt;element ref="{http://nequi.co/message/registry/ServiceRegistry}registryRequest"/>
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
    "registryRequest"
})
@XmlRootElement(name = "registryRQ")
public class RegistryRQ
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected RegistryRequestType registryRequest;

    /**
     * Gets the value of the registryRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RegistryRequestType }
     *     
     */
    public RegistryRequestType getRegistryRequest() {
        return registryRequest;
    }

    /**
     * Sets the value of the registryRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistryRequestType }
     *     
     */
    public void setRegistryRequest(RegistryRequestType value) {
        this.registryRequest = value;
    }

}