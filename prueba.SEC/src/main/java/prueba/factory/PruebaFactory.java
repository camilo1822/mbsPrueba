package prueba.factory;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import prueba.factory.prueba.COPruebaFactory;
import prueba.service.ServiceBean;
import prueba.util.ConstantPrueba;

/**
 * Session Bean implementation class PruebaFactory
 */
@Singleton(mappedName = ConstantPrueba.COMMON_STRING_PRUEBA_FACTORY)
@LocalBean
public class PruebaFactory {

    @EJB(beanName = ConstantPrueba.COMMON_STRING_CO_PRUEBA_FACTORY)
    private COPruebaFactory factory;

    /**
     * Mapeo de service bean a generar por la fabrica.
     * 
     * @param region
     * @param version
     * @return {@link ServiceBean}
     */
    public ServiceBean getServiceBean(String region, String version) {
        ServiceBean bean = null;

        switch (region) {
        case ConstantPrueba.COMMON_STRING_REGION_COLOMBIA:
            bean = factory.buildServiceBean(version);
            break;
        default:
            bean = factory.buildServiceBean(version);
            break;
        }
        return bean;
    }
}
