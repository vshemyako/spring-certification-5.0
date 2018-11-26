package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

/**
 * Verifies functionality to manually register custom source of properties.
 */
public class Q015Test {

    /**
     * Verifies that manually added {@link PropertySource} is indeed registered in {@link Environment} abstraction.
     */
    @Test
    public void shouldContainCustomPropertySource() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Q015.CustomPropertySourceConfiguration.class);
        context.registerShutdownHook();

        ConfigurableEnvironment environment = context.getEnvironment();
        PropertySource<?> seasonEmotions = environment.getPropertySources().get("seasonEmotions");
        Assert.assertNotNull(seasonEmotions);
        Assert.assertTrue(seasonEmotions.containsProperty("autumn"));
    }
}