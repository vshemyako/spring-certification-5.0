package spring.certification.boot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * Does Spring Boot do component scanning?<br>
 * Where does it look by default?<br>
 * <p>
 * Answer:<br>
 * It is possible to construct Spring Boot application which doesn't rely on classpath component scan. For example
 * if only {@link EnableAutoConfiguration} annotation is used. In case main configuration class is annotated with
 * {@link SpringBootApplication} - component scan is performed recursively in depth from the main configuration package
 * (where {@link SpringBootApplication} is placed). Default scan policy can be amended via {@link SpringBootApplication#scanBasePackageClasses()}
 * or {@link SpringBootApplication#scanBasePackages()} attributes.<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q012componentscan {
}
