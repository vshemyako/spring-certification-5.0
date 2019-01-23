package spring.certification.ioc.q003;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 003:<br>
 * What is an interface and what are the advantages of making use of them in Java?<br>
 * Why are they recommended for Spring beans?
 * <p>
 * Answer:<br>
 * Interface is an abstract reference type which defines a set of methods with no implementations (prior to Java 8).
 * <p>
 * Advantages of using interfaces:<br>
 * 1. Reduces dependencies on implementation details, therefore making code more reusable and easier to refactor<br>
 * 2. Allows to provide different implementations at runtime<br>
 * 3. Makes code easier to test
 * <p>
 * Those advantages are the main reasons why interfaces are suggested to be used by Spring beans (replacements,
 * interception, decoration of beans is possible).<br>
 * <p>
 * <p>
 * Note:<br>
 * Spring bean is an object which is instantiated, assembled and otherwise managed by Spring IoC container.
 * The motivation for using the name 'bean' arose as a response to the complexity of <b>Enterprise JavaBeans</b>
 * technology.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link spring.certification.ioc.q003.example} - shows advantages of programming to an interface instead of implementation.<br>
 *
 * @author Valentine Shemyako
 * @since November 13, 2018
 */
public class Interface {
}
