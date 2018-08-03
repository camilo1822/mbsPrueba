package prueba.jpa.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import prueba.exception.JPAException;
import prueba.jpa.model.TarjetaVirtual;
import prueba.jpa.service.VirtualCardJPAService;
import prueba.jpa.util.ConstantJPA;

/**
 * @author juan.arboleda
 *
 */
public class VirtualCardJPAServiceIMPL implements VirtualCardJPAService {

    private static VirtualCardJPAServiceIMPL instance = null;

    public static VirtualCardJPAServiceIMPL getInstance() {
        if (null == instance)
            instance = new VirtualCardJPAServiceIMPL();
        return instance;
    }

    @Override
    public void persistVirtualCard(TarjetaVirtual virtualCard, EntityManager em)
            throws JPAException {
        try {

            virtualCard.setFechaCreacion(new Timestamp(new Date().getTime()));
            virtualCard
                    .setUsuarioCreacion(ConstantJPA.COMMON_STRING_NEQUI_UPPER);
            em.persist(virtualCard);

        } catch (Exception e) {
            StringBuilder errorString = new StringBuilder(
                    VirtualCardJPAServiceIMPL.class.getCanonicalName());
            errorString.append(
                    ConstantJPA.COMMON_STRING_PERSIST_VIRTUAL_CARD_METHOD);
            throw new JPAException(errorString.toString(), e);
        }

    }

    @Override
    public void mergeVirtualCard(TarjetaVirtual virtualCard, EntityManager em)
            throws JPAException {
        try {

            virtualCard
                    .setFechaModificacion(new Timestamp(new Date().getTime()));
            virtualCard.setUsuarioModificacion(
                    ConstantJPA.COMMON_STRING_NEQUI_UPPER);
            em.merge(virtualCard);

        } catch (Exception e) {
            StringBuilder errorString = new StringBuilder(
                    VirtualCardJPAServiceIMPL.class.getCanonicalName());
            errorString.append(
                    ConstantJPA.COMMON_STRING_MERGE_VIRTUAL_CARD_METHOD);
            throw new JPAException(errorString.toString(), e);
        }

    }

    @Override
    public TarjetaVirtual getVirtualCard(long customerId, String cardId,
            EntityManager em) throws JPAException {

        Query query;
        try {
            query = em.createNamedQuery(
                    ConstantJPA.NAMED_QUERY_TARJETA_VIRTUAL_GET_CARD_NAME);

            query.setParameter(ConstantJPA.COMMON_STRING_CUSTOMER_ID,
                    customerId);

            query.setParameter(ConstantJPA.COMMON_STRING_CARD_ID, cardId);

            return (TarjetaVirtual) query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            StringBuilder errorString = new StringBuilder(
                    VirtualCardJPAServiceIMPL.class.getCanonicalName());
            errorString
                    .append(ConstantJPA.COMMON_STRING_GET_VIRTUAL_CARD_METHOD);
            throw new JPAException(errorString.toString(), e);
        }

    }

}
