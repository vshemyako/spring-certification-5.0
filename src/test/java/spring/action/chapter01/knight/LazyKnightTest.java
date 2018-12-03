package spring.action.chapter01.knight;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functionality of {@link LazyKnight} class.
 * What's actually stays untested is custom implementation of
 * {@link Knight#embarkOnQuest()} method due to dependencies
 * initialization which is performed by {@link LazyKnight} himself.
 */
public class LazyKnightTest {

    /**
     * Verifies that constructor indeed initializes quest field
     */
    @Test
    public void constructorShouldInitializeQuest() {
        Knight knight = new LazyKnight();
        Assert.assertNotNull(knight.getQuest());
    }
}