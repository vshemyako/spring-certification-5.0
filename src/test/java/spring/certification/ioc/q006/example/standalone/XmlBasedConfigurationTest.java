package spring.certification.ioc.q006.example.standalone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates creation of xml-based configured application context.
 */
public class XmlBasedConfigurationTest {

    @Test
    public void shouldConstruct() {
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("classpath:/config-metadata.xml")) {

            MessageProvider messageProvider = applicationContext.getBean(MessageProvider.class);
            assertThat(messageProvider).isNotNull();
            assertThat(messageProvider.getMessage()).isEqualTo("Xml-based configuration");
        }
    }
}
