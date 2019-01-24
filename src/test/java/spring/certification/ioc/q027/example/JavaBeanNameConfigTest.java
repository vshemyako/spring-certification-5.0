package spring.certification.ioc.q027.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.Duration;
import java.time.Period;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Verifies bean naming functionality offered by Spring framework.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JavaBeanNameConfig.class)
public class JavaBeanNameConfigTest {

    @Autowired
    private ApplicationContext context;

    /**
     * Verifies that default bean name is indeed bean factory method name.
     */
    @Test
    public void defaultNameShouldBeMethodName() {
        Period day = context.getBean("day", Period.class);
        assertNotNull(day);
    }

    /**
     * Verifies that default bean name can be changed by {@link Bean#name()} attribute.
     */
    @Test
    public void beanNameShouldBeNameAttributeValue() {
        Period week = context.getBean("week", Period.class);
        assertNotNull(week);

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
        assertNotNull(month);

        // Default name was substituted with attribute name.
        shouldFailToFindBean("thirtyDays");
    }

    /**
     * Verifies that default bean name can be changed to array of values.
     */
    @Test
    public void beanNameShouldBeNameAttributeArrayOfValues() {
        Duration thirtyMinutes = context.getBean("thirtyMinutes", Duration.class);
        assertNotNull(thirtyMinutes);
        Duration halfAnHour = context.getBean("halfAnHour", Duration.class);
        assertNotNull(halfAnHour);
    }

    private void shouldFailToFindBean(String beanName) {
        try {
            context.getBean(beanName, Period.class);
            fail("Default bean name should be discarded");
        } catch (NoSuchBeanDefinitionException e) {
            // Legal to ignore.
        }
    }
}