//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.03 at 05:22:26 PM COT 
//


package pruebas.seiya;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destination" type="{http://nequi.co/message/bussines/services/}destinationType"/>
 *         &lt;element name="messageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://nequi.co/message/bussines/services/}statusType"/>
 *         &lt;element name="responseDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="provider" type="{http://nequi.co/message/bussines/services/}providerType"/>
 *         &lt;element name="container" type="{http://nequi.co/message/bussines/services/}containerType" minOccurs="0"/>
 *         &lt;element name="channel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseHeaderType", propOrder = {
    "destination",
    "messageID",
    "status",
    "responseDate",
    "provider",
    "container",
    "channel"
})
public class ResponseHeaderType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected DestinationType destination;
    @XmlElement(required = true)
    protected String messageID;
    @XmlElement(required = true)
    protected StatusType status;
    @XmlElement(required = true)
    protected String responseDate;
    @XmlElement(required = true)
    protected ProviderType provider;
    protected ContainerType container;
    @XmlElement(required = true)
    protected String channel;

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link DestinationType }
     *     
     */
    public DestinationType getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationType }
     *     
     */
    public void setDestination(DestinationType value) {
        this.destination = value;
    }

    /**
     * Gets the value of the messageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * Sets the value of the messageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageID(String value) {
        this.messageID = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the responseDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseDate() {
        return responseDate;
    }

    /**
     * Sets the value of the responseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseDate(String value) {
        this.responseDate = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderType }
     *     
     */
    public ProviderType getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderType }
     *     
     */
    public void setProvider(ProviderType value) {
        this.provider = value;
    }

    /**
     * Gets the value of the container property.
     * 
     * @return
     *     possible object is
     *     {@link ContainerType }
     *     
     */
    public ContainerType getContainer() {
        return container;
    }

    /**
     * Sets the value of the container property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerType }
     *     
     */
    public void setContainer(ContainerType value) {
        this.container = value;
    }

    /**
     * Gets the value of the channel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannel(String value) {
        this.channel = value;
    }

}
