package spring.certification.security;

import org.springframework.security.core.Authentication;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 017:<br>
 * Spring security offers a security tag library for JSP, would you recognize it if you saw it in an example?<br>
 * <p>
 * Answer:<br>
 * To utilize Spring Security jsp-tag library one have to declare it first:<br>
 * {@code <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>}<br>
 * <p>
 * Security tag-lib is tiny, consists only of several security tags:<br>
 * {@code <sec:authorize>} - contents are only visible in case <i>access</i> property is evaluated to true.<br>
 * {@code <sec:authentication>} - allows to access {@link Authentication} object properties.<br>
 * {@code <sec:csrfInput>} - adds hidden form fields to utilize CSRF functionality.<br>
 * {@code <sec:csrfMetaTags>} - allows to access CSRF token via Javascript code.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q017jsplib {
}
