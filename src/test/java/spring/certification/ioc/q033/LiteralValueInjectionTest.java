package spring.certification.ioc.q033;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q033.example.LiteralConfiguration;
import spring.certification.ioc.q033.example.ValueObject;

/**
 * Verifies literal / scalar values injection functionality provided by {@link Value} annotation.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LiteralConfiguration.class)
public class LiteralValueInjectionTest {

    @Autowired
    private ValueObject valueObject;

    @Test
    public void shouldInjectScalarValues() {
        assertThat(valueObject.getIntegral()).isEqualTo(1);
        assertThat(valueObject.getFloatingPoint()).isEqualTo(1.0);
        assertThat(valueObject.getWord()).isEqualTo("abc");
        assertThat(valueObject.getHex()).isEqualTo(0x11);
        assertThat(valueObject.isPredicateResult()).isTrue();
        assertThat(valueObject.getWithoutPlaceholder()).isEqualTo("no placeholder");
    }
}