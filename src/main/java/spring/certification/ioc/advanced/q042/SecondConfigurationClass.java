package spring.certification.ioc.advanced.q042;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConfigurationClass {

    @Bean
    public String dull() {
        return "Second Dull Object";
    }
}
