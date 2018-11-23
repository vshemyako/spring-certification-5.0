package spring.certification.ioc;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * What is the concept of a 'container' and what is its lifecycle?<br>
 * <p>
 * Answer:<br>
 * In Spring terms a <b>container</b> is 'something' which provides an infrastructure for another objects to live.
 * Some examples of containers not directly related to Spring:<br>
 * 1. JVM to run Java programs<br>
 * 2. TomCat to run servlets<br>
 * <p>
 * The same way Spring container is 'something' which provides an infrastructure for Spring <b>beans</b> to live.<br>
 * Spring framework's {@link ApplicationContext} is a central interface which represents Spring IoC container.<br>
 * <p>
 * The lifecycle of an {@link ApplicationContext} is the following:<br>
 * 1. Spring IoC container is instantiated<br>
 * 2. Configuration bean metadata is loaded into the container<br>
 * 3. Bean definitions are created from loaded metadata<br>
 * 4. Bean definitions are adjusted by {@link BeanFactoryPostProcessor BeanFactoryPostProcessors}<br>
 * 5. Beans are created, properties are set<br>
 * 6. Methods of {@link Aware} beans are invoked<br>
 * 7. {@link BeanPostProcessor#postProcessBeforeInitialization} methods are invoked for each {@link BeanPostProcessor}<br>
 * 8. Creation life-cycle callbacks are called: {@link PostConstruct}, {@link InitializingBean#afterPropertiesSet()},
 * {@link Bean#initMethod()}<br>
 * 9. {@link BeanPostProcessor#postProcessAfterInitialization} methods are invoked for each {@link BeanPostProcessor}<br>
 * 10. Application runs<br>
 * 11. Application terminates<br>
 * 12. Destruction life-cycle callbacks are called: {@link PreDestroy}, {@link DisposableBean},
 * {@link Bean#destroyMethod()}<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q007} - bean lifecycle is described and examined in more details
 *
 * @author Valentine Shemyako
 * @since November 23, 2018
 */
public class Q005 {
}
