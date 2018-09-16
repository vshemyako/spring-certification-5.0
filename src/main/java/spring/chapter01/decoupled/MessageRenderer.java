package spring.chapter01.decoupled;

/**
 * Contract for rendering a message which is provided by instance returned
 * by {@link #getMessageProvider()}
 */
public interface MessageRenderer {

    /**
     * Renders message passed by {@link MessageProvider} instance
     */
    void render();

    /**
     * Sets {@link MessageProvider} instance which supplies messages to render
     */
    void setMessageProvider(MessageProvider messageProvider);

    /**
     * Provides {@link MessageProvider} instance
     */
    MessageProvider getMessageProvider();
}
