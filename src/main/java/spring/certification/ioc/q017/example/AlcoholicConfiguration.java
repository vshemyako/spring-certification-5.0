package spring.certification.ioc.q017.example;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Simple java-based IoC configuration class.
 */
@Configuration
public class AlcoholicConfiguration {

    /**
     * Bean factory which returns instance of an {@link Alcohol} interface.
     */
    @Bean
    public Alcohol wine() {
        return new Wine();
    }

    /**
     * Static bean factory to register {@link BeanPostProcessor} as soon as possible.
     */
    @Bean
    public static AlcoholicPostProcessor alcoholicPostProcessor() {
        return new AlcoholicPostProcessor();
    }
}
