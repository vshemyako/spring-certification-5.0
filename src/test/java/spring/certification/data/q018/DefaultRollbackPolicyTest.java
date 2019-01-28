package spring.certification.data.q018;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;

/**
 * Verified default rollback policy of a declarative transaction
 * functionality and ways to change this default behavior.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EmbeddedDBConfiguration.class, ExceptionThrower.class})
@Sql(scripts = {"classpath:drop-database.sql", "classpath:create-database.sql", "classpath:database-data.sql"})
public class DefaultRollbackPolicyTest {

    @Autowired
    private ExceptionThrower thrower;

    @Test
    public void shouldRollbackForUncheckedExceptionByDefault() {
        long initialCount = thrower.countHolidays();
        wrapExceptionalCall(thrower::createHolidayWithDefaultRollback, new RuntimeException());
        long eventualCount = thrower.countHolidays();

        assertThat(initialCount).isEqualTo(eventualCount);
    }

    @Test
    public void shouldNotRollbackForCheckedExceptionByDefault() {
        long initialCount = thrower.countHolidays();
        wrapExceptionalCall(thrower::createHolidayWithDefaultRollback, new HappyException());
        long eventualCount = thrower.countHolidays();

        assertThat(initialCount).isNotEqualTo(eventualCount);
    }

    @Test
    public void shouldRollbackForAllExceptions() {
        long initialCount = thrower.countHolidays();
        wrapExceptionalCall(thrower::createHolidayWithThrowableRollback, new Throwable());
        wrapExceptionalCall(thrower::createHolidayWithThrowableRollback, new HappyException());
        long eventualCount = thrower.countHolidays();

        assertThat(initialCount).isEqualTo(eventualCount);
    }

    @Test
    public void shouldRollbackForHappyExceptionHierarchy() {
        long initialCount = thrower.countHolidays();
        wrapExceptionalCall(thrower::createHolidayWithHappyExceptionRollback, new HappyException());
        wrapExceptionalCall(thrower::createHolidayWithHappyExceptionRollback, new MerryException());
        long eventualCount = thrower.countHolidays();

        assertThat(initialCount).isEqualTo(eventualCount);
    }

    private <T extends Throwable> void wrapExceptionalCall(Thrower thrower, T exceptionToThrow) {
        try {
            thrower.doThrow("'KnowledgeDay'", exceptionToThrow);
            fail();
        } catch (Throwable e) {
            // Legal to ignore...
        }
    }
}