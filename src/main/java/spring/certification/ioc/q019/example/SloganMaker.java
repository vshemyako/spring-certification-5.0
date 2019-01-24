package spring.certification.ioc.q019.example;

/**
 * A person who writes slogans.
 */
public class SloganMaker {

    /**
     * Composes slogan based on a film {@link SloganMaker} has watched.
     */
    public String composeSlogan(String filmTitle) {
        // Some magic happens here
        switch (filmTitle) {
            case "The Shawshank Redemption":
                return "Fear can hold you prisoner. Hope can set you free.";
            case "El Maquinista":
                return "How do you wake up from a nightmare if you're not asleep?";
            default:
                return "There can be only one.";
        }
    }
}
