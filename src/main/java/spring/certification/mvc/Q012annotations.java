package spring.certification.mvc;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 012:<br>
 * What other annotations might you use on a controller method parameter?<br>
 * <p>
 * Answer:<br>
 * Along with {@link RequestParam} and {@link PathVariable} the following annotations
 * might be used to bind values to method parameters:<br>
 * - {@link MatrixVariable} to bind name-value pairs from URI segments<br>
 * - {@link RequestBody} to bind body of web-request<br>
 * - {@link RequestHeader} to bind web-request header<br>
 * - {@link RequestPart} to bind part of multipart request<br>
 * - {@link CookieValue} to bind cookie value<br>
 * - different attributes: {@link ModelAttribute}, {@link RequestAttribute}, {@link SessionAttribute}<br>
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q012annotations {
}
