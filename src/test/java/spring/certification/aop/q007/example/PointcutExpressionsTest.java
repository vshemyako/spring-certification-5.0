package spring.certification.aop.q007.example;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.aop.helper.AnnotatedPointcutHelper;
import spring.certification.aop.helper.HelperConfigurationMarker;
import spring.certification.aop.helper.PointcutHelper;
import spring.certification.aop.helper.Pojo;
import spring.certification.aop.helper.StreamRedefiner;

/**
 * Verifies functionality of pointcuts designators.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PointcutConfigurationMarker.class, HelperConfigurationMarker.class})
public class PointcutExpressionsTest extends StreamRedefiner {

    private static final String EMPTY_STRING = "";

    @Autowired
    private Executor executor;
    @Autowired
    private AnnotatedPointcutHelper annotatedHelper;
    @Autowired
    private Politeness politeness;
    @Autowired
    private PointcutHelper helper;
    @Autowired
    private Pojo pojo;

    /**
     * Verifies functionality of public pointcut designator.
     */
    @Test
    public void shouldMatchAccessModifier() {
        // Before advice should be executed only before 'greet' message.
        politeness.greet();
        // After advice should be executed only after 'greet' message.
        politeness.sayGoodbye();

        String actualValue = outputStream.toString();
        String expectedValue = Stream.of("Before", "Greet", "Goodbye", "After")
                .collect(Collectors.joining(System.lineSeparator(), EMPTY_STRING, System.lineSeparator()));
        Assert.assertEquals(expectedValue, actualValue);
    }

    /**
     * Verifies functionality of within pointcut designator.
     */
    @Test
    public void shouldMatchExecutor() {
        executor.execute();
        helper.ignore();

        String actualValue = outputStream.toString();
        String expectedValue = Stream.of("Execute", "Within", "Ignore")
                .collect(Collectors.joining(System.lineSeparator(), EMPTY_STRING, System.lineSeparator()));
        Assert.assertEquals(expectedValue, actualValue);
    }

    /**
     * Verifies functionality of @within pointcut designator.
     */
    @Test
    public void shouldMatchAnnotatedHelper() {
        annotatedHelper.help();
        helper.ignore();

        String actualValue = outputStream.toString();
        String expectedValue = Stream.of("@Within", "Help", "Ignore")
                .collect(Collectors.joining(System.lineSeparator(), EMPTY_STRING, System.lineSeparator()));
        Assert.assertEquals(expectedValue, actualValue);
    }

    /**
     * Verifies functionality of args pointcut designator.
     */
    @Test
    public void shouldMatchStringArgsMethod() {
        helper.printOut("Drop it");

        String actualValue = outputStream.toString();
        String expectedValue = Stream.of("Args", "Drop it")
                .collect(Collectors.joining(System.lineSeparator(), EMPTY_STRING, System.lineSeparator()));
        Assert.assertEquals(expectedValue, actualValue);
    }

    /**
     * Verifies functionality of pointcut expression which matches getters and setters.
     */
    @Test
    public void shouldMatchGetterAndSetterAccess() {
        pojo.setCount(1);
        pojo.getCount();

        String actualValue = outputStream.toString();
        String expectedValue = Stream.of("Detected property access", "Detected property access")
                .collect(Collectors.joining(System.lineSeparator(), EMPTY_STRING, System.lineSeparator()));
        Assert.assertEquals(expectedValue, actualValue);
    }
}