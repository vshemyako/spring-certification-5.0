package spring.action.chapter01.knight;

/**
 * Implementation of {@link Knight} interface
 * which allows some third party to define what type of
 * quest knight should participate in.
 */
public class BraveKnight implements Knight {

    private Quest quest;

    /**
     * Constructor.
     * Required dependencies are injected by some
     * 3-rd party. This type of field initialization
     * is known as 'constructor dependency injection'.
     *
     * @param quest which is associated with created {@link BraveKnight}
     */
    public BraveKnight(Quest quest) {
        this.quest = quest;
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
