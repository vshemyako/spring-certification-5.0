package spring.certification.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.Period;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 027:<br>
 * What is the default bean id if you only use @Bean? How can you override this?<br>
 * <p>
 * Answer:<br>
 * Default bean identifier (id for short), in case {@link Bean} annotation is used without attribute values
 * specified, is the same as the method name which it annotates.<br>
 * <p>
 * In case explicit naming is desired the {@code name} attribute, or the {@code value} attribute should be specified.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q027.JavaBeanNameConfig} - demonstrates how to change default bean name.
 *
 * @author Valentine Shemyako
 * @since November 17, 2018
 */
public class Q027 {

    /**
     * Demonstrates how different bean names are declared.
     */
    @Configuration
    public static class JavaBeanNameConfig {

        /**
         * @return one-day period object. Default bean name is the same as method name.
         */
        @Bean
        public Period day() {
            return Period.ofDays(1);
        }

        /**
         * @return 7-day period bean with default name changed to "week".
         */
        @Bean(name = {"week"})
        public Period sevenDays() {
            return Period.ofDays(7);
        }

        /**
         * @return 30-day period bean with default name changed to "month".
         */
        @Bean(value = {"month"})
        public Period thirtyDays() {
            return Period.ofDays(30);
        }

        /**
         * @return 30-minutes period, bean name of which was changed to array of values.
         */
        @Bean(name = {"thirtyMinutes", "halfAnHour"})
        public Duration thirtyMinutes() {
            return Duration.ofMinutes(30);
        }
    }
}
