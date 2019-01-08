package spring.certification.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.helper.config.jpa.entity.Holiday;
import spring.certification.data.helper.config.jpa.repository.HolidayRepository;

import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Just a demonstration of {@link PersistenceContext} annotation usage.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EmbeddedDBConfiguration.class, HolidayRepository.class})
public class Q026persistencecontextTest {

    @Autowired
    private HolidayRepository holidayRepository;

    /**
     * Verifies functionality of a {@link HolidayRepository} class.
     * The main purpose of this dummy implementation - demonstrate usage of
     */
    @Test
    public void repositoryReturnAllEntities() {
        List<Holiday> holidays = holidayRepository.findAll();
        assertFalse(holidays.isEmpty());
        assertEquals(4, holidays.size());
    }
}