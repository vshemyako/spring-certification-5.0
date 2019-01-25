package spring.certification.data.q001;

import org.springframework.dao.DataAccessException;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * What's the difference between checked and unchecked exceptions?<br>
 * Why does Spring prefer unchecked exceptions?<br>
 * What is the data access exception hierarchy?<br>
 * <p>
 * Answer:<br>
 * All exceptions in Java application are <b>checked</b> exceptions, except those, which are subclasses of
 * {@link RuntimeException} or {@link Error} classes. {@link RuntimeException} and {@link Error} exceptions are known as
 * <b>unchecked</b> exceptions.<br>
 * Blocks of code which may throw a checked exception have to be wrapped in a <b>try-catch</b> blocks or declare in their
 * method signature that this code block by itself might throw such an exception. Well-written application should
 * anticipate such exceptions and recover from them.<br>
 * <p>
 * On the contrary unchecked exceptions are those exceptions which either designate some fatal error which isn't related
 * to the code being executed or designate programming bugs. Those kinds of exceptions usually cannot be anticipated, and
 * there's little a program can do with them at runtime.<br>
 * <p>
 * Very often (even in JDK) checked exceptions are used in cases where little can be done in case such an exception is thrown.
 * As a consequence client's code is scattered with catch blocks which do not do anything useful. JDBC native library is a
 * good example where such exceptions were used inappropriately.<b>
 * Therefore Spring framework prefers unchecked exceptions which do not clutter client's code and, if needed, can also
 * be caught and handled appropriately.<br>
 * <p>
 * {@link DataAccessException} hierarchy has been introduced with two main reasons in mind:<br>
 * 1. It offers technology agnostic hierarchy of exceptions.<br>
 * 2. It wraps checked exceptions with unchecked counterparts, which are not required to be caught and, in comparison
 * to JDBC, are more descriptive and vast.<br>
 *
 * @author Valentine Shemyako
 * @since December 15, 2018
 */
public class ExceptionHierarchy {
}
