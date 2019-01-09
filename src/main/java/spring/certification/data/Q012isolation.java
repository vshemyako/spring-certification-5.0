package spring.certification.data;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * What is a transaction isolation level?<br>
 * How many transaction isolation levels do we have and how are they ordered?<br>
 * <p>
 * Answer:<br>
 * Transaction isolation is a visibility of changes done by one transaction to another transactions, before those
 * changes are committed to a database. The higher isolation is the less visible are those uncommitted changes (the
 * more sequential are database operations).<br>
 * <p>
 * There are four isolation levels:<br>
 * - read uncommitted - concurrent transaction may read even uncommitted changes by another transaction. This isolation
 * level may result in <b>dirty read</b> phenomena.<br>
 * - read committed - in such isolation level only write locks are held, therefore non-repeatable phenomena might occur.<br>
 * - repeatable read - in such isolation level read and write locks are held, but range locks are omitted. Phantom read
 * phenomena might occur.<br>
 * - serializable - range, read and write locks are held. No phenomena is possible, records are completely locked.<br>
 * <p>
 * There are lots of ways to specify database transaction isolation levels, using Spring it's possible to specify
 * those by changing {@link Transactional#isolation()} attribute.<br>
 *
 * @author Valentine Shemyako
 * @since December 27, 2018
 */
public class Q012isolation {
}
