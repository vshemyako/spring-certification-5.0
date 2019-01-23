package spring.certification.ioc.q015.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Verifies functionality to manually register custom source of properties.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomPropertySourceConfiguration.class)
public class CustomPropertySourceConfigurationTest {

    @Autowired
    private ConfigurableEnvironment environment;

    /**
     * Verifies that manually added {@link PropertySource} is indeed registered in {@link Environment} abstraction.
     */
    @Test
    public void shouldContainCustomPropertySource() {
        PropertySource<?> seasonEmotions = environment.getPropertySources().get("seasonEmotions");
        assertNotNull(seasonEmotions);
        assertTrue(seasonEmotions.containsProperty("autumn"));
    }

    /**
     * Verifies that standalone application context is preconfigured with JVM properties and OS properties.
     */
    @Test
    public void shouldContainPredefinedPropertySources() {
        List<String> propertySourcesNames = environment.getPropertySources().stream()
                .map(PropertySource::getName)
                .collect(Collectors.toList());

        assertThat(propertySourcesNames.size()).isEqualTo(3);
        assertThat(propertySourcesNames).containsExactly("systemProperties", "systemEnvironment", "seasonEmotions");
    }
}