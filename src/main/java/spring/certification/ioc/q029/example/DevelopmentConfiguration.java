package spring.certification.ioc.q029.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Shows the most basic usage of {@link Profile} annotation.
 */
@Profile("production")
@Configuration
public class DevelopmentConfiguration {

    /**
     * Success application startup message.
     */
    @Bean
    public String startupMessage() {
        return "Success!";
    }
}
