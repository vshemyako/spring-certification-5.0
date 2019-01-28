package spring.certification.data.q023;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.helper.config.jpa.entity.Holiday;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Verifies functionality of JPA entity-manager configures for embedded database.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EmbeddedDBConfiguration.class)
public class CentralJpaBeanTest {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    /**
     * Verifies that during initialization process embedded database is pre-filled
     * with data.
     */
    @Test
    public void holidayDatabaseNotEmptyAfterInitialization() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(Holiday.class)));

        long entitiesCount = entityManager.createQuery(criteriaQuery).getSingleResult();
        assertEquals(5, entitiesCount);
    }

    /**
     * Verifies ORM functionality of simple {@link Holiday} entity.
     */
    @Test
    public void holidayDatabaseContainsChristmas() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Holiday christmas = entityManager.find(Holiday.class, 1);
        assertNotNull(christmas);
        assertEquals("Christmas", christmas.getName());
    }
}