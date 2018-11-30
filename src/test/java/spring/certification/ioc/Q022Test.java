package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Verifies private fields injection functionality offered by Spring IoC container.
 */
public class Q022Test {

    /**
     * Verifies processing functionality of {@link Autowired} and {@link Value}.
     */
    @Test
    public void shouldInjectionValues() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Q022.PrivateFieldInjection.class);
        Q022.SpringFramework framework = context.getBean(Q022.SpringFramework.class);
        Assert.assertEquals("Rod Johnson", framework.getCeo());
        Assert.assertEquals("Juergen Hoeller", framework.getDev());
    }
}