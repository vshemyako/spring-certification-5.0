package spring.certification.test.q007;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 007:<br>
 * How does Spring Boot simplify writing tests?<br>
 * <p>
 * Answer:<br>
 * As always Spring Boot offers starter and autoconfigure jars to ease dependency management
 * and creation of commonly utilized beans. More over Spring Boot offers the following neat functionality:<br>
 * - No need to explicitly specify primary {@link Configuration} class, {@link SpringBootTest} will by default
 * try to locate {@link SpringBootApplication} or {@link SpringBootConfiguration} classes.<br>
 * - Allows to easily start a web server on a random port.<br>
 * - Provides several utility classes:<br>
 * -- {@link TestPropertyValues} - for adding properties.<br>
 * -- {@link OutputCapture} - to verify output of {@link System#out}, {@link System#err}.<br>
 * -- {@link TestRestTemplate} - to consume REST services.<br>
 * - Allows to test a slice of an application ({@link JsonTest}, {@link DataJpaTest}, {@link WebMvcTest}...).<br>
 *
 * @author Valentine Shemyako
 * @since January 22, 2019
 */
public class SpringBootTestSupport {
}
