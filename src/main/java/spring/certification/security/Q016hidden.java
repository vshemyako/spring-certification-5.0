package spring.certification.security;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 016:<br>
 * Is it enough to hide sections of my output (e.g. JSP-Page or Mustache template)?<br>
 * <p>
 * Answer:<br>
 * It's important to remember that hidden link doesn't actually prevent a user from accessing a resource.
 * For testing scenario (to verify that all hidden links are also protected on the back-end side) Spring
 * introduced {@code spring.security.disableUISecurity} property. In case this property value is set to {@code true},
 * the {@code authorize} tags will not be hidden.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q016hidden {
}
