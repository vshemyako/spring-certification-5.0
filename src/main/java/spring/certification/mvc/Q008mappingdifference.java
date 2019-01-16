package spring.certification.mvc;

import java.lang.annotation.ElementType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 008:<br>
 * What is the difference between @RequestMapping and @GetMapping?<br>
 * <p>
 * Answer:<br>
 * {@link RequestMapping} is a web-request mapping annotation that can be applied both at a class or at a method level,
 * optionally specifying matching HTTP request method (GET, POST, etc.). In case {@link RequestMapping} is applied at
 * a {@link ElementType#TYPE} level and HTTP request method is specified - all method-level mappings inherit this HTTP
 * method restriction.<br>
 * {@link GetMapping} is also a web-request mapping annotation. It's a composed annotation, which can be applied only
 * at a <b>method</b> level ({@link ElementType#METHOD}) and is used as a short-cut for {@code @RequestMapping(method = RequestMethod.GET)}.
 * It narrows down mapping restrictions which are applied at a class-level.<br>
 * Note: Spring Mvc Framework supports custom composed request-mapping annotation alike {@link GetMapping}.<br>
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q008mappingdifference {
}
