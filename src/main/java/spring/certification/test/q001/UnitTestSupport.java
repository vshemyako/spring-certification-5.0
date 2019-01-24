package spring.certification.test.q001;

import org.springframework.mock.env.MockEnvironment;
import org.springframework.mock.env.MockPropertySource;
import spring.certification.test.q001.example.PropertyResolver;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * Do you use Spring in a unit test?<br>
 * <p>
 * Answer:<br>
 * Unit testing should not depend on any infrastructure framework / use it in some way in unit testing.
 * Spring framework advocates this non-invasive approach, thus your unit-tests do not depend on Spring.<br>
 * <b>Note:</b> Spring framework provides some mock objects and testing support classes that are convenient to be used
 * in unit testing (e.g. {@link MockPropertySource}, {@link MockEnvironment}...)<br>
 * <p>
 * {@link PropertyResolver} and related unit test demonstrate basic usage of Spring Framework support classes.<br>
 *
 * @author Valentine Shemyako
 * @since December 31, 2018
 */
public class UnitTestSupport {
}
