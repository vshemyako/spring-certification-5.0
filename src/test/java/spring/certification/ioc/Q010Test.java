package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Verifies that concepts described in {@link Q010} class indeed work. More specifically that
 * {@link AnnotationConfigApplicationContext} loads java-based configurations and produces beans.
 */
public class Q010Test {

    /**
     * Verify java-based configuration workings.
     */
    @Test
    public void shouldManageBeans() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Q010.JavaBasedConfiguration.class);
        Q010.Smartphone smartphone = context.getBean(Q010.Smartphone.class);
        Assert.assertNotNull(smartphone.extractBattery());
    }
}