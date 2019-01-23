package spring.certification.ioc.q018;

import org.springframework.context.annotation.Bean;
import spring.certification.ioc.q018.example.LibraryConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 018:<br>
 * What is an initialization method and how is it declared on a Spring bean?<br>
 * What is a destroy method, how is it declared and when is it called?<br>
 * <p>
 * Answer:<br>
 * An initialization method is a method which is invoked after a bean is fully initialized (bean is created and all its
 * properties were set). Common usage of an init-method: execute some logic which is dependent on bean's properties. To
 * specify init-method of a bean {@link Bean#initMethod()} annotation type element is used.<br>
 * <p>
 * A destroy method is a method which is invoked during application context closure. Common usage of a
 * destroy-method is to release resources that the bean was dependent on. To specify destroy-method of a bean
 * {@link Bean#destroyMethod()} annotation type element is used.<br.
 * Examples of mentioned terms:<br>
 * {@link LibraryConfiguration} - demonstrates how bean factory can be created with init and destroy methods
 * specified at a {@link Bean} annotation level.
 *
 * @author Valentine Shemyako
 * @since November 24, 2018
 */
public class BeanLifecycleCallbacks {
}
