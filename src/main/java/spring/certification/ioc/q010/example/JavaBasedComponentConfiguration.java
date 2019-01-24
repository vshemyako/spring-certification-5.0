package spring.certification.ioc.q010.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Java-based DI component class.
 * Java-docs say that component configuration class is processed in a lite-mode.
 */
@Component
public class JavaBasedComponentConfiguration {

    @Bean
    public Battery battery() {
        return new Battery();
    }

    @Bean
    public Remote remote() {
        return new Remote(battery());
    }

    @Bean
    public Smartphone smartphone() {
        return new Smartphone(battery());
    }
}
