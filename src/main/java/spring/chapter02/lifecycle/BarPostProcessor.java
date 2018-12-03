package spring.chapter02.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BarPostProcessor implements BeanPostProcessor {

    /**
     * 6. Container invokes {@link #postProcessBeforeInitialization(Object, String)} method
     * defined by {@link BeanPostProcessor} interface
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before initialization");
        return bean;
    }

    /**
     * 8. Container invokes {@link #postProcessAfterInitialization(Object, String)} method
     * defined by {@link BeanPostProcessor} interface
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After initialization");
        return bean;
    }
}
