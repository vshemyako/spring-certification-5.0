package spring.certification.ioc.q023.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class which uses {@link Qualifier} annotation properly.
 */
@Configuration
public class QualifiedConfiguration {

    @Bean
    public Cinema cinema(@Genre(FilmGenre.ACTION) Film film) {
        return new Cinema(film);
    }

    @Genre(FilmGenre.COMEDY)
    @Bean
    public Film comedyFilm(@Value("Pulp Fiction") String filmName) {
        return new Film(filmName);
    }

    @Genre(FilmGenre.ACTION)
    @Bean
    public Film actionFilm(@Value("Fight Club") String filmName) {
        return new Film(filmName);
    }
}
