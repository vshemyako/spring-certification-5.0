package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import spring.certification.ioc.Q016.Holiday;

/**
 * Verifies functionality offered by {@link BeanFactoryPostProcessor}.
 */
public class Q016Test {

    private static final String MERRY_CHRISTMAS = "Merry Christmas";

    /**
     * Verifies that {@link PropertySourcesPlaceholderConfigurer} substitutes properties placeholders with values
     * provided in property files.
     */
    @Test
    public void shouldReplaceParameterPlaceholder() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q016.ProcessedByPostProcessorConfiguration.class);
        Holiday holiday = context.getBean(Holiday.class);
        Assert.assertEquals(MERRY_CHRISTMAS, holiday.getName());
        context.close();
    }
}