package spring.certification.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
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
 *
 * @author Valentine Shemyako
 * @since January 04, 2019
 */
public class Q010transactionmanager {
}
