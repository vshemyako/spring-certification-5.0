package spring.certification.data.q024;

import javax.sql.DataSource;
import org.springframework.orm.jpa.JpaTransactionManager;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 024:<br>
 * Are you able to participate in a given transaction in Spring while working with JPA?<br>
 * <p>
 * Answer:<br>
 * {@link JpaTransactionManager} java-docs clearly state that this transaction-manager supports direct
 * {@link DataSource} access. This allows for mixing services which access JPA and services which use plain
 * JDBC (without being aware of JPA).<br>
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
public class TransactionParticipation {
}
