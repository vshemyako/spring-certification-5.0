package spring.chapter01.decoupled;

/**
 * Reworked 'Hello World' examples with decoupled logic
 */
public class HelloWorldDecoupled {

    /**
     * Main starter method were basically all logic is placed
     */
    public static void main(String[] args) {
        MessageRenderer messageRenderer = new StandardOutputMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        // render passed message
        messageRenderer.render();
    }
}
