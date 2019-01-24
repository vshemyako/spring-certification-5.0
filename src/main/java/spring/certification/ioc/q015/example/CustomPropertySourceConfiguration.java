package spring.certification.ioc.q015.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures a bean which will add a custom source of properties.
 */
@Configuration
public class CustomPropertySourceConfiguration {

    @Bean
    public PropertySourceProvider propertySourceProvider() {
        return new PropertySourceProvider();
    }
}
