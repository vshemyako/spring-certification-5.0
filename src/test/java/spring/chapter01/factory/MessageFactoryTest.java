package spring.chapter01.factory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import spring.chapter01.decoupled.MessageProvider;
import spring.chapter01.decoupled.MessageRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tests functionality of {@link MessageFactory} class
 */
public class MessageFactoryTest {

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
     * Verifies that {@link MessageFactory} class provides valid instances of
     * {@link MessageRenderer} and {@link MessageProvider} classes, which
     * in cooperation print desired message
     */
    @Test
    public void shouldPrintGreetingMessage() {
        MessageProvider messageProvider = MessageFactory.getInstance().getMessageProvider();
        MessageRenderer messageRenderer = MessageFactory.getInstance().getMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();

        Assert.assertEquals("Hello World!" + System.lineSeparator(), substitutionStream.toString());
    }
}
