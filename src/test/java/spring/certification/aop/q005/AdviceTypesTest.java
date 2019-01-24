package spring.certification.aop.q005;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.aop.helper.StreamRedefiner;
import spring.certification.aop.q005.example.AdviceConfigurationMarker;
import spring.certification.aop.q005.example.Fool;
import spring.certification.aop.q005.example.PanicException;

/**
 * Verifies functionality of different types of AOP advices.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdviceConfigurationMarker.class)
public class AdviceTypesTest extends StreamRedefiner {

    @Autowired
    private Fool fool;

    /**
     * Verifies that {@link Before} advice is executed 'before' {@link Fool#nameCapital(String)} method.
     */
    @Test
    public void shouldExecuteBeforeAdvice() {
        fool.nameCapital("Germany");

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Berlin", "Capital of Germany unknown")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        assertEquals(expectedString, actualString);
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
        assertEquals(expectedString, actualString);
    }

    /**
     * Verifies that {@link AfterThrowing} advice is executed 'after exception has been thrown' from
     * {@link Fool#nameContinent(String)} method.
     */
    @Test
    public void shouldExecuteAfterThrowingAdvice() {
        try {
            fool.nameContinent("China");
            fail();
        } catch (PanicException ex) {
            // Legal to ignore.
        }

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Asia")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        assertEquals(expectedString, actualString);
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
        assertEquals(expectedString, actualString);
    }

    /**
     * Verifies that {@link org.aspectj.lang.annotation.After} advice is executed 'after' exceptional returning
     * of {@link Fool#nameCurrency(String)} method.
     */
    @Test
    public void shouldExecuteAfterExceptionalAdvice() {
        try {
            fool.nameCurrency("Russia");
            fail();
        } catch (PanicException ex) {
            // Legal to ignore.
        }

        String actualString = outputStream.toString();
        String expectedString = Stream.of("Russian ruble")
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
        assertEquals(expectedString, actualString);
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
        assertEquals(expectedString, actualString);
    }
}