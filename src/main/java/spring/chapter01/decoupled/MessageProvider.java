package spring.chapter01.decoupled;

/**
 * Defines contract to provide a message
 */
public interface MessageProvider {

    /**
     * Returns {@link String} instance which represents some message
     */
    String getMessage();
}
