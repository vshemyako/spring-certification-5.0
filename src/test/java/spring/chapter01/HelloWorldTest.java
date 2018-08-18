package spring.chapter01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tests functionality of {@link HelloWorld} class
 */
public class HelloWorldTest {

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
     * Asserts that predefined message is printed to the standard output
     */
    @Test
    public void shouldPrintHelloWorld() {
        HelloWorld.main(null);
        Assert.assertEquals("Hello World!", outputStream.toString());
    }
}