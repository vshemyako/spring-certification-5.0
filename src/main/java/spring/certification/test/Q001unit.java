package spring.certification.test;

import org.springframework.mock.env.MockEnvironment;
import org.springframework.mock.env.MockPropertySource;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * Do you use Spring in a unit test?<br>
 * <p>
 * Answer:<br>
 * Unit testing should not depend on any infrastructure framework and use it in some invasive way in unit testing.
 * Spring framework advocates this non-invasive approach, thus your unit-tests do not depend on Spring.<br>
 * <b>Note:</b> Spring framework provides some mock objects and testing support classes that are convenient to be used
 * in unit testing (e.g. {@link MockPropertySource}, {@link MockEnvironment}...)<br>
 *
 * @author Valentine Shemyako
 * @since December 31, 2018
 */
public class Q001unit {
}
