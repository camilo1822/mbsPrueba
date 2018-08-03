/**
 * 
 */
package prueba.service;

import javax.ejb.Local;

import prueba.exception.PruebaException;

/**
 * @author eduardo.altamar
 *
 */
@Local
public interface ServiceBean {

    /**
     * Metodo que expone la operacion principal del servicio.
     * 
     * @param request
     * @return respuesta del servicio en formato JSON.
     * @throws PruebaException
     */
    public String executeOperation(String request) throws PruebaException;

}
