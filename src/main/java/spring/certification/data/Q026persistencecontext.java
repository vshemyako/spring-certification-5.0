package spring.certification.data;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 026:<br>
 * What does @PersistenceContext do?<br>
 * <p>
 * Answer:<br>
 * {@link PersistenceContext} is analogous to a well-known {@link Autowired} Spring Framework annotation, but the sole
 * purpose of it is to inject {@link EntityManager} instance. Spring Framework goes further injecting not the
 * instance itself, but a proxy which takes care of transaction management and thread-safety ({@link EntityManager}
 * instance is by definition not thread-safe).<br>
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
public class Q026persistencecontext {
}
