package spring.certification.ioc.q005;

import static org.assertj.core.api.Assertions.assertThat;
import static spring.certification.ioc.q005.StringAccumulator.lifeCycleSteps;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates container's lifecycle steps.
 */
public class ContainerTest {

    @Test
    public void shouldFollowSteps() {
        // 1. Context is initialized
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 2. Bean meta-data is loaded
        applicationContext.register(BeanConfigurationMetadata.class);
        // 3. Bean definitions are created
        applicationContext.refresh();
        // 4. Behind the scenes bean definitions are adjusted (e.g. placeholder for values to be injected are substituted)
        // 5. Bean is created
        assertThat(lifeCycleSteps.get(0)).isEqualTo("Created");
        // 6. @Value annotation is finally injected by BeanPostProcessor
        assertThat(lifeCycleSteps.get(1)).isEqualTo("Injected");
        // 7. Bean is notified by container about its creation
        assertThat(lifeCycleSteps.get(2)).isEqualTo("Notified");
        // 8. Post-construct method is invoked
        assertThat(lifeCycleSteps.get(3)).isEqualTo("Post-constructed");
        // 9. BeanPostProcessor applies some logic after bean is fully initialized
        // 10. Application runs
        applicationContext.getBean(ManagedObject.class).live();
        assertThat(lifeCycleSteps.get(4)).isEqualTo("Happy to exist");
        // 11. Application terminates
        applicationContext.close();
        assertThat(lifeCycleSteps.get(5)).isEqualTo("Destroyed");
    }
}