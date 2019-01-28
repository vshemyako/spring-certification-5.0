package spring.certification.ioc.advanced.q040;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.common.Beverage;
import spring.certification.ioc.common.Refrigerator;

/**
 * Verifies that all well-known interfaces do not require manual registration.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Beverage.class, Refrigerator.class})
public class AutoRegisteredBeansTest {

    @Autowired
    private BeanFactory factory;
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ResourceLoader loader;
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private MessageSource source;

    @Test
    public void shouldResolveAutomatically() {
        // Though not required to verify explicitly...
        assertThat(factory).isNotNull();
        assertThat(context).isNotNull();
        assertThat(loader).isNotNull();
        assertThat(publisher).isNotNull();
        assertThat(source).isNotNull();
    }
}