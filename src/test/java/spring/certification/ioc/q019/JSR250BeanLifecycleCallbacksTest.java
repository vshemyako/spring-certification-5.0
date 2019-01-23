package spring.certification.ioc.q019;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.q019.example.Cinema;
import spring.certification.ioc.q019.example.CinemaConfiguration;
import spring.certification.ioc.q019.example.Signboard;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Verifies that JSR-250 {@link PostConstruct} and {@link PreDestroy} annotations are indeed processed by Spring IoC
 * container.
 */
public class JSR250BeanLifecycleCallbacksTest {

    private AnnotationConfigApplicationContext context;
    private Signboard signboard;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(CinemaConfiguration.class);
        Cinema cinema = context.getBean(Cinema.class);
        signboard = cinema.getSignboard();
    }

    /**
     * Verifies that init and destroy functionality of {@link Cinema} class is executed by Spring IoC container.
     */
    @Test
    public void shouldInvokeInitAndDestroyMethods() {
        // Initialization callback should fill the signboard
        assertThat(signboard.getTitle()).isEqualTo("Fear can hold you prisoner. Hope can set you free.");
        // Destruction callback should clean the signboard
        context.close();
        assertThat(signboard.getTitle()).isNull();
    }
}