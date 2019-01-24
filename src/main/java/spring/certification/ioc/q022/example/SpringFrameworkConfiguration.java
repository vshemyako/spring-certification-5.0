package spring.certification.ioc.q022.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Demonstrates how to inject values into private fields.
 */
@Configuration
public class SpringFrameworkConfiguration {

    @Bean
    public String ceo() {
        return "Rod Johnson";
    }

    @Bean
    public SpringFramework springFramework() {
        return new SpringFramework();
    }
}
