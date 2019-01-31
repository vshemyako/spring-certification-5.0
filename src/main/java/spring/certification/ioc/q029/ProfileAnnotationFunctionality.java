package spring.certification.ioc.q029;

import org.springframework.context.annotation.Profile;
import spring.certification.ioc.q029.example.DevelopmentConfiguration;
import spring.certification.ioc.q029.example.LeadDeveloperProductionConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 029:<br>
 * How do you configure profiles?<br>
 * What are possible use cases where they might be useful?<br>
 * <p>
 * Answer:<br>
 * Profile is a named state of application which instructs Spring about beans that should be managed by IoC
 * container. It's possible to configure profiles using <b>xml files</b> or <b>java annotations</b>. Annotation-based
 * profile configuration is build upon {@link Profile} annotation.<br>
 * Application use cases:<br>
 * 1. Different application environments: development, testing, production. Each of those may require different beans
 * (e.g. datasource objects).<br>
 * 2. Performance measurement (isn't required when application has been already deployed on production system).<br>
 * 3. Different application behavior which depends on user/client type.<br>
 * <p>
 * Additional note:<br>
 * It also possible to control active / default profiles using Spring properties:<br>
 * - spring.profiles.active - to specify active profile (comma separated values for multiple profiles)<br>
 * - spring.profiles.default - default profile if none is active<br>
 *
 * Examples of mentioned terms:<br>
 * {@link DevelopmentConfiguration}, {@link LeadDeveloperProductionConfiguration} - demonstrates usage of {@link Profile} annotation.
 *
 * @author Valentine Shemyako
 * @since November 18, 2018
 */
public class ProfileAnnotationFunctionality {
}
