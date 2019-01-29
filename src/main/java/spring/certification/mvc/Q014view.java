package spring.certification.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 014:<br>
 * What is a View and what's the idea behind supporting different types of View?<br>
 * <p>
 * Answer:<br>
 * <b>View</b> is a model information displayed to a user in the desired format.<br>
 * The main idea behind Mvc pattern is to decouple it elements from each other, thus
 * allowing to easily change or substitute implementation details. More specifically,
 * {@link Model} element knows nothing about {@link View} and therefore might be rendered
 * or displayed in any desired format (desktop, mobile devices, printed pages, etc.).
 * {@link View} changes do not lead to modifications of {@link Controller controllers} or
 * {@link Model models} code - thus leading to high extensibility.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Q014view {
}
