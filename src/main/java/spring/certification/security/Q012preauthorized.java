package spring.certification.security;

import javax.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * What do @PreAuthorized and @RolesAllowed do? What is the difference between them?<br>
 * <p>
 * Answer:<br>
 * Similarities:<br>
 * Both of these annotations might be used to apply authorization logic at a method-level.
 * Access control for both annotations is applied before method invocation.<br>
 * <p>
 * Discrepancies:<br>
 * {@link RolesAllowed} supports only a list of authentications (roles). It's an annotation defined by JSR-250 specification.<br>
 * {@link PreAuthorize} supports SPeL, it's a Spring Security framework annotation.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q012preauthorized {
}
