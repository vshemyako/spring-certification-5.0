package spring.certification.ioc.q036.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

/**
 * Demonstrates basic interactions with profiles and properties which are accessible through environment
 * abstraction.
 */
@Profile("certification")
@Configuration
public class EnvironmentConfiguration {

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
