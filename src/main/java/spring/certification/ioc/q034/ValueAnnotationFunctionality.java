package spring.certification.ioc.q034;

import org.springframework.beans.factory.annotation.Value;
import spring.certification.ioc.q034.example.ShelfConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 034:<br>
 * What is @Value used for?<br>
 * <p>
 * Answer:<br>
 * Simply put {@link Value} is used for injecting values into bean properties, method / constructor parameters.
 * Sources of those properties differ:<br>
 * 1. Constant, literal values<br>
 * 2. SpEL expressions<br>
 * 3. Environment variables, default property sources<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link ShelfConfiguration} - an example of usage of {@link Value} annotation.
 *
 * @author Valentine Shemyako
 * @since December 01, 2018
 */
public class ValueAnnotationFunctionality {
}
