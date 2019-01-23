package spring.certification.ioc.q007;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import spring.certification.ioc.q017.BeanCustomization;
import spring.certification.ioc.Q018;
import spring.certification.ioc.Q019;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 007:<br>
 * Can you describe the lifecycle of a Spring Bean in an ApplicationContext?<br>
 * <p>
 * Answer:<br>
 * Spring bean lifecycle is the following:<br>
 * 1. Bean instance is created<br>
 * 2. Bean properties are set<br>
 * 3. In case bean implements {@linkplain Aware aware} interfaces - those implemented methods are invoked. 'Aware' beans
 * are actually processed by {@link BeanPostProcessor} implementations provided with Spring and registered by IoC
 * container by default.<br>
 * 4. {@link BeanPostProcessor#postProcessBeforeInitialization} methods of custom {@link BeanPostProcessor post-processors}
 * are invoked.<br>
 * 5. Initialization callbacks are invoked in the following order:<br>
 * 5.1. {@link PostConstruct} method is invoked<br>
 * 5.2. {@link InitializingBean#afterPropertiesSet()} method is invoked<br>
 * 5.3. {@link Bean#initMethod()} method is invoked<br>
 * 6. {@link BeanPostProcessor#postProcessAfterInitialization} methods of custom {@link BeanPostProcessor post-processors}
 * are invoked.<br>
 * 7. Destruction callbacks are invoked in the following order:<br>
 * 7.1. {@link PreDestroy} method is invoked<br>
 * 7.2. {@link DisposableBean#destroy()} method is invoked<br>
 * 7.3. {@link Bean#destroyMethod()}
 * <p>
 * Examples of mentioned terms:<br>
 * {@link BeanCustomization.AlcoholicPostProcessor} - example of a post-processor which substitutes bean with completely different
 * instance.<br>
 * {@link Q018.LibraryConfiguration} - example of {@link Bean#initMethod()} and {@link Bean#destroyMethod()} annotation
 * type elements usage<br>
 * {@link Q019.CinemaConfiguration} - example of {@link PostConstruct} and {@link PreDestroy} annotations.<br>
 *
 * @author Valentine Shemyako
 * @since November 23, 2018
 */
public class BeanLifecycle {
}
