package spring.chapter02.factory;

/**
 * A lazy guy which knows much about life
 */
public class CoachPotatoOracle implements Oracle {

    private String chips;

    /**
     * Give this coach potato a pack of chips
     */
    public void setChips(String chips) {
        this.chips = chips;
    }

    @Override
    public String getMeaningOfLife() {
        return "Bear for the life";
    }
}
