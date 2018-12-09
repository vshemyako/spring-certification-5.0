package spring.certification.aop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.aop.Q007pointcut.Executor;
import spring.certification.aop.Q007pointcut.Politeness;
import spring.certification.aop.helper.AnnotatedPointcutHelper;
import spring.certification.aop.helper.PointcutHelper;
import spring.certification.aop.helper.Pojo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Verifies functionality of pointcuts designators.
 */
public class Q007pointcutTest {

    private static final String EMPTY_STRING = "";

    /**
     * Fields to redefine system streams.
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream predefinedOutputStream = System.out;

    /**
     * Auto-configured application context.
     */
    private AnnotationConfigApplicationContext context;
    private Executor executor;
    private AnnotatedPointcutHelper annotatedHelper;
    private Politeness politeness;
    private PointcutHelper helper;
    private Pojo pojo;

    /**
     * Substitutes system stream with 'dummy' byte array stream.
     * Configures application-context and registers shut down hook.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        context = new AnnotationConfigApplicationContext(Q007pointcut.PointcutConfigurationMarker.class);
        context.registerShutdownHook();
        politeness = context.getBean(Politeness.class);
        executor = context.getBean(Executor.class);
        annotatedHelper = context.getBean(AnnotatedPointcutHelper.class);
        helper = context.getBean(PointcutHelper.class);
        pojo = context.getBean(Pojo.class);
    }

    /**
     * Set previously changed system stream back.
     */
    @After
    public void tearDown() {
        System.setOut(predefinedOutputStream);
    }

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