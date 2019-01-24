package spring.certification.ioc.q006;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import spring.certification.ioc.q006.example.standalone.JavaBasedConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 006:<br>
 * How are you going to create a new instance of an ApplicationContext?<br>
 * <p>
 * Answer:<br>
 * {@link ApplicationContext} creation process depends on the application type for which this context is being created.<br>
 * For a <b>standalone</b> application {@link ApplicationContext} has to be created manually by invoking required
 * constructor, e.g.:<br>
 * 1. {@link AnnotationConfigApplicationContext} - for java-configured application contexts<br>
 * 2. {@link ClassPathXmlApplicationContext} - for xml-configured application contexts<br>
 * 3. configurations mentioned in #1 and #2 can be mixed in a single application context<br>
 * <p>
 * For a <b>web-application</b> this process differs: application context is created automatically by
 * {@link ContextLoaderListener}. Central interface for a web-application also differs from a standalone application:
 * it is called a {@link WebApplicationContext} and it exposes a method to work with servlet-context.<br>
 * For a web-container to load appropriate configuration the following steps should be taken:<br>
 * 1. Special configuration file has to be supplied (WEB-INF/web.xml - it's often called a <b>deployment descriptor</b>),
 * which defines concrete implementation of {@link ContextLoaderListener} and required web-application-context.<br>
 * 2. In Servlet 3+ environments {@link WebApplicationInitializer} interface should be implemented.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link JavaBasedConfiguration} - demonstrates what primary steps should be made in order to create Spring-powered
 * standalone application.<br>
 *
 * @author Valentine Shemyako
 * @since November 24, 2018
 */
public class ApplicationContextConstruction {
}
