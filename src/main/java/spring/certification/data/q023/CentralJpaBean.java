package spring.certification.data.q023;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 023:<br>
 * What do you need to do in Spring if you would like to work with JPA?<br>
 * <p>
 * Answer:<br>
 * Central bean which is required to work with JPA is an {@link EntityManagerFactory} bean. This bean is responsible
 * for management of {@link EntityManager} instances. JPA specification declares two types of entity-manager factories:<br>
 * 1. container managed entity-manager factory - factory is managed by container.
 * {@link LocalContainerEntityManagerFactoryBean} is a Spring Framework implementation of such a bean.<br>
 * 2. application managed entity-manager factory - factory is managed directly by application.
 * {@link LocalEntityManagerFactoryBean} is a Spring Framework implementation of such a bean.<br>
 * <p>
 * Important note: for Spring-based applications difference between those kinds of factories is minor: in each case
 * Spring Framework manages entity-manager factories by itself. The main difference is how those factories are configured:
 * application-managed factory configuration is primarily xml-based (using persistence.xml file).<br>
 * <p>
 *
 * @author Valentine Shemyako
 * @since January 07, 2019
 */
public class CentralJpaBean {
}
