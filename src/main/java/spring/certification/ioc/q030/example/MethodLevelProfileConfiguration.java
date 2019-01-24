package spring.certification.ioc.q030.example;

import java.time.Instant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Shows basic usage of {@link Profile} annotations applied on method level.
 */
@Configuration
public class MethodLevelProfileConfiguration {

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

    /**
     * Point in time of 1970 year.
     */
    @Profile("develop & production")
    @Bean
    public Instant epochInstant() {
        return Instant.EPOCH;
    }
}
