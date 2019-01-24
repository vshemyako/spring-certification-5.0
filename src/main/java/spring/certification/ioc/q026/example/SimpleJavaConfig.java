package spring.certification.ioc.q026.example;

import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Simplistic java-based Spring IoC configuration without complex inter-dependencies.
 * Is used to demonstrate basic functionality offered by {@link Bean} annotation.
 */
@Configuration
public class SimpleJavaConfig {

    /**
     * Bean factory which composes {@link LocalDate} object representing
     * Christmas holiday point in time.
     */
    @Bean
    public LocalDate christmas() {
        int currentYear = LocalDate.now().getYear();
        return LocalDate.of(currentYear, 12, 25);
    }
}
