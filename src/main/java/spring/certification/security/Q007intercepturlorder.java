package spring.certification.security;

import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 007:<br>
 * In which order do you have to write multiple intercept-url's?<br>
 * <p>
 * Answer:<br>
 * Url pattern matching is performed in the order in which those patterns are supplied. The first
 * {@link SecurityFilterChain} match will be used for further request processing. That means
 * that more specific url patterns must be defined first. If not, more specific patterns will be
 * ignored by filter-chain proxy.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q007intercepturlorder {
}
