package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.Q017.AlcoholicPostProcessor;
import spring.certification.ioc.Q017.Beer;
import spring.certification.ioc.Q017.Wine;

/**
 * Verifies functionality offered by {@link AlcoholicPostProcessor}
 */
public class Q017Test {

    /**
     * Verifies that {@link AlcoholicPostProcessor} bean post-processor will substitute beans of type {@link Wine}
     * with beans of type {@link Beer}.
     */
    @Test
    public void shouldSubstituteBeans() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q017.AlcoholicConfiguration.class);
        context.registerShutdownHook();
        Q017.Alcohol alcohol = context.getBean(Q017.Alcohol.class);
        Assert.assertEquals("bear", alcohol.getName());
    }
}