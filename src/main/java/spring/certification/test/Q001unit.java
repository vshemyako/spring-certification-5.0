package spring.certification.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.stereotype.Component;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * Do you use Spring in a unit test?<br>
 * <p>
 * Answer:<br>
 * Unit testing should not depend on any infrastructure framework and use it in some invasive way in unit testing.
 * Spring framework advocates this non-invasive approach, thus your unit-tests do not depend on Spring.<br>
 * <b>Note:</b> Spring framework provides some mock objects and testing support classes that are convenient to be used
 * in unit testing (e.g. {@link MockPropertySource}, {@link MockEnvironment}...)<br>
 *
 * @author Valentine Shemyako
 * @since December 31, 2018
 */
public class Q001unit {

    /**
     * Demonstrates a simple class which depend on {@link Environment} abstraction.
     */
    @Component
    public static class PropertyResolver {

        private Environment environment;

        @Autowired
        public PropertyResolver(Environment environment) {
            this.environment = environment;
        }

        /**
         * @param name of a property to resolve.
         * @return resolved value of a property.
         */
        public String resolveProperty(String name) {
            return this.environment.getProperty(name);
        }
    }
}
