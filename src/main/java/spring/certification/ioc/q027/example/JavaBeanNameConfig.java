package spring.certification.ioc.q027.example;

import java.time.Duration;
import java.time.Period;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Demonstrates how different bean names are declared.
 */
@Configuration
public class JavaBeanNameConfig {

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
