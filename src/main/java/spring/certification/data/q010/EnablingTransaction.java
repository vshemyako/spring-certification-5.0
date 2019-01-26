package spring.certification.data.q010;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 010:<br>
 * How are you going to define transaction in Spring?<br>
 * What does @Transactional do?<br>
 * What is the PlatformTransactionManager?<br>
 * <p>
 * Answer:<br>
 * The key notion in the Spring Framework transactional model is the notion of a transaction strategy. Transaction
 * strategy is defined by the {@link PlatformTransactionManager} bean. Presence of this bean in an application context
 * is mandatory to enable transaction management.<br>
 * <p>
 * In case {@link PlatformTransactionManager} bean is present in the application context, transaction might be defined
 * in the following ways:<br>
 * 1. Declarative (annotation-driven, xml-based)<br>
 * 2. Programmatic<br>
 * <p>
 * In case of declarative annotation-driven way of applying transaction functionality {@link Transactional} annotation
 * has to be used at class, method level or both if needed. In order for {@link Transactional} annotation to be processed
 * by the application-context {@link EnableTransactionManagement} annotation must mark a {@link Configuration} class.<br>
 * <p>
 * Additional notes:<br>
 * Three core interfaces are used to define a transaction internally in Spring framework:<br>
 * {@link PlatformTransactionManager} - defines method for obtaining a transaction, committing or rolling it back:<br>
 * - {@link PlatformTransactionManager#getTransaction(TransactionDefinition)} - obtain existing or create new transaction<br>
 * - {@link PlatformTransactionManager#commit(TransactionStatus)} - commit transaction defined by {@link TransactionStatus}<br>
 * - {@link PlatformTransactionManager#rollback(TransactionStatus)} - rollback transaction defined by {@link TransactionStatus}<br>
 * {@link TransactionDefinition} - defines transaction properties:<br>
 * - {@link TransactionDefinition#getPropagationBehavior()} - propagation behavior<br>
 * - {@link TransactionDefinition#getIsolationLevel()} - isolation level<br>
 * - {@link TransactionDefinition#getTimeout()} - transaction timeout<br>
 * - {@link TransactionDefinition#isReadOnly()} - hint for underlying implementation to optimize transaction<br>
 * - {@link TransactionDefinition#getName()} - transaction name<br>
 * {@link TransactionStatus} - defines actual transaction state:<br>
 * - {@link TransactionStatus#isNewTransaction()} - whether a new transaction has been created<br>
 * - {@link TransactionStatus#isRollbackOnly()} - whether a transaction has been marked as roll back only<br>
 * - {@link TransactionStatus#isCompleted()} - whether a transaction has been committed or rolled back<br>
 *
 * @author Valentine Shemyako
 * @since January 04, 2019
 */
public class EnablingTransaction {
}
