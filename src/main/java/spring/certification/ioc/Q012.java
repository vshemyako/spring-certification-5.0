package spring.certification.ioc;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * Describe component-scanning.<br>
 * Describe stereotypes.<br>
 * Describe meta-annotations.<br>
 * <p>
 * Answer:<br>
 * Meta annotation is an annotation which can be applied to other types of annotations. Some predefined meta-annotations
 * which come with JDK are: {@link Target}, {@link Retention}, etc. For an annotation to become a meta-annotation
 * appropriate {@link ElementType} should be used ({@link ElementType#ANNOTATION_TYPE}, {@link ElementType#TYPE} or none).<br>
 * <p>
 * Spring framework uses intensively those kind of annotations, e.g. {@link Configuration} annotation is meta annotated
 * with {@link Component} annotation, therefore classes annotated with {@link Configuration} are also registered as
 * Spring beans.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since November 27, 2018
 */
public class Q012 {
}
