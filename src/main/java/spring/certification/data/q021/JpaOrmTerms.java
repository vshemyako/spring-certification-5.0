package spring.certification.data.q021;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 021:<br>
 * What does JPA stand for - what about ORM?<br>
 * What is the idea behind an ORM?<br>
 * What are benefits/disadvantages of ORM?<br>
 * <p>
 * Answer:<br>
 * <b>JPA</b> stands for Java Persistence API - it's a specification, implementation of which is supplied by different
 * third-parties.<br>
 * <b>ORM</b> stands for Object Relational Mapping - it's the approach to map relational data to object-oriented data
 * and vice versa.<br>
 * JPA is actually a specification for implementing ORM.<br>
 * <p>
 * The main idea behind <b>ORM</b> is that a programmer is still dealing with domain objects, <b>ORM</b> is also
 * SQL agnostic (e.g. JPQL).<br>
 * <p>
 * <b>Advantages of ORM</b>:<br>
 * - mapping between database records and domain objects is declarative, which leads to much less code<br>
 * - automatic management of connection acquisition and release, transaction, cache, etc.<br>
 * - concurrent<br>
 * <b>Disadvantages of ORM</b>:<br>
 * - plain SQL might be more efficient<br>
 * - overkill for simple requirements<br>
 * - requires learning<br>
 * - hard to utilize with legacy database (e.g. presence of a primary key is mandatory)<br>
 *
 * @author Valentine Shemyako
 * @since January 06, 2019
 */
public class JpaOrmTerms {
}
