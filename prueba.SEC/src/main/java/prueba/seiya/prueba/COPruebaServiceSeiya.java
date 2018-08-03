package prueba.seiya.prueba;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nequi.cmm.consumer.registry.ServiceRegistry;
import com.nequi.cmm.consumer.rest.util.CallServiceUtil;
import com.nequi.cmm.consumer.util.UtilJSON;
import com.nequi.mdw.common.tracerv7.service.GenericLogger;
import com.nequi.mdw.common.tracerv7.service.LoggerFactory;
import com.nequi.mdw.common.tracerv7.service.ServiceTypeEnum;

import prueba.exception.PruebaException;
import prueba.jpa.model.Cliente;
import prueba.jpa.service.impl.ClientJPAServiceIMPL;
import prueba.service.ServiceBean;
import prueba.util.CommonUtil;
import prueba.util.ConstantPrueba;
import pruebas.seiya.MessageRQ;
import pruebas.seiya.MessageRS;
import pruebas.seiya.PruebaRQType;
import pruebas.seiya.RequestHeaderType;

/**
 * Session Bean implementation class COPruebaServiceSeiya
 * 
 * @author juan.arboleda
 *
 */
@Stateless(mappedName = ConstantPrueba.COMMON_STRING_CO_PRUEBA_SERVICE_SEIYA)
@LocalBean
public class COPruebaServiceSeiya extends CallServiceUtil
        implements ServiceBean {

    @PersistenceContext(unitName = ConstantPrueba.COMMON_STRING_PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    private GenericLogger logger;
    private ServiceRegistry serviceRegistry;

    @PostConstruct
    void init() {
        logger = LoggerFactory.getLogger(ServiceTypeEnum.BUSSINES,
                COPruebaServiceSeiya.class);
    }

    /**
     * Metodo que implementa de la interfaz {@link ServiceBean}
     * 
     * @see ServiceBean#executeOperation(String)
     */
    @Override
    public String executeOperation(String request) {

        MessageRS messageRS = null;
        MessageRQ messageRQ = null;
        RequestHeaderType requestHeader = null;
        try {

            serviceRegistry = ServiceRegistry.getInstance();
            messageRQ = (MessageRQ) UtilJSON
                    .parsePayloadIgnoreUnKnownProperties(request,
                            MessageRQ.class);
            requestHeader = messageRQ.getRequestMessage().getHeader();

            PruebaRQType pruebaRQType = messageRQ.getRequestMessage().getBody()
                    .getPruebaRQ();

            Cliente client = ClientJPAServiceIMPL.getInstance()
                    .getClientByPhoneNumber(pruebaRQType.getPhoneNumber(), em);

            if (null == client) {
                logger.traceError(
                        ConstantPrueba.ERROR_MESSAGE_DB_QUERY_NO_RESULTS,
                        new PruebaException(
                                ConstantPrueba.ERROR_MESSAGE_DB_QUERY_NO_RESULTS));

                messageRS = CommonUtil.responseCustomMessage(requestHeader,
                        ConstantPrueba.ERROR_CODE_NO_RESULTS_BD,
                        ConstantPrueba.MDW_SYSTEM, ConstantPrueba.APP_SYSTEM,
                        logger, serviceRegistry);

                return CommonUtil.generateResponseAsString(messageRS, logger);
            }

        } catch (Exception e) {
            logger.traceError(ConstantPrueba.ERROR_DEFAULT_MSG, e);
            messageRS = CommonUtil.responseCustomMessage(requestHeader,
                    ConstantPrueba.ERROR_DEFAULT_CODE,
                    ConstantPrueba.MDW_SYSTEM, ConstantPrueba.APP_SYSTEM,
                    logger, serviceRegistry);

        }
        return CommonUtil.generateResponseAsString(messageRS, logger);
    }
}
