package spring.certification.security;

import java.util.Collection;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 015:<br>
 * In which security annotation are you allowed to use SpEL?<br>
 * <p>
 * Answer:<br>
 * Spring Security v3.0 introduced several method-level security annotations with support of SpEL:<br>
 * - {@link PreAuthorize} - access-control expression is evaluated before method is invoked.<br>
 * - {@link PostAuthorize} - access-control expression is evaluated after method is invoked.<br>
 * - {@link PreFilter} - filtering-expression is evaluated before method is invoked.
 * Argument to be filtered has to be of type {@link Collection} and support {@link Collection#remove} method.<br>
 * - {@link PostFilter} - similar to {@link PreFilter}, but expression is evaluated after method is invoked.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q015spel {
}
