package spring.certification.data.helper.config.jpa.instant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * Just an example of intermediate repository which specifies additional base methods for the rest
 * of concrete interfaces. Note that the usage of {@link NoRepositoryBean} annotation is mandatory -
 * otherwise Spring complains that there's no entity-class of type {@link Object}.
 */
@NoRepositoryBean
public interface IntermediateHolidayRepository<T, ID> extends CrudRepository<T, ID> {

    /**
     * Searches for an object which is uniquely identified by {@param name}.
     *
     * @param name which is unique within database table.
     * @return found object if any.
     */
    Optional<T> findByName(String name);
}
