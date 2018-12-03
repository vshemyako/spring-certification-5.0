package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Objects;

/**
 * Accompanies {@link Q035} answer to the question about basic features of SpEL language, more specifically verifies
 * functionality offered by {@link ExpressionParser} and {@link Expression} interfaces.
 */
public class Q035Test {

    /**
     * SpEL parser used within unit tests. Reusable and thread-safe.
     */
    private static final ExpressionParser PARSER = new SpelExpressionParser();

    /**
     * Verifies SpEL functionality of evaluating literal expressions.
     */
    @Test
    public void shouldEvaluateLiteralExpression() {
        String singleCharacter = "'A'";
        String word = "'Word'";
        String integralNumber = "1";
        String floatingPointNumber = "1.0";

        Expression characterExpression = PARSER.parseExpression(singleCharacter);
        Character evaluatedCharacter = characterExpression.getValue(Character.class);
        Assert.assertTrue(Objects.equals('A', evaluatedCharacter));

        Expression stringExpression = PARSER.parseExpression(word);
        String evaluatedString = stringExpression.getValue(String.class);
        Assert.assertEquals("Word", evaluatedString);

        Expression integralNumberExpression = PARSER.parseExpression(integralNumber);
        Integer evaluatedIntegralNumber = integralNumberExpression.getValue(Integer.class);
        Assert.assertEquals(1, (int) evaluatedIntegralNumber);

        Expression floatingPointExpression = PARSER.parseExpression(floatingPointNumber);
        Double evaluatedFloatingPointExpression = floatingPointExpression.getValue(Double.class);
        Assert.assertEquals(1.0, (double) evaluatedFloatingPointExpression, 0.01);
    }

    /**
     * Verifies SpEL functionality of evaluating boolean expressions.
     */
    @Test
    public void shouldEvaluateBooleanExpression() {
        Boolean trueValue = PARSER.parseExpression("true").getValue(Boolean.class);
        Assert.assertTrue(trueValue);

        Boolean trueExpression = PARSER.parseExpression("0 < 1").getValue(Boolean.class);
        Assert.assertTrue(trueExpression);
    }

    /**
     * Verifies SpEL functionality of evaluating regular expressions.
     */
    @Test
    public void shouldEvaluateRegexp() {
        Boolean regexpResult = PARSER.parseExpression("'Bonnie' matches '\\w*'").getValue(Boolean.class);
        Assert.assertTrue(regexpResult);
    }

    /**
     * Verifies SpEL functionality of evaluating class expressions.
     */
    @Test
    public void shouldEvaluateClassExpression() {
        WordWrapper wordWrapper = new WordWrapper();
        String wrappedWord = PARSER.parseExpression("word").getValue(wordWrapper, String.class);
        Assert.assertEquals("Santa is coming", wrappedWord);
    }

    /**
     * Simple wrapper to demonstrate evaluation of class expressions
     */
    private static class WordWrapper {
        private String word = "Santa is coming";

        public String getWord() {
            return word;
        }
    }
}