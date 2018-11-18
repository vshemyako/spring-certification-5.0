package spring.certification.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 029:<br>
 * How do you configure profiles?<br>
 * What are possible use cases where they might be useful?<br>
 * <p>
 * Answer:<br>
 * Profile is a named state of application which instructs Spring about beans that should be managed by IoC
 * container. It's possible to configure profiles using <b>xml</b> or <b>annotation-based</b> approach. Annotation-based
 * profile configuration is build upon {@link Profile} annotation.<br>
 * Application use cases:<br>
 * 1. Different application environments: development, testing, production. Each of those may require different beans
 * (e.g. database connections).<br>
 * 2. Performance measurement (isn't required when application has been already deployed on production system).<br>
 * 3. Different application behavior which depends on user/client type.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q029.DevelopmentConfiguration} - demonstrates usage of {@link Profile} annotation.
 *
 * @author Valentine Shemyako
 * @since November 18, 2018
 */
public class Q029 {

    /**
     * Shows the most basic usage of {@link Profile} annotation.
     */
    @Profile("production")
    @Configuration
    public static class DevelopmentConfiguration {

        /**
         * Success application startup message.
         */
        @Bean
        public String startupMessage() {
            return "Success!";
        }
    }
}
