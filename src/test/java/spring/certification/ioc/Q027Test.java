package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Period;

/**
 * Verifies bean naming functionality offered by Spring framework.
 */
public class Q027Test {

    AnnotationConfigApplicationContext context;

    /**
     * Test fixture.
     */
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Q027.JavaBeanNameConfig.class);
    }

    /**
     * Verifies that default bean name is indeed bean factory method name.
     */
    @Test
    public void defaultNameShouldBeMethodName() {
        Period day = context.getBean("day", Period.class);
        Assert.assertNotNull(day);
    }

    /**
     * Verifies that default bean name can be changed by {@link Bean#name()} attribute.
     */
    @Test
    public void beanNameShouldBeNameAttributeValue() {
        Period week = context.getBean("week", Period.class);
        Assert.assertNotNull(week);

        // Default name was substituted with attribute name.
        shouldFailToFindBean("sevenDays");
    }

    /**
     * Verifies that default bean name can be changed by {@link Bean#value()} attribute which is alias for
     * {@link Bean#name} attribute.
     */
    @Test
    public void beanNameShouldBeValueAttributeValue() {
        Period month = context.getBean("month", Period.class);
        Assert.assertNotNull(month);

        // Default name was substituted with attribute name.
        shouldFailToFindBean("thirtyDays");
    }

    /**
     * Verifies that default bean name can be changed to array of values.
     */
    @Test
    public void beanNameShouldBeNameAttributeArrayOfValues() {
        Duration thirtyMinutes = context.getBean("thirtyMinutes", Duration.class);
        Assert.assertNotNull(thirtyMinutes);
        Duration halfAnHour = context.getBean("halfAnHour", Duration.class);
        Assert.assertNotNull(halfAnHour);
    }

    private void shouldFailToFindBean(String beanName) {
        try {
            context.getBean(beanName, Period.class);
            Assert.fail("Default bean name should be discarded");
        } catch (NoSuchBeanDefinitionException e) {
            // Legal to ignore.
        }
    }
}