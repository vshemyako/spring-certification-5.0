package spring.certification.mvc;

import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 016:<br>
 * What is the Model?<br>
 * <p>
 * Answer:<br>
 * <b>{@link Model}</b> is a data displayed by a <b>{@link View}</b>. Once a controller
 * completes request processing - the model should contain all the data to display. Model
 * should not perform any data access and business logic, or in any case depend on
 * web-framework. In Spring Mvc framework {@link Model} is envisioned and implemented
 * as a key-value collection (more specifically a {@link Map}).<br>
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q016model {
}
