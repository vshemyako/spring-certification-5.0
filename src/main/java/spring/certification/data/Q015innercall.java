package spring.certification.data;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 015:<br>
 * What happens if one @Transactional annotated method is calling another @Transactional annotated method on the same
 * object instance?<br>
 * <p>
 * Answer:<br>
 * Since declarative transaction management is implemented using dynamic proxies, inner calls to a method marked with
 * {@link Transactional} will not take effect. It's just a usual behavior of Spring AOP proxies (inner calls are not
 * intercepted). If an inner method call interception is required, AspectJ weaving must be turned on.<br>
 *
 * @author Valentine Shemyako
 * @since January 06, 2019
 */
public class Q015innercall {
}
