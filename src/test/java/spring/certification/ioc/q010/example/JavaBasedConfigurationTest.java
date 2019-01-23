package spring.certification.ioc.q010.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.q010.DependencyInjectionJavaConfig;

/**
 * Verifies that concepts described in {@link DependencyInjectionJavaConfig} class indeed work. More specifically that
 * {@link AnnotationConfigApplicationContext} loads java-based configurations and produces beans.
 */
public class JavaBasedConfigurationTest {

    /**
     * Verify java-based configuration workings.
     */
    @Test
    public void shouldManageBeans() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaBasedConfiguration.class);
        context.registerShutdownHook();

        Smartphone smartphone = context.getBean(Smartphone.class);
        Battery smartphoneBattery = smartphone.extractBattery();
        Remote remote = context.getBean(Remote.class);
        Battery remoteBattery = remote.extractBattery();

        // It is expected that @Configuration classes are processed in a full mode,
        // and all internal method invocations are intercepted.
        assertThat(smartphoneBattery).isEqualTo(remoteBattery);
    }
}