package spring.certification.mvc;

import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.WebRequest;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 011:<br>
 * What are some of the parameter types for a controller method?<br>
 * <p>
 * Answer:<br>
 * Multiple argument types are supported by Spring Mvc framework:<br>
 * - {@link WebRequest} - to access general request metadata, e.g. {@link WebRequest#getParameter(String)}<br>
 * - {@link ServletRequest}, {@link ServletResponse} native Servlet API objects, to handle client's request and sending response<br>
 * - extensions of {@link ServletRequest} and {@link ServletResponse} types (e.g. {@link HttpServletRequest})<br>
 * - types which can be indirectly accessed through {@link HttpServletRequest} objects (e.g. {@link HttpSession}, {@link HttpMethod}, etc.)<br>
 * - {@link Errors}, {@link BindingResult} types for data-binding and validation errors<br>
 * - {@link Model}, {@link ModelMap}, {@link Map}<br>
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q011parametertypes {
}
