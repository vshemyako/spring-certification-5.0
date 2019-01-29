package spring.certification.mvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 013:<br>
 * What are some of the valid return types of a controller method?<br>
 * <p>
 * Answer:<br>
 * - {@code null} or {@code void} - to designate that request was fully handled<br>
 * - {@link View}, {@link Model}, {@link ModelAndView}<br>
 * - {@link String} - a view name to be resolved<br>
 * - {@link HttpHeaders} - response headers<br>
 * - {@link HttpEntity} - {@link HttpHeaders} plus response-body<br>
 * - {@link ResponseEntity} - {@link HttpEntity} plus response-status<br>
 * - types for async, reactive programming<br>
 * <p>
 * Note: it useful to annotate handler return value with {@link ResponseBody} to bound return value
 * directly to the web response body. Return value is serialized using an {@link HttpMessageConverter}.
 * Common usage is to serialize object to a <b>JSON</b> view. To minimize usage of {@link ResponseBody}
 * one might find helpful to annotate a class with {@link RestController} annotation which is a
 * compound annotation consisting of {@link Controller} and {@link ResponseBody} annotations, applied
 * to each method defined within annotated class.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q013returntypes {
}
