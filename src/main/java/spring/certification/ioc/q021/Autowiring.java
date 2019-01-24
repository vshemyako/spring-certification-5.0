package spring.certification.ioc.q021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 021:<br>
 * What is the behavior of the annotation @Autowired with regards to field injection, constructor injection and method
 * injection?<br>
 * <p>
 * Answer:<br>
 * {@link Autowired} annotation can be applied to a field, a method or a constructor of any visibility (including
 * private).<br>
 * By default declared injection is required. It's possible to change this behavior:<br>
 * 1. Declaring dependency of type {@link Optional}<br>
 * 2. Annotating dependency with {@link Nullable} annotation<br>
 * 3. Changing annotation as non-required (changing default value of {@link Autowired#required()})<br>
 * <p>
 * If only one constructor is present in a class - utilizing {@link Autowired} is optional, Spring IoC container
 * will inject those dependencies all the same.<br>
 *
 * @author Valentine Shemyako
 * @since November 30, 2018
 */
public class Autowiring {
}
