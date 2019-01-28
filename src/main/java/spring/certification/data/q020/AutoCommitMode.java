package spring.certification.data.q020;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 020:<br>
 * Why is the term "unit of work" so important and why does JDBC AutoCommit violate this pattern?<br>
 * <p>
 * Answer:<br>
 * 'Unit of work' term relates to an atomicity principle of a transaction, which means that all database related
 * operations which comprise the transaction must succeed so that transaction will succeed. Default JDBC behavior
 * violates this atomicity principle, because no transaction boundaries are specified: each single SQL statement
 * is treated as an implicit transaction. Such behavior might lead to undesirable results (e.g. one bank account might
 * lose the money while the other one will not receive those).<br>
 *
 * @author Valentine Shemyako
 * @since January 03, 2019
 */
public class AutoCommitMode {
}