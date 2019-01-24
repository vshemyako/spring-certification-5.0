package spring.certification.ioc;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import spring.certification.ioc.q034.ValueAnnotationFunctionality;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 039:<br>
 * What is the difference between $ and # in @Value expressions?
 * <p>
 * Answer:<br>
 * Expressions started with '$' sign refer to property name of the application's {@link Environment}.<br>
 * Those expressions are evaluated by {@link PropertySourcesPlaceholderConfigurer}.<br>
 * Expressions started with '#' sign designate SpEL expressions which should be parsed by {@link ExpressionParser}
 * and are evaluated by {@link Expression}.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link ValueAnnotationFunctionality.ShelfConfiguration} - demonstrates usage of both types.
 *
 * @author Valentine Shemyako
 * @since December 01, 2018
 */
public class Q039 {
}
