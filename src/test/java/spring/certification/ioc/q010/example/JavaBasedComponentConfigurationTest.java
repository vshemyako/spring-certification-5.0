package spring.certification.ioc.q010.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Verifies that {@link Component} configuration class is processed in a lite mode.
 */
public class JavaBasedComponentConfigurationTest {

    @Test
    public void shouldManageBeans() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaBasedComponentConfiguration.class);
        context.registerShutdownHook();

        Smartphone smartphone = context.getBean(Smartphone.class);
        Battery smartphoneBattery = smartphone.extractBattery();
        Remote remote = context.getBean(Remote.class);
        Battery remoteBattery = remote.extractBattery();

        // It is expected that @Component classes are processed in a lite mode,
        // and all internal method invocations are NOT intercepted.
        assertThat(smartphoneBattery).isNotEqualTo(remoteBattery);
    }
}