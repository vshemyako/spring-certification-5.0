package spring.certification.ioc.q014.example;

/**
 * A lazy person.
 */
public class CoachPotato {

    private static boolean initialized = false;

    public CoachPotato() {
        initialized = true;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
