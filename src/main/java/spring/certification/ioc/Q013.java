package spring.certification.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 013:<br>
 * Describe scopes for Spring beans. What is the default scope?<br>
 * <p>
 * Answer:<br>
 * Spring Framework offers several bean scopes:<br>
 * Stand-alone application scopes:<br>
 * 1. Singleton scope - bean definition is used to create only one bean which is unique within an
 * {@link ApplicationContext}.  This scope is the default one.
 * 2. Prototype scope - bean definition is used to create any number of beans that is requested. This is actually a
 * 'rough' replacement for the Java 'new' operator.<br>
 * <p>
 * Additional web-application scopes:
 * 3. Request scope - bean definition is used to create a bean for each HTTP request. {@link RequestScope} annotation<br>
 * 4. Session scope - bean definition is used to create a bean for each HTTP session.<br>
 * 5. Application scope - bean definition is used to create a bean for the lifecycle of a ServletContext.<br>
 * 6. Websocket scope - bean definition is used to create a bean for the lifecycle of a Websocket.<br>
 * <p>
 * In annotation-based configuration these scopes can be chosen by using {@link Scope} annotation with provided scope
 * name.<br>
 * Examples of mentioned terms:<br>
 * {@link Q013.ScopeConfiguration} - demonstrates basic usage of bean {@link Scope scopes}.
 *
 * @author Valentine Shemyako
 * @since November 21, 2018
 */
public class Q013 {

    /**
     * Demonstrates basic usage of {@link Scope} annotation as well as scoping logic which is supported by Spring IoC
     * container.
     */
    @Configuration
    public static class ScopeConfiguration {

        /**
         * Default singleton scope is changed using {@link Scope} annotation.
         * New bean instance will be created for each injection.
         * It's a stateful bean.
         */
        @Scope(scopeName = "prototype")
        @Bean
        public Notebook notebook() {
            return new Notebook();
        }

        /**
         * Singleton bean - scope doesn't have to be explicitly specified.
         * This bean will be shared among all other beans.
         * It's a stateless bean.
         */
        @Bean
        public Inspiration inspiration() {
            return new Inspiration();
        }

        /**
         * Required dependency will be injected by Spring IoC container automatically.
         */
        @Bean
        public Writer writer(Notebook notebook, Inspiration inspiration) {
            return new Writer(notebook, inspiration);
        }

        /**
         * As in previous factory method {@code notebook} dependency will be satisfied by IoC container.
         * But this time it won't be the same instance. Scope of a {@code notebook} is 'prototype'.
         */
        @Bean
        public Student student(Notebook notebook, Inspiration inspiration) {
            return new Student(notebook, inspiration);
        }
    }

    /**
     * A person who lays thoughts on the paper.
     */
    public static class Writer {

        private Notebook notebook;
        private Inspiration inspiration;

        public Writer(Notebook notebook, Inspiration inspiration) {
            this.notebook = notebook;
            this.inspiration = inspiration;
        }

        public Notebook getNotebook() {
            return notebook;
        }

        public Inspiration getInspiration() {
            return inspiration;
        }
    }

    /**
     * A person enrolled in educational processes.
     */
    public static class Student {

        private Notebook notebook;
        private Inspiration inspiration;

        public Student(Notebook notebook, Inspiration inspiration) {
            this.notebook = notebook;
            this.inspiration = inspiration;
        }

        public Notebook getNotebook() {
            return notebook;
        }

        public Inspiration getInspiration() {
            return inspiration;
        }
    }

    /**
     * Bunch of paper pages.
     */
    public static class Notebook {
    }

    /**
     * Burst of creativity.
     */
    public static class Inspiration {
    }
}
