package spring.certification.data;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 003:<br>
 * What is the Template design pattern and what is the JDBC template?<br>
 * <p>
 * Answer:<br>
 * <b>Template</b> design pattern, commonly known as <b>template method</b> defines series of steps which are executed
 * in particular order. This order cannot be changed, but some of the steps can be altered or are required to be
 * implemented by a subclass.<br>
 * <p>
 * {@link JdbcTemplate} is a class which implements template method design pattern and performs some boilerplate jdbc
 * operations. Thus user is only required to define sql statements and result set custom mappings.<br>
 * <p>
 * Operations which are performed by Jdbc template:<br>
 * - Open the connection<br>
 * - Prepare, execute statements<br>
 * - Iterate through result set<br>
 * - Exception processing<br>
 * - Transaction handling<br>
 * - Close connection, statement, result set<br>
 * <p>
 * Operations which should be performed by Jdbc template client:<br>
 * - Define connection parameters<br>
 * - Specify SQL statement and it's parameters<br>
 * - Specify mappings for each result set iteration<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link TemplateMethod} - demonstrates basic example of a template method design pattern.<br>
 *
 * @author Valentine Shemyako
 * @since December 17, 2018
 */
public class Q003template {

    /**
     * Demonstrates series of steps which can be altered but order of which cannot be changed.
     */
    public static class TemplateMethod {

        /**
         * Main design pattern method cannot be overridden - it defines skeleton of program flow.
         */
        public final void dailyRoutine() {
            wakeUp();
            work();
            sleep();
        }

        /**
         * A person wakes up.
         */
        public void wakeUp() {
        }

        /**
         * A person works. Method will throw an exception in case not overridden.
         */
        public void work() {
            throw new IllegalStateException("Working routine is not defined");
        }

        /**
         * A person has a rest.
         */
        public void sleep() {
        }
    }
}
