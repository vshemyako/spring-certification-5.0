package spring.certification.ioc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 015:<br>
 * What is a property source?<br>
 * How would you use @PropertySource annotation?<br>
 * <p>
 * Answer:<br>
 * Property source is any source of key/value pairs. Spring's {@link Environment} provides a configurable hierarchy of
 * property sources:<br>
 * 1. For a <b>stand-alone</b> application two default property sources are available:
 * - JVM properties<br>
 * - OS properties<br>
 * 2. For a <b>web</b> application additional default property source are registered:
 * - ServletConfig parameters<br>
 * - ServletContext parameters<br>
 * - JNDI properties<br>
 * <p>
 * It's possible to configure property source hierarchy or add custom property sources (this can by done by implementing
 * {@link PropertySources} interface and adding it via {@link MutablePropertySources#addFirst} method call).<br>
 * <p>
 * Spring offers an easier way to register custom property source via {@link PropertySource} annotation with has to be
 * used in conjunction with {@link Configuration} classes.<br>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since November 26, 2018
 */
public class Q015 {
}
