package spring.chapter02.injection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.chapter01.decoupled.MessageRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Verifies functionality offered by 'component-scan' attribute of configuration xml file
 */
public class ComponentScanTest {

    private static final String APPLICATION_CONTEXT_CONFIG = "chapter02/component-scan-definition.xml";

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
     * Tests that renderer outputs message provided by auto-injected message provider bean
     * defined in xml configuration file
     */
    @Test
    public void shouldOutputGreetingMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_CONFIG);
        MessageRenderer renderer = context.getBean(MessageRenderer.class);
        renderer.render();

        Assert.assertEquals("Hello World!" + System.lineSeparator(), outputStream.toString());
    }
}
