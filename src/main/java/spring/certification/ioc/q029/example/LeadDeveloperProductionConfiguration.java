package spring.certification.ioc.q029.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Demonstrates basic usage of profile expressions.
 */
@Profile("production & leadDeveloper")
@Configuration
public class LeadDeveloperProductionConfiguration {

    /**
     * @return lead developer's password.
     */
    @Bean
    public String password() {
        return "HighFive";
    }
}
