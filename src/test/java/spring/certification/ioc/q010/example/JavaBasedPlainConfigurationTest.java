package spring.certification.ioc.q010.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Testing of plain java-based configuration class, which is annotated neither with {@link Configuration}
 * nor with {@link Component} annotations.
 */
public class JavaBasedPlainConfigurationTest {

    @Test
    public void shouldManageBeans() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaBasedPlainConfiguration.class);
        context.registerShutdownHook();

        Smartphone smartphone = context.getBean(Smartphone.class);
        Battery smartphoneBattery = smartphone.extractBattery();
        Remote remote = context.getBean(Remote.class);
        Battery remoteBattery = remote.extractBattery();

        // It is expected that plain java-classes are processed in a lite mode,
        // and all internal method invocations are NOT intercepted.
        assertThat(smartphoneBattery).isNotEqualTo(remoteBattery);
    }
}