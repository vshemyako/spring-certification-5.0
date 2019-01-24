package spring.certification.ioc.q019;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import spring.certification.ioc.q018.BeanLifecycleCallbacks;
import spring.certification.ioc.q019.example.CinemaConfiguration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 019:<br>
 * Consider how you enable JSR-250 annotations like @PostConstruct and @PreDestroy? When/how will they get called?<br>
 * How else can you define an initialization or destruction method for a Spring bean?<br>
 * <p>
 * Answer:<br>
 * Scanning and processing of <b>JSR-250</b> {@link PostConstruct} and {@link PreDestroy} annotations is done by
 * {@link CommonAnnotationBeanPostProcessor} class which is registered automatically in case of annotation-based
 * context configuration. Therefore some manual registering and enabling isn't required.<br>
 * Those annotation are invoked at the same lifecycle phases as {@link Bean#initMethod()} and {@link Bean#destroyMethod()}
 * respectively (discussed in details in {@link BeanLifecycleCallbacks}).
 * <p>
 * Another possibility to define init and destroy methods is to implement {@link InitializingBean} and {@link DisposableBean}
 * interfaces. The logic behind implemented methods is the same.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link CinemaConfiguration} - demonstrates basic usage of {@link PostConstruct} and {@link PreDestroy}
 * annotations.
 *
 * @author Valentine Shemyako
 * @since November 25, 2018
 */
public class JSR250BeanLifecycleCallbacks {
}
