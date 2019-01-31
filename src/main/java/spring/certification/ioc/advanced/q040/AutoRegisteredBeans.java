package spring.certification.ioc.advanced.q040;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 040:<br>
 * What well-known dependencies are automatically resolved without manual set-up?<br>
 * <p>
 * Answer:<br>
 * Automatically resolved dependencies are:<br>
 * - {@link BeanFactory}<br>
 * - {@link ApplicationContext}<br>
 * - {@link ResourceLoader}<br>
 * - {@link ApplicationEventPublisher}<br>
 * - {@link MessageSource}<br>
 * - {@link Environment}<br>
 * <p>
 * {@link Autowired} annotation can be used for all of the well-known interfaces described above.<br>
 *
 * @author Valentine Shemyako
 * @since January 25, 2018
 */
public class AutoRegisteredBeans {
}
