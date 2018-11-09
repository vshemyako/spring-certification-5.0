package spring.action.chapter01.knight;

/**
 * Implementation of {@link Knight} interface with predefined
 * {@link Quest} which actually is doing nothing
 */
public class LazyKnight implements Knight {

    /**
     * An adventure in which knight participates.
     */
    private Quest quest;

    /**
     * Constructor.
     * Each instance is responsible for related quest by itself.
     * This is tightly coupled approach which should be avoided.
     */
    public LazyKnight() {
        this.quest = new LayOnACoach();
    }

    @Override
    public void embarkOnQuest() {
        this.quest.embark();
    }

    @Override
    public Quest getQuest() {
        return this.quest;
    }
}
