package spring.certification.ioc.q017;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q017.example.Alcohol;
import spring.certification.ioc.q017.example.AlcoholicConfiguration;
import spring.certification.ioc.q017.example.AlcoholicPostProcessor;
import spring.certification.ioc.q017.example.Beer;
import spring.certification.ioc.q017.example.Wine;

/**
 * Verifies functionality offered by {@link AlcoholicPostProcessor}
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AlcoholicConfiguration.class)
public class BeanCustomizationTest {

    @Autowired
    private Alcohol alcohol;

    /**
     * Verifies that {@link AlcoholicPostProcessor} bean post-processor will substitute beans of type {@link Wine}
     * with beans of type {@link Beer}.
     */
    @Test
    public void shouldSubstituteBeans() {
        assertThat(alcohol.getName()).isEqualTo("bear");
    }
}