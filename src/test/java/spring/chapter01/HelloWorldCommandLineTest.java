package spring.chapter01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tests functionality of {@link HelloWorldCommandLine} class
 */
public class HelloWorldCommandLineTest {

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
     * Asserts that standard predefined message is printed
     * in case arguments weren't passed to message printing method
     */
    @Test
    public void shouldPrintStandardMessageOnEmptyArguments() {
        HelloWorldCommandLine.main(new String[]{});
        Assert.assertEquals("Hello World!" + System.lineSeparator(), outputStream.toString());
    }

    /**
     * Asserts that single argument which is passed to message
     * printing method is indeed printed
     */
    @Test
    public void shouldPrintPassedSingleArgument() {
        String greetingMessage = "Hello kids";
        HelloWorldCommandLine.main(new String[]{greetingMessage});
        Assert.assertEquals(greetingMessage + System.lineSeparator(), outputStream.toString());
    }
}