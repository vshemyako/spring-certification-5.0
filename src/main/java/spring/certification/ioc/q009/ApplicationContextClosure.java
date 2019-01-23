package spring.certification.ioc.q009;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 009:<br>
 * What is the preferred way to close an application context?<br>
 * Does Spring Boot close application context for you?<br>
 * <p>
 * Answer:<br>
 * <b>Stand-alone application</b> should be closed by invoking {@link ConfigurableApplicationContext#registerShutdownHook()}
 * method which will gracefully close an application-context on JVM shutdown unless this context was previously closed.<br>
 * <p>
 * <b>Web application</b> is closed automatically by {@link ContextLoaderListener#contextDestroyed} method which actually
 * invokes {@link ConfigurableApplicationContext#close} method.
 * <p>
 * Spring Boot closes stand-alone and web applications in the same way, but manual registering of the shutdown hook isn't
 * required for stand-alone applications (look at {@link SpringApplication#refreshContext} method).<br>
 *
 * @author Valentine Shemyako
 * @since November 25, 2018
 */
public class ApplicationContextClosure {
}
