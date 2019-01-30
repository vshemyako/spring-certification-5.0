package spring.certification.ioc.q015.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Basic test class to verify workings of {@link TestPropertySource} annotation to selectively override chosen properties.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomPropertySourceConfiguration.class)
@TestPropertySource(properties = "autumn=misery", locations = "classpath:/season.properties")
public class SelectivePropertyOverrideTest {

    @Autowired
    private Environment environment;

    @Test
    public void shouldOverrideByInlineAttribute() {
        String actualPropertyValue = environment.getProperty("autumn");
        assertThat("misery").isEqualTo(actualPropertyValue);
    }

    @Test
    public void shouldOverrideByLocationAttribute() {
        String actualPropertyValue = environment.getProperty("summer");
        assertThat("pain").isEqualTo(actualPropertyValue);
    }
}
