package spring.chapter01.factory;

import spring.chapter01.decoupled.MessageProvider;
import spring.chapter01.decoupled.MessageRenderer;

import java.util.ResourceBundle;

/**
 * Further extended decoupled example which chooses concrete interface implementations
 * from a property file
 */
public class MessageFactory {

    private static final String RESOURCE_BUNDLE_NAME = "factory";
    private static final String PROVIDER = "provider";
    private static final String RENDERER = "renderer";

    private static MessageFactory instance = new MessageFactory();

    private final MessageProvider messageProvider;
    private final MessageRenderer messageRenderer;
    private final ResourceBundle messageBundle;

    /**
     * Instantiates 'message' type classes on application start-up, reading concrete implementation classes
     * from properties file
     */
    private MessageFactory() {
        try {
            this.messageBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME);
            this.messageProvider = (MessageProvider) Class.forName(messageBundle.getString(PROVIDER)).newInstance();
            this.messageRenderer = (MessageRenderer) Class.forName(messageBundle.getString(RENDERER)).newInstance();
        } catch (Exception ex) {
            System.err.println("Failed to instantiate message factory: " + ex.getMessage());
            throw new IllegalStateException("Application is in an undefined state. Review application config.");
        }
    }

    /**
     * Eager singleton design pattern implementation (not actually the best choice)
     */
    public static MessageFactory getInstance() {
        return instance;
    }

    /**
     * @return {@link MessageProvider} instance, concrete implementation class
     * is defined within properties file
     */
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    /**
     * @return {@link MessageRenderer} instance, concrete implementation class
     * is defined within properties file
     */
    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }
}
