package spring.certification.ioc.q022;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;
import spring.certification.ioc.q022.example.SpringFramework;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 022:<br>
 * What do you have to do, if you would like to inject something into a private field?<br>
 * How does this impact testing?<br>
 * <p>
 * Answer:<br>
 * There are several possibilities to inject values into a private field directly (obviously, constructors and setter
 * methods are omitted):<br>
 * 1. Using {@link Autowired} annotation<br>
 * 2. Using {@link Value} annotation<br>
 * <p>
 * Impact on testing:<br>
 * One should avoid injection of values into private fields directly, because it complicates testing (complicates
 * usage of mocks). Better approach is to rely on constructor or setter injection, thus substitution of collaborators
 * becomes much easier (one doesn't have to rely on reflection).<br>
 * Note: Spring Framework offers utility class for accessing private fields and methods, thus making testing of those easier
 * (please look at {@link ReflectionTestUtils} class).<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link SpringFramework} - demonstrates how to inject values into private fields using {@link Autowired} or
 * {@link Value} annotations<br>
 *
 * @author Valentine Shemyako
 * @since November 29, 2018
 */
public class PrivateFieldInjection {
}
