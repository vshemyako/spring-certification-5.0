package spring.certification.boot;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 006:<br>
 * How are properties defined?<br>
 * Where is Spring Boot’s default property source?<br>
 * <p>
 * Answer:<br>
 * Spring Boot application allows to specify properties in lots of ways.
 * They are evaluated in the following order (excerpt from documentation):<br>
 * <p>
 * 1. Devtools global settings properties on your home directory (~/.spring-boot-devtools.properties when devtools is active).<br>
 * 2. {@link TestPropertySource} annotations on your tests.<br>
 * 3. {@link SpringBootTest#properties()} annotation attribute on your tests.<br>
 * 4. Command line arguments.<br>
 * 5. Properties from SPRING_APPLICATION_JSON (inline JSON embedded in an environment variable or system property).<br>
 * 6. {@link ServletConfig} init parameters.<br>
 * 7. {@link ServletContext} init parameters.<br>
 * 8. JNDI attributes from java:comp/env.<br>
 * 9. Java System properties (System.getProperties()).<br>
 * 10. OS environment variables.<br>
 * 11. A {@link RandomValuePropertySource} that has properties only in random.*.<br>
 * 12. Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants).<br>
 * 13. Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants).<br>
 * 14. Application properties outside of your packaged jar (application.properties and YAML variants).<br>
 * 15. Application properties packaged inside your jar (application.properties and YAML variants).<br>
 * 16. {@link PropertySource} annotations on your {@link Configuration} classes.<br>
 * 17. Default properties (specified by setting {@link SpringApplication#setDefaultProperties}).<br>
 * <p>
 * Spring Boot's default property source is an <b>application.properties</b> file.<br>
 * <p>
 * <b>Note:</b> Spring Boot offers additional way to bind configuration properties to {@link Bean bean-methods} or simple Java classes.
 * {@link ConfigurationProperties} annotation doesn't support SpEL features but allows to validate injected values using JSR-303 compliant implementation.
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q006properties {
}
