package spring.certification.test.q005;

import spring.certification.test.q001.UnitTestSupport;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * How are mock frameworks such as Mockito or EasyMock used?<br>
 * <p>
 * Answer:<br>
 * Mocking frameworks are usually used to isolate unit of code being tested. This isolation is achieved by replacing
 * real collaborators with <b>dummy</b> objects. Thus it's possible to verify whether an inner method call was made or
 * not, number of such calls, returned predefined value from a collaborator's method, etc.<br>
 * Mocking frameworks successfully complement IoC pattern (utilized by Spring Framework) which supplies dependencies to
 * objects through setters or constructors, thus it's very easy to substitute those dependencies with mocks.<br>
 * <p>
 * Spring Framework provides lots of mock objects by itself, thus making it easier to test some-spring specific code in isolation
 * (mock support was briefly tested in {@link UnitTestSupport} counterpart class).<br>
 *
 * @author Valentine Shemyako
 * @since January 02, 2019
 */
public class MockingSupport {
}
