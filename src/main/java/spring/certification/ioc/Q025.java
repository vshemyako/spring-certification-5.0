package spring.certification.ioc;

import org.springframework.context.annotation.Bean;
import spring.certification.ioc.q010.DependencyInjectionJavaConfig;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 025:<br>
 * What are the advantages of Java Config? What are the limitations?<br>
 * <p>
 * Answer:<br>
 * Java Config advantages are the following:<br>
 * 1. It's more powerful comparing to xml-based explicit configuration, because body of a {@link Bean} factory method
 * can utilize any java code is necessary to ultimately produce an object. Thus limitations of such approach are only
 * limited by the Java language itself.<br>
 * 2. It's type safe.<br>
 * 3. It's refactor friendly.<br>
 * 4. Summing everything up: it's just plain java code - doesn't require knowledge of another technologies.<br>
 * <p>
 * Java Config limitations and drawbacks are the following:<br>
 * 1. Configuration code is just java plain code which is included in packaged jar / war file, therefore recompiling
 * is required in case of configuration changes.<br>
 * 2. It's not easy to quickly determine what bean definition declaration has been used in autowiring in case several
 * configuration classes are used (unless specific software is used (e.g. Spring Tool Suite).
 * <p>
 * Examples of mentioned terms:<br>
 * {@link DependencyInjectionJavaConfig} - shows simplistic java-based configuration
 *
 * @author Valentine Shemyako
 * @since November 13, 2018
 */
public class Q025 {
}
