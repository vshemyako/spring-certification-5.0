package spring.certification.security;

import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 006:<br>
 * Why do you need the intercept-url?<br>
 * <p>
 * Answer:<br>
 * As previously discussed in {@link Q004securityfilterchain security filter chain} question, {@link FilterChainProxy}
 * maintains several filter-chains. For a simplistic application it's even possible that a chain-proxy maintains a single
 * filter-chain. For such simplistic application there's no need to differentiate between different types of web-request.<br>
 * More commonly different parts of an application require different levels of security and thus different urls
 * have to be filtered by different chains of security filters. <b>Intercept url</b> patterns define mappings between
 * different web-requests and appropriate filter chain. Actual web-request url comparison with predefined intercept-url pattern
 * is performed by a {@link RequestMatcher} instance.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q006url {
}
