package spring.certification.aop.q009;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.aop.helper.StreamRedefiner;
import spring.certification.aop.q009.example.ArgumentValidator;
import spring.certification.aop.q009.example.AspectMarkerConfiguration;
import spring.certification.aop.q009.example.PositiveNumbers;

/**
 * Verifies functionality of {@link ProceedingJoinPoint} object.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AspectMarkerConfiguration.class)
public class ProceedingJoinPointArgumentTest extends StreamRedefiner {

    @Autowired
    private PositiveNumbers positiveNumbers;

    /**
     * Verifies that it's possible to manipulate execution of advised method via {@link ProceedingJoinPoint} object
     * of around advice. In particular case {@link ArgumentValidator} should throw an exception in case of negative
     * argument.
     */
    @Test
    public void shouldThrowExceptionOnNegativeNumber() {
        try {
            positiveNumbers.addNumber(-1);
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals("Only positive numbers are accessible", ex.getMessage());
        }
    }

    /**
     * Verifies that target method will be invoked by {@link ArgumentValidator} object.
     */
    @Test
    public void shouldAddNumber() {
        positiveNumbers.addNumber(1);
        int first = positiveNumbers.getFirst();
        assertEquals(10, first);
    }
}