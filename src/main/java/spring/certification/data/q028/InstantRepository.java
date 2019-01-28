package spring.certification.data.q028;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 028:<br>
 * What is an "instant repository"? (hint: recall Spring Data)<br>
 * <p>
 * Answer:<br>
 * <b>Instant repository</b> term refers to dynamic creation of a repository implementation. Such functionality
 * is offered by 'spring-data-jpa' module.<br>
 * <p>
 * In order to utilize this functionality the following steps must be taken:<br>
 * - {@link Configuration} class has also be marked with Enable[Jpa]Repositories annotation.<br>
 * - custom repository interface has to extend {@link Repository} interface, or has to be marked with {@link RepositoryDefinition}
 * annotation.<br>
 *
 * @author Valentine Shemyako
 * @since January 09, 2019
 */
public class InstantRepository {
}
