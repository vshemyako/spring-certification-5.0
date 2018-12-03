package spring.certification.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 026:<br>
 * What does the @Bean annotation do?<br>
 * <p>
 * Answer:<br>
 * The {@link Bean} annotation is used to indicate that a method instantiates, configures, and initializes a new object
 * to be managed by the Spring IoC container. The {@link Bean} annotation plays the same role as the {@code <bean/>}
 * element in xml configuration. It's legal to use {@link Bean} annotated methods within {@link Component},
 * {@link Configuration} classes or plain java classes.
 * <p>
 * In case {@link Bean} method is used within {@link Configuration} class it is processed by Spring IoC container
 * in <b>full mode</b>. <b>Full mode</b> processing means that {@link Bean} methods can declare inter-dependencies
 * which will be intercept by Spring IoC container.
 * In case {@link Bean} method is used within {@link Component} class it is processed by Spring IoC container in <b>lite
 * mode</b>. <b>Lite mode</b> means that internal calls between {@link Bean} methods are not intercepted by Spring IoC
 * container.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link SimpleJavaConfig} - demonstrates the most basic usage of {@link Bean} annotation.
 *
 * @author Valentine Shemyako
 * @since November 17, 2018
 */
public class Q026 {

    /**
     * Simplistic java-based Spring IoC configuration without complex inter-dependencies.
     * Is used to demonstrate basic functionality offered by {@link Bean} annotation.
     */
    @Configuration
    public static class SimpleJavaConfig {

        /**
         * Bean factory which composes {@link LocalDate} object representing
         * Christmas holiday point in time.
         */
        @Bean
        public LocalDate christmas() {
            int currentYear = LocalDate.now().getYear();
            return LocalDate.of(currentYear, 12, 25);
        }
    }
}
