package spring.certification.ioc.q006.example.standalone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates creation of java-based configured application context.
 */
public class JavaBasedConfigurationTest {

    @Test
    public void shouldConstruct() {
        // try block to close application, alternatively we could register lifecycle hook
        try (AnnotationConfigApplicationContext context
                     = new AnnotationConfigApplicationContext(JavaBasedConfiguration.class)) {

            // required bean is accessed
            MessageProvider messageProvider = context.getBean(MessageProvider.class);
            assertThat(messageProvider).isNotNull();
            assertThat(messageProvider.getMessage()).isEqualTo("Java-based configuration");
        }
    }
}