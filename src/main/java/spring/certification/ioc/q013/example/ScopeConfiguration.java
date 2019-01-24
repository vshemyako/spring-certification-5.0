package spring.certification.ioc.q013.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Demonstrates basic usage of {@link Scope} annotation as well as scoping logic which is supported by Spring IoC
 * container.
 */
@Configuration
public class ScopeConfiguration {

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
