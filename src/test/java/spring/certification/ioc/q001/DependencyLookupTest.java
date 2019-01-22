package spring.certification.ioc.q001;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.common.Beverage;
import spring.certification.ioc.common.Refrigerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Demonstrates another flavor of dependency injection functionality known as dependency lookup.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Beverage.class)
public class DependencyLookupTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void shouldManuallyWireUpComponents() {
        // Required dependency is obtained manually.
        Beverage beverage = applicationContext.getBean("beverage", Beverage.class);
        assertThat(beverage).isNotNull();
        // Target object is created.
        new Refrigerator(beverage);
    }
}