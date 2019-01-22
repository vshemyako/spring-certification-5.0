package spring.certification.ioc;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

import java.util.HashMap;
import java.util.Map;

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
 * 2. For a <b>web</b> application additional default property source are registered:<br>
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
 * {@link Q015.CustomPropertySourceConfiguration} - demonstrates programmatic registration of custom source of
 * properties<br>
 *
 * @author Valentine Shemyako
 * @since November 26, 2018
 */
public class Q015 {

    /**
     * Configures a bean which will add a custom source of properties.
     */
    @Configuration
    public static class CustomPropertySourceConfiguration {

        @Bean
        public PropertySourceProvider propertySourceProvider() {
            return new PropertySourceProvider();
        }
    }

    /**
     * {@link EnvironmentAware} class which will register a new custom source of properties once
     * notified about {@link Environment} it runs within.
     */
    public static class PropertySourceProvider implements EnvironmentAware {

        @Override
        public void setEnvironment(Environment environment) {
            // Compose a source of key/value pairs
            Map<String, Object> seasonEmotions = new HashMap<>();
            seasonEmotions.put("summer", "joy");
            seasonEmotions.put("autumn", "sadness");
            seasonEmotions.put("winter", "surprise");
            seasonEmotions.put("spring", "love");

            // Create instance property source instance
            MapPropertySource emotionsSource = new MapPropertySource("seasonEmotions", seasonEmotions);

            // Put new property source in existing environment
            ((StandardEnvironment) environment).getPropertySources().addFirst(emotionsSource);
        }
    }
}
