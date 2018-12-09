package spring.certification.aop.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Helper annotation to test workings of {@code @within} pointcut designator.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WithinHelper {
}
