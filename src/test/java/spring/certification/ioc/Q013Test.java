package spring.certification.ioc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Tests bean scoping functionality offered by Spring IoC container.
 */
public class Q013Test {

    private AnnotationConfigApplicationContext context;

    /**
     * Load configurations, create beans.
     */
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Q013.ScopeConfiguration.class);
    }

    /**
     * Release resources, remove beans.
     */
    @After
    public void tearDown() {
        context.close();
    }

    /**
     * Verifies that default bean scope is singleton.
     */
    @Test
    public void shouldShareSameBean() {
        Q013.Student student = context.getBean(Q013.Student.class);
        Q013.Writer writer = context.getBean(Q013.Writer.class);
        Assert.assertEquals(student.getInspiration(), writer.getInspiration());
    }

    /**
     * Verifies that new beans are created for each injected, in case prototype scope is defined.
     */
    @Test
    public void shouldCreateDifferentBeans() {
        Q013.Student student = context.getBean(Q013.Student.class);
        Q013.Writer writer = context.getBean(Q013.Writer.class);
        Assert.assertNotEquals(student.getNotebook(), writer.getNotebook());
    }
}