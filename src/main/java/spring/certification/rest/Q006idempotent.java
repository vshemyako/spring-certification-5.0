package spring.certification.rest;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 006:<br>
 * What are idempotent operations?<br>
 * Why is idempotency important?<br>
 * <p>
 * Answer:<br>
 * Idempotency refers to the state of a system, <b>after</b> a request has completed, it is not related to the status
 * code which is returned by the system. Idempotent operations are the operations side effects of which do not differ
 * no matter how many times those operations are executed.<br>
 * Idempotency is important in building fault-tolerant APIs, e.g. in case of a failure it's safe to resent the request
 * until satisfactory response is returned back.<br>
 * The following http methods are considered idempotent:<br>
 * - all operation which are considered {@link Q005safe safe}<br>
 * plus<br>
 * - DELETE<br>
 * - PUT<br>
 * <p>
 * The only http methods which are not considered idempotent are:<br>
 * - POST<br>
 * - PATCH<br>
 * <p>
 * It's important to emphasise that POST and PATCH can be also <b>idempotent</b>, they are just not required to be so.<br>
 *
 * @author Valentine Shemyako
 * @since December 14, 2018
 */
public class Q006idempotent {
}
