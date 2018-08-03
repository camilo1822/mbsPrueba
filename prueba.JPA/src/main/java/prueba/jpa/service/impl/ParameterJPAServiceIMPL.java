/**
 * 
 */
package prueba.jpa.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import prueba.exception.EnumJPAException;
import prueba.exception.JPAException;
import prueba.jpa.model.Parametro;
import prueba.jpa.service.ParameterJPAService;
import prueba.jpa.util.ConstantJPA;

/**
 * @author juan.arboleda
 *
 */
public class ParameterJPAServiceIMPL implements ParameterJPAService {

    private static ParameterJPAServiceIMPL instance;

    public static ParameterJPAServiceIMPL getInstance() {
        if (null == instance)
            instance = new ParameterJPAServiceIMPL();
        return instance;
    }
    
    @Override
    public List<Parametro> getParameterValue(String tipoParametroId,
            String countryCode, EntityManager em) throws JPAException {

        try {
            Query query = em
                    .createNamedQuery(ConstantJPA.QUERY_PARAMETER_BY_REGION);
            query.setParameter(ConstantJPA.COMMON_STRING_TIPO_PARAMETRO_ID,
                    Long.parseLong(tipoParametroId));
            query.setParameter(ConstantJPA.COMMON_STRING_TIPO_COUNTRY_ID,
                    countryCode);
            em.getEntityManagerFactory().getCache().evict(Parametro.class);

            // si llegan varios resultados tomará solo el primero
            List<Parametro> resultado = (List<Parametro>)query.getResultList();
            return resultado;

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new JPAException(EnumJPAException.DB_ERROR,
                    this.getClass().getName()
                            + ConstantJPA.COMMON_STRING_GET_PARAMETER_METHOD,
                    e);
        }
    }
}
