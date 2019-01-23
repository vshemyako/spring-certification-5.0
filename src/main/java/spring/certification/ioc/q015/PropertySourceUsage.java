package spring.certification.ioc.q015;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import spring.certification.ioc.Q016;
import spring.certification.ioc.q015.example.CustomPropertySourceConfiguration;

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
 * 1. For a <b>stand-alone</b> application two default property sources are available:<br>
 * - JVM properties<br>
 * - OS properties<br>
 * 2. For a <b>web</b> application additional property sources are registered:<br>
 * - ServletConfig parameters<br>
 * - ServletContext parameters<br>
 * - JNDI properties<br>
 * <p>
 * It's possible to configure property source hierarchy or add custom property sources (this can by done by implementing
 * {@link org.springframework.core.env.PropertySource} interface and adding it via {@link MutablePropertySources#addFirst}
 * method call).<br>
 * <p>
 * Spring offers an easier way to register custom property source via {@link PropertySource} annotation which has to be
 * used in conjunction with {@link Configuration} classes.<br>
 * Examples of mentioned terms:<br>
 * {@link Q016.ProcessedByPostProcessorConfiguration} - demonstrates the most basic usage of {@link PropertySource}
 * annotation<br>
 * {@link CustomPropertySourceConfiguration} - demonstrates programmatic registration of custom source of
 * properties<br>
 *
 * @author Valentine Shemyako
 * @since November 26, 2018
 */
public class PropertySourceUsage {
}
