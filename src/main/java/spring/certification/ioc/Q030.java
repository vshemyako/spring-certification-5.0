package spring.certification.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.time.Instant;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 030:<br>
 * Can you use @Bean together with @Profile?<br>
 * <p>
 * Answer:<br>
 * {@link Profile} is itself meta-annotated with {@link Target} {@link ElementType#METHOD} annotation which means that
 * it can be applied to methods, and more specifically factory {@link Bean} methods.<br>
 * <p>
 * Use cases for applying {@link Profile} annotation on method-level:
 * 1. Bean will only be registered in case application runs with the same active profile declared in {@link Profile}
 * annotation.<br>
 * 2. In case of overloaded {@link Bean} methods chosen {@link Profile} must be the same for all overloaded methods. If
 * the profile is inconsistent among all overloaded methods, only {@link Profile} of the first declared method will be
 * considered.<br>
 * Examples of mentioned terms:<br>
 * {@link Q030.MethodLevelProfileConfiguration} - demonstrates simplistic usage of {@link Profile} annotation applied at
 * method level.<br>
 *
 * @author Valentine Shemyako
 * @since November 18, 2018
 */
public class Q030 {

    /**
     * Shows basic usage of {@link Profile} annotations applied on method level.
     */
    @Configuration
    public static class MethodLevelProfileConfiguration {

        /**
         * Point in time related to application startup.
         */
        @Profile("qa")
        @Bean
        public Instant startupInstant() {
            return Instant.now();
        }

        /**
         * Point in time related to scheduled shutdown of the application.
         */
        @Bean
        public Instant shutdownInstant() {
            return Instant.MAX;
        }
    }
}
