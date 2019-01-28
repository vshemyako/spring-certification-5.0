package spring.certification.data.q004;

import spring.certification.data.q004.example.CallbackExample;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * What is a callback?<br>
 * What are the three JdbcTemplate callback interfaces that can be used with queries?<br>
 * What each JdbcTemplate is used for?<br>
 * <p>
 * Answer:<br>
 * <b>Callback</b> is a function 'A' which is provided as an argument to a function 'B' and is allowed to be called by
 * the function 'B'.<br>
 * <b>Main JdbcTemplate callbacks:</b><br>
 * - {@link org.springframework.jdbc.core.CallableStatementCreator} - is used for executing stored procedures<br>
 * - {@link org.springframework.jdbc.core.PreparedStatementCreator} - is used for repeatable executing of pre-compiled
 * SQL statements<br>
 * - {@link org.springframework.jdbc.core.RowCallbackHandler} - is used for mapping ResultSet results on one-row basis<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link CallbackExample} - demonstrates a basic usage of callback function.<br>
 *
 * @author Valentine Shemyako
 * @since December 21, 2018
 */
public class Callback {
}
