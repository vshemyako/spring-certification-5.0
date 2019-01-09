package spring.certification.data;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 018:<br>
 * What is the default rollback policy? How can you override it?<br>
 * <p>
 * Answer:<br>
 * Default rollback policy in defined by {@link DefaultTransactionAttribute} which states that rollback should be
 * performed only in case of {@link RuntimeException} and {@link Error} but not on checked exceptions.<br>
 * <p>
 * This default behavior can be overridden using (in case declarative approach is used):<br>
 * - {@link Transactional#noRollbackFor()}<br>
 * - {@link Transactional#noRollbackForClassName()}<br>
 * - {@link Transactional#rollbackFor()}<br>
 * - {@link Transactional#rollbackForClassName()}<br>
 * annotation attributes.
 *
 * @author Valentine Shemyako
 * @since January 06, 2019
 */
public class Q018rollbackpolicy {
}
