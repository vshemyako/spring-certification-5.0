package spring.certification.ioc.q023.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class which do not use {@link Qualifier} annotation properly and therefore
 * is not appropriate as meta-data provider for application-context.
 */
@Configuration
public class NonQualifiedConfiguration {

    @Bean
    public Cinema cinema(Film film) {
        return new Cinema(film);
    }

    @Bean
    public Film comedyFilm(@Value("Pulp Fiction") String filmName) {
        return new Film(filmName);
    }

    @Bean
    public Film actionFilm(@Value("Fight Club") String filmName) {
        return new Film(filmName);
    }
}
