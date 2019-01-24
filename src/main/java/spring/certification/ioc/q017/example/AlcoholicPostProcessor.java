package spring.certification.ioc.q017.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean post-processor which will substitute created {@link Wine} instance with {@link Beer} instances.
 */
public class AlcoholicPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object substitution = bean;
        // check type of post-processed bean
        if (substitution instanceof Wine) {
            // substitute with bear instance
            substitution = new Beer();
        }
        return substitution;
    }
}
