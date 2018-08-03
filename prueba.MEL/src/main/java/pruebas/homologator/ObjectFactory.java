//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.04 at 10:18:17 AM COT 
//


package pruebas.homologator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nequi.mbs.fis609.messaging.services.homologator package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HmgRequest_QNAME = new QName("http://nequi.co/services/util/homologator", "hmgRequest");
    private final static QName _HmgResponse_QNAME = new QName("http://nequi.co/services/util/homologator", "hmgResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nequi.mbs.fis609.messaging.services.homologator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HmgResponseType }
     * 
     */
    public HmgResponseType createHmgResponseType() {
        return new HmgResponseType();
    }

    /**
     * Create an instance of {@link HmgRS }
     * 
     */
    public HmgRS createHmgRS() {
        return new HmgRS();
    }

    /**
     * Create an instance of {@link HmgRQ }
     * 
     */
    public HmgRQ createHmgRQ() {
        return new HmgRQ();
    }

    /**
     * Create an instance of {@link HmgRequestType }
     * 
     */
    public HmgRequestType createHmgRequestType() {
        return new HmgRequestType();
    }

    /**
     * Create an instance of {@link ConsumerType }
     * 
     */
    public ConsumerType createConsumerType() {
        return new ConsumerType();
    }

    /**
     * Create an instance of {@link HeaderResponseType }
     * 
     */
    public HeaderResponseType createHeaderResponseType() {
        return new HeaderResponseType();
    }

    /**
     * Create an instance of {@link BodyRequestType }
     * 
     */
    public BodyRequestType createBodyRequestType() {
        return new BodyRequestType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link HeaderRequestType }
     * 
     */
    public HeaderRequestType createHeaderRequestType() {
        return new HeaderRequestType();
    }

    /**
     * Create an instance of {@link BodyResponseType }
     * 
     */
    public BodyResponseType createBodyResponseType() {
        return new BodyResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HmgRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://nequi.co/services/util/homologator", name = "hmgRequest")
    public JAXBElement<HmgRequestType> createHmgRequest(HmgRequestType value) {
        return new JAXBElement<HmgRequestType>(_HmgRequest_QNAME, HmgRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HmgResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://nequi.co/services/util/homologator", name = "hmgResponse")
    public JAXBElement<HmgResponseType> createHmgResponse(HmgResponseType value) {
        return new JAXBElement<HmgResponseType>(_HmgResponse_QNAME, HmgResponseType.class, null, value);
    }

}
