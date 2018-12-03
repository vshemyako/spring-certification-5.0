package spring.action.chapter01.knight;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests functionality of {@link BraveKnight} class.
 * More specifically constructor dependency injection impact on related
 * logic is being tested.
 */
public class BraveKnightTest {

    /**
     * Verifies that quest is injected using constructor.
     */
    @Test
    public void constructorShouldInitializeFieldWithPassedArgument() {
        Quest quest = new LayOnACoach();
        Knight knight = new BraveKnight(quest);
        Assert.assertEquals(quest, knight.getQuest());
    }

    /**
     * Verifies that knight invokes {@link Quest#embark()}
     * method after his {@link Knight#embarkOnQuest()} method is invoked.
     */
    @Test
    public void embarkShouldInvokeSameMethodOnQuest() {
        Quest quest = Mockito.mock(Quest.class);
        Knight knight = new BraveKnight(quest);
        knight.embarkOnQuest();
        Mockito.verify(quest).embark();
    }
}