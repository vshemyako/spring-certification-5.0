package spring.certification.ioc.q014;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spring.certification.ioc.q014.example.CoachPotato;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 014:<br>
 * Are beans lazily of eagerly instantiated by default? How do you alter this behaviour?<br>
 * <p>
 * Answer:<br>
 * Only beans with scope <b>singleton</b> are instantiated eagerly (i.e. as part of application-context initialization
 * process).<br>
 * Marking bean definition as lazy-initialized alters this default behavior. Initialization of lazy-loaded beans is
 * delayed until bean is requested. However, if lazily-initialized bean is a collaborator of an eagerly-initialized
 * bean, this lazy behavior is ignored to satisfy required dependencies of the eagerly-initialized bean.<br>
 * <p>
 * It's possible to control bean initialization type at {@link Configuration} class level, {@link Component} class level,
 * or at {@link Bean} method factory level with the help of {@link Lazy} annotation.<br>
 * Examples of mentioned terms:<br>
 * {@link CoachPotato} - simplistic usage of {@link Lazy} annotation at {@link Configuration} class level.
 *
 * @author Valentine Shemyako
 * @since November 22, 2018
 */
public class LazyBeanCreation {
}
