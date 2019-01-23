package spring.certification.ioc.q003.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

/**
 * Even though there's no concrete implementation of the dependency required by a {@link Pet} class it is still
 * possible to <b>test</b> this class!
 */
public class PetTest {

    @Rule
    public OutputCapture capture = new OutputCapture();

    private static final String FEEDING_MESSAGE = "Feeding pet";
    private Human human;

    @Before
    public void setUp() {
        human = mock(Human.class);
        doAnswer(invocation -> {
            System.out.print(FEEDING_MESSAGE);
            return null;
        }).when(human).feed();
    }

    @Test
    public void shouldPrintFeedingMessage() {
        Pet pet = new Pet(human);
        pet.eat();

        verify(human).feed();
        assertThat(capture.toString()).isEqualTo(FEEDING_MESSAGE);
    }
}