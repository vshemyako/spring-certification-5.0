package spring.certification.ioc.q022;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q022.example.SpringFramework;
import spring.certification.ioc.q022.example.SpringFrameworkConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Verifies private fields injection functionality offered by Spring IoC container.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringFrameworkConfiguration.class)
public class PrivateFieldInjectionTest {

    @Autowired
    private SpringFramework springFramework;

    /**
     * Verifies processing functionality of {@link Autowired} and {@link Value}.
     */
    @Test
    public void shouldInjectionValues() {
        assertThat(springFramework.getCeo()).isEqualTo("Rod Johnson");
        assertThat(springFramework.getDev()).isEqualTo("Juergen Hoeller");
    }
}