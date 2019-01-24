package spring.certification.ioc.q014.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Configuration of lazily-loaded beans: not created by container until requested.
 */
@Lazy
@Configuration
public class LazyConfiguration {

    /**
     * Bean factory to initialize lazy bean.
     */
    @Bean
    public CoachPotato coachPotato() {
        return new CoachPotato();
    }

    @Bean
    @Lazy(false) // Override configuration class policy
    public RollingStone rollingStone() {
        return new RollingStone();
    }
}
