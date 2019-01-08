package spring.certification.data.helper.config.jpa.repository;

import org.springframework.stereotype.Component;
import spring.certification.data.helper.config.jpa.entity.Holiday;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Simple facade to find all entities of type {@link Holiday}.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
@Component
public class HolidayRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Holiday> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Holiday> criteriaQuery = criteriaBuilder.createQuery(Holiday.class);
        Root<Holiday> rootEntry = criteriaQuery.from(Holiday.class);
        CriteriaQuery<Holiday> allCriteriaQuery = criteriaQuery.select(rootEntry);
        TypedQuery<Holiday> allQuery = entityManager.createQuery(allCriteriaQuery);
        return allQuery.getResultList();
    }
}
