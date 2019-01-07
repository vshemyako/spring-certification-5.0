package spring.certification.data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 022:<br>
 * What is a PersistenceContext and what is an EntityManager. What is the relationship between both?<br>
 * Why do you need the @Entity annotation. Where can it be placed?<br>
 * <p>
 * Answer:<br>
 * <b>PersistenceContext</b> is a set of cached entity instances. Within persistence context entities and their lifecycle
 * are managed. Set of entities (actually a set of related classes) is uniquely identified by a persistence unit
 * (a database).<br>
 * An <b>EntityManager</b> is essentially an API to access <b>PersistenceContext</b>. Each <b>EntityManager</b> is
 * associated with a <b>PersistenceContext</b>.<br>
 * <p>
 * {@link Entity} annotation can be applied at a <b>class-level</b> only. Only annotated class is considered to be
 * an <b>entity-class</b> (according to JPA specification) and is used to be mapped to a database record.<br>
 *
 * @author Valentine Shemyako
 * @since January 07, 2019
 */
public class Q022entitymanager {

    /**
     * An example of an entity-class. The following is required for a class to be an entity-class:<br>
     * - a class must be annotated with {@link Entity}<br>
     * - a class must have an {@link Id} field<br>
     * - a class must have a public or protected, no-argument constructor<br>
     * - a class must not be declared final<br>
     */
    @Entity
    public static class Human {
        @Id
        private long id;
        private String firstName;
        private String lastName;
    }
}
