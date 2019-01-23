package spring.certification.ioc.q004;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.common.Beverage;
import spring.certification.ioc.common.Refrigerator;

/**
 * Demonstrates basic capabilities of {@link org.springframework.context.ApplicationContext} container for assembling
 * and managing objects (known as beans).
 */
public class ApplicationContextTest {

    private AnnotationConfigApplicationContext applicationContext;

    /**
     * Manually configures {@link org.springframework.context.ApplicationContext} object
     * (by loading bean-definitions).
     */
    @Before
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Refrigerator.class);
        applicationContext.register(Beverage.class);
        applicationContext.refresh();
    }

    @After
    public void tearDown() {
        applicationContext.close();
    }

    @Test
    public void shouldAssembleBeans() {
        Refrigerator refrigerator = applicationContext.getBean(Refrigerator.class);
        Beverage beverage = applicationContext.getBean(Beverage.class);
        assertThat(refrigerator.getBeverage()).isEqualTo(beverage);
    }
}