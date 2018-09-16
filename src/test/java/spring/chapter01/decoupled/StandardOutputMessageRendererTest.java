package spring.chapter01.decoupled;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tests functionality of {@link StandardOutputMessageRenderer} class
 */
public class StandardOutputMessageRendererTest {

    /**
     * Fields to redefine system streams
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream predefinedOutputStream = System.out;

    /**
     * Sets up custom {@link OutputStream} instead of system predefined
     */
    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Restores system defaults
     */
    @After
    public void restoreStreams() {
        System.setOut(predefinedOutputStream);
    }

    /**
     * Verifies that new instance of {@link MessageRenderer} class doesn't have predefined
     * {@link MessageProvider} instance
     */
    @Test
    public void newInstanceShouldNotHaveMessageProvider() {
        MessageRenderer messageRenderer = new StandardOutputMessageRenderer();
        Assert.assertNull(messageRenderer.getMessageProvider());
    }

    /**
     * Verifies that instance which is passed to the {@link MessageRenderer#setMessageProvider(MessageProvider)}
     * method is return by {@link MessageRenderer#getMessageProvider()} method
     */
    @Test
    public void setMessageProviderShouldInitializeRelatedField() {
        MessageRenderer messageRenderer = new StandardOutputMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        Assert.assertEquals(messageProvider, messageRenderer.getMessageProvider());
    }

    /**
     * Verifies that invocation of {@link MessageRenderer#render} method without previous
     * invocation of {@link MessageRenderer#setMessageProvider(MessageProvider)} method
     * will result in an exception being thrown
     */
    @Test(expected = IllegalStateException.class)
    public void renderMethodWithoutSpecifiedProviderShouldThrowException() {
        new StandardOutputMessageRenderer().render();
    }

    /**
     * Verifies that {@link MessageRenderer} indeed renders a message which is passed by
     * {@link MessageProvider}
     */
    @Test
    public void shouldRenderMessageProviderMessage() {
        MessageRenderer messageRenderer = new StandardOutputMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
        Assert.assertEquals("Hello World!" + System.lineSeparator(), outputStream.toString());
    }
}