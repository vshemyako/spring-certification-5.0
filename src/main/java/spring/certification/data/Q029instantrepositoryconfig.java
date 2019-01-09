package spring.certification.data;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 029:<br>
 * How do you define an “instant” repository?<br>
 * Why is it an interface not a class?<br>
 * <p>
 * Answer:<br>
 * Spring Data repository ('instant' in other words) is created by extending {@link Repository} interface or by
 * annotating custom repository interface with {@link RepositoryDefinition} annotation. Both choices have the same
 * effect.<br>
 * <p>
 * Spring instant repository is defined as an interface for several reasons:<br>
 * - most importantly instant repository doesn't define any implementation details, it just declares
 * methods to be implemented dynamically.<br>
 * - interfaces allow to create JDK dynamic proxies to intercept repository calls.<br>
 *
 * @author Valentine Shemyako
 * @since January 09, 2019
 */
public class Q029instantrepositoryconfig {
}
