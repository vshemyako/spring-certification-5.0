package spring.certification.ioc.advanced.ambiguity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * There's some ambiguity about default no arg constructor constraint for {@link Configuration} class.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DummyConfiguration.class)
public class ConfigurationClassTests {

    @Autowired
    private DummyConfiguration dummyConfiguration;

    @Test
    public void shouldInjectDependencies() {
        assertThat("Indeed autowired").isEqualTo(dummyConfiguration.isAutowired());
    }
}
