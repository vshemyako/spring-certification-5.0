package spring.certification.ioc.q006.example.standalone;

/**
 * Provides a message defined at object construction phase.
 */
public class MessageProvider {

    private String message;

    /**
     * Instance creation method.
     */
    public MessageProvider(String message) {
        this.message = message;
    }

    /**
     * Central method of {@link MessageProvider}
     */
    public String getMessage() {
        return message;
    }
}
