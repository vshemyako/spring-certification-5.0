package spring.certification.mvc;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 003:<br>
 * What is the DispatcherServlet and what is it used for?<br>
 * <p>
 * Answer:<br>
 * Dispatcher servlet is a front-controller servlet through which all requests are funneled and handled to the
 * appropriate spring-mvc-controller. To decide which controller to send request to dispatcher servlet consults
 * one or more handler mappings. The main purpose of a dispatcher-servlet usage is to centralize security functionality
 * and error-handling functionality.<br>
 * Spring framework allows to defined multiple dispatcher servlets, each containing its own set of handler mappings,
 * application context, spring-mvc-controllers.<br>
 *
 * @author Valentine Shemyako
 * @since January 11, 2019
 */
public class Q003dispatcherservlet {
}
