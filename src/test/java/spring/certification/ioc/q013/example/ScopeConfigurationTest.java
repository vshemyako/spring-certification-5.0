package spring.certification.ioc.q013.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Valentine Shemyako
 * Created on 23.01.2019.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ScopeConfiguration.class)
public class ScopeConfigurationTest {

    @Autowired
    private ApplicationContext context;

    /**
     * Verifies that default bean scope is singleton.
     */
    @Test
    public void shouldShareSameBean() {
        Student student = context.getBean(Student.class);
        Writer writer = context.getBean(Writer.class);
        assertEquals(student.getInspiration(), writer.getInspiration());
    }

    /**
     * Verifies that new beans are created for each injected, in case prototype scope is defined.
     */
    @Test
    public void shouldCreateDifferentBeans() {
        Student student = context.getBean(Student.class);
        Writer writer = context.getBean(Writer.class);
        assertNotEquals(student.getNotebook(), writer.getNotebook());
    }
}