package spring.certification.rest;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * What does REST stand for?<br>
 * <p>
 * Answer:<br>
 * <b>REST</b> stands for Representational State Transfer. It's an architectural style for designing distributed systems.
 * Simply put Representational State Transfer is about <b>transferring</b> of <b>representations</b> of a resource state
 * (e.g. a rdbms record in particular <b>state</b> is serialized into JSON <b>representation</b> which is <b>transferred</b>
 * to a client).<br>
 * <p>
 * Core principles of REST are:<br>
 * 1. Uniform interface<br>
 * 2. Stateless<br>
 * 3. Cacheable<br>
 * 4. Client-server<br>
 * 5. Layered system<br>
 * 6. Code on demand<br>
 * <p>
 * <p>
 * Each REST principle in more details:<br>
 * 1. <b>Uniform interface</b> is build upon the following things:<br>
 * - Each resource is uniquely identified using <b>URIs</b>. Those resource are conceptually separate from representations
 * which are sent to the client (not db record is sent, but some JSON, XML or other representation).<br>
 * - Manipulation of resources is done through representations. Client, holding an representation with some attached
 * metadata has enough information to somehow modify this resource on the server (in case client has permission to do so).<br>
 * - Messages which are sent to the client, are self-descriptive, e.g. http message media type gives a client enough
 * info about how to process (parse) resource representation which is sent along.<br>
 * - Hypermedia as the Engine of Application State (<b>HATEOAS</b>): client utilize request body contents, request parameters,
 * request headers, URIs; service utilize response body, response codes, response headers. Those terms are technically
 * called as hypermedia. Moreover sometimes hyperlinks (URIs) are supplied within body or headers.<br>
 * <p>
 * 2. <b>Stateless</b> means that server doesn't store any client session info. Session is stored on the client side, and,
 * if necessary is sent to the server side.<br>
 * 3. <b>Cacheable</b> means that client can cache responses, which are defined so implicitly or explicitly by the server.<br>
 * 4. <b>Client-Server</b> means that client doesn't care about implementation details of a server and vice versa (data
 * storage is an implementation detail of a server, user interface is an implementation detail of a client).<br>
 * 5. <b>Layered system</b>: client doesn't know whether it communicates directly with the server or some intermediate
 * node.<br>
 * 6. <b>Code on demand</b>: servers are able to temporarily extend functionality of clients by transferring logic which
 * client can execute.<br>
 * <p>
 * Service which conforms to REST principles is called <b>RESTful</b>.
 *
 * @author Valentine Shemyako
 * @since December 11, 2018
 */
public class Q001rest {
}
