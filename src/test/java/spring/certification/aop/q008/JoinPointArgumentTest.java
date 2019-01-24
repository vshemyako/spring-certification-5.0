package spring.certification.aop.q008;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.aspectj.lang.JoinPoint;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.aop.helper.StreamRedefiner;
import spring.certification.aop.q008.example.Calculator;
import spring.certification.aop.q008.example.JoinPointMarkerConfiguration;

/**
 * Verifies advice access possibility to advised method info which is represented by {@link JoinPoint} interface.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JoinPointMarkerConfiguration.class)
public class JoinPointArgumentTest extends StreamRedefiner {

    @Autowired
    private Calculator calculator;

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