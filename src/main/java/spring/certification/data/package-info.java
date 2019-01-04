/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Table of contents:<br>
 * 1.1. What's the difference between checked and unchecked exceptions? {@link spring.certification.data.Q001exception link}<br>
 * 1.2. Why does Spring prefer unchecked exceptions? {@link spring.certification.data.Q001exception link}<br>
 * 1.3. What is the data access exception hierarchy? {@link spring.certification.data.Q001exception link}<br>
 * 2.1. How do you configure a DataSource in Spring? {@link spring.certification.data.Q002datasource link}<br>
 * 2.2. Which bean is very useful for development/test databases? {@link spring.certification.data.Q002datasource link}<br>
 * 3. What is the Template design pattern and what is the JDBC template? {@link spring.certification.data.Q003template link}<br>
 * 4.1. What is a callback? {@link spring.certification.data.Q004callback link}<br>
 * 4.2. What are the three JdbcTemplate callback interfaces that can be used with queries? {@link spring.certification.data.Q004callback link}<br>
 * 4.3. What each JdbcTemplate is used for? {@link spring.certification.data.Q004callback link}<br>
 * 5. Can you execute a plain SQL statement with the JDBC template? {@link spring.certification.data.Q005sql link}<br>
 * 6. When does the JDBC template acquire (and release) a connection  - for every method called or once per template?
 * {@link spring.certification.data.Q006connection link}<br>
 * 7.1. How does the JdbcTemplate support generic queries? {@link spring.certification.data.Q007generics link}<br>
 * 7.2. How does it return objects and lists/maps of objects? {@link spring.certification.data.Q007generics link}<br>
 * <p>
 * 8.1. What is a transaction? {@link spring.certification.data.Q008transaction link}<br>
 * 8.2. What is the difference between a local and a global transaction? {@link spring.certification.data.Q008transaction link}<br>
 * 9.1. Is a transaction a cross cutting concern? {@link spring.certification.data.Q009implementation link}<br>
 * 9.2. How is it implemented by Spring? {@link spring.certification.data.Q009implementation link}<br>
 * 10.1. How are you going to define transaction in Spring?<br>
 * 10.2. What does @Transactional do?<br>
 * 10.3. What is the PlatformTransactionManager?<br>
 * 11. Is the JDBC template able to participate in an existing transaction?<br>
 * 12.1. What is a transaction isolation level? {@link spring.certification.data.Q012isolation link}<br>
 * 12.2. How many transaction isolation levels do we have and how are they ordered? {@link spring.certification.data.Q012isolation link}<br>
 * 13. What is @EnableTransactionManagement for?<br>
 * 14. What does transaction propagation mean?<br>
 * 15. What happens if one @Transactional annotated method is calling another @Transactional annotated method on the
 * same object instance?<br>
 * 16.1. Where can the @Transactional annotation be used?<br>
 * 16.2. What is a typical usage if you put it at class level?<br>
 * 17. What does declarative transaction management mean?<br>
 * 18. What is the default rollback policy? How can you override it?<br>
 * 19. What is the default rollback policy in a JUnit test, when you use the @RunWith(SpringJUnit4ClassRunner.class) in
 * JUnit 4 or @ExtendWith(SpringExtension.class) in JUnit 5, and annotate your @Test annotated method with @Transactional?
 * {@link spring.certification.data.Q019testrollbackpolicy link}<br>
 * 20. Why is the term "unit of work" so important and why does JDBC AutoCommit violate this pattern?
 * {@link spring.certification.data.Q020autocommit link}<br>
 * <p>
 * 21.1. What does JPA stand for - what about ORM?<br>
 * 21.2. What is the idea behind an ORM?<br>
 * 21.3. What are benefits/disadvantages or ORM?<br>
 * 21.4. What is a PersistenceContext and what is an EntityManager. What is the relationship between both?<br>
 * 21.5. Why do you need the @Entity annotation. Where can it be placed?<br>
 * 22. What do you need to do in Spring if you would like to work with JPA?<br>
 * 23. Are you able to participate in a given transaction in Spring while working with JPA?<br>
 * 24. Which PlatformTransactionManager(s) can you use with JPA?<br>
 * 25. What does @PersistenceContext do?<br>
 * 26. What do you have to configure to use JPA with Spring? How does Spring Boot make this easier?<br>
 * <p>
 * 27. What is an "instant repository"? (hint: recall Spring Data)<br>
 * 28.1. How do you define an “instant” repository?<br>
 * 28.2. Why is it an interface not a class?<br>
 * 29. What is the naming convention for finder methods?<br>
 * 30. How are Spring Data repositories implemented by Spring at runtime?<br>
 * 31. What is @Query used for?<br>
 *
 * @author Valentine Shemyako
 * @since December 15, 2018
 */
package spring.certification.data;