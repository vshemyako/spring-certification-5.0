package spring.action.chapter01.knight;

/**
 * A person who is granted an honorary title of knighthood
 */
public interface Knight {

    /**
     * Makes knight to participate in associated quest
     */
    void embarkOnQuest();

    /**
     * Returns associated {@link Quest} instance in which
     * this knight participates
     *
     * @return associated {@link Quest}
     */
    Quest getQuest();
}
