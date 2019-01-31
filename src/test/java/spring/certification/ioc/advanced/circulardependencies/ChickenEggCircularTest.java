package spring.certification.ioc.advanced.circulardependencies;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Chicken.class, Egg.class})
public class ChickenEggCircularTest {

    @Autowired
    private Chicken chicken;
    @Autowired
    private Egg egg;

    @Test
    public void shouldResolveCircularDependency() {
        assertThat(chicken).isSameAs(egg.getChicken());
        assertThat(egg).isSameAs(chicken.getEgg());
    }
}
