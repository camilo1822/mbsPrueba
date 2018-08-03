/**
 * 
 */
package pruebas.util;

import java.util.Date;

import com.nequi.cmm.consumer.util.CommonServiceConsumerUtil;

import prueba.util.ConstantPrueba;
import pruebas.seiya.ContainerType;
import pruebas.seiya.DestinationType;
import pruebas.seiya.MessageRS;
import pruebas.seiya.ProviderType;
import pruebas.seiya.RequestHeaderType;
import pruebas.seiya.ResponseBodyType;
import pruebas.seiya.ResponseHeaderType;
import pruebas.seiya.ResponseMessageType;
import pruebas.seiya.StatusType;

/**
 * @author juan.arboleda
 *
 */
public class BuildMessageServiceUtil {
    /**
     * Default constructor
     */
    private BuildMessageServiceUtil() {
        super();
    }

    /**
     * Metodo que configura la respuesta con la configuracion dada.
     * 
     * @param headerRQ
     * @param code
     * @param message
     * @return {@link MessageRS}
     */
    public static MessageRS generateResponse(RequestHeaderType headerRQ,
            String code, String message) {

        MessageRS messageRS = getGenericResponseStructure();
        messageRS.getResponseMessage().setHeader(setRequestDataToResponse(
                headerRQ, messageRS.getResponseMessage().getHeader()));
        messageRS.getResponseMessage().getHeader().getStatus().setCode(code);
        messageRS.getResponseMessage().getHeader().getStatus()
                .setDescription(message);
        return messageRS;
    }

    /**
     * Metodo que configura la respuesta.
     * 
     * @param headerRQ
     * @param headerRS
     * @return {@link ResponseHeaderType} header para respuesta de servicio.
     */
    private static ResponseHeaderType setRequestDataToResponse(
            RequestHeaderType headerRQ, ResponseHeaderType headerRS) {
        String responseDate;
        responseDate = CommonServiceConsumerUtil.getCurrentTimeStamp(
                ConstantPrueba.COMMON_FORMAT_DATE_TO_FRONT);
        if (null == headerRQ) {
            headerRS.getDestination()
                    .setServiceName(ConstantPrueba.HEADER_CONSUMER_TYPE_NAME);
            headerRS.getDestination()
                    .setServiceOperation(ConstantPrueba.COMMON_STRING_EMPTY);
            headerRS.getDestination()
                    .setServiceRegion(ConstantPrueba.COMMON_STRING_EMPTY);
            headerRS.getDestination()
                    .setServiceVersion(ConstantPrueba.COMMON_STRING_EMPTY);

            headerRS.setMessageID(String.valueOf(new Date().getTime()));
            headerRS.getContainer()
                    .setId(ConstantPrueba.COMMON_STRING_CONTAINER_TYPE_ID);
            headerRS.getContainer()
                    .setName(ConstantPrueba.COMMON_STRING_CONTAINER_TYPE_NAME);

        } else {
            headerRS.setDestination(headerRQ.getDestination());
            headerRS.setMessageID(headerRQ.getMessageID());
            headerRS.setContainer(headerRQ.getContainer());
            headerRS.setChannel(headerRQ.getChannel().getId());
        }

        headerRS.setResponseDate(responseDate);
        headerRS.getProvider().setId(ConstantPrueba.HEADER_PROVIDER_TYPE_ID);
        headerRS.getProvider()
                .setName(ConstantPrueba.HEADER_PROVIDER_TYPE_NAME);
        return headerRS;
    }

    /**
     * Metodo que genera una respuesta por defecto.
     * 
     * @return {@link MessageRS} respuesta generica.
     */
    private static MessageRS getGenericResponseStructure() {

        MessageRS messageRS = new MessageRS();
        ResponseMessageType responseMessageType = new ResponseMessageType();
        ResponseHeaderType responseHeaderType = new ResponseHeaderType();
        DestinationType destinationType = new DestinationType();
        StatusType statusType = new StatusType();
        ProviderType providerType = new ProviderType();
        ContainerType containerType = new ContainerType();

        responseHeaderType.setDestination(destinationType);
        responseHeaderType.setStatus(statusType);
        responseHeaderType.setProvider(providerType);
        responseHeaderType.setContainer(containerType);

        ResponseBodyType responseBodyType = new ResponseBodyType();

        responseMessageType.setHeader(responseHeaderType);
        responseMessageType.setBody(responseBodyType);
        messageRS.setResponseMessage(responseMessageType);
        return messageRS;
    }

}
