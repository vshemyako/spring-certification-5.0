package spring.certification.aop;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * What is the concept of AOP?<br>
 * What problems does AOP solve?<br>
 * What is cross cutting concern?<br>
 * Name three typical cross cutting concerns.<br>
 * What two problems arise if you don't solve a cross cutting concern via AOP?<br>
 * <p>
 * Answer:<br>
 * <b>Concept of AOP:</b><br>
 * Concept of Aspect Oriented Programming is to move secondary functionality (also known as <b>cross cutting concern</b>
 * or <b>system-wide concern</b>), which is scattered all over the code, to a single separate module or class. Examples
 * of such secondary functionality are: logging, transaction management, security, etc. This functionality is not
 * central, it's just surrounds main business logic (<b>core concern</b>). In AOP terminology that separate module or
 * class is called an <b>aspect</b>.
 * <p>
 * <b>Solved problems:</b><br>
 * 1. Code duplication decreases.<br>
 * 2. Business logic code is not scattered with non-related secondary functionality code (e.g. transaction management)<br>
 * <p>
 * <b>Cross cutting concern:</b><br>
 * Functionality which is duplicated in different modules of an application, but which is not directly related to
 * business logic (e.g. logging).<br>
 * <p>
 * <b>Typical cross-cutting concerns:</b><br>
 * - logging<br>
 * - caching<br>
 * - security<br>
 * - transaction management<br>
 * - application monitoring<br>
 * <p>
 * <b>Problems without AOP</b>:<br>
 * 1. Business and non-business logic is mixed. Code is harder to maintain and understand.<br>
 * 2. Code duplication, which otherwise could be moved to a separate class or package.<br>
 *
 * @author Valentine Shemyako
 * @since December 03, 2018
 */
public class Q001 {
}
