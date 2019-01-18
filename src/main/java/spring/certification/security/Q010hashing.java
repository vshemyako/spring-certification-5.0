package spring.certification.security;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 010:<br>
 * Does Spring Security support password hashing?<br>
 * What is salting?<br>
 * <p>
 * Answer:<br>
 * Important terms:<br>
 * <b>Hash function</b> is a function which can be used to map data of arbitrary size to data of fixed size.<br>
 * <b>Cryptographic hash function</b> is a one-way hash function. The only way to recreate input data in an ideal
 * hash function is a brute-force search.<br>
 * <b>Salt</b> is an additional random data which is passed along with a password to a one-way hash function.<br>
 * <p>
 * Nowadays passwords are not stored in a database as a plain-text strings, but instead are stored in a hashed form.
 * Spring Security framework supports password hashing through a {@link PasswordEncoder} interface. More specifically
 * Spring Security documentation recommends to utilize {@link DelegatingPasswordEncoder} implementation which,
 * depending on encoded password prefix, delegates to concrete {@link PasswordEncoder} implementation. Reference
 * implementation of a {@link DelegatingPasswordEncoder} is offered by {@link PasswordEncoderFactories}.<br>
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class Q010hashing {
}
