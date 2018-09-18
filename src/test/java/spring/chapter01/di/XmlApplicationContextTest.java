package spring.chapter01.di;

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
 * Tests functionality of beans detection/creation using 'xml' based configuration
 */
public class XmlApplicationContextTest {

    private static final String APPLICATION_CONTEXT_CONFIG = "chapter01/spring/app-context.xml";

    private PrintStream predefinedStream = System.out;
    private OutputStream substitutionStream = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(substitutionStream));
    }

    @After
    public void restoreDefaults() {
        System.setOut(predefinedStream);
    }

    /**
     * Verifies that automatically instantiated class with needed injections indeed prints
     * greeting message
     */
    @Test
    public void shouldPrintGreetingMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_CONFIG);
        MessageRenderer renderer = context.getBean(MessageRenderer.class);
        renderer.render();

        Assert.assertEquals("Hello World!" + System.lineSeparator(), substitutionStream.toString());
    }
}
