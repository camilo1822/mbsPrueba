/**
 * 
 */
package pruebas.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import pruebas.service.PruebaService;

/**
 * @author ricardo.paredes@pragma.com.co Clase de configuración de los Servicios
 *         Rest de Middleware
 *
 */
public class ConfigServices extends Application {

    @Override
    /**
     * Metodo para agregar Interfaces de Servicios Rest. Se deben agregar las
     * clases que expongan servicios Rest
     */
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(PruebaService.class);
        return classes;
    }
}
