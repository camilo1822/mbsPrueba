package prueba.util;

import java.util.Date;
import java.util.List;

import com.nequi.cmm.consumer.exception.CommonUtilException;
import com.nequi.cmm.consumer.registry.ServiceRegistry;
import com.nequi.cmm.consumer.util.CommonServiceConsumerUtil;
import com.nequi.cmm.consumer.util.UtilJSON;
import com.nequi.cmm.messaging.esb.ResponseHeaderOutMessageType;
import com.nequi.mdw.common.tracerv7.service.GenericLogger;

import prueba.jpa.model.Parametro;
import pruebas.seiya.ChannelType;
import pruebas.seiya.ContainerType;
import pruebas.seiya.DestinationType;
import pruebas.seiya.MessageRQ;
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
public class CommonUtil {

    private CommonUtil() {
    }

    /**
     * Metodo que devuelve parametro por Nombre
     * 
     * @param parameters
     * @param name
     * @param defaultvalue
     * @return Parametro
     */
    public static String getParameterByName(List<Parametro> parameters,
            String name, String defaultvalue) {
        if (null != parameters && !parameters.isEmpty()) {
            for (Parametro parametro : parameters) {
                if (parametro.getNombre().equalsIgnoreCase(name)) {
                    return parametro.getValor();
                }
            }
        }
        return defaultvalue;
    }

    /**
     * Genera un mensaje de Response a Front Homologando el error que se le
     * envíe.
     * 
     * @param requestHeader
     * @param errorCode
     * @param system
     * @param destinationSystem
     * @param logger
     * @param serviceRegistry
     * @return <code>MessageRS</code>>
     */
    public static MessageRS responseCustomMessage(
            RequestHeaderType requestHeader, String errorCode, String system,
            String destinationSystem, GenericLogger logger,
            ServiceRegistry serviceRegistry) {

        if (null == requestHeader) {
            requestHeader = new RequestHeaderType();
            requestHeader.setDestination(new DestinationType());
            requestHeader.setChannel(new ChannelType());
            requestHeader.setContainer(new ContainerType());
        }
        requestHeader.getContainer()
                .setId(ConstantPrueba.COMMON_STRING_CONTAINER_TYPE_ID);
        requestHeader.getContainer()
                .setName(ConstantPrueba.COMMON_STRING_CONTAINER_TYPE_NAME);
        requestHeader.getChannel()
                .setId(ConstantPrueba.COMMON_STRING_CHANNEL_ID);
        requestHeader.getChannel().setName(ConstantPrueba.CHANNEL_APP);

        requestHeader.setMessageID(null != requestHeader.getMessageID()
                ? requestHeader.getMessageID()
                : String.valueOf((new Date()).getTime()));

        return buildResponseErrorMessage(requestHeader, errorCode, system,
                destinationSystem, logger, serviceRegistry);
    }

    /**
     * Metodo que construye el mensaje tomando el sistema destino para
     * homologar.
     * 
     * @param requestHeader
     * @param errorCode
     * @param system
     * @param destinationSystem
     * @param logger
     * @param serviceRegistry
     * @return <code>MessageRS</code>>
     */
    private static MessageRS buildResponseErrorMessage(
            RequestHeaderType requestHeader, String errorCode, String system,
            String destinationSystem, GenericLogger logger,
            ServiceRegistry serviceRegistry) {

        ResponseMessageType responseMessageType = new ResponseMessageType();
        ResponseHeaderType responseHeader = new ResponseHeaderType();
        ResponseBodyType responseBody = new ResponseBodyType();
        MessageRS response = new MessageRS();
        ProviderType providerType = new ProviderType();
        StatusType statusType;
        String responseDate;

        responseDate = CommonServiceConsumerUtil.getCurrentTimeStamp(
                ConstantPrueba.COMMON_FORMAT_DATE_TO_FRONT);

        if (null != requestHeader) {
            responseHeader.setMessageID(requestHeader.getMessageID());
        } else {
            responseHeader.setMessageID(String.valueOf(new Date().getTime()));
        }

        providerType.setId(ConstantPrueba.HEADER_CONSUMER_TYPE_ID);
        providerType.setName(ConstantPrueba.HEADER_CONSUMER_TYPE_NAME);

        statusType = new StatusType();

        if (ConstantPrueba.COMMON_STRING_SUCCESS_CODE.equals(errorCode)) {

            statusType.setCode(ConstantPrueba.COMMON_STRING_SUCCESS_CODE);
            statusType
                    .setDescription(ConstantPrueba.COMMON_STRING_SUCCESS_MAYUS);

        } else {

            return HomologateUtil.homologateError(errorCode, system,
                    destinationSystem, requestHeader, logger, serviceRegistry);

        }

        responseHeader.setProvider(providerType);
        responseHeader.setResponseDate(responseDate);
        responseHeader.setChannel(null != requestHeader
                ? requestHeader.getChannel().getName() : null);
        responseHeader.setContainer(
                null != requestHeader ? requestHeader.getContainer() : null);
        responseHeader.setDestination(
                null != requestHeader ? requestHeader.getDestination() : null);
        responseHeader.setStatus(statusType);

        responseMessageType.setHeader(responseHeader);
        responseMessageType.setBody(responseBody);
        response.setResponseMessage(responseMessageType);

        return response;
    }

    /**
     * Metodo que genera una respuesta con el codigo y mensaje especificado.
     * 
     * @param request
     * @return {@link MessageRS} respuesta con la configuracion dada.
     */
    public static MessageRS getResponseStructure(RequestHeaderType headerRQ,
            String code, String message) {
        MessageRS response = null;
        response = getResponseStructure();
        ResponseHeaderType headerRS = response.getResponseMessage().getHeader();
        response.getResponseMessage()
                .setHeader(setRequestDataToResponse(headerRQ, headerRS));
        response.getResponseMessage().getHeader().getStatus().setCode(code);
        response.getResponseMessage().getHeader().getStatus()
                .setDescription(message);
        return response;
    }

    /**
     * Metodo que construye la mensajeria de la respuesta de los servicios sin
     * configuracion.
     * 
     * @return {@link MessageRS} generacion de respuesta sin configuracion.
     */
    public static MessageRS getResponseStructure() {

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

    /**
     * Metodo que construye el header para la respuesta del servicio.
     * 
     * @param headerRQ
     * @param headerRS
     * @return {@link ResponseHeaderType} header para respuesta del servicio.
     */
    public static ResponseHeaderType setRequestDataToResponse(
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
     * Metodo que parsea la respuesta para generarla en formato JSON.
     * 
     * @param messageRS
     * @param logger
     * @return respuesta en formato JSON.
     */
    public static String generateResponseAsString(MessageRS messageRS,
            GenericLogger logger) {
        try {

            return UtilJSON.parseJSONToString(messageRS);

        } catch (CommonUtilException e1) {
            logger.traceError(ConstantPrueba.ERROR_MESSAGE_PARSING_ERROR, e1);
        }
        return ConstantPrueba.COMMON_STRING_EMPTY;
    }

    /**
     * Metodo para validar respuesta de MBS
     * 
     * @param messageRS
     * @return boolean
     */
    public static boolean successResponse(MessageRS messageRS) {

        return null != messageRS && null != messageRS.getResponseMessage()
                && null != messageRS.getResponseMessage().getHeader()
                && ConstantPrueba.COMMON_STRING_SUCCESS_CODE
                        .equals(messageRS.getResponseMessage().getHeader()
                                .getStatus().getCode());

    }

    /**
     * Metodo para validar respuesta de IIB
     * 
     * @param responseHeaderOutMessageType
     * @return boolean
     */
    public static boolean successResponse(
            ResponseHeaderOutMessageType responseHeaderOutMessageType) {

        return null != responseHeaderOutMessageType
                && null != responseHeaderOutMessageType.getResponseHeaderOut()
                && null != responseHeaderOutMessageType.getResponseHeaderOut()
                        .getHeader()
                && ConstantPrueba.COMMON_STRING_SUCCESS_CODE
                        .equals(responseHeaderOutMessageType
                                .getResponseHeaderOut().getHeader()
                                .getResponseStatus().getStatusCode());

    }
}