package spring.certification.ioc.q023;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.q023.example.Cinema;
import spring.certification.ioc.q023.example.NonQualifiedConfiguration;
import spring.certification.ioc.q023.example.QualifiedConfiguration;

/**
 * Verifies appropriate usage of {@link Qualifier} annotations.
 */
public class QualifiedAutowiringTest {

    /**
     * Verifies that application-context will fail in initialize in case dependency injection cannot be performed
     * due to ambiguity.
     */
    @Test(expected = UnsatisfiedDependencyException.class)
    public void configurationShouldFail() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(NonQualifiedConfiguration.class)) {
            context.getBean(Cinema.class);
        }
    }

    /**
     * Verifies that application-context will succeed to initialize due to appropriate usage of custom
     * {@link Qualifier} annotation.
     */
    @Test
    public void configurationShouldSucceed() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(QualifiedConfiguration.class)) {
            Cinema cinema = context.getBean(Cinema.class);
            String filmName = cinema.getFilm().getFilmName();
            Assert.assertEquals("Fight Club", filmName);
        }
    }
}