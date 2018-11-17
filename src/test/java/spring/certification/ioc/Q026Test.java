package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * Tests functionality of {@link Bean} annotation discussed in related question {@link Q026}.
 */
public class Q026Test {

    /**
     * Verifies that {@link Bean} factory method is producing bean definitions for Spring IoC container.
     */
    @Test
    public void shouldReturnComposedBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q026.SimpleJavaConfig.class);
        LocalDate christmasDay = context.getBean(LocalDate.class);
        Assert.assertNotNull(christmasDay);
    }
}