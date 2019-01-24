package spring.certification.ioc.q028.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q028.ConfigurationAnnotationFunctionality;

/**
 * Verifies that internal bean factory method calls are intercepted by Spring IoC container thus respecting bean scopes.
 * This functionality is discussed in details in question {@link ConfigurationAnnotationFunctionality}.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BeanScopingSupportiveConfig.class)
public class BeanScopingSupportiveConfigTest {

    @Autowired
    private MusicCenter musicCenter;
    @Autowired
    private Walkman walkman;

    /**
     * Verifies that {@link MusicCenter} bean and {@link Walkman} bean are referencing the same {@link CompactDisc} bean.
     */
    @Test
    public void shouldRespectBeanScope() {
        assertThat(musicCenter.extractDisc()).isSameAs(walkman.extractDisc());
    }
}