package spring.certification.test;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 008:<br>
 * What does @SpringBootTest do?<br>
 * How does it interact with @SpringBootApplication and @SpringBootConfiguration?<br>
 * <p>
 * Answer:<br>
 * {@link SpringBootTest} annotation automatically picks up main Spring Boot configuration class:<br>
 * As documentation suggests, main Spring Boot configuration class might be annotated in the following ways:<br>
 * - With {@link SpringBootConfiguration}.<br>
 * - With {@link SpringBootApplication} which is meta-annotated with {@link SpringBootConfiguration}, thus the second approach
 * (when it comes to class auto-detection) boils down to the first one.<br>
 * Thus usage of {@link ContextConfiguration} annotation is no longer required.<br>
 * <p>
 * {@link SpringBootTest} allows to easily define additional {@link Environment} properties via means of {@link SpringBootTest#properties()} attribute.<br>
 * <p>
 * {@link SpringBootTest} allows to initialize fully running web server listening on a random port.<br>
 *
 * @author Valentine Shemyako
 * @since January 22, 2019
 */
public class Q008bootannotations {
}
