package spring.certification.data.q030;

import org.springframework.data.repository.query.parser.PartTree;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 030:<br>
 * What is the naming convention for finder methods?<br>
 * <p>
 * Answer:<br>
 * The build-in parsing mechanism strips out prefixes like 'find...By', 'read...By', 'query...By', 'count..By',
 * 'get...By', etc. (look at {@link PartTree} for more variants):<br>
 * - {@code T readByName(String name)}<br>
 * - {@code T queryByName(String name)}<br>
 * One of those prefixes is mandatory to start a finder method.<br>
 * <p>
 * Additionally it's possible to specify number of fetched entities using 'First' or 'Top' keywords, optionally
 * following by the desired number:<br>
 * - {@code List<T> readTop2By()}<br>
 * <p>
 * After first 'By' keyword any number of additional search filters might be applied. Those search filters should be
 * delimited by 'Or' or 'And' keywords:<br>
 * - {@code List<T> readByNameOrName(String name, String otherName)}<br>
 *
 * @author Valentine Shemyako
 * @since January 09, 2019
 */
public class FinderMethods {
}
