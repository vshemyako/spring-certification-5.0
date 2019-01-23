package spring.certification.ioc.q021;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q021.example.Creature;
import spring.certification.ioc.q021.example.Cyclops;
import spring.certification.ioc.q021.example.Eye;
import spring.certification.ioc.q021.example.Heart;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Series of tests to verify functionality of {@link Autowired} annotation.
 */
public class AutowiringTest {

    /**
     * Verifies that single non-annotated constructor is indeed picked up by the container.
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {Heart.class, Creature.class})
    public static class SingleNonAnnotatedConstructor {

        @Autowired
        private Creature creature;

        @Test
        public void shouldManageBeans() {
            assertThat(creature).isNotNull();
            assertThat(creature.getHeart()).isNotNull();
        }
    }

    /**
     * Verifies that a constructor with most satisfied dependencies will be picked up by the container.
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {Eye.class, Heart.class, Cyclops.class})
    public static class MultipleChoiceAnnotatedConstructors {

        @Autowired
        private Cyclops cyclops;

        @Test
        public void shouldManageBeans() {
            assertThat(cyclops).isNotNull();
            assertThat(cyclops.getEye()).isNotNull();
            assertThat(cyclops.getHeart()).isNotNull();
        }
    }
}