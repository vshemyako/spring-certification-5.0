package spring.certification.ioc.q014.example;

/**
 * Guess this one is more active =).
 */
public class RollingStone {

    private static boolean initialized = false;

    public RollingStone() {
        initialized = true;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
