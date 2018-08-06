package prueba.util;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author juan.arboleda
 *
 */
@Stateless(mappedName = ConstantPrueba.COMMON_STRING_SEND_JMS_MGE_SERVICE_BEAN)
@LocalBean
public class SendJmsMessageServiceBean {

    /**
     * Metodo para enviar mensaje a cola JMS
     * 
     * @param jmsStringMessage
     * @param queueJDNI
     * @throws JMSException
     * @throws NamingException
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void sendJmsStringMessage(String jmsStringMessage, String queueJDNI)
            throws JMSException, NamingException {

        InitialContext initialContext = null;
        Context myEnv = null;
        QueueConnectionFactory sampleQCF;
        QueueConnection queueConn = null;
        Queue backoutQ;
        TextMessage textMsg;

        QueueSender queueSender = null;
        QueueSession queueSession = null;

        try {
            initialContext = new InitialContext();
            myEnv = (Context) initialContext
                    .lookup(ConstantPrueba.COMMON_STRING_ENVIROMENT);

            sampleQCF = (QueueConnectionFactory) myEnv
                    .lookup(ConstantPrueba.COMMON_STRING_QUEUE_FACTORY);

            queueConn = (QueueConnection) sampleQCF.createConnection();

            queueSession = queueConn.createQueueSession(false, 0);

            backoutQ = (Queue) myEnv.lookup(queueJDNI);

            queueSender = queueSession.createSender(backoutQ);

            textMsg = queueSession.createTextMessage();

            textMsg.setText(jmsStringMessage);

            queueSender.send(textMsg);

        } finally {

            if (null != queueSender) {
                queueSender.close();
            }

            if (null != queueSession) {
                queueSession.close();
            }

            if (null != queueConn) {
                queueConn.close();
            }

            if (null != myEnv) {
                myEnv.close();
            }

            if (null != initialContext) {
                initialContext.close();
            }
        }
    }

}
