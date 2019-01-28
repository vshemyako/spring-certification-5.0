package spring.certification.data.q016;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 016:<br>
 * Where can the @Transactional annotation be used?<br>
 * What is a typical usage if you put it at class level?<br>
 * <p>
 * Answer:<br>
 * {@link Transactional} annotation might be applied at a class level, at a method level or both. In case
 * {@link Transactional} annotation is applied at a class level - it implicitly makes any method within that class
 * transactional. This default transactional behavior defined at a class level is overridden in case
 * {@link Transactional} annotation is also applied at a method level also.<br>
 * <b>Big note:</b> though declarative transaction management is implemented using AOP proxies, only methods with <b>public</b>
 * visibility are managed by {@link PlatformTransactionManager}. This behavior is verified in related test class.<br>
 *
 * @author Valentine Shemyako
 * @since January 06, 2019
 */
public class TransactionalAnnotation {
}
