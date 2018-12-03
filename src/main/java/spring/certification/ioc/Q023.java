package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 023:<br>
 * How does the @Qualifier annotation complement the use of @Autowired?<br>
 * <p>
 * Answer:<br>
 * As a fallback {@link Autowired} annotation uses target bean names in case single type matching bean
 * cannot be chosen. {@link Qualifier} annotation offers even more control over bean selection process.
 * But fundamentally this 'qualified' selection is still within type matching beans.<br>
 * <p>
 * The most common usages of {@link Qualifier} annotation are the following:<br>
 * 1. Explicitly specify target bean name, which, by default, will match all the same.<br>
 * 2. Utilize the same {@link Qualifier} annotations (with same values) at the bean definitions and injection points.<br>
 * 3. Define your custom annotation and use it at the bean definition level and at the injection point level.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q012.QualifiedConfiguration} - demonstrates usage of custom annotation defined both at bean definition level
 * and at the injection point level<br>
 *
 * @author Valentine Shemyako
 * @since November 30, 2018
 */
public class Q023 {
}
