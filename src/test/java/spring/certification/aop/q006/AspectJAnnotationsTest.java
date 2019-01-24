package spring.certification.aop.q006;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.aspectj.lang.annotation.Aspect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.aop.q006.example.fair.FairWorldConfiguration;
import spring.certification.aop.q006.example.people.Tramp;
import spring.certification.aop.q006.example.unfair.UnfairWorldConfiguration;

/**
 * Verifies that {@link EnableAspectJAutoProxy} annotation indeed enables detection of {@link Aspect}.
 */
public class AspectJAnnotationsTest {

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = UnfairWorldConfiguration.class)
    public static class AspectDisabledTest extends StreamRedefiner {

        @Autowired
        private Tramp tramp;

        @Test
        public void shouldLeftTrampWithoutMoney() {
            tramp.askForMoney();

            String actualWordsSpoken = outputStream.toString();
            String expectedWordsSpoken = Stream.of("Living on a prayer")
                    .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
            assertEquals(expectedWordsSpoken, actualWordsSpoken);
        }
    }

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = FairWorldConfiguration.class)
    public static class AspectEnabledTest extends StreamRedefiner {

        @Autowired
        private Tramp tramp;

        @Test
        public void shouldLeftTrampWithoutMoney() {
            tramp.askForMoney();

            String actualWordsSpoken = outputStream.toString();
            String expectedWordsSpoken = Stream.of("Living on a prayer", "Take my hand and we'll make it I swear")
                    .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
            assertEquals(expectedWordsSpoken, actualWordsSpoken);
        }
    }

    public static class StreamRedefiner {

        /**
         * Fields to redefine system streams.
         */
        protected final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        protected final PrintStream predefinedOutputStream = System.out;

        /**
         * Substitutes system stream with 'dummy' byte array stream.
         */
        @Before
        public void setUp() {
            System.setOut(new PrintStream(outputStream));
        }

        /**
         * Set previously changed system stream back.
         */
        @After
        public void tearDown() {
            System.setOut(predefinedOutputStream);
        }
    }
}