package spring.chapter01.decoupled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Renders message to {@link System#out} stream
 */
@Component
public class StandardOutputMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (this.messageProvider == null) {
            throw new IllegalStateException("Cannot render message: provider isn't specified");
        }

        System.out.println(this.messageProvider.getMessage());
    }

    @Autowired
    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
