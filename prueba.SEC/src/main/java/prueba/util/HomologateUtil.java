/**
 * 
 */
package prueba.util;

import com.nequi.cmm.consumer.exception.RestClientException;
import com.nequi.cmm.consumer.pojo.ServicePojo;
import com.nequi.cmm.consumer.registry.ServiceRegistry;
import com.nequi.cmm.consumer.rest.util.GenericRestClient;
import com.nequi.cmm.consumer.util.CommonServiceConsumerUtil;
import com.nequi.cmm.consumer.util.UtilJSON;
import com.nequi.mdw.common.tracerv7.service.GenericLogger;

import prueba.exception.PruebaException;
import pruebas.homologator.BodyRequestType;
import pruebas.homologator.ConsumerType;
import pruebas.homologator.HeaderRequestType;
import pruebas.homologator.HmgRequestType;
import pruebas.homologator.HmgResponseType;
import pruebas.homologator.StatusType;
import pruebas.seiya.MessageRS;
import pruebas.seiya.RequestHeaderType;

/**
 * 
 * @author juan.arboleda
 *
 */
public class HomologateUtil {

    private HomologateUtil() {
    }

    /**
     * Método que obtiene el request del homologador a partir de un object
     * requestHeaderType
     * 
     * @param errorCode
     * @param originSystem
     * @param destinationSystem
     * @param requestHeaderType
     * @return <code>HmgRequestType</code>
     * @throws PruebaException
     */
    public static HmgRequestType getRequestHomologator(String errorCode,
            String originSystem, String destinationSystem,
            RequestHeaderType headerPetition) throws PruebaException {

        HmgRequestType request = new HmgRequestType();
        HeaderRequestType headerRequestType = new HeaderRequestType();
        headerRequestType.setMessageId(headerPetition.getMessageID());
        ConsumerType consumerType = new ConsumerType();
        consumerType.setId(null != headerPetition.getConsumer()
                ? headerPetition.getConsumer().getId()
                : ConstantPrueba.COMMON_STRING_EMPTY);

        consumerType.setDescription(null != headerPetition.getConsumer()
                ? headerPetition.getConsumer().getName()
                : ConstantPrueba.COMMON_STRING_EMPTY);
        headerRequestType.setConsumer(consumerType);
        headerRequestType
                .setMessageDate(CommonServiceConsumerUtil.getCurrentTimeStamp(
                        ConstantPrueba.COMMON_FORMAT_DATE_TO_FRONT));
        request.setHeader(headerRequestType);
        BodyRequestType bodyRequestType = new BodyRequestType();
        bodyRequestType.setErrorCode(errorCode);
        bodyRequestType.setOriginSystem(originSystem);

        if (null == destinationSystem) {
            String system = (headerPetition.getChannel().getId()).toLowerCase();
            if (ConstantPrueba.CHANNELS.containsKey(system)) {
                bodyRequestType.setDestinationSystem(
                        ConstantPrueba.CHANNELS.get(system));
            }
        }
        bodyRequestType.setDestinationSystem(destinationSystem);
        request.setBody(bodyRequestType);
        return request;
    }

    /**
     * Método que obtiene el request del homologador a partir de un object
     * requestHeaderType. Version seiya
     * 
     * @param errorCode
     * @param originSystem
     * @param destinationSystem
     * @param headerPetition
     * @return HmgRequestType
     * @throws PruebaException
     */
    public static HmgRequestType getRequestHomologatorseiya(String errorCode,
            String originSystem, String destinationSystem,
            pruebas.seiya.RequestHeaderType headerPetition) {

        HmgRequestType request = new HmgRequestType();
        HeaderRequestType headerRequestType = new HeaderRequestType();
        headerRequestType.setMessageId(headerPetition.getMessageID());
        ConsumerType consumerType = new ConsumerType();
        consumerType.setId(null != headerPetition.getConsumer()
                ? headerPetition.getConsumer().getId()
                : ConstantPrueba.COMMON_STRING_EMPTY);

        consumerType.setDescription(null != headerPetition.getConsumer()
                ? headerPetition.getConsumer().getName()
                : ConstantPrueba.COMMON_STRING_EMPTY);
        headerRequestType.setConsumer(consumerType);
        headerRequestType
                .setMessageDate(CommonServiceConsumerUtil.getCurrentTimeStamp(
                        ConstantPrueba.COMMON_FORMAT_DATE_TO_FRONT));
        request.setHeader(headerRequestType);
        BodyRequestType bodyRequestType = new BodyRequestType();
        bodyRequestType.setErrorCode(errorCode);
        bodyRequestType.setOriginSystem(originSystem);

        if (null == destinationSystem) {
            String system = (headerPetition.getChannel().getId()).toLowerCase();
            if (ConstantPrueba.CHANNELS.containsKey(system)) {
                bodyRequestType.setDestinationSystem(
                        ConstantPrueba.CHANNELS.get(system));
            }
        }
        bodyRequestType.setDestinationSystem(destinationSystem);
        request.setBody(bodyRequestType);
        return request;
    }

    /**
     * Metodo para homologar errores dependiendo al sistema
     * 
     * @param errorCode
     * @param originSystem
     * @param destinationSystem
     * @param headerRequestTypeObject
     * @param logger
     * @param serviceRegistry
     * @return MessageRS
     */
    public static MessageRS homologateError(String errorCode,
            String originSystem, String destinationSystem,
            Object headerRequestTypeObject, GenericLogger logger,
            ServiceRegistry serviceRegistry) {

        HmgRequestType hmgRequestType = null;

        StatusType statusType = new StatusType();
        statusType.setCode(ConstantPrueba.ERROR_DEFAULT_CODE);
        statusType.setDescription(ConstantPrueba.ERROR_DEFAULT_MESSAGE);

        RequestHeaderType headerRequestType = null;

        try {
            headerRequestType = UtilJSON.parseSpecificObject(
                    headerRequestTypeObject, RequestHeaderType.class);

            if (null != headerRequestType) {

                hmgRequestType = getRequestHomologator(errorCode, originSystem,
                        destinationSystem, headerRequestType);

                ServicePojo servicePojo = SecurityService
                        .getServiceRegistryPojo(
                                headerRequestType.getMessageID(),
                                ConstantPrueba.HOMOLOGATOR_SERVICE_NAME,
                                ConstantPrueba.HOMOLOGATOR_SERVICE_OPERATION,
                                ConstantPrueba.INTEGRATION_CLASIFICATION,
                                ConstantPrueba.COMMON_STRING_REGION_CORE,
                                ConstantPrueba.COMMON_STRING_DEFAULT_VERSION,
                                serviceRegistry);

                HmgResponseType hmgResponseType = GenericRestClient.sendRequest(
                        hmgRequestType, HmgResponseType.class,
                        servicePojo.getEndPoint(),
                        servicePojo.getAuthBasicUser(),
                        servicePojo.getAuthBasicPwd(),
                        servicePojo.getConnectTimeOut(),
                        servicePojo.getReadTimeOut());

                String codeResult = hmgResponseType.getHeader().getStatus()
                        .getCode();

                if (ConstantPrueba.COMMON_STRING_SUCCESS_CODE
                        .equals(codeResult)) {

                    statusType.setCode(hmgResponseType.getBody().getOutCode());
                    statusType.setDescription(
                            hmgResponseType.getBody().getOutMessage());

                }

            }
        } catch (RestClientException e) {
            MessageTracerUtil.traceException(
                    ConstantPrueba.ERROR_REST_CLIENT_HOMOLOGATE_ERROR, e,
                    logger);
        } catch (Exception e) {
            MessageTracerUtil.traceException(
                    ConstantPrueba.ERROR_TO_HOMOLOGATE_ERROR, e, logger);
        }

        return CommonUtil.getResponseStructure(headerRequestType,
                statusType.getCode(), statusType.getDescription());
    }

    /**
     * Metodo para homologar errores dependiendo al sistema version seiya
     * 
     * @param errorCode
     * @param originSystem
     * @param destinationSystem
     * @param headerRequestType
     * @param logger
     * @param serviceRegistry
     * @return <code>MessageRS</code>>
     */
    public static pruebas.seiya.MessageRS homologateErrorseiya(
            String errorCode, String originSystem, String destinationSystem,
            Object headerRequestTypeObject, GenericLogger logger,
            ServiceRegistry serviceRegistry) {

        HmgRequestType hmgRequestType = null;

        StatusType statusType = new StatusType();
        statusType.setCode(ConstantPrueba.ERROR_DEFAULT_CODE);
        statusType.setDescription(ConstantPrueba.ERROR_DEFAULT_MESSAGE);

        pruebas.seiya.RequestHeaderType headerRequestType = null;

        try {
            headerRequestType = UtilJSON.parseSpecificObject(
                    headerRequestTypeObject,
                    pruebas.seiya.RequestHeaderType.class);

            if (null != headerRequestType) {

                hmgRequestType = getRequestHomologatorseiya(errorCode,
                        originSystem, destinationSystem, headerRequestType);

                ServicePojo servicePojo = SecurityService
                        .getServiceRegistryPojo(
                                headerRequestType.getMessageID(),
                                ConstantPrueba.HOMOLOGATOR_SERVICE_NAME,
                                ConstantPrueba.HOMOLOGATOR_SERVICE_OPERATION,
                                ConstantPrueba.INTEGRATION_CLASIFICATION,
                                ConstantPrueba.COMMON_STRING_REGION_CORE,
                                ConstantPrueba.COMMON_STRING_DEFAULT_VERSION,
                                serviceRegistry);

                HmgResponseType hmgResponseType = GenericRestClient.sendRequest(
                        hmgRequestType, HmgResponseType.class,
                        servicePojo.getEndPoint(),
                        servicePojo.getAuthBasicUser(),
                        servicePojo.getAuthBasicPwd(),
                        servicePojo.getConnectTimeOut(),
                        servicePojo.getReadTimeOut());

                String codeResult = hmgResponseType.getHeader().getStatus()
                        .getCode();

                if (ConstantPrueba.COMMON_STRING_SUCCESS_CODE
                        .equals(codeResult)) {

                    statusType.setCode(hmgResponseType.getBody().getOutCode());
                    statusType.setDescription(
                            hmgResponseType.getBody().getOutMessage());

                }

            }
        } catch (RestClientException e) {
            MessageTracerUtil.traceException(
                    ConstantPrueba.ERROR_REST_CLIENT_HOMOLOGATE_ERROR, e,
                    logger);
        } catch (Exception e) {
            MessageTracerUtil.traceException(
                    ConstantPrueba.ERROR_TO_HOMOLOGATE_ERROR, e, logger);
        }

        return CommonUtil.getResponseStructure(headerRequestType,
                statusType.getCode(), statusType.getDescription());
    }
}
