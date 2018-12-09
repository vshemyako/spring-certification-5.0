package spring.certification.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.aop.Q005advice.ConfigurationMarker;
import spring.certification.aop.Q005advice.Fool;
import spring.certification.aop.Q005advice.PanicException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Verifies functionality of different types of AOP advices.
 */
public class Q005adviceTest {

    /**
     * Fields to redefine system streams.
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream predefinedOutputStream = System.out;

    /**
     * Auto-configured application context.
     */
    private AnnotationConfigApplicationContext context;
    private Fool fool;

    /**
     * Substitutes system stream with 'dummy' byte array stream.
     * Configures application-context and registers shut down hook.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        context = new AnnotationConfigApplicationContext(ConfigurationMarker.class);
        context.registerShutdownHook();
        fool = context.getBean(Fool.class);
    }

    /**
     * Set previously changed system stream back.
     */
    @After
    public void tearDown() {
        System.setOut(predefinedOutputStream);
    }

    /**
     * Verifies that {@link Before} advice is executed 'before' {@link Fool#nameCapital(String)} method.
     */
    @Test
    public void shouldExecuteBeforeAdvice() {
        fool.nameCapital("Germany");

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Berlin", "Capital of Germany unknown")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Verifies that {@link AfterReturning} advice is executed 'after' {@link Fool#nameQueen(String)} method.
     */
    @Test
    public void shouldExecuteAfterReturningAdvice() {
        fool.nameQueen("England");

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Queen of England unknown", "Elizabeth")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Verifies that {@link AfterThrowing} advice is executed 'after exception has been thrown' from
     * {@link Fool#nameContinent(String)} method.
     */
    @Test(expected = PanicException.class)
    public void shouldExecuteAfterThrowingAdvice() {
        fool.nameContinent("China");

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Asia")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Verifies that {@link org.aspectj.lang.annotation.After} advice is executed 'after' normal returning
     * of {@link Fool#nameCurrency(String)} method.
     */
    @Test
    public void shouldExecuteAfterNormalAdvice() {
        fool.nameCurrency("Denmark");

        String actualString = outputStream.toString();
        String expectedString = Stream.of("No money no honey", "The euro")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Verifies that {@link org.aspectj.lang.annotation.After} advice is executed 'after' exceptional returning
     * of {@link Fool#nameCurrency(String)} method.
     */
    @Test(expected = PanicException.class)
    public void shouldExecuteAfterExceptionalAdvice() {
        fool.nameCurrency("Russia");

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Russian ruble")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Verifies that {@link org.aspectj.lang.annotation.Around} advice is executed 'before' and 'after' execution
     * of {@link Fool#nameNeighboring(String)} method.
     */
    @Test
    public void shouldExecuteAroundAdvice() {
        fool.nameNeighboring("Belarus");

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Poland", "No idea", "Ukraine")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        Assert.assertEquals(expectedString, actualString);
    }
}