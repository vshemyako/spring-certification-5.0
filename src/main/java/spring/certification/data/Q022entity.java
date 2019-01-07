package spring.certification.data;

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
 *
 * @author Valentine Shemyako
 * @since January 07, 2019
 */
public class Q022entity {
}
