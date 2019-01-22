package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.util.ReflectionTestUtils;

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
 * {@link Q022.SpringFramework} - demonstrates how to inject values into private fields using {@link Autowired} or
 * {@link Value} annotations<br>
 *
 * @author Valentine Shemyako
 * @since November 29, 2018
 */
public class Q022 {

    /**
     * Demonstrates how to inject values into private fields.
     */
    @Configuration
    public static class PrivateFieldInjection {

        @Bean
        public String ceo() {
            return "Rod Johnson";
        }

        @Bean
        public SpringFramework springFramework() {
            return new SpringFramework();
        }
    }

    /**
     * Framework which simplifies java development.
     */
    public static class SpringFramework {

        /**
         * Chief executive officer.
         */
        @Autowired
        private String ceo;

        /**
         * Leading developer.
         */
        @Value("Juergen Hoeller")
        private String dev;

        public String getCeo() {
            return ceo;
        }

        public String getDev() {
            return dev;
        }
    }
}
