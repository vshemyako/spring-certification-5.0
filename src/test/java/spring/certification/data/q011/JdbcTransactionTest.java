package spring.certification.data.q011;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.q005.example.PlainSqlExecutor;
import spring.certification.data.q011.helper.HolidayService;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests different approaches for participating in database transactions using {@link JdbcTemplate}.
 *
 * @author Valentine Shemyako
 * @since January 05, 2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {HolidayService.class, PlainSqlExecutor.class, EmbeddedDBConfiguration.class})
public class JdbcTransactionTest {

    public static final String SUNNY_DAY_HOLIDAY = "'Sunny day'";
    @Autowired
    private HolidayService holidayService;

    @Test
    public void shouldRollbackDeclarativeTransaction() {
        long initialCount = holidayService.countHolidays();
        try {
            holidayService.rollbackSavedHolidayDeclaratively("'Sunny Day'");
        } catch (IllegalStateException ex) {
            // Legal to ignore...
        }
        long eventualCount = holidayService.countHolidays();
        assertThat(initialCount).isEqualTo(eventualCount);
    }

    @Test
    public void shouldRollbackProgrammaticTransaction() {
        long initialCount = holidayService.countHolidays();
        holidayService.rollbackSavedHolidayProgrammatically(SUNNY_DAY_HOLIDAY);
        long eventualCount = holidayService.countHolidays();
        assertThat(initialCount).isEqualTo(eventualCount);
    }
}