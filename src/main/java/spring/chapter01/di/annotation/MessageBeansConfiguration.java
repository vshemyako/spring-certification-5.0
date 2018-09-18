package spring.chapter01.di.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.chapter01.decoupled.HelloWorldMessageProvider;
import spring.chapter01.decoupled.MessageProvider;
import spring.chapter01.decoupled.MessageRenderer;
import spring.chapter01.decoupled.StandardOutputMessageRenderer;

/**
 * Substitution of xml-based configuration classes
 */
@Configuration
public class MessageBeansConfiguration {

    @Bean
    public MessageProvider messageProvider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer() {
        StandardOutputMessageRenderer messageRenderer = new StandardOutputMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }
}
