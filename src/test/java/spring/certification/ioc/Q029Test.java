package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Verifies basic functionality of {@link Profile} annotation.
 */
public class Q029Test {

    /**
     * Verifies that startupMessage bean is created by IoC container in case production profile is active.
     */
    @Test
    public void prodContainerShouldReturnStartupMessage() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // Set active profile as "production".
        context.getEnvironment().setActiveProfiles("production");
        context.register(Q029.DevelopmentConfiguration.class);
        context.refresh();

        String startupMessage = context.getBean("startupMessage", String.class);
        Assert.assertNotNull(startupMessage);
    }

    /**
     * Verifies that startupMessage bean is not created by IoC container in case production profile is not active.
     */
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void defaultContainerShouldFailToReturnStartupMessage() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q029.DevelopmentConfiguration.class);
        context.getBean("startupMessage");
    }

    /**
     * Verifies that password bean is registered only in case of more complex 'and' profile expression.
     */
    @Test
    public void leadDeveloperProfileShouldRegisterConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("production", "leadDeveloper");
        context.register(Q029.LeadDeveloperProductionConfiguration.class);
        context.refresh();

        String password = context.getBean(String.class);
        Assert.assertNotNull(password); // Not needed actually
        context.close();
    }
}