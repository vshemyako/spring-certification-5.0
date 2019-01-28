package spring.certification.data.q018;

import static spring.certification.data.helper.SqlQueries.HOLIDAYS_TABLE_NAME;
import static spring.certification.data.helper.SqlQueries.SQL_COUNT_QUERY;
import static spring.certification.data.helper.SqlQueries.SQL_INSERT_HOLIDAYS_STATEMENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class to verify rollback transaction policy of declarative transaction.
 */
@Service
public class ExceptionThrower {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExceptionThrower(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long countHolidays() {
        return jdbcTemplate.queryForObject(String.format(SQL_COUNT_QUERY, HOLIDAYS_TABLE_NAME), Long.class);
    }

    /**
     * Default rollback policy transaction, which should rollback for {@link Error} and {@link RuntimeException} classes.
     */
    @Transactional
    public <T extends Throwable> void createHolidayWithDefaultRollback(String holidayName, T exceptionToThrow) throws T {
        jdbcTemplate.execute(String.format(SQL_INSERT_HOLIDAYS_STATEMENT, holidayName));
        throw exceptionToThrow;
    }

    /**
     * Customized rollback policy, which rolls back for all exceptions.
     */
    @Transactional(rollbackFor = Throwable.class)
    public <T extends Throwable> void createHolidayWithThrowableRollback(String holidayName, T exceptionToThrow) throws T {
        jdbcTemplate.execute(String.format(SQL_INSERT_HOLIDAYS_STATEMENT, holidayName));
        throw exceptionToThrow;
    }

    /**
     * Customized rollback policy, which rolls back for {@link HappyException} class and its subclasses.
     */
    @Transactional(rollbackForClassName = "HappyException")
    public <T extends Throwable> void createHolidayWithHappyExceptionRollback(String holidayName, T exceptionToThrow) throws T {
        jdbcTemplate.execute(String.format(SQL_INSERT_HOLIDAYS_STATEMENT, holidayName));
        throw exceptionToThrow;
    }
}
