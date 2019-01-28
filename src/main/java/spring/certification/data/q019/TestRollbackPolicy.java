package spring.certification.data.q019;

import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 019:<br>
 * What is the default rollback policy in a JUnit test, when you use the @RunWith(SpringJUnit4ClassRunner.class) in
 * JUnit 4 or @ExtendWith(SpringExtension.class) in JUnit 5, and annotate your @Test annotated method with @Transactional?<br>
 * <p>
 * Answer:<br>
 * By default, test transactions will be automatically rolled back after completion of the test; however, transactional
 * commit and rollback behavior can be configured via the {@link Commit} and {@link Rollback} annotations.<br>
 *
 * @author Valentine Shemyako
 * @since January 03, 2019
 */
public class TestRollbackPolicy {
}
