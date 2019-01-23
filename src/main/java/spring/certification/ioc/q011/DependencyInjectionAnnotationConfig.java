package spring.certification.ioc.q011;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import spring.certification.ioc.q011.example.ComponentScanPackageMarker;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 011:<br>
 * Describe dependency injection using annotations (@Component, @Autowired).<br>
 * <p>
 * Answer:<br>
 * Stereotype annotated classes (directly or indirectly marked with {@link Component} annotation) can be automatically
 * detected and registered as {@link BeanDefinition} instances in the {@link ApplicationContext}. Spring framework, as
 * usual, offers two possible ways to enable automatic detection and registering of Spring beans: XML-based and
 * Java-based.<br>
 * <p>
 * Java-based approach turns around usage of {@link ComponentScan} annotation along with {@link Configuration} annotation.
 * The main purpose of a {@link ComponentScan} annotation is to define a <b>root package</b> which will be scanned
 * recursively in depth. If non package is defined, {@link Configuration} class annotated with {@link ComponentScan}
 * by itself declares root package to start scanning from.
 * <p>
 * Along with automatic bean detection the following {@link BeanPostProcessor bean post-processors} are registered:<br>
 * 1. {@link AutowiredAnnotationBeanPostProcessor} - which processes {@link Autowired}, {@link Inject}, {@link Value}
 * and {@link Lookup} annotations.<br>
 * 2. {@link CommonAnnotationBeanPostProcessor} - which processes JSR-250 annotations ({@link PostConstruct},
 * {@link PreDestroy}, etc.).<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link ComponentScanPackageMarker} - demonstrates basic usage of {@link ComponentScan} annotation.
 *
 * @author Valentine Shemyako
 * @since November 28, 2018
 */
public class DependencyInjectionAnnotationConfig {
}
