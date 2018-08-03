package prueba.util;

import java.util.Date;

import com.nequi.cmm.consumer.exception.CommonUtilException;
import com.nequi.cmm.consumer.exception.RestClientException;
import com.nequi.cmm.consumer.pojo.ServicePojo;
import com.nequi.cmm.consumer.registry.ServiceRegistry;
import com.nequi.cmm.consumer.rest.util.GenericRestClient;
import com.nequi.cmm.consumer.util.CommonServiceConsumerUtil;
import com.nequi.cmm.consumer.util.UtilJSON;
import com.nequi.cmm.messaging.registry.BodyRequestType;
import com.nequi.cmm.messaging.registry.ConsumerType;
import com.nequi.cmm.messaging.registry.ContainerType;
import com.nequi.cmm.messaging.registry.EndpointType;
import com.nequi.cmm.messaging.registry.HeaderRequestType;
import com.nequi.cmm.messaging.registry.LookupRequestType;
import com.nequi.cmm.messaging.registry.LookupResponseType;
import com.nequi.cmm.messaging.registry.RegistryRQ;
import com.nequi.cmm.messaging.registry.RegistryRS;
import com.nequi.cmm.messaging.registry.RegistryRequestType;
import com.nequi.cmm.messaging.registry.TimeoutType;

import pruebas.security.BodyType;
import pruebas.security.HeaderType;
import pruebas.security.SecurityRQ;
import pruebas.security.SecurityRS;
import pruebas.security.SecurityRequestType;
import pruebas.security.SecurityResponseType;

public class SecurityService {

    /**
     * Metodo para llamar a Servicio de Diffie-Hellman
     * 
     * @param info
     * @param phoneNumber
     * @param publicKey
     * @param encrypt
     * @param messageID
     * @param serviceRegistry
     * @return <code>SecurityRS</code>
     * @throws RestClientException
     * @throws CommonUtilException
     */
    public static SecurityRS securityDiffie(String info, String phoneNumber,
            String publicKey, boolean encrypt, String messageID,
            ServiceRegistry serviceRegistry)
            throws RestClientException, CommonUtilException {

        SecurityRQ securityRQ = new SecurityRQ();
        SecurityRequestType securityRequestType = new SecurityRequestType();
        HeaderType headerType = new HeaderType();
        BodyType bodyType = new BodyType();

        headerType.setClientPublicKey(publicKey);
        headerType.setConsumerID(ConstantPrueba.HEADER_CONSUMER_TYPE_ID);
        headerType.setMessageDate(CommonServiceConsumerUtil.getCurrentTimeStamp(
                ConstantPrueba.COMMON_FORMAT_DATE_TO_FRONT));
        headerType.setMessageID(messageID);

        headerType.setPhoneNumber(phoneNumber);

        /* Se verifica si se va a cifrar o descifrar */
        if (encrypt) {
            headerType.setOperation(ConstantPrueba.COMMON_STRING_ENCRYPT);
            bodyType.setClearMessage(info);
            bodyType.setProtectMessage(null);
        } else {
            headerType.setOperation(ConstantPrueba.COMMON_STRING_DECRYPT);
            bodyType.setProtectMessage(info);
            bodyType.setClearMessage(null);
        }

        securityRequestType.setHeader(headerType);
        securityRequestType.setBody(bodyType);
        securityRQ.setSecurityRequest(securityRequestType);

        ServicePojo servicePojo = getServiceRegistryPojo(messageID,
                ConstantPrueba.REGISTRY_SERVICE_NAME_DIFFIE_HELLMAN,
                ConstantPrueba.REGISTRY_OPERATION_DIFFIE_HELLMAN,
                ConstantPrueba.INTEGRATION_CLASIFICATION,
                ConstantPrueba.COMMON_STRING_REGION_CORE,
                ConstantPrueba.COMMON_STRING_DEFAULT_VERSION, serviceRegistry);

        String securityRSJson = GenericRestClient.sendRequest(securityRQ,
                String.class, servicePojo.getEndPoint(),
                servicePojo.getAuthBasicUser(), servicePojo.getAuthBasicPwd(),
                servicePojo.getConnectTimeOut(), servicePojo.getReadTimeOut());

        return UtilJSON.parsePayload(securityRSJson, SecurityRS.class);

    }

    /**
     * Método que construye un <b>RegistryRQ</b> a partir de un
     * <b>RequestHeaderType</b>
     * 
     * @param messageId
     * @param serviceName
     * @param serviceOperation
     * @param classification
     * @param region
     * @param version
     * @return<code>RegistryRQ</code>
     */
    private static RegistryRQ getRegistryRQ(String messageId,
            String serviceName, String serviceOperation, String classification,
            String region, String version) {

        RegistryRQ registryRQ = new RegistryRQ();
        RegistryRequestType registryRequestType = new RegistryRequestType();
        HeaderRequestType headerRequestType = new HeaderRequestType();
        ConsumerType consumerType = new ConsumerType();
        ContainerType containerType = new ContainerType();
        BodyRequestType bodyRequestType = new BodyRequestType();
        LookupRequestType lookupRequestType = new LookupRequestType();

        registryRQ.setRegistryRequest(registryRequestType);
        registryRequestType.setHeader(headerRequestType);

        headerRequestType.setMessageId(null != messageId ? messageId
                : String.valueOf(new Date().getTime()));
        headerRequestType
                .setMessageDate(CommonServiceConsumerUtil.getCurrentTimeStamp(
                        ConstantPrueba.COMMON_FORMAT_DATE_TO_FRONT));

        headerRequestType.setType(ConstantPrueba.COMMON_STRING_EMPTY);
        headerRequestType.setOperation(ConstantPrueba.COMMON_STRING_EMPTY);

        headerRequestType.setConsumer(consumerType);

        /* Atibutos del consumer */
        consumerType.setId(ConstantPrueba.HEADER_CONSUMER_TYPE_ID);
        consumerType.setName(ConstantPrueba.HEADER_CONSUMER_TYPE_NAME);

        consumerType.setContainer(containerType);
        containerType.setId(ConstantPrueba.COMMON_STRING_CONTAINER_TYPE_ID);
        containerType.setName(ConstantPrueba.COMMON_STRING_CONTAINER_TYPE_NAME);

        /* Atributos del body */
        registryRequestType.setBody(bodyRequestType);

        bodyRequestType.setLookupRequest(lookupRequestType);

        lookupRequestType.setName(serviceName);
        lookupRequestType.setOperation(serviceOperation);
        lookupRequestType.setClassification(classification);
        lookupRequestType.setRegion(region);
        lookupRequestType.setVersion(version);

        return registryRQ;
    }

    /**
     * Método que consulta al serviceRegistry para resolver el endpoint del
     * servicio que se solicita
     * 
     * @param messageId
     * @param serviceName
     * @param serviceOperation
     * @param classification
     * @param region
     * @param version
     * @param serviceRegistry
     * @return <code>ServicePojo</code>
     * @throws CommonUtilException
     * @throws RestClientException
     */
    public static ServicePojo getServiceRegistryPojo(String messageId,
            String serviceName, String serviceOperation, String classification,
            String region, String version, ServiceRegistry serviceRegistry)
            throws CommonUtilException, RestClientException {
        ServicePojo servicePojo = new ServicePojo();
        RegistryRQ registryRQ = getRegistryRQ(messageId, serviceName,
                serviceOperation, classification, region, version);

        String registryRString = serviceRegistry.lookUpRegistryService(
                registryRQ, RegistryRS.class, serviceName, serviceOperation,
                classification, region, version);

        RegistryRS registryRS = UtilJSON.parsePayload(registryRString,
                RegistryRS.class);

        LookupResponseType lookupResponseType = registryRS.getRegistryResponse()
                .getBody().getLookupResponse();

        EndpointType endpointType = lookupResponseType.getEndpoint();
        TimeoutType timeout = lookupResponseType.getTimeout();

        String endPoint = GenericRestClient.getUrlRestServicesEndPoint(
                endpointType.getProtocol(), endpointType.getHost(),
                endpointType.getPort(), endpointType.getContext());

        Integer connectTimeOut = Integer.parseInt(timeout.getConnection());
        Integer readTimeOut = Integer.parseInt(timeout.getRead());

        servicePojo.setEndPoint(endPoint);
        servicePojo.setAuthBasicUser(endpointType.getAuthBasicUser());
        servicePojo.setAuthBasicPwd(endpointType.getAuthBasicPwd());
        servicePojo.setConnectTimeOut(connectTimeOut);
        servicePojo.setReadTimeOut(readTimeOut);

        return servicePojo;
    }

    /**
     * Metodo para validar respuesta de SecurityServices
     * 
     * @param securityResponse
     * @return boolean
     */
    public static boolean successResponse(
            SecurityResponseType securityResponse) {

        return null != securityResponse && null != securityResponse.getHeader()
                && ConstantPrueba.COMMON_STRING_SUCCESS_CODE.equals(
                        securityResponse.getHeader().getStatus().getCode());

    }

}
