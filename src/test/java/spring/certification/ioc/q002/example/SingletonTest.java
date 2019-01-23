package spring.certification.ioc.q002.example;

import org.junit.Test;
import spring.certification.ioc.q002.example.Singleton;

import static org.junit.Assert.assertSame;

/**
 * Verifies that subsequently obtained instances refer to the same object.
 */
public class SingletonTest {

    @Test
    public void shouldBeTheSame() {
        Singleton firstInstance = Singleton.getInstance();
        Singleton secondInstance = Singleton.getInstance();
        assertSame(firstInstance, secondInstance);
    }
}