package spring.certification.ioc.q002;

import spring.certification.ioc.q001.DependencyInjection;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 002:<br>
 * What is a pattern?<br>
 * What is an anti-pattern?<br>
 * Is dependency injection a pattern?
 * <p>
 * Answer:<br>
 * Design pattern is a typical solution to commonly occurring problem in software design which is considered a good
 * programming practice. <b>Singleton</b> is an example of a design pattern which is also widely used by Spring
 * framework (though implemented completely differently in comparison to well-known Gang-of-Four approach).
 * <p>
 * Anti-pattern is the opposite - typical solution that is considered a bad programming practice because it's usually
 * ineffective and counterproductive. <b>God object</b> is well known object-oriented anti-pattern.
 * <p>
 * Dependency injection is a design pattern which makes code look cleaner, decreases decoupling between objects,
 * makes code easier to test. For more information about dependency injection design pattern look at {@link DependencyInjection}.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Singleton} - an example of good coding practice (design pattern).<br>
 * {@link GodObject} - an example of bad coding practice (anti-pattern).<br>
 * {@link DependencyInjection} - discusses dependency injection design pattern in greater details.
 *
 * @author Valentine Shemyako
 * @since November 12, 2018
 */
public class Pattern {
}
