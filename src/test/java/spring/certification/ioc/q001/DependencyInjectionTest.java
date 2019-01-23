package spring.certification.ioc.q001;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.common.Beverage;
import spring.certification.ioc.common.Refrigerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Demonstrates dependency injection functionality which is offered by Spring IoC container.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Refrigerator.class, Beverage.class})
public class DependencyInjectionTest {

    @Autowired
    private Refrigerator refrigerator;
    @Autowired
    private Beverage beverage;

    /**
     * Verifies constructor-based dependency injection functionality.
     */
    @Test
    public void shouldWireUpComponents() {
        assertThat(refrigerator.getBeverage()).isEqualTo(beverage);
    }
}