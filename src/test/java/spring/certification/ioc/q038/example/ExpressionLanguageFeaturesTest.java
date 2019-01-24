package spring.certification.ioc.q038.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests SpEL functionality offered by {@link Value} annotation.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ComponentScanMarker.class)
public class ExpressionLanguageFeaturesTest {

    @Autowired
    private ExpressionLanguageFeatures languageFeatures;

    /**
     * Verifies evaluation of <b>literal</b> expressions.
     */
    @Test
    public void shouldEvaluateLiteralExpression() {
        int number = languageFeatures.getLiteralExpression();
        assertEquals(911, number);
    }

    /**
     * Verifies evaluation of <b>bean property</b> expressions.
     */
    @Test
    public void shouldEvaluateBeanProperty() {
        String beanName = languageFeatures.getCollaboratorBeanProperty();
        assertEquals("collaborator", beanName);
    }

    /**
     * Verifies evaluation of <b>inline list</b> expressions.
     */
    @Test
    public void shouldEvaluateInlineList() {
        List<Boolean> booleanValues = languageFeatures.getInlineList();
        assertTrue(booleanValues.contains(true));
        assertTrue(booleanValues.contains(false));
    }

    /**
     * Verifies evaluation of <b> inline map</b> expressions.
     */
    @Test
    public void shouldEvaluateInlineMap() {
        Map<String, Integer> wordToNumber = languageFeatures.getInlineMap();
        assertTrue(wordToNumber.containsKey("one"));
        assertEquals(1, (int) wordToNumber.get("one"));
        assertTrue(wordToNumber.containsKey("two"));
        assertEquals(2, (int) wordToNumber.get("two"));
    }

    /**
     * Verifies evaluation of <b>inline array</b> expressions.
     */
    @Test
    public void shouldEvaluateInlineArray() {
        Character[] abc = languageFeatures.getInlineArray();
        List<Character> alphabet = Arrays.asList(abc);
        assertTrue(alphabet.contains('a'));
        assertTrue(alphabet.contains('b'));
        assertTrue(alphabet.contains('c'));
    }

    /**
     * Verifies evaluation of <b>method invocation</b> expressions.
     */
    @Test
    public void shouldEvaluateMethodInvocation() {
        String greetingString = languageFeatures.getMethodInvocation();
        assertEquals("Hello SpEL", greetingString);
    }

    /**
     * Verifies evaluation of <b>comparison operator</b> expressions.
     */
    @Test
    public void shouldEvaluateComparison() {
        Boolean greaterThan = languageFeatures.getComparisonResult();
        assertTrue(greaterThan);
    }

    /**
     * Verifies evaluation of <b>type</b> expressions.
     */
    @Test
    public void shouldEvaluateType() throws ClassNotFoundException {
        Class<String> stringType = languageFeatures.getStringType();
        assertEquals(Class.forName("java.lang.Class"), stringType.getClass());
    }
}