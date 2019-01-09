package spring.certification.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.helper.config.jpa.entity.Holiday;
import spring.certification.data.helper.config.jpa.instant.InstantHolidayRepository;

import java.util.Optional;

/**
 * Verified functionality of instant spring-data repositories.
 *
 * @author Valentine Shemyako
 * @since January 09, 2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EmbeddedDBConfiguration.class)
public class Q028instantrepositoryTest {

    @Autowired
    private InstantHolidayRepository holidayRepository;

    @Test
    public void shouldReturnChristmas() {
        Optional<Holiday> christmas = holidayRepository.findById(1);
        Assert.assertTrue(christmas.isPresent());
        Assert.assertEquals("Christmas", christmas.get().getName());
    }
}