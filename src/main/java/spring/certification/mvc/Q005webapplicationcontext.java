package spring.certification.mvc;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * What is a web application context? What extra scopes does it offer?<br>
 * <p>
 * Answer:<br>
 * Web application context is a web application configuration class. It implements {@link WebApplicationContext} interface
 * which allows to access {@link ServletContext} in which it runs.<br>
 * <p>
 * Web application context offers several extra bean scopes:<br>
 * - Request - per each http request<br>
 * - Session - per each http session<br>
 * - Application - unique within servlet context<br>
 * - Websocket - unique within websocket lifecycle<br>
 *
 * @author Valentine Shemyako
 * @since January 11, 2019
 */
public class Q005webapplicationcontext {
}
