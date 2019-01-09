package spring.certification.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.data.repository.NoRepositoryBean;
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

    private static final String CHRISTMAS = "Christmas";

    @Autowired
    private InstantHolidayRepository holidayRepository;

    /**
     * Verifies that jpa repositories were configured correctly, by fetching
     * a {@link Holiday} instance from a database.
     */
    @Test
    public void shouldFindChristmasById() {
        Optional<Holiday> christmas = holidayRepository.findById(1);
        Assert.assertTrue(christmas.isPresent());
        Assert.assertEquals(CHRISTMAS, christmas.get().getName());
    }

    /**
     * Verifies functionality of a method which is defined within intermediate interface.
     * Consequently verifies functionality of a {@link NoRepositoryBean} annotation, which
     * essentially demarcate interface for which {@link BeanDefinition} should not be created.
     */
    @Test
    public void shouldFindChristmasByName() {
        Optional<Holiday> christmas = holidayRepository.findByName(CHRISTMAS);
        Assert.assertTrue(christmas.isPresent());
        Assert.assertEquals(CHRISTMAS, christmas.get().getName());
    }
}