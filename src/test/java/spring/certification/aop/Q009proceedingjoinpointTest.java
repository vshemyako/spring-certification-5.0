package spring.certification.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.aop.Q009proceedingjoinpoint.ArgumentValidator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Verifies functionality of {@link ProceedingJoinPoint} object.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
public class Q009proceedingjoinpointTest {

    /**
     * Fields to redefine system streams.
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream predefinedOutputStream = System.out;

    /**
     * Auto-configured application context.
     */
    private AnnotationConfigApplicationContext context;
    private Q009proceedingjoinpoint.PositiveNumbers positiveNumbers;

    /**
     * Substitutes system stream with 'dummy' byte array stream.
     * Configures application-context and registers shut down hook.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        context = new AnnotationConfigApplicationContext(Q009proceedingjoinpoint.AspectMarkerConfiguration.class);
        context.registerShutdownHook();
        positiveNumbers = context.getBean(Q009proceedingjoinpoint.PositiveNumbers.class);
    }

    /**
     * Set previously changed system stream back.
     */
    @After
    public void tearDown() {
        System.setOut(predefinedOutputStream);
    }

    /**
     * Verifies that it's possible to manipulate execution of advised method via {@link ProceedingJoinPoint} object
     * of around advice. In particular case {@link ArgumentValidator} should throw an exception in case of negative
     * argument.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnNegativeNumber() {
        positiveNumbers.addNumber(-1);
    }

    /**
     * Verifies that target method will be invoked by {@link ArgumentValidator} object.
     */
    @Test
    public void shouldAddNumber() {
        positiveNumbers.addNumber(1);
        int first = positiveNumbers.getFirst();
        Assert.assertEquals(10, first);
    }
}