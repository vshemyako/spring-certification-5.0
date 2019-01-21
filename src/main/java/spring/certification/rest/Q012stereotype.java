package spring.certification.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import spring.certification.ioc.Q012;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * Is @Controller a stereotype?<br>
 * Is @RestController a stereotype?<br>
 * What is a stereotype annotation? What does that mean?<br>
 * <p>
 * Answer:<br>
 * Annotations which are placed in <code>stereotype</code> package are considered as <i>stereotype annotations</i>.
 * {@link Controller} annotation is also placed there. {@link RestController} is a compound annotation which
 * is meta-annotated with {@link Controller}, thus it can also be considered as <i>stereotype</i>.<br>
 * <i>Stereotype annotation</i> relates to some community agreed role of a class to which a stereotype annotation
 * is applied. Stereotype annotations are discussed in more details in the {@link Q012 IoC sections}.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q012stereotype {
}
