package spring.certification.ioc.q014.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Verifies functionality offered by {@link Lazy} annotation, which alters eager instantiation of singleton beans.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LazyConfiguration.class)
public class LazyConfigurationTest {

    @Autowired
    private GenericApplicationContext context;

    /**
     * Verifies that bean marked with {@link Lazy} annotation is indeed loaded lazily.
     */
    @Test
    public void shouldBeLazilyLoaded() {
        BeanDefinition coachPotato = context.getBeanDefinition("coachPotato");
        assertTrue(coachPotato.isLazyInit());
        assertFalse(CoachPotato.isInitialized());
        // Let's request bean creation...
        context.getBean(CoachPotato.class);
        assertTrue(CoachPotato.isInitialized());

        BeanDefinition rollingStone = context.getBeanDefinition("rollingStone");
        assertFalse(rollingStone.isLazyInit());
        assertTrue(RollingStone.isInitialized());
    }
}