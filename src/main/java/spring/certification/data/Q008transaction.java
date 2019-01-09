package spring.certification.data;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 008:<br>
 * What is a transaction?<br>
 * What is the difference between a local and a global transaction?<br>
 * <p>
 * Answer:<br>
 * A transaction is a unit of work that you want to treat as 'a whole'. It has to either happen in full or not at all.<br>
 * Transaction has to follow the following principles (ofter referred as ACID principles):<br>
 * - Atomicity - guaranties that all transaction-related operations are done, or none of them are done<br>
 * - Consistency - guaranties that none of the data constraints will be ever violated<br>
 * - Isolation - guaranties that one transaction cannot read data from another transaction until the first one finishes<br>
 * - Durability - guaranties that after a transaction completes - it is somehow reliably stored (e.g. on the hard drive)<br>
 * <p>
 * - <b>Local transactions</b> are transactions which work only with a single transactional resource (e.g. JDBC connection).<br>
 * - <b>Global transactions</b> are transactions which work with multiple transactional resources. Those transactions are
 * managed by application-server.<br>
 *
 * @author Valentine Shemyako
 * @since December 22, 2018
 */
public class Q008transaction {
}
