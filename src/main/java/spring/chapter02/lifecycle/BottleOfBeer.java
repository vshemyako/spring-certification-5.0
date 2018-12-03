package spring.chapter02.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Simple model class to verify bean lifecycle managed by spring container
 */
@Component
public class BottleOfBeer implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        BeanPostProcessor, InitializingBean, DisposableBean {

    private Beer beer;
    private String beanName;
    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;

    /**
     * 1. Spring instantiates the bean
     */
    public BottleOfBeer() {
        System.out.println("Constructor");
    }

    /**
     * 2. Dependencies are being set
     */
    @Autowired
    public void setBeer(Beer beer) {
        System.out.println("Setter");
        this.beer = beer;
    }

    /**
     * 3. Container invokes {@link #setBeanName(String)} method
     * defined by {@link BeanNameAware} interface
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name aware");
        this.beanName = name;
    }

    /**
     * 4. Container invokes {@link #setBeanFactory(BeanFactory)} method
     * defined by {@link BeanFactoryAware} interface
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean factory aware");
        this.beanFactory = beanFactory;
    }

    /**
     * 5. Container invokes {@link #setApplicationContext(ApplicationContext)} method
     * defined by {@link ApplicationContextAware} interface
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context aware");
        this.applicationContext = applicationContext;
    }

    /**
     * 7.1 Hook for properties validation
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After properties set");
    }

    /**
     * 7.2 Hook for further fields initialization
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("Post construct");
    }

    /**
     * 9. Hook to release resources before bean destruction
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy");
    }
}
