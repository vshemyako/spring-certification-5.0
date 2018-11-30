package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
 * Examples of mentioned terms:<br>
 * -
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
