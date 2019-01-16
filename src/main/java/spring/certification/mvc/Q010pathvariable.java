package spring.certification.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 010:<br>
 * What are the differences between @RequestParam and @PathVariable?<br>
 * <p>
 * Answer:<br>
 * For {@link RequestParam} usage refer to {@link Q009requestparam}.<br>
 * {@link PathVariable} is used to map <b>URI template variables</b> to method parameters.
 * URI template variable is a part of URI which adheres to the following syntax:<br>
 * - is wrapped into curly brackets (e.g. ../{name})<br>
 * - is wrapped into $-curly brackets (alike {@link Value} annotation placeholders), (e.g. ../${name})<br>
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q010pathvariable {
}
