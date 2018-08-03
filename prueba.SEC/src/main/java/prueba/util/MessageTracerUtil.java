/**
 * 
 */
package prueba.util;

import java.io.IOException;

import com.ibm.xml.crypto.util.Base64;
import com.nequi.cmm.consumer.util.UtilJSON;
import com.nequi.mdw.common.tracerv7.service.GenericLogger;
import com.nequi.mdw.common.tracerv7.util.TypeEnum;

/**
 * @author juan.arboleda
 *
 */
public class MessageTracerUtil {

    /**
     * Constructor Privado
     */
    private MessageTracerUtil() {

    }

    /**
     * Método utilidad para trazar los JSON de Respuesta
     * 
     * @param statusCode
     * @param messageID
     * @param responseDate
     * @param body
     * @param logger
     * @param keyLog
     * @param valueLog
     */
    public static void traceResponseMessage(String statusCode, String messageID,
            String responseDate, String body, GenericLogger logger,
            String keyLog, String valueLog) {

        StringBuilder traceInfo = buildResponseTraceInfo(statusCode, messageID,
                responseDate, body, Boolean.FALSE);

        if (null != keyLog) {

            traceInfo.append(keyLog);
            traceInfo.append(valueLog);
            traceInfo.append(ConstantPrueba.CLOSE);
        }

        logger.traceDebug(traceInfo.toString());

    }

    /**
     * Método que forma una traza de Request Message y la registra en el log si
     * esta habilitado
     * 
     * @param serviceName
     * @param messageID
     * @param serviceOperation
     * @param requestDate
     * @param serviceRegion
     * @param serviceVersion
     * @param body
     * @param logger
     */
    public static void traceRequestMessage(String serviceName, String messageID,
            String serviceOperation, String requestDate, String serviceRegion,
            String serviceVersion, String body, GenericLogger logger) {

        StringBuilder traceInfo = buildRequestTraceInfo(serviceName, messageID,
                serviceOperation, requestDate, serviceRegion, serviceVersion,
                body, Boolean.FALSE);

        logger.traceInfo(traceInfo.toString());

    }

    /**
     * Método que forma una traza de Request Message y la registra en el log si
     * esta habilitado para mensaje muy largos
     * 
     * @param serviceName
     * @param messageID
     * @param serviceOperation
     * @param requestDate
     * @param serviceRegion
     * @param serviceVersion
     * @param body
     * @param logger
     */
    public static void traceRequestLargeMessage(String serviceName,
            String messageID, String serviceOperation, String requestDate,
            String serviceRegion, String serviceVersion, String body,
            GenericLogger logger) {

        StringBuilder traceInfo = buildRequestTraceInfo(serviceName, messageID,
                serviceOperation, requestDate, serviceRegion, serviceVersion,
                body, Boolean.TRUE);

        logger.traceInfo(traceInfo.toString());
    }

    /**
     * Método para trazar los JSON de Respuesta
     * 
     * @param statusCode
     * @param messageID
     * @param responseDate
     * @param body
     * @param logger
     */
    public static void traceResponseMessage(String statusCode, String messageID,
            String responseDate, String body, GenericLogger logger) {

        StringBuilder traceInfo = buildResponseTraceInfo(statusCode, messageID,
                responseDate, body, Boolean.FALSE);
        logger.traceInfo(traceInfo.toString());

    }

    /**
     * Método para trazar los JSON de Respuesta muy largas.
     * 
     * @param statusCode
     * @param messageID
     * @param responseDate
     * @param body
     * @param logger
     */
    public static void traceResponseLargeMessage(String statusCode,
            String messageID, String responseDate, String body,
            GenericLogger logger) {
        StringBuilder traceInfo = buildResponseTraceInfo(statusCode, messageID,
                responseDate, body, Boolean.TRUE);
        logger.traceInfo(traceInfo.toString());

    }

    /**
     * Método que construye la traza para el log del response.
     * 
     * @param statusCode
     * @param messageID
     * @param responseDate
     * @param body
     * @param largeMessage
     * @return StringBuilder
     */
    private static StringBuilder buildResponseTraceInfo(String statusCode,
            String messageID, String responseDate, String body,
            boolean largeMessage) {

        StringBuilder traceInfo;

        traceInfo = new StringBuilder(ConstantPrueba.RESPONSE_INIT);

        traceInfo.append(ConstantPrueba.STATUSCODE);
        traceInfo.append(statusCode);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.MESSAGEID);
        traceInfo.append(messageID);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.RSDATE);
        traceInfo.append(responseDate);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.PAYLOAD_RS);
        if (null != body) {
            traceInfo.append(Base64.encode(body.getBytes()));
            traceInfo.append(ConstantPrueba.CLOSE);
        } else {
            traceInfo.append(ConstantPrueba.NO_BODY);
        }
        return traceInfo;
    }

    /**
     * Método que construye la traza para el log del request.
     * 
     * @param serviceName
     * @param messageID
     * @param serviceOperation
     * @param requestDate
     * @param serviceRegion
     * @param serviceVersion
     * @param body
     * @param largeMessage
     * @return StringBuilder
     */
    private static StringBuilder buildRequestTraceInfo(String serviceName,
            String messageID, String serviceOperation, String requestDate,
            String serviceRegion, String serviceVersion, String body,
            boolean largeMessage) {

        StringBuilder traceInfo = new StringBuilder(
                ConstantPrueba.REQUEST_INIT);

        traceInfo.append(serviceName);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.MESSAGEID);
        traceInfo.append(messageID);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.OPERATION);
        traceInfo.append(serviceOperation);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.RQDATE);
        traceInfo.append(requestDate);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.RQREGION);
        traceInfo.append(serviceRegion);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.RQVERSION);
        traceInfo.append(serviceVersion);
        traceInfo.append(ConstantPrueba.CLOSE);
        traceInfo.append(ConstantPrueba.PAYLOAD_RQ);

        if (null != body) {
            traceInfo.append(Base64.encode(body.getBytes()));
            traceInfo.append(ConstantPrueba.CLOSE);
        } else {
            traceInfo.append(ConstantPrueba.NO_BODY);
        }

        return traceInfo;
    }

    /**
     * Este método traza un response
     * 
     * @param header
     * @param payload
     * @param logger
     */
    public static void traceResponseMessage(Object header, Object payload,
            GenericLogger logger) {

        String headerString = ConstantPrueba.COMMON_STRING_EMPTY;
        String bodyString = ConstantPrueba.COMMON_STRING_EMPTY;
        try {
            if (null != header) {
                headerString = UtilJSON.parseObjectToString(header);
            }
            if (payload != null) {
                bodyString = UtilJSON.parseObjectToString(payload);
            }
            logger.traceInfo(headerString, bodyString, TypeEnum.RS);
        } catch (Exception e) {
            logger.traceError(ConstantPrueba.PARSE_FAILED, e);
        }

    }

    /**
     * Este método traza un request
     * 
     * @param header
     * @param payload
     * @param logger
     */
    public static void traceRequestMessage(Object header, Object payload,
            GenericLogger logger) {
        String headerString = ConstantPrueba.COMMON_STRING_EMPTY;
        String bodyString = ConstantPrueba.COMMON_STRING_EMPTY;
        try {
            if (null != header) {
                headerString = UtilJSON.parseObjectToString(header);
            }
            if (payload != null) {
                bodyString = UtilJSON.parseObjectToString(payload);
            }
            logger.traceInfo(headerString, bodyString, TypeEnum.RQ);
        } catch (Exception e) {
            logger.traceError(ConstantPrueba.PARSE_FAILED, e);
        }
    }

    /**
     * Este método traza una exepcion
     * 
     * @param message
     * @param ex
     * @param logger
     */
    public static void traceException(String message, Throwable ex,
            GenericLogger logger) {
        logger.traceError(message, ex);
    }

    /**
     * Este método traza Debug
     * 
     * @param message
     * @param object
     * @param logger
     */
    public static void traceDebug(String message, Object object,
            GenericLogger logger) {
        StringBuilder sb = new StringBuilder();
        if (null == message) {
            message = ConstantPrueba.COMMON_STRING_EMPTY;
        }
        sb.append(message);
        sb.append(ConstantPrueba.COMMON_STRING_COLON);
        if (null != object) {
            try {
                sb.append(UtilJSON.parseObjectToString(object));
                logger.traceDebug(sb.toString());
            } catch (IOException e) {
                logger.traceError(ConstantPrueba.PARSE_FAILED, e);
            }
        } else {
            sb.append(ConstantPrueba.NO_BODY);
            logger.traceDebug(sb.toString());
        }
    }
}
