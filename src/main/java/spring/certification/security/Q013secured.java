package spring.certification.security;

import javax.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 013:<br>
 * What does Spring’s @Secured do?<br>
 * <p>
 * Answer:<br>
 * {@link Secured} annotation is used to define a list of authority restrictions (role permissions)
 * at least one of which should have been granted to a principal invoking the request.<br>
 * To enable processing of {@link Secured} annotations - {@link EnableGlobalMethodSecurity#securedEnabled()} attribute
 * should be set to {@code true}.
 * <p>
 * {@link RolesAllowed} is a similar annotation defined by JSR-250 specification.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q013secured {
}
