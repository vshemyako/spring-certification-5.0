package spring.chapter02.lifecycle;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class BeanLifecycleTest {

    private static final String CONFIG_LOCATION = "chapter02/beer-scan-definition.xml";

    private static final String CONSTRUCTOR = "Constructor";
    private static final String SETTER = "Setter";
    private static final String NAME_AWARE = "Bean name aware";
    private static final String FACTORY_AWARE = "Bean factory aware";
    private static final String CONTEXT_AWARE = "Application context aware";
    private static final String POST_CONSTRUCT = "Post construct";
    private static final String PROPERTIES_SET = "After properties set";
    private static final String BEFORE_INITIALIZATION = "Before initialization";
    private static final String AFTER_INITIALIZATION = "After initialization";
    private static final String DESTROY = "Destroy";

    /**
     * Fields to redefine system streams
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream predefinedOutputStream = System.out;

    /**
     * Substitutes predefined {@link OutputStream} of a {@link System} class
     */
    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Restores default streams
     */
    @After
    public void restoreStreams() {
        System.setOut(predefinedOutputStream);
    }

    /**
     * Verifies that bean lifecycle indeed goes through subsequent method invocations
     * described in {@link org.springframework.beans.factory.BeanFactory} interface
     */
    @Test
    public void shouldFollowBeanFactoryLifeCycleDefinition() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        context.close();

        String[] hooks = outputStream.toString().split(System.lineSeparator());
        String[] expectedHooks = new String[]{
                CONSTRUCTOR,
                SETTER,
                NAME_AWARE,
                FACTORY_AWARE,
                CONTEXT_AWARE,
                POST_CONSTRUCT,
                PROPERTIES_SET,
                BEFORE_INITIALIZATION,
                AFTER_INITIALIZATION,
                BEFORE_INITIALIZATION,
                AFTER_INITIALIZATION,
                DESTROY
        };

        // Assert
        Assert.assertTrue(Arrays.equals(hooks, expectedHooks));
    }
}
