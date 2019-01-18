package spring.certification.security;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 011:<br>
 * Why do you need method security?<br>
 * What type of object is typically secured at the method level (think of its purpose not its Java type).<br>
 * <p>
 * Answer:<br>
 * Importance of method level security:<br>
 * 1. Another security level which might be configured separately from the web-layer security.<br>
 * 2. Several web-controllers with different authority level utilize the same business method.<br>
 * 3. Protection from developer mistakes, malicious usage.<br>
 * <p>
 * Method level security is all about protecting sensitive data, which is usually managed by business (service)
 * layer of an application. Spring method-security aims to protect exactly that layer of an application.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q011methodsecurity {
}
