package spring.certification.ioc.q031;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import spring.certification.ioc.q029.example.DevelopmentConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 031:<br>
 * Can you use @Component together with @Profile?<br>
 * <p>
 * Answer:<br>
 * {@link Profile} annotation can be applied as a type-level annotation on any class directly or indirectly annotated with
 * {@link Component}. Actually that is why this annotation is picked up by application context in case {@link Profile}
 * is applied to {@link Configuration} class.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link DevelopmentConfiguration} - demonstrates usage of {@link Profile} annotation applied to
 * {@link Configuration} class. {@link Configuration} annotation is meta-annotated by itself with {@link Component}
 * annotation, that is why {@link Profile} is involved in bean-registration process.
 *
 * @author Valentine Shemyako
 * @since November 18, 2018
 */
public class ComponentClassProfileConfiguration {
}
