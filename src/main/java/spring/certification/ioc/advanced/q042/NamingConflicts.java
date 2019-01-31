package spring.certification.ioc.advanced.q042;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 042:<br>
 * What happens if several beans with the same name are defined with application context?<br>
 * <p>
 * Answer:<br>
 * The first one will be overridden by the second. This is an intentional behavior which allows to override some third-party
 * beans which are out of the programmer's control.<br>
 * <p>
 * This behavior is verified in the corresponding test class.<br>
 *
 * @author Valentine Shemyako
 * @since January 31, 2018
 */
@Import({FirstConfigurationClass.class, SecondConfigurationClass.class})
@Configuration
public class NamingConflicts {
}
