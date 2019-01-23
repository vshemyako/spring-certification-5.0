package spring.certification.ioc.q005;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/default.properties")
public class BeanConfigurationMetadata {

    @Bean
    public ManagedObject managedObject() {
        return new ManagedObject();
    }
}
