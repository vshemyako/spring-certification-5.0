package spring.certification.ioc.q035;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 035:<br>
 * What is Spring Expression Language (SpEL for short)?<br>
 * <p>
 * Answer:<br>
 * It's an independent expression language which can be used separately from Spring framework itself. But its
 * functionality and language features are driven directly by the requirements of the Spring framework.<br>
 * <p>
 * SpEL turns around usage of the following interfaces:<br>
 * 1. {@link ExpressionParser} - is used to parse 'string' expressions into compiled {@link Expression} objects<br>
 * 2. {@link Expression} - is used to evaluate self-contained value against context of objects it is used within<br>
 * <p>
 * SpEL language features:<br>
 * - literal expressions (should be wrapped into <b>'</b> single quotation marks<br>
 * - boolean and relational operators<br>
 * - regular expressions (using matches keyword)<br>
 * - class expressions<br>
 * - etc.<br>
 * Examples of mentioned terms:<br>
 * Please look at the counterpart test suite - it demonstrates usage of SpEL language in framework agnostic way.<br>
 *
 * @author Valentine Shemyako
 * @since December 01, 2018
 */
public class SpelFunctionality {
}
