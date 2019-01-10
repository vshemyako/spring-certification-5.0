package spring.certification.mvc;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * MVC is an abbreviation for a design pattern.<br>
 * What does it stand for and what is the idea behind it?<br>
 * <p>
 * Answer:<br>
 * <b>MVC</b> stands for Model-View-Controller. The main idea is to separate different layers of a web-application,
 * which makes it possible to reuse controllers and models with different views.<br>
 * - Model - business data of an application<br>
 * - View - model presented to the user in desired format<br>
 * - Controller - users' requests handler, interacts with the model (usually via service layer) and directs users
 * to the appropriate view<br>
 * <p>
 * MVC design pattern can be implemented in different ways. Spring Framework utilizes <b>Front Controller</b> design
 * pattern which funnels all user requests through a single <b>Dispatcher Servlet</b> object.<br>
 *
 * @author Valentine Shemyako
 * @since January 10, 2019
 */
public class Q001mvc {
}
