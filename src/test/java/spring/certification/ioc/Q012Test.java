package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Verifies appropriate usage of {@link Qualifier} annotations.
 */
public class Q012Test {

    /**
     * Verifies that application-context will fail in initialize in case dependency injection cannot be performed
     * due to ambiguity.
     */
    @Test(expected = UnsatisfiedDependencyException.class)
    public void configurationShouldFail() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(Q012.NonQualifiedConfiguration.class)) {
            context.getBean(Q012.Cinema.class);
        }
    }

    /**
     * Verifies that application-context will succeed to initialize due to appropriate usage of custom
     * {@link Qualifier} annotation.
     */
    @Test
    public void configurationShouldSucceed() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(Q012.QualifiedConfiguration.class)) {
            Q012.Cinema cinema = context.getBean(Q012.Cinema.class);
            String filmName = cinema.getFilm().getFilmName();
            Assert.assertEquals("Fight Club", filmName);
        }
    }
}