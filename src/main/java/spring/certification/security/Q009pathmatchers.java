package spring.certification.security;

import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 009:<br>
 * Why is an mvcMatcher more secure than an antMatcher?<br>
 * <p>
 * Answer:<br>
 * There are several reason behind this assertion:<br>
 * 1. {@link MvcRequestMatcher} is used for {@link RequestMapping} processing. Thus pattern matching both in
 * mvc module and security module will yield the same result.<br>
 * 2. {@link MvcRequestMatcher} implicitly adds .* suffix pattern matching
 * (e.g. /profile will also match /profile.pdf, /profile.csv, etc.)<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q009pathmatchers {
}
