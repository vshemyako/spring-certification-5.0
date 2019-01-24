package spring.certification.test.q003;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 003:<br>
 * How can you create a shared application context in a JUnit integration test?<br>
 * <p>
 * Answer:<br>
 * Possibilities differ depending on a version of JUnit being used:<br>
 * <b>JUnit 4</b>:<br>
 * - using {@link SpringRunner} class with {@link RunWith} annotation<br>
 * - using {@link SpringJUnit4ClassRunner} class with {@link RunWith}<br>
 * - implementing {@link ApplicationContextAware} interface which mandates to override
 * {@link ApplicationContextAware#setApplicationContext} method<br>
 * - extending one of the base test classes {@link AbstractJUnit4SpringContextTests}
 * or {@link AbstractTransactionalJUnit4SpringContextTests} depending on integration-test needs<br>
 * - by using {@link SpringClassRule} or {@link SpringMethodRule} custom Spring rules, in case another third-party
 * runners are used<br>
 * <p>
 * <b>JUnit 5</b>:<br>
 * - using {@link SpringExtension} class<br>
 * - using composed annotation {@link SpringJUnitConfig}<br>
 *
 * @author Valentine Shemyako
 * @since December 31, 2018
 */
public class SharedApplicationContext {
}
