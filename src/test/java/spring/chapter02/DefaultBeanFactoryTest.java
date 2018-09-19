package spring.chapter02;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import spring.chapter02.factory.Oracle;

/**
 * Tests one of the main implementations of {@link org.springframework.beans.factory.BeanFactory} interface
 */
public class DefaultBeanFactoryTest {

    private static final String BEAN_DEFINITION_FILE = "chapter02/bean-definition.xml";

    /**
     * Tests the most basic functionality of IoC offered by {@link DefaultListableBeanFactory} class
     */
    @Test
    public void shouldPrintMeaningOfLife() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // specify mediator to load bean definition into factory
        XmlBeanDefinitionReader beanReader = new XmlBeanDefinitionReader(beanFactory);
        beanReader.loadBeanDefinitions(BEAN_DEFINITION_FILE);
        // fetch desired bean from the factory
        Oracle oracle = beanFactory.getBean(Oracle.class);

        // assert
        Assert.assertEquals("Bear for the life", oracle.getMeaningOfLife());
    }
}
