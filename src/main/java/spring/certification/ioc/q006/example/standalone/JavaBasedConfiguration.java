package spring.certification.ioc.q006.example.standalone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java-based configuration class for a standalone application.
 */
@Configuration
public class JavaBasedConfiguration {

    /**
     * Bean factory method with default method specified.
     */
    @Bean
    public MessageProvider messageProvider(@Value("Java-based configuration") String message) {
        return new MessageProvider(message);
    }
}
