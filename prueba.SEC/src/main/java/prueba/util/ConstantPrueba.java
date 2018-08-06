/**
 * 
 */
package prueba.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author juan.arboleda
 *
 */
public final class ConstantPrueba {

    // PARAMETROS GENERALES

    public static final String COMMON_STRING_COLON = ":";
    public static final String COMMON_STRING_SLASH = "/";
    public static final String COMMON_STRING_SUCCESS_MAYUS = "SUCCESS";
    public static final String COMMON_STRING_SUCCESS_CODE = "0";
    public static final String COMMON_STRING_ZERO = "0";
    public static final int COMMON_INT_ZERO = 0;
    public static final String COMMON_STRING_ONE = "1";
    public static final String COMMON_STRING_TWO = "2";
    public static final String COMMON_FORMAT_DATE_TO_FRONT = "yyyy-MM-dd HH:mm:ss";

    public static final String COMMON_STRING_UTF_8 = "UTF-8";
    public static final String COMMON_STRING_MD5 = "MD5";

    public static final String COMMON_STRING_EMPTY = "";
    public static final String COMMON_STRING_BLANK_SPACE = " ";
    public static final String COMMON_STRING_IPADDRESS = "ipAddress";
    public static final String COMMON_STRING_NA = "N/A";
    public static final String COMMON_STRING_REGION_CORE = "001";
    public static final String COMMON_STRING_REGION_PANAMA = "P001";
    public static final String COMMON_STRING_REGION_COLOMBIA = "C001";

    public static final String COMMON_STRING_DEFAULT_VERSION = "1.0.0";
    public static final String COMMON_STRING_IKKI = "1.0.1";
    public static final String COMMON_STRING_YOGA = "1.0.2";

    public static final String ENV_DEFAULT_CONECTION_TIMEOUT = "10000";
    public static final String ENV_DEFAULT_READ_TIMEOUT = ENV_DEFAULT_CONECTION_TIMEOUT;

    public static final Integer DEFAULT_CONNECT_TIME_OUT = 10000;
    public static final Integer DEFAULT_READ_TIME_OUT = 10000;

    // SISTEMAS
    public static final String SYS_MBS = "MBS";
    public static final String APP_SYSTEM = "APP";
    public static final String MDW_SYSTEM = "MDW";
    public static final String DB_SYSTEM = "BD_SHERPA";
    public static final String API_SYSTEM = "API";
    public static final String AGI_SYSTEM = "IS_API_GATEWAY";
    // CHANNEL
    public static final Map<String, String> CHANNELS;
    public static final String CHANNEL_APP = "mf-001";

    static {
        CHANNELS = new HashMap<>();
        CHANNELS.put(CHANNEL_APP, APP_SYSTEM);
    }

    // DEBUG
    public static final String INITIAL_RQ = "Request entrante: ";

    public static final String COMMON_STRING_CHANNEL_ID = "MBS-609";
    public static final String COMMON_STRING_CHANNEL_NAME = "MBS_FINANCIAL_SERVICE";

    public static final String HEADER_CONSUMER_TYPE_ID = "MBS-FIS.609";
    public static final String HEADER_CONSUMER_TYPE_NAME = "MBS.FinancialServices.609";

    public static final String HEADER_PROVIDER_TYPE_ID = "AIACOS-FIS.609";
    public static final String HEADER_PROVIDER_TYPE_NAME = "AIACOS-FinancialServices.609";

    public static final String COMMON_STRING_CONTAINER_TYPE_ID = "WAS-Node";
    public static final String COMMON_STRING_CONTAINER_TYPE_NAME = "WebSphere Application Server";

    public static final String INTEGRATION_CLASIFICATION = "INTEGRATION";

    // Constantes para utilidades del TraceManager
    public static final String CLOSE = "]";
    public static final String OPEN = "[";
    public static final String MESSAGEID = "[MessageID:";
    public static final String STATUSCODE = "[StatusCode:";
    public static final String CLIENTID = "[clientID:";
    public static final String CLIENT_TYPE = "[clientType:";
    public static final String OPERATION = "[Operation:";
    public static final String REQUEST_INIT = "[REQUEST][ServiceName:";
    public static final String RQDATE = "[Request Date:";
    public static final String RQREGION = "[Request Region:";
    public static final String RQVERSION = "[Request Version:";
    public static final String PAYLOAD_RQ = "[PAYLOAD RQ: ]";
    public static final String RESPONSE_INIT = "[RESPONSE]";
    public static final String RSDATE = "[Response Date:";
    public static final String RSREGION = "[Response Region:";
    public static final String RSVERSION = "[Response Version:";
    public static final String PAYLOAD_RS = "[PAYLOAD RS: ]";
    public static final String NO_BODY = "NO PAYLOAD";
    public static final String COMMON_STRING_GET = "get";

    // Constantes DIFIE HELLMAN
    public static final String REGISTRY_SERVICE_NAME_DIFFIE_HELLMAN = "SecurityManager";
    public static final String REGISTRY_OPERATION_DIFFIE_HELLMAN = REGISTRY_SERVICE_NAME_DIFFIE_HELLMAN;
    public static final String COMMON_STRING_DECRYPT = "decrypt";
    public static final String COMMON_STRING_ENCRYPT = "encrypt";

    public static final String MESSAGE_RECEIVED_AT = "MessageReceived at:";

    // PARAMETROS DE HOMOLOGACION DE ERRORES
    public static final String ERROR_CODE_DB_CLIENT_NOT_FOUND = "1L";
    public static final String ERROR_CODE_DB_POCKET = "2L";
    public static final String ERROR_CODE_DB_TRANSACTION = "3L";
    public static final String ERROR_CODE_DIFFIE_HELLMAN = "5L";
    public static final String ERROR_CODE_INVALID_DATA = "6L";
    public static final String ERROR_CODE_NO_RESULTS_BD = "9L";
    public static final String ERROR_CODE_PARSING_ERROR = "10L";
    public static final String ERROR_CODE_COMMUNICATION_IIB = "18L";
    public static final String ERROR_CODE_MBS_FIS_602 = "24L";
    public static final String ERROR_PARSE = "17L";
    public static final String ERROR_DEFAULT_CODE = "500";
    public static final String ERROR_TO_GET_BANKS_DB = "505";
    public static final String ERROR_CODE_DB_OPERATION = "450";
    public static final String ERROR_CODE_IIB_TIME_OUT = "10-504";
    public static final String ERROR_CODE_INVALID_DATA_MDW = "38L";
    public static final String ERROR_CODE_TIMEOUT_BROKER = "11-18L";
    public static final String ERROR_CODE_IIB_TIME_OUT_WITHOUT_SYSTEM = "504";
    public static final String ERROR_CODE_REST_CONSUMER_ERROR = "45L";
    public static final String ERROR_CODE_INVALID_PARAMETER = "40L";
    public static final String ERROR_CODE_CUSTOMER_ALREADY_HAS_A_CARD_ASSIGNED = "55L";
    public static final String ERROR_CODE_GET_CARD_BALANCE = "56L";
    public static final String ERROR_CODE_GET_NEQUI_CARD_NOT_DATA = "57L";
    public static final String ERROR_CODE_DATA_NOT_FOUND_DYNAMO = "42-20-08A";
    public static final String ERROR_CODE_DATA_NOT_FOUND_API = "30-5L";
    public static final String ERROR_CODE_RECORD_ALREADY_EXISTS = "CCSB000310";

    // MENSAJES DE ERROR MDW
    public static final String ERROR_MESSAGE_DB_QUERY_NO_RESULTS = "Error No se encuentra registro en BD";
    public static final String ERROR_MESSAGE_GET_POCKECT_NO_RESULTS = "Error consultando bolsillo Tarjeta virtual";
    public static final String ERROR_MESSAGE_INVALID_PAREMETER = "Error de validación de campos - campos vacios";
    public static final String ERROR_MESSAGE_INVALID_PAREMETER_DFH = "Error de validación de campos de Seguridad - falta llave para cifrar";
    public static final String ERROR_MESSAGE_CUSTOMER_DOC_TYPE_NOT_ALLOWED = "Error el tipo de documento del cliente no esta permitido";
    public static final String ERROR_MESSAGE_CUSTOMER_ALREADY_HAS_A_CARD_ASSIGNED = "Error el cliente ya tiene una tarjeta asignada";
    public static final String ERROR_MESSAGE_IIB_SOFTOKEN = "Error al tratar de validar softToken ";
    public static final String ERROR_MESSAGE_IIB_COMMUNICATION = "Error de Proveedor: Broker";
    public static final String ERROR_MESSAGE_DIFFIE_HELLMAN_DECRYPT = "ERROR - Se obtuvo código %1$s al descifrar mensaje desde el servicio %2$s";
    public static final String ERROR_MESSAGE_SERCIVE_REGISTRY = "ERROR - Se obtuvo código %1$s al llamar service registry";
    public static final String ERROR_PARSING = "Error al Parsear el JSON:";

    public static final String ERROR_MESSAGE_DIFFIE_HELLMAN = "Error al consumir servicio de diffie hellman";
    public static final String ERROR_MESSAGE_TRANSFER_BEAN = "ERROR - Ocurrió un error al llamar el ejb de transferencias";

    public static final String ERROR_MESSAGE_DB_CLIENT_NOT_FOUND = "Error al consultar el cliente no encontrado";
    public static final String ERROR_MESSAGE_PARSING_ERROR = "Error al parsear mensaje";

    public static final String ERROR_DEFAULT_MESSAGE = "¡Uy! Algo va mal, ya vamos a solucionarlo.";
    public static final String ERROR_TO_PARSE_RQ = "Error al parsear el request";
    public static final String ERROR_TO_CALL_REST = "Error al invocar el servicio rest";
    public static final String ERROR_DB_OPERATION = "Error genérico de base de datos";
    public static final String ERROR_MESSAGE_JMS_MESSAGE = "Error al procesar mensaje JMS";
    public static final String ERROR_DEFAULT_MSG = "Middleware Internal Error";
    // HOMOLOGADOR
    public static final String HOMOLOGATOR_SERVICE_NAME = "HomologatorService";
    public static final String HOMOLOGATOR_SERVICE_OPERATION = "HomologateError";
    public static final String ERROR_TO_HOMOLOGATE_ERROR = "Error al homologar un error";
    public static final String ERROR_GET_NEQUI_CARDS = "Error al consultar las tarjetas del usuario";
    public static final String ERROR_ASSIGN_NEQUI_CARD_FINACLE = "Error al asignar tarjeta en FINACLE";
    public static final String ERROR_RECHARGE_NEQUI_CARD_FINACLE = "Error al recargar tarjeta NEQUI";
    public static final String ERROR_ASSIGN_NEQUI_CARD_DYNAMO = "Error al asignar tarjeta en DYNAMO";
    public static final String ERROR_UPDATE_NEQUI_CARD_STATUS = "Error al actualizar el estado tarjeta en Dynamo";
    public static final String ERROR_GET_NEQUI_CARD_BALANCE = "Error al consultar saldo de la tarjeta NEQUI";
    public static final String ERROR_CANCEL_CARD = "Error al cancelar la tarjeta NEQUI";
    public static final String PARSE_FAILED = "Error al parse un object a un String";
    public static final String ERROR_TO_PARSE_RESPONSE = "Error al parsear el response";
    public static final String ERROR_REST_CLIENT_HOMOLOGATE_ERROR = "Error por cliente REST al homologar error";
    public static final String ERROR_BACKOUT = "Error al intentar enviar JMS";
    public static final Integer CONVERTO_TO_MILISECONDS_1000 = 1000;

    public static final String COMMON_STRING_PERSISTENCE_UNIT_NAME = "JPAManager";

    public static final String COMMON_STRING_PRUEBA_FACTORY = "PruebaFactory";
    public static final String COMMON_STRING_REISSUE_CARD_FACTORY = "ReissueCardFactory";
    public static final String COMMON_STRING_CO_PRUEBA_FACTORY = "COPruebaFactory";
    public static final String COMMON_STRING_CO_REISSUE_CARD_FACTORY = "COReissueCardFactory";
    public static final String COMMON_STRING_CO_PRUEBA_SERVICE_SEIYA = "COPruebaServiceSeiya";
    public static final String COMMON_STRING_CO_REISSUE_CARD_SERVICE_SEIYA = "COReissueCardServiceSeiya";
    public static final String SERVICE_OPERATION_NEQUI_CARDS_SERVICES = "NequiCardsServices";

    // Facade
    public static final String FACADE_PRUEBAS_SERVICES_PATH = "/services/Pruebas";
    public static final String SERVICE_OPERATION_PRUEBA = "/prueba";
    public static final String SERVICE_OPERATION_REISSUE_CARD = "/reissueCard";

    public static final String COMMON_STRING_VIRTUAL_CARD_CANCELLED_STATUS = "4";
    public static final String COMMON_STRING_VIRTUAL_CARD_ASSIGNED_STATUS = "2";
    public static final String SERVICE_NAME_API_GATEWAY = "APIGateway406Service";
    public static final String SERVICE_OPERATION_SEND_API_REQUEST = "sendApiRequest";
    public static final String SERVICE_OPERATION_AGI_UPDATE_CARD = "updateCardStatus";

    // Atributos para petición hacia IIB (cancelCard)
    public static final String NAME_CARD = "Card";
    public static final String NAMESPACE_CARD = "http://co.bancaDigital/nequi/services/ProductServices/Card/v1.0";
    public static final String OPERATION_CANCEL_CARD = "cancelCard";
    public static final String REQUEST_CANCEL_CARD = "cancelCardRQ";
    public static final String RESPONSE_CANCEL_CARD = "cancelCardRS";

    // Atributos para petición hacia IIB (rechargeCard)
    public static final String OPERATION_RECHARGE_CARD = "rechargeCard";
    public static final String REQUEST_RECHARGE_CARD = "rechargeCardRQ";
    public static final String RESPONSE_RECHARGE_CARD = "rechargeCardRS";

    // Atributos para petición hacia IIB (softoken)
    public static final String NAME_MANAGMENT_MSG = "ManagementMessaging";
    public static final String NAMESPACE_SECURITY_MANAGMENT_MSG = "http://co.bancaDigital/nequi/services/SecurityServices/ManagementMessaging/v1.0";
    public static final String OPERATION_VALIDATE_SOFTTOKEN = "validateSoftToken";
    public static final String VALIDATETOKEN_RQ = "softTokenRQ";
    public static final String VALIDATETOKEN_RS = "softTokenRS";

    // Atributos para petición hacia IIB (consultarBolsillos)
    public static final String NAME_POCKETS = "Bolsillos";
    public static final String NAMESPACE_POCKETS = "http://co.bancaDigital/sherpa/servicio/bolsillos/v1.0";
    public static final String OPERATION_GET_POCKETS = "consultarBolsillos";
    public static final String REQUEST_GET_POCKETS = "getPocketRQ";
    public static final String RESPONSE_GET_POCKETS = "getPocketRS";

    public static final String COMMON_STRING_NEQUI_CARD_PARAMETERS = "169";
    public static final String COMMON_STRING_CANCEL_CARD_REASON = "cancelCardReason";
    public static final String COMMON_STRING_CANCEL_CARD_REASON_DEFAULT = "Cancelación voluntaria.";
    public static final String COMMON_STRING_VIRTUAL_CARD_POCKET_TYPE = "6";

    public static final String COMMON_STRING_SERVICE_FINANCIAL_608 = "FinancialService608";
    public static final String SERVICE_OPERATION_ASSIGN_CARD = "assignCard";
    public static final String BUSINESS_CLASSIFICATION = "BUSINESS";
    public static final String COMMON_STRING_REQUEST_ORIGIN_MDW = COMMON_STRING_TWO;
    public static final String COMMON_STRING_CHARGE_CARD_PARAMETER = "C";
    public static final String COMMON_STRING_CHARGE_PARAMETER = "Charge";
    public static final String COMMON_STRING_CHARGE_CARD_PARAMETER_DEFAULT = "B001";
    public static final String COMMON_STRING_ERROR_CLIENT_WITHOUT_TARGET = "2-CCSB000675";
    public static final String COMMON_STRING_ERROR_ASSIGN_TARGET = "64L";
    
    
    public static final String COMMON_STRING_SEND_JMS_MGE_SERVICE_BEAN = "SendJmsMessageServiceBean";
    public static final String COMMON_STRING_QUEUE_FACTORY = "jms/SHP-CF";
    public static final String COMMON_STRING_ENVIROMENT = "java:comp/env";
    public static final String COMMON_STRING_COLA_PROMOCIONES = "jms/BCO-PromotionCntlr.Q";

    private ConstantPrueba() {
    }

}
