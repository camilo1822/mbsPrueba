package prueba.jpa.service;

import javax.persistence.EntityManager;

import prueba.exception.JPAException;
import prueba.jpa.model.Cliente;

/**
 * @author juan.arboleda
 *
 */
public interface ClientJPAService {

    /**
     * Consulta de cliente por el número de celular
     * 
     * @param phoneNumber
     * @param em
     * @return Cliente
     * @throws JPAException
     */
    public Cliente getClientByPhoneNumber(String phoneNumber, EntityManager em)
            throws JPAException;

}
