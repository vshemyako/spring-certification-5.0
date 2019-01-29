package spring.certification.security;

import javax.servlet.Filter;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * What is the security filter chain?<br>
 * <p>
 * Answer:<br>
 * {@link FilterChainProxy} maintains a list of {@link SecurityFilterChain} objects each of which
 * is capable to decide whether it should be applied to a web-request or not. The first filter-chain
 * which matches the request is responsible for its processing. Internally {@link SecurityFilterChain}
 * is itself a list of {@link Filter} objects plus single instance of {@link RequestMatcher} which
 * actually performs url-matching.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q004securityfilterchain {
}
