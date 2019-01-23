package spring.certification.ioc.q011.example;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Component;

/**
 * Class annotated with <b>stereotype</b> annotation is a candidate for automatic detection and registering as
 * {@link BeanDefinition} instance.
 */
@Getter
@Component
public class Pen {

    private Ink ink;

    @Autowired
    public Pen(Ink ink) {
        this.ink = ink;
    }
}
