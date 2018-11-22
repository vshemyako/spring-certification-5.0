package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

/**
 * Verifies functionality offered by {@link Lazy} annotation, which alters eager instantiation of singleton beans.
 */
public class Q014Test {

    /**
     * Verifies that bean marked with {@link Lazy} annotation is indeed loaded lazily.
     */
    @Test
    public void shouldBeLazilyLoaded() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q014.LazyConfiguration.class);
        BeanDefinition coachPotato = context.getBeanDefinition("coachPotato");
        Assert.assertTrue(coachPotato.isLazyInit());
        context.close();
    }
}