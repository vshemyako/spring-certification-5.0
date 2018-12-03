package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

/**
 * Verifies {@link Profile} annotation functionality applied on method-level.
 */
public class Q030Test {

    /**
     * Verifies that startupInstant bean is created by IoC container in case qa profile is active.
     * Also no-profile bean creation is verified.
     */
    @Test
    public void qaContainerShouldReturnStartupInstant() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("qa");
        context.register(Q030.MethodLevelProfileConfiguration.class);
        context.refresh();

        verifyRegisteredBeans(context);
    }

    /**
     * Verifies that startupInstant bean will not be registered and therefore created in case no active profile is
     * specified.
     */
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void qaContainerShouldFailToReturnStartupInstant() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q030.MethodLevelProfileConfiguration.class);
        verifyRegisteredBeans(context);
    }

    private void verifyRegisteredBeans(ApplicationContext context) {
        // Verify that no-profile bean doesn't depend on active-profile.
        Instant shutdownInstant = context.getBean("shutdownInstant", Instant.class);
        Assert.assertNotNull(shutdownInstant);
        // Verify that profile bean depends on active-profile.
        Instant startupInstant = context.getBean("startupInstant", Instant.class);
        Assert.assertNotNull(startupInstant);
    }
}