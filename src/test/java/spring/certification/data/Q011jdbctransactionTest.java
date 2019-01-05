package spring.certification.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.Q011jdbctransaction.EmployeeService;
import spring.certification.data.Q011jdbctransaction.JdbcConfigMarker;
import spring.certification.data.helper.Employee;
import spring.certification.data.helper.Gender;

import java.time.LocalDate;

/**
 * Tests different approaches for participating in database transactions using {@link JdbcTemplate}.
 *
 * @author Valentine Shemyako
 * @since January 05, 2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JdbcConfigMarker.class)
public class Q011jdbctransactionTest {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Verifies {@link JdbcTemplate} queries might participate in existing transaction.
     */
    @Test
    public void shouldRollbackInsert() {
        Employee employee = new Employee(
                LocalDate.of(1990, 5, 21),
                "Valentine",
                "Shemyako",
                Gender.M,
                LocalDate.of(2000, 1, 1)
        );

        long beforeInsertEmployeesCount = employeeService.countEmployees();
        try {
            employeeService.saveEmployeeErroneously(employee);
        } catch (Exception e) {
            // Save to ignore.
        }
        long afterInsertEmployeesCount = employeeService.countEmployees();
        Assert.assertEquals(beforeInsertEmployeesCount, afterInsertEmployeesCount);
    }
}