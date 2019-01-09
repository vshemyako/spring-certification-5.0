package spring.certification.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.helper.config.jpa.entity.Holiday;
import spring.certification.data.helper.config.jpa.instant.InstantHolidayRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

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
    public static final String NEW_YEAR = "New Year";
    public static final String HALLOWEEN = "Halloween";

    @Autowired
    private InstantHolidayRepository holidayRepository;

    /**
     * Verifies that jpa repositories were configured correctly, by fetching
     * a {@link Holiday} instance from a database.
     */
    @Test
    public void shouldFindChristmasById() {
        Optional<Holiday> christmas = holidayRepository.findById(1);
        assertChristmasHoliday(christmas.orElse(null));
    }

    /**
     * Verifies functionality of a method which is defined within intermediate interface.
     * Consequently verifies functionality of a {@link NoRepositoryBean} annotation, which
     * essentially demarcate interface for which {@link BeanDefinition} should not be created.
     */
    @Test
    public void shouldFindChristmasByName() {
        Optional<Holiday> christmas = holidayRepository.findByName(CHRISTMAS);
        assertChristmasHoliday(christmas.orElse(null));
    }

    /**
     * Verifies method name parsing mechanism, which allows to declare custom queries.
     */
    @Test
    public void shouldFindChristmasByAlternativeQueries() {
        Holiday holiday = holidayRepository.readByName(CHRISTMAS);
        assertChristmasHoliday(holiday);

        holiday = holidayRepository.queryByName(CHRISTMAS);
        assertChristmasHoliday(holiday);
    }

    /**
     * Verifies that number of entities fetched from a database can be controlled
     * by 'Top' or 'First' keywords.
     */
    @Test
    public void shouldFindTop2Holidays() {
        List<Holiday> holidays = holidayRepository.readTop2By();
        assertEquals(2, holidays.size());
    }

    @Test
    public void shouldFindHolidaysByNames() {
        List<Holiday> holidays = holidayRepository.readByNameOrName(NEW_YEAR, HALLOWEEN);
        List<String> holidayNames = holidays.stream()
                .map(Holiday::getName)
                .collect(Collectors.toList());
        assertEquals(2, holidayNames.size());
        assertTrue(holidayNames.containsAll(Arrays.asList(NEW_YEAR, HALLOWEEN)));
    }

    /**
     * Verifies workings of spring-data jpa queries specified
     * using {@link Query} annotation.
     */
    @Test
    public void shouldFindDistinctHolidays() {
        List<Holiday> holidays = holidayRepository.getUnique();
        assertTrue(!holidays.isEmpty());
        assertEquals(4, holidays.size());
    }

    private void assertChristmasHoliday(Holiday holiday) {
        assertNotNull(holiday);
        assertEquals(CHRISTMAS, holiday.getName());
    }
}