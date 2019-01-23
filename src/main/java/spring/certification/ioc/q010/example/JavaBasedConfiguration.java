package spring.certification.ioc.q010.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java-based DI bean configuration class.
 */
@Configuration
public class JavaBasedConfiguration {

    /**
     * Simplistic factory method which provides bean-definition for Battery type.
     */
    @Bean
    public Battery battery() {
        return new Battery();
    }

    @Bean
    public Remote remote() {
        return new Remote(battery());
    }

    /**
     * More complex bean factory which produces bean-definition for {@link Smartphone} type.
     */
    @Bean
    public Smartphone smartphone() {
        return new Smartphone(battery());
    }
}
