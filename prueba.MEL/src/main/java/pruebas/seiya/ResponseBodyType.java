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
 * <p>Java class for responseBodyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseBodyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://nequi.co/message/integration/services/mbs/prueba}pruebaRS"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseBodyType", propOrder = {
    "pruebaRS"
})
public class ResponseBodyType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://nequi.co/message/integration/services/mbs/prueba")
    protected PruebaRSType pruebaRS;

    /**
     * Gets the value of the pruebaRS property.
     * 
     * @return
     *     possible object is
     *     {@link PruebaRSType }
     *     
     */
    public PruebaRSType getPruebaRS() {
        return pruebaRS;
    }

    /**
     * Sets the value of the pruebaRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link PruebaRSType }
     *     
     */
    public void setPruebaRS(PruebaRSType value) {
        this.pruebaRS = value;
    }

}
