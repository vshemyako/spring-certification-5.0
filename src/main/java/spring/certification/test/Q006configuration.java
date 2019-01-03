package spring.certification.test;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 006:<br>
 * How is @ContextConfiguration used?<br>
 * <p>
 * Answer:<br>
 * {@link ContextConfiguration} annotation specifies xml or java based configuration which should be loaded by
 * {@link ApplicationContext} class. It is used along with {@link SpringRunner} class to test particular context
 * configuration (presumably not so complex as production-one, only some kind of a subset).<br>
 * <p>
 * There're integration tests in the related project section which investigates usages of {@link ContextConfiguration}
 * annotation.<br>
 *
 * @author Valentine Shemyako
 * @since January 02, 2019
 */
public class Q006configuration {
}
