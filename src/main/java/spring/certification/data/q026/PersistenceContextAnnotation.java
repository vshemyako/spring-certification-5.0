package spring.certification.data.q026;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;

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
 * <p>
 * As another option {@link PersistenceUnit} might be used to inject {@link EntityManagerFactory} instance for obtaining {@link EntityManager}.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
public class PersistenceContextAnnotation {
}
