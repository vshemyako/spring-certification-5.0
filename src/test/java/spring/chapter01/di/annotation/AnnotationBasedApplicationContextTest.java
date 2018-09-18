package spring.chapter01.di.annotation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.chapter01.decoupled.MessageRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tests functionality of annotation based application context configuration
 */
public class AnnotationBasedApplicationContextTest {

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
     * Verifies rendering functionality of {@link MessageRenderer} class which is instantiated
     * and configured using Spring DI model
     */
    @Test
    public void shouldPrintGreetingMessage() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageBeansConfiguration.class);
        MessageRenderer renderer = context.getBean(MessageRenderer.class);
        renderer.render();

        Assert.assertEquals("Hello World!" + System.lineSeparator(), substitutionStream.toString());
    }
}
