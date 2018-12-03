package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.Q038.ExpressionLanguageFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Tests SpEL functionality utilized by {@link Value} annotation.
 */
public class Q038Test {

    private AnnotationConfigApplicationContext context;
    private ExpressionLanguageFeatures languageFeatures;

    /**
     * Test fixture which initializes application-context.
     */
    @Before
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(Q038.ComponentScanMarker.class);
        // Preferred way to close application context over plain #close method.
        this.context.registerShutdownHook();
        this.languageFeatures = context.getBean(ExpressionLanguageFeatures.class);
    }

    /**
     * Verifies evaluation of <b>literal</b> expressions.
     */
    @Test
    public void shouldEvaluateLiteralExpression() {
        int number = languageFeatures.getLiteralExpression();
        Assert.assertEquals(911, number);
    }

    /**
     * Verifies evaluation of <b>bean property</b> expressions.
     */
    @Test
    public void shouldEvaluateBeanProperty() {
        String beanName = languageFeatures.getCollaboratorBeanProperty();
        Assert.assertEquals("collaborator", beanName);
    }

    /**
     * Verifies evaluation of <b>inline list</b> expressions.
     */
    @Test
    public void shouldEvaluateInlineList() {
        List<Boolean> booleanValues = languageFeatures.getInlineList();
        Assert.assertTrue(booleanValues.contains(true));
        Assert.assertTrue(booleanValues.contains(false));
    }

    /**
     * Verifies evaluation of <b> inline map</b> expressions.
     */
    @Test
    public void shouldEvaluateInlineMap() {
        Map<String, Integer> wordToNumber = languageFeatures.getInlineMap();
        Assert.assertTrue(wordToNumber.containsKey("one"));
        Assert.assertEquals(1, (int) wordToNumber.get("one"));
        Assert.assertTrue(wordToNumber.containsKey("two"));
        Assert.assertEquals(2, (int) wordToNumber.get("two"));
    }

    /**
     * Verifies evaluation of <b>inline array</b> expressions.
     */
    @Test
    public void shouldEvaluateInlineArray() {
        Character[] abc = languageFeatures.getInlineArray();
        List<Character> alphabet = Arrays.asList(abc);
        Assert.assertTrue(alphabet.contains('a'));
        Assert.assertTrue(alphabet.contains('b'));
        Assert.assertTrue(alphabet.contains('c'));
    }

    /**
     * Verifies evaluation of <b>method invocation</b> expressions.
     */
    @Test
    public void shouldEvaluateMethodInvocation() {
        String greetingString = languageFeatures.getMethodInvocation();
        Assert.assertEquals("Hello SpEL", greetingString);
    }

    /**
     * Verifies evaluation of <b>comparison operator</b> expressions.
     */
    @Test
    public void shouldEvaluateComparison() {
        Boolean greaterThan = languageFeatures.getComparisonResult();
        Assert.assertTrue(greaterThan);
    }

    /**
     * Verifies evaluation of <b>type</b> expressions.
     */
    @Test
    public void shouldEvaluateType() throws ClassNotFoundException {
        Class<String> stringType = languageFeatures.getStringType();
        Assert.assertEquals(Class.forName("java.lang.Class"), stringType.getClass());
    }
}