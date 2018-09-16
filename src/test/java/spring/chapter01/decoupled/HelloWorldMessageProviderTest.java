package spring.chapter01.decoupled;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functionality of {@link HelloWorldMessageProvider} class
 */
public class HelloWorldMessageProviderTest {

    /**
     * Tests whether instance of {@link HelloWorldMessageProvider} indeed returns
     * 'Hello World!' message
     */
    @Test
    public void shouldReturnHelloWorld() {
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        Assert.assertEquals("Hello World!", messageProvider.getMessage());
    }
}