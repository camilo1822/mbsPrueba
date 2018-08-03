/**
 * 
 */
package prueba.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;

import prueba.exception.JPAException;
import prueba.jpa.model.Parametro;

/**
 * @author juan.arboleda
 *
 */
public interface ParameterJPAService {

    /**
     * Consulta de parametros por pais y tipoparametro
     * 
     * 
     * @param tipoParametroId
     * @param countryCode
     * @param em
     * @return Valor del parametro
     * @throws JPAException
     */
    public List<Parametro> getParameterValue(String tipoParametroId,
            String countryCode, EntityManager em) throws JPAException;

}
