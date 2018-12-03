package spring.chapter01.decoupled;

import org.springframework.stereotype.Component;

/**
 * Returns "Hello World!" message
 */
@Component
public class HelloWorldMessageProvider implements MessageProvider {

    private static final String MESSAGE_HELLO_WORLD = "Hello World!";

    @Override
    public String getMessage() {
        return MESSAGE_HELLO_WORLD;
    }
}
