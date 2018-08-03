package prueba.jpa.service;

import javax.persistence.EntityManager;

import prueba.exception.JPAException;
import prueba.jpa.model.TarjetaVirtual;

/**
 * @author juan.arboleda
 *
 */
public interface VirtualCardJPAService {

    /**
     * Metodo para persistir tarjeta virtual
     * 
     * @param virtualCard
     * @param em
     * @throws JPAException
     */
    public void persistVirtualCard(TarjetaVirtual virtualCard, EntityManager em)
            throws JPAException;

    /**
     * Metodo para consultar tarjeta virtual de un usuario
     * 
     * @param customerId
     * @param cardId
     * @param em
     * @return <code>TarjetaVirtual</code>
     * @throws JPAException
     */
    public TarjetaVirtual getVirtualCard(long customerId, String cardId,
            EntityManager em) throws JPAException;

    /**
     * Metodo para actualizar tarjeta virtual
     * 
     * @param virtualCard
     * @param em
     * @throws JPAException
     */
    public void mergeVirtualCard(TarjetaVirtual virtualCard, EntityManager em)
            throws JPAException;

}
