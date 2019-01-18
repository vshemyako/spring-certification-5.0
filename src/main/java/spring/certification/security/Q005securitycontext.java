package spring.certification.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * What is a security context?<br>
 * <p>
 * Answer:<br>
 * {@link SecurityContext} is an object associated with the <b>current thread of execution</b>, holding
 * authentication information. Authentication info is defined by {@link Authentication} interface.<br>
 * {@link SecurityContext} instances are accessed using {@link SecurityContextHolder}. Depending on defined
 * {@link SecurityContextHolderStrategy}, {@link SecurityContext} might be unique for an execution thread
 * or might be shared across all thread instances.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q005securitycontext {
}
