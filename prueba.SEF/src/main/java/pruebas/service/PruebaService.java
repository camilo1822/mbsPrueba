/**
 * 
 */
package pruebas.service;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nequi.cmm.consumer.exception.CommonUtilException;
import com.nequi.cmm.consumer.util.UtilJSON;
import com.nequi.mdw.common.tracerv7.service.GenericLogger;
import com.nequi.mdw.common.tracerv7.service.LoggerFactory;
import com.nequi.mdw.common.tracerv7.service.ServiceTypeEnum;

import prueba.exception.PruebaException;
import prueba.factory.PruebaFactory;
import prueba.service.ServiceBean;
import prueba.util.ConstantPrueba;
import prueba.util.MessageTracerUtil;
import pruebas.seiya.MessageRQ;
import pruebas.seiya.MessageRS;
import pruebas.seiya.RequestHeaderType;
import pruebas.util.BuildMessageServiceUtil;

/**
 * @author juan.arboleda
 *
 */
@Path(ConstantPrueba.FACADE_PRUEBAS_SERVICES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class PruebaService {

    private GenericLogger logger;

    @EJB
    private PruebaFactory pruebaFactory;

    /**
     * 
     */
    @PostConstruct
    public void init() {
        logger = LoggerFactory.getLogger(ServiceTypeEnum.BUSSINES,
                PruebaService.class);
    }

    /**
     * Fachada del dominio de negocio para cancelar una tarjetas Nequi
     * 
     * @param request
     * @return {@link String}
     */
    @Path(ConstantPrueba.SERVICE_OPERATION_PRUEBA)
    @javax.ws.rs.POST
    public String prueba(String request) {
        MessageTracerUtil.traceDebug(ConstantPrueba.INITIAL_RQ, request,
                logger);
        String response = null;
        MessageRQ messageRQ = null;
        MessageRS messageRS = null;

        try {

            messageRQ = (MessageRQ) UtilJSON
                    .parsePayloadIgnoreUnKnownProperties(request,
                            MessageRQ.class);

            /* Se traza la petición */
            MessageTracerUtil.traceRequestMessage(
                    messageRQ.getRequestMessage().getHeader(), request, logger);

            String region = messageRQ.getRequestMessage().getHeader()
                    .getDestination().getServiceRegion();

            String version = messageRQ.getRequestMessage().getHeader()
                    .getDestination().getServiceVersion();

            ServiceBean bean = pruebaFactory.getServiceBean(region,
                    version);

            response = bean.executeOperation(request);

            messageRS = UtilJSON.parsePayload(response, MessageRS.class);

        } catch (CommonUtilException | PruebaException e) {
            logger.traceError(e.getMessage(), e);

            RequestHeaderType headerRQ = null;

            if (null != messageRQ) {
                headerRQ = messageRQ.getRequestMessage().getHeader();
            }

            messageRS = BuildMessageServiceUtil.generateResponse(headerRQ,
                    ConstantPrueba.ERROR_DEFAULT_CODE,
                    ConstantPrueba.ERROR_DEFAULT_MESSAGE);
            try {
                response = UtilJSON.parseObjectToString(messageRS);
            } catch (IOException ex) {
                MessageTracerUtil.traceException(
                        ConstantPrueba.ERROR_TO_PARSE_RESPONSE, ex, logger);
            }
        }
        MessageTracerUtil.traceResponseMessage(
                messageRS.getResponseMessage().getHeader(), response, logger);
        return response;
    }
  
}