package spring.certification.aop.q005.example;

/**
 * Sometimes people panic.
 */
public class PanicException extends RuntimeException {

    public PanicException() {
    }

    public PanicException(String message) {
        super(message);
    }
}
