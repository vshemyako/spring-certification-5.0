package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * Describe component-scanning.<br>
 * Describe stereotypes.<br>
 * Describe meta-annotations.<br>
 * <p>
 * Answer:<br>
 * Meta annotation is an annotation which can be applied to other types of annotations. Some predefined meta-annotations
 * which come with JDK are: {@link Target}, {@link Retention}, etc. For an annotation to become a meta-annotation
 * appropriate {@link ElementType} should be used ({@link ElementType#ANNOTATION_TYPE}, {@link ElementType#TYPE} or none).<br>
 * <p>
 * Spring framework uses intensively those kind of annotations, e.g. {@link Configuration} annotation is meta annotated
 * with {@link Component} annotation, therefore classes annotated with {@link Configuration} are also registered as
 * Spring beans.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q012.NonQualifiedConfiguration} - demonstrates wrong configuration class with DI ambiguity.<br>
 * {@link Q012.QualifiedConfiguration} - demonstrates appropriate configuration class which properly uses custom
 * {@link Qualifier} annotation.
 *
 * @author Valentine Shemyako
 * @since November 27, 2018
 */
public class Q012 {

    /**
     * Configuration class which do not use {@link Qualifier} annotation properly and therefore
     * is not appropriate as meta-data provider for application-context.
     */
    @Configuration
    public static class NonQualifiedConfiguration {

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

    /**
     * Configuration class which uses {@link Qualifier} annotation properly.
     */
    @Configuration
    public static class QualifiedConfiguration {

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

    /**
     * Custom annotation type which can be used for more granular dependency injection.
     * {@link Qualifier} annotation is used as meta-annotation here.
     */
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Qualifier
    public @interface Genre {
        FilmGenre value();
    }

    /**
     * Defines the most common list of film genres.
     */
    public enum FilmGenre {
        ACTION, COMEDY, DRAMA
    }

    /**
     * A motion picture.
     */
    public static class Film {

        private String filmName;

        public Film(String filmName) {
            this.filmName = filmName;
        }

        public String getFilmName() {
            return filmName;
        }
    }

    /**
     * A movie theater.
     */
    public static class Cinema {

        private Film film;

        public Cinema(Film film) {
            this.film = film;
        }

        public Film getFilm() {
            return film;
        }
    }
}
