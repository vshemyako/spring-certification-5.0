package spring.certification.mvc;

import javax.servlet.ServletException;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 015:<br>
 * How is the right View chosen when it comes to the rendering phase?<br>
 * <p>
 * Answer:<br>
 * Rendering phase is performed by {@link DispatcherServlet#render} method,
 * which roughly consists of the following steps:<br>
 * 1. {@link ModelAndView} object is requested to return a view-name.<br>
 * 1.1. In case view-name is specified, predefined chain of {@link DispatcherServlet#viewResolvers}
 * is asked to {@link ViewResolver#resolveViewName resolve view-name}.<br>
 * 1.2. In case {@link ModelAndView} object doesn't contain view-name - it is requested
 * to return already set {@link View} object.<br>
 * 2.1. If {@link View} object wasn't determined in #1 - {@link ServletException} is thrown.<br>
 * 2.1. In case {@link View} object is determined - it is given a model object to actually
 * render the itself ({@link View} is invoked).<br>
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q015viewresolution {
}
