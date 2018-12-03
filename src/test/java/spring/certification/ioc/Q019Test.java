package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.Q019.Cinema;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Verifies that JSR-250 {@link PostConstruct} and {@link PreDestroy} annotations are indeed processed by Spring IoC
 * container.
 */
public class Q019Test {

    /**
     * Verifies that init and destroy functionality of {@link Cinema} class is executed by Spring IoC container.
     */
    @Test
    public void shouldInvokeInitAndDestroyMethods() {
        // Initialization callback should fill the signboard
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q019.CinemaConfiguration.class);
        Cinema cinema = context.getBean(Cinema.class);
        Q019.Signboard signboard = cinema.getSignboard();
        Assert.assertEquals(
                "Fear can hold you prisoner. Hope can set you free.",
                signboard.getTitle()
        );

        // Destruction callback should clean the signboard
        context.close();
        Assert.assertNull(signboard.getTitle());
    }
}