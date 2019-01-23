package spring.certification.ioc.q012;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import spring.certification.ioc.q011.DependencyInjectionAnnotationConfig;
import spring.certification.ioc.q023.example.NonQualifiedConfiguration;
import spring.certification.ioc.q023.example.QualifiedConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * Describe component-scanning.<br>
 * Describe stereotypes.<br>
 * Describe meta-annotations.<br>
 * <p>
 * Answer:<br>
 * <b>Component scanning</b> allows to implicitly register bean definitions without additional configuration specified
 * in java-based classes or xml documents. For enabling component scanning {@link org.springframework.context.annotation.ComponentScan} annotation should be
 * used (or appropriate {@code <context:component-scan>} xml element). For more information about component scanning
 * refer to {@link DependencyInjectionAnnotationConfig}.<br>
 * <p>
 * <b>Stereotype</b> (in a Spring framework sense) is some kind of a class which conforms to a fixed, community
 * standardized role. Spring framework defines a set of <b>stereotype</b> annotations to highlight the main purpose
 * of an annotated class (in addition to being auto-detected as a Spring bean):<br>
 * 1. {@link Component} - root annotation, which may serve as a meta-annotation (primarily used as component scan candidate).<br>
 * 2. {@link Service} - general-purpose role class, usually specifies business-logic of an application<br>
 * 3. {@link Repository} - data access object class<br>
 * 4. {@link Controller} - web controller class<br>
 * 5. {@link Configuration} - class which contains bean meta-information<br>
 * <p>
 * <b>Meta annotation</b> is an annotation which can be applied to other types of annotations. Some predefined meta-annotations
 * which come with JDK are: {@link Target}, {@link Retention}, etc. For an annotation to become a meta-annotation
 * appropriate {@link ElementType} should be used ({@link ElementType#ANNOTATION_TYPE}, {@link ElementType#TYPE} or none).<br>
 * <p>
 * Spring framework uses intensively those kind of annotations, e.g. {@link Configuration} annotation is meta annotated
 * with {@link Component} annotation, therefore classes annotated with {@link Configuration} are also registered as
 * Spring beans.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link NonQualifiedConfiguration} - demonstrates wrong configuration class with DI ambiguity.<br>
 * {@link QualifiedConfiguration} - demonstrates appropriate configuration class which properly uses custom
 * {@link Qualifier} annotation.
 *
 * @author Valentine Shemyako
 * @since November 27, 2018
 */
public class ComponentScan {
}
