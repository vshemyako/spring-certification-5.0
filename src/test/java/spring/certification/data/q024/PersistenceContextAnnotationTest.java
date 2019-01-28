package spring.certification.data.q024;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Proxy;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.helper.config.jpa.entity.Holiday;
import spring.certification.data.helper.config.jpa.repository.HolidayRepository;

/**
 * Just a demonstration of {@link PersistenceContext} annotation usage.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EmbeddedDBConfiguration.class, HolidayRepository.class})
public class PersistenceContextAnnotationTest {

    @Autowired
    private HolidayRepository holidayRepository;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Verifies functionality of a {@link HolidayRepository} class.
     * The main purpose of this dummy implementation - demonstrate usage of
     */
    @Test
    public void repositoryReturnAllEntities() {
        List<Holiday> holidays = holidayRepository.findAll();
        assertFalse(holidays.isEmpty());
        assertEquals(5, holidays.size());
    }

    /**
     * Verifies that {@link EntityManager} instance injected by Spring IoC is actually a
     * proxy which is thread-safe.
     */
    @Test
    public void shouldBeProxyWrapped() {
        assertTrue(Proxy.isProxyClass(entityManager.getClass()));
    }
}