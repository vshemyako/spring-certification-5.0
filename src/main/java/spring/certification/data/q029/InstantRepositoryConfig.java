package spring.certification.data.q029;

import org.springframework.data.repository.NoRepositoryBean;
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
 * <p>
 * <b>Important note:</b><br>
 * Often it is useful to define some common data-access repository methods which are shared among different
 * instant repositories. Such intermediate interfaces should be marked with {@link NoRepositoryBean} annotation,
 * telling Spring Framework not to create dynamic proxy for it.<br>
 *
 * @author Valentine Shemyako
 * @since January 09, 2019
 */
public class InstantRepositoryConfig {
}
