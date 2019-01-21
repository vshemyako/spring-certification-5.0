package spring.certification.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 013:<br>
 * What is the difference between @Controller and @RestController?<br>
 * <p>
 * Answer:<br>
 * {@link RestController} is a compound annotation, which is meta-annotated with {@link Controller}
 * and {@link ResponseBody} annotations. Thus response-request bodies are a subject of http-converters
 * omitting view-model phase. One might prefer to use {@link Controller} and {@link ResponseBody} annotations
 * instead - {@link RestController} is just a convenience annotation.<br>
 *
 * @author Valentine Shemyako
 * @since January 19, 2019
 */
public class Q013restcontroller {
}
