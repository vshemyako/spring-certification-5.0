package spring.certification.boot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 011:<br>
 * What does @SpringBootApplication do?<br>
 * <p>
 * Answer:<br>
 * {@link SpringBootApplication} is a compound annotation which is meta-annotated with the following annotations:<br>
 * - {@link EnableAutoConfiguration} - to enable implicit bean auto-configuration based on the classpath jars.<br>
 * - {@link SpringBootConfiguration} - to register manually defined beans within main configuration class.<br>
 * - {@link ComponentScan} - to enable implicit bean creation from stereotype classes (annotated directly or indirectly with {@link Component} annotation).<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q011springbootapplication {
}
