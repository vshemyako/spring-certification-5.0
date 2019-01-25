package spring.certification.ioc.advanced.q041;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.advanced.q041.example.Alcohol;
import spring.certification.ioc.advanced.q041.example.HappyAlcoholic;
import spring.certification.ioc.advanced.q041.example.SadAlcoholic;

/**
 * Verifies different scope wiring functionality offered by Spring Framework.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Alcohol.class, SadAlcoholic.class, HappyAlcoholic.class})
public class DifferentScopeWiringTest {

    @Autowired
    private SadAlcoholic sadAlcoholic;
    @Autowired
    private HappyAlcoholic happyAlcoholic;

    @Test
    public void shouldReturnSameAlcohol() {
        Alcohol firstBottle = sadAlcoholic.getAlcohol();
        Alcohol secondBottle = sadAlcoholic.getAlcohol();
        assertThat(firstBottle).isSameAs(secondBottle);
    }

    @Test
    public void shouldReturnDifferentAlcohol() {
        Alcohol firstBottle = happyAlcoholic.getAlcohol();
        Alcohol secondBottle = happyAlcoholic.getAlcohol();
        assertThat(firstBottle).isNotSameAs(secondBottle);
    }
}