package spring.certification.ioc.q010.example;

import org.springframework.context.annotation.Bean;

/**
 * There's some ambiguity within Spring documentation:<br>
 * it is not absolutely clear whether it is possible
 * to use plain-java configuration classes or not.
 */
public class JavaBasedPlainConfiguration {

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
