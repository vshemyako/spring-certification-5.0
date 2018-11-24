package spring.certification.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 017:<br>
 * What is a BeanPostProcessor and how is it different to a BeanFactoryPostProcessor?<br>
 * What both of them do?<br>
 * When are they called?<br>
 * <p>
 * Answer:<br>
 * {@link BeanPostProcessor} is an interface which allows to extend functionality of an {@link ApplicationContext} in
 * regard of bean instantiation logic. More specifically it defines two methods:<br>
 * 1. {@link BeanPostProcessor#postProcessBeforeInitialization} - which applies some logic before beans init lifecycle
 * callbacks are invoked<br>
 * 2. {@link BeanPostProcessor#postProcessAfterInitialization} - which applies some logic after beans init lifecycle
 * callbacks are invoked<br>
 * <p>
 * Typically {@link BeanPostProcessor} implementations validate injected dependencies of a bean, or inject them
 * themselves, wrap instantiated object with a proxy object and so on.<br>
 * It's possible to register several custom {@link BeanPostProcessor post-processors} which will be applied in order
 * defined by {@link Ordered} interface which has to be implemented too.<br>
 * <p>
 * It's important to remember that {@link BeanPostProcessor} beans are related to specific phase of application-context
 * initialization - they are instatiated as soon as possible to post-process all other 'normal' beans. Therefore, their
 * definition using java code should be done with the help of <b>static</b> factory methods which are loaded early.<br>
 * <p>
 * {@link BeanPostProcessor} and {@link BeanFactoryPostProcessor} are related in the sense that they both extend
 * standard functionality of an {@link ApplicationContext} and therefore they should be defined as static factories. But
 * their main purpose is quite different:<br>
 * {@link BeanFactoryPostProcessor} adjusts {@linkplain BeanDefinition bean definitions}<br>
 * {@link BeanPostProcessor} adjusts beans themselves<br>
 * <p>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since November 24, 2018
 */
public class Q017 {

    /**
     * Simple java-based IoC configuration class.
     */
    @Configuration
    public static class AlcoholicConfiguration {

        /**
         * Bean factory which returns instance of an {@link Alcohol} interface.
         */
        @Bean
        public Alcohol wine() {
            return new Wine();
        }

        /**
         * Static bean factory to register {@link BeanPostProcessor} as soon as possible.
         */
        @Bean
        public static AlcoholicPostProcessor alcoholicPostProcessor() {
            return new AlcoholicPostProcessor();
        }
    }

    /**
     * Bean post-processor which will substitute created {@link Wine} instance with {@link Beer} instances.
     */
    public static class AlcoholicPostProcessor implements BeanPostProcessor {

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

    /**
     * Alcoholic drink made of fermented grapes.
     */
    public static class Wine implements Alcohol {

        @Override
        public String getName() {
            return "wine";
        }
    }

    /**
     * Bitter alcoholic drink made from grain.
     */
    public static class Beer implements Alcohol {

        @Override
        public String getName() {
            return "bear";
        }
    }

    /**
     * Colorless liquid with some implicit benefits.
     */
    public interface Alcohol {

        /**
         * @return name of an alcoholic drink.
         */
        String getName();
    }
}
