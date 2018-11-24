package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

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
 * For a web-container to load appropriate configuration special configuration file has to be supplied (it's often
 * called a <b>deployment descriptor</b>), which defines concrete implementation of {@link ContextLoaderListener}
 * and required web-application-context.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q006.StandaloneApplication} - demonstrates what primary steps should be made in order to create Spring-powered
 * standalone application.<br>
 *
 * @author Valentine Shemyako
 * @since November 24, 2018
 */
public class Q006 {

    /**
     * Demonstrates how an application context can be created and utilized in a stand-alone application.
     */
    public static class StandaloneApplication {

        /**
         * Entry point for any standalone application.
         */
        public static void main(String[] args) {
            // try block to close application, alternatively we could register lifecycle hook
            try (AnnotationConfigApplicationContext context
                         = new AnnotationConfigApplicationContext(ContextConfiguration.class)) {

                // required bean is accessed
                MessageProvider messageProvider = context.getBean(MessageProvider.class);
                System.out.println(messageProvider.getMessage());
            }
        }
    }

    /**
     * Java-based configuration class for a standalone application.
     */
    @Configuration
    public static class ContextConfiguration {

        /**
         * Bean factory method with default method specified.
         */
        @Bean
        public MessageProvider messageProvider(@Value("Forever alone") String message) {
            return new MessageProvider(message);
        }
    }

    /**
     * Provides a message defined at object construction phase.
     */
    public static class MessageProvider {

        private String message;

        /**
         * Instance creation method.
         */
        public MessageProvider(String message) {
            this.message = message;
        }

        /**
         * Central method of {@link MessageProvider}
         */
        public String getMessage() {
            return message;
        }
    }
}
