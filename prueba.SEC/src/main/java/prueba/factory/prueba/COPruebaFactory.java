package prueba.factory.prueba;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import prueba.service.ServiceBean;
import prueba.util.ConstantPrueba;

/**
 * Session Bean implementation class COPruebaFactory
 */
@Singleton(mappedName = ConstantPrueba.COMMON_STRING_CO_PRUEBA_FACTORY)
@LocalBean
public class COPruebaFactory {

    @EJB(beanName = ConstantPrueba.COMMON_STRING_CO_PRUEBA_SERVICE_SEIYA)
    private ServiceBean serviceBeanSeiya;

    public ServiceBean buildServiceBean(String version) {

        switch (String.valueOf(version)) {
        case ConstantPrueba.COMMON_STRING_DEFAULT_VERSION:

            return serviceBeanSeiya;

        default:
            return serviceBeanSeiya;
        }
    }
}
