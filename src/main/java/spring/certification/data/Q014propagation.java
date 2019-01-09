package spring.certification.data;

import org.springframework.transaction.annotation.Propagation;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 014:<br>
 * What does transaction propagation mean?<br>
 * <p>
 * Answer:<br>
 * Transaction propagation is a transaction's behavior in relation to other transactions. The following propagation types
 * exist:<br>
 * - {@link Propagation#REQUIRED} - support a current transaction, create a new one if none exists.<br>
 * - {@link Propagation#REQUIRES_NEW} - create a new transaction, and suspend the current transaction if one exists.<br>
 * - {@link Propagation#NESTED} - execute within a nested transaction if a current transaction exists, behave like
 * PROPAGATION_REQUIRED else.<br>
 * <p>
 * - {@link Propagation#SUPPORTS} - support a current transaction, execute non-transactionally if none exists.<br>
 * - {@link Propagation#NOT_SUPPORTED} - execute non-transactionally, suspend the current transaction if one exists.<br>
 * <p>
 * - {@link Propagation#MANDATORY} - support a current transaction, throw an exception if none exists.<br>
 * - {@link Propagation#NEVER} - execute non-transactionally, throw an exception if a transaction exists.<br>
 *
 * @author Valentine Shemyako
 * @since January 06, 2019
 */
public class Q014propagation {
}
