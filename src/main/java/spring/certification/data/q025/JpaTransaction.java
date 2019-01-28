package spring.certification.data.q025;

import javax.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 025:<br>
 * Which PlatformTransactionManager(s) can you use with JPA?<br>
 * <p>
 * Answer:<br>
 * There're two possible alternatives:<br>
 * 1. {@link JpaTransactionManager} to use with a single JPA {@link EntityManagerFactory} (single transactional resource).<br>
 * 2. {@link JtaTransactionManager} to use with several transactional resources.<br>
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
public class JpaTransaction {
}
