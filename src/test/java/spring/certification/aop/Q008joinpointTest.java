package spring.certification.aop;

import org.aspectj.lang.JoinPoint;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Verifies advice access possibility to advised method info which is represented by {@link JoinPoint} interface.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
public class Q008joinpointTest {

    /**
     * Fields to redefine system streams.
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream predefinedOutputStream = System.out;

    /**
     * Auto-configured application context.
     */
    private AnnotationConfigApplicationContext context;
    private Q008joinpoint.Calculator calculator;

    /**
     * Substitutes system stream with 'dummy' byte array stream.
     * Configures application-context and registers shut down hook.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        context = new AnnotationConfigApplicationContext(Q008joinpoint.JoinPointMarkerConfiguration.class);
        context.registerShutdownHook();
        calculator = context.getBean(Q008joinpoint.Calculator.class);
    }

    /**
     * Set previously changed system stream back.
     */
    @After
    public void tearDown() {
        System.setOut(predefinedOutputStream);
    }

    /**
     * Verifies that advised method info can indeed be accessed using {@link JoinPoint} object.
     */
    @Test
    public void shouldPrintArgumentsInfo() {
        calculator.add(2, 3);

        String actualValue = outputStream.toString();
        String expectedValue = Stream.of("Argument 1: 2", "Argument 2: 3")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        Assert.assertEquals(expectedValue, actualValue);
    }
}