package spring.certification.ioc.q002;

/**
 * There's no reason to allow creation of several instances of a stateless class.
 * Demonstrates good programming practice in regard of software design.
 */
public class Singleton {

    /**
     * Reference to single instance is created eagerly.
     */
    private static final Singleton INSTANCE = new Singleton();

    /**
     * External creation of singleton instances is forbidden.
     */
    private Singleton() {
    }

    /**
     * Public access point to get singleton reference.
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
