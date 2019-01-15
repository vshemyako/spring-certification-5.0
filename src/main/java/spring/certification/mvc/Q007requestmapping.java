package spring.certification.mvc;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 007:<br>
 * How is an incoming request mapped to a controller and mapped to a method?<br>
 * <p>
 * Answer:<br>
 * Incoming request mapping consists of three parts:<br>
 * 1. Root front-controller mapping (e.g. "/")<br>
 * 2. Class-level web-controller mapping (optional, e.g. "/person"), defined via {@link RequestMapping}<br>
 * 3. Method-level mapping (optional, e.g. handling only HTTP GET requests), defined via {@link RequestMapping}<br>
 *
 * @author Valentine Shemyako
 * @since January 15, 2019
 */
public class Q007requestmapping {
}
