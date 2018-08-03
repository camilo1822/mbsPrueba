package prueba.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import prueba.exception.EnumJPAException;
import prueba.exception.JPAException;
import prueba.jpa.model.Cliente;
import prueba.jpa.service.ClientJPAService;
import prueba.jpa.util.ConstantJPA;

/**
 * @author juan.arboleda
 *
 */
public class ClientJPAServiceIMPL implements ClientJPAService {

    private static ClientJPAServiceIMPL instance = null;

    public static ClientJPAServiceIMPL getInstance() {
        if (null == instance)
            instance = new ClientJPAServiceIMPL();
        return instance;
    }

    @Override
    public Cliente getClientByPhoneNumber(String phoneNumber, EntityManager em)
            throws JPAException {

        Cliente cliente = null;
        try {

            Query query = em
                    .createNamedQuery(ConstantJPA.QUERY_CLIENTE_BY_PHONENUMBER);
            query.setParameter(ConstantJPA.COMMON_PARAMETER_PHONENUMBER,
                    phoneNumber);
            cliente = (Cliente) query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new JPAException(EnumJPAException.DB_ERROR,
                    this.getClass().getName()
                            + ConstantJPA.COMMON_STRING_GET_CLIENT_PHONENUMBER_METHOD,
                    e);
        }
        return cliente;

    }

}
