package spring.certification.ioc.advanced.q041;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 041:<br>
 * What will happen if bean wiring will be applied to beans of different scopes (e.g. singleton bean depends on prototype bean)?<br>
 * <p>
 * Answer:<br>
 * By default, singleton - prototype beans wiring will end up with all beans initialized only once.<br>
 * There are several ways to override this behavior:<br>
 * - using {@link Lookup} method overriding.<br>
 * - using {@link ObjectFactory} field injection.<br>
 *
 * @author Valentine Shemyako
 * @since January 25, 2018
 */
public class DifferentScopeWiring {
}
