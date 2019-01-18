package spring.certification.security;

import javax.servlet.Filter;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 002:<br>
 * Is security a cross cutting concern?<br>
 * How is it implemented internally?<br>
 * <p>
 * Answer:<br>
 * Security concern pertains to lots of layers of an application and therefore is considered to be a cross-cutting.
 * Those cross-cutting concerns where discussed in the {@linkplain spring.certification.aop.Q001concepts AOP section}.<br>
 * <p>
 * Depending on what is secured Spring Security framework internals differ:<br>
 * 1. Method invocation is declarative and is implemented using AOP proxies (proxy object wraps secured one and applies
 * implemented advices at particular join-points).<br>
 * 2. Web-layer security is implemented using hierarchy of {@link Filter} instances.<br>
 * <p>
 * Web-layer filter security hierarchy is the following:<br>
 * Single instance of {@link DelegatingFilterProxy} is installed into the servlet container's filter chain.
 * This filter is <b>not</b> a Spring bean, its lifecycle is managed by servlet container. Usually this filter
 * is created by Spring Security framework itself.<br>
 * {@link DelegatingFilterProxy} delegates filtering functionality to a single instance of {@link FilterChainProxy} which <b>is</b>
 * a Spring bean, thus lifecycle of it is managed by {@link ApplicationContext}. {@link FilterChainProxy} holds a list of
 * {@link SecurityFilterChain security filter chains} which contain all security logic.
 * Only <b>one</b> security filter chain can process a single web-request.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q002implementation {
}
