package spring.certification.ioc.q003.example;

/**
 * Interface which defines basic actions each human can perform.
 */
public interface Human {

    /**
     * Gives a polite word or sign of welcome.
     */
    void greet();

    /**
     * Gives food to somebody who needs it.
     */
    void feed();

    /**
     * Makes one easier to do something.
     */
    void help();
}
