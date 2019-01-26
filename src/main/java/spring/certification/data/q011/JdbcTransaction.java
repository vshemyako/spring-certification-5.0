package spring.certification.data.q011;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 011:<br>
 * Is the JDBC template able to participate in an existing transaction?<br>
 * <p>
 * Answer:<br>
 * It's possible to participate in database transaction using {@link JdbcTemplate} both programmatically (using
 * {@link TransactionTemplate}) and declaratively (using {@link Transactional} annotation). Both of these approaches
 * are examined in related test section.<br>
 * Another approach which actually relates to some third-party or legacy code is to wrap injected {@link DataSource}
 * instance with {@link TransactionAwareDataSourceProxy} object.<br>
 *
 * @author Valentine Shemyako
 * @since January 05, 2019
 */
public class JdbcTransaction {
}
