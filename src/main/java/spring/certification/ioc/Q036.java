package spring.certification.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 036:<br>
 * What is the Environment abstraction in Spring?<br>
 * <p>
 * Answer:<br>
 * Environment abstraction in Spring represents conditions in which current application is running. More specifically,
 * those conditions are: {@link Profile Profiles} and {@link PropertySource Properties}.<br>
 * <p>
 * {@link ApplicationContext} is {@link EnvironmentCapable}, therefore it exposes {@link EnvironmentCapable#getEnvironment()}
 * method to get reference to the single environment in which current application is running.<br>
 * <p>
 * Beans managed by {@link ApplicationContext} may register {@link EnvironmentAware} hook or directly injection
 * environment reference by the means of DI.<br>
 * Examples of mentioned terms:<br>
 * {@link Q036.EnvironmentAbstraction} - demonstrates how to access environment active profiles and jmv properties.<br>
 *
 * @author Valentine Shemyako
 * @since November 19, 2018
 */
public class Q036 {

    /**
     * Demonstrates basic interactions with profiles and properties which are accessible through environment
     * abstraction.
     */
    @Profile("certification")
    @Configuration
    public static class EnvironmentAbstraction {

        /**
         * Demonstrates possibility to delegate injection of {@link Environment} object to Spring IoC container.
         */
        @Bean
        public String[] externalProfileConditions(Environment environment) {
            return environment.getActiveProfiles();
        }

        /**
         * Demonstrates possibility to access JVM properties using {@link Environment} abstraction.
         */
        @Bean
        public String javaVersion(Environment environment) {
            return environment.getProperty("java.version");
        }
    }
}
