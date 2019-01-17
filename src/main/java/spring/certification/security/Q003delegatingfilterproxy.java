package spring.certification.security;

import javax.servlet.Filter;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 003:<br>
 * What is the delegating filter proxy?<br>
 * <p>
 * Answer:<br>
 * {@link DelegatingFilterProxy} is a servlet {@link Filter}, lifecycle of which is managed by servlet-container.
 * The sole purpose of this object is to delegate filtering functionality to a Spring managed bean (which obviously
 * can rely on IoC, AOP, etc. extra functionality offered by Spring Framework). Usually {@link DelegatingFilterProxy}
 * filter delegates filtering to a single instance of {@link FilterChainProxy}.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q003delegatingfilterproxy {
}
