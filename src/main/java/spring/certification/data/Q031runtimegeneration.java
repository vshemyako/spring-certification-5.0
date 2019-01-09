package spring.certification.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.parser.PartTree;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 031:<br>
 * How are Spring Data repositories implemented by Spring at runtime?<br>
 * <p>
 * Answer:<br>
 * For a thorough explanation of runtime repository generation please refer to a Stackoverflow thread:
 * <a href="https://stackoverflow.com/questions/38509882/how-are-spring-data-repositories-actually-implemented">
 * link
 * </a><br>
 * In essence, no code is generated but instead JDK dynamic proxies are created for each repository interface, thus
 * method calls are intercepted and routed to the one of the following places:<br>
 * - to a custom repository implementation (if one was specified)<br>
 * - to a specific query execution mechanism (in case {@link Query} is specified)<br>
 * - to a method name parsing mechanism ({@link PartTree} is used)<br>
 * - to a default {@link SimpleJpaRepository} implementation (in case JPA repositories are used)<br>
 *
 * @author Valentine Shemyako
 * @since January 10, 2019
 */
public class Q031runtimegeneration {
}
