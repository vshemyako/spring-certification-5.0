package spring.certification.ioc.q019.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java-based config class to be processed by Spring IoC container.
 */
@Configuration
public class CinemaConfiguration {

    @Bean
    public SloganMaker sloganMaker() {
        return new SloganMaker();
    }

    @Bean
    public Cinema cinema(@Value("The Shawshank Redemption") String filmName, SloganMaker sloganMaker) {
        return new Cinema(filmName, sloganMaker);
    }
}
