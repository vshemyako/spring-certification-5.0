package spring.certification.test;

import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * When and where do you use @Transactional in testing?<br>
 * <p>
 * Answer:<br>
 * {@link Transactional} annotation might be used at a class level or at a method level to utilize test-managed
 * transactions. Those transactions are very handy to test database data management without changing the internal
 * state of a database (test-transactions are rolled back by default). Key object which manipulates a transaction
 * is a {@link TransactionalTestExecutionListener} object which is registered by default (but requires configured
 * {@link PlatformTransactionManager} bean to be present in the application-context). Additional annotations which
 * might be helpful in controlling behavior of a transaction are {@link Commit} and {@link Rollback}.<br>
 *
 * @author Valentine Shemyako
 * @since January 01, 2019
 */
public class Q004transaction {
}
