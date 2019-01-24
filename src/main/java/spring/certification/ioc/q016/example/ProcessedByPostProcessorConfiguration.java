package spring.certification.ioc.q016.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Demonstrates how single bean is processed by {@link PropertySourcesPlaceholderConfigurer} post-processor.
 */
@PropertySource("classpath:/goodmood.properties")
@Configuration
public class ProcessedByPostProcessorConfiguration {

    /**
     * Creates bean-definition of {@link Holiday} class.
     */
    @Bean
    public Holiday holiday(@Value("${holiday.favourite}") String name) {
        return new Holiday(name);
    }
}
