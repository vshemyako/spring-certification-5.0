package spring.certification.mvc;

import org.springframework.ui.Model;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.View;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 017:<br>
 * Why do you have access to the model in your View? Where does it come from?<br>
 * <p>
 * Answer:<br>
 * {@link View} representation is based on a model. This model info is passed by
 * {@link DispatcherServlet} to the resolved view (during {@link View#render} method invocation).<br>
 * On the contrary {@link Model} knows nothing about a {@link View}.<br>
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q017viewmodelrelation {
}
