package spring.certification.rest;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 007:<br>
 * Is REST scalable and/or interoperable?<br>
 * <p>
 * Answer:<br>
 * <b>Scalability</b>:<br>
 * Client session info is stored on client-side and never on sever-side. In case session info is needed - it is passed from client to server.<br>
 * Client can cache some responses which reduces the load on a server.<br>
 * <b>Interoperability</b>:<br>
 * Resources are identified using URIs, which isn't bound to any language or technology.<br>
 * Services can produce representations in different formats (JSON, XML, HTML, etc.) depending on client's request.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q007scalability {
}
