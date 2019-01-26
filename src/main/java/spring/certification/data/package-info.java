/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Table of contents:<br>
 * 1.1. What's the difference between checked and unchecked exceptions? {@link spring.certification.data.q001.ExceptionHierarchy link}<br>
 * 1.2. Why does Spring prefer unchecked exceptions? {@link spring.certification.data.q001.ExceptionHierarchy link}<br>
 * 1.3. What is the data access exception hierarchy? {@link spring.certification.data.q001.ExceptionHierarchy link}<br>
 * 2.1. How do you configure a DataSource in Spring? {@link spring.certification.data.q002.DataSourceTypes link}<br>
 * 2.2. Which bean is very useful for development/test databases? {@link spring.certification.data.q002.DataSourceTypes link}<br>
 * 3. What is the Template design pattern and what is the JDBC template? {@link spring.certification.data.q003.TemplatePattern link}<br>
 * 4.1. What is a callback? {@link spring.certification.data.q004.Callback link}<br>
 * 4.2. What are the three JdbcTemplate callback interfaces that can be used with queries? {@link spring.certification.data.q004.Callback link}<br>
 * 4.3. What each JdbcTemplate is used for? {@link spring.certification.data.q004.Callback link}<br>
 * 5. Can you execute a plain SQL statement with the JDBC template? {@link spring.certification.data.q005.PlainSql link}<br>
 * 6. When does the JDBC template acquire (and release) a connection  - for every method called or once per template? {@link spring.certification.data.q006.ConnectionAcquireStrategy link}<br>
 * 7.1. How does the JdbcTemplate support generic queries? {@link spring.certification.data.q007.JdbcGenericsSupport link}<br>
 * 7.2. How does it return objects and lists/maps of objects? {@link spring.certification.data.q007.JdbcGenericsSupport link}<br>
 * <p>
 * 8.1. What is a transaction? {@link spring.certification.data.q008.TransactionTerm link}<br>
 * 8.2. What is the difference between a local and a global transaction? {@link spring.certification.data.q008.TransactionTerm link}<br>
 * 9.1. Is a transaction a cross cutting concern? {@link spring.certification.data.q009.TransactionProxy link}<br>
 * 9.2. How is it implemented by Spring? {@link spring.certification.data.q009.TransactionProxy link}<br>
 * 10.1. How are you going to define transaction in Spring? {@link spring.certification.data.q010.EnablingTransaction link}<br>
 * 10.2. What does @Transactional do? {@link spring.certification.data.q010.EnablingTransaction link}<br>
 * 10.3. What is the PlatformTransactionManager? {@link spring.certification.data.q010.EnablingTransaction link}<br>
 * 11. Is the JDBC template able to participate in an existing transaction? {@link spring.certification.data.q011.JdbcTransaction link}<br>
 * 12.1. What is a transaction isolation level? {@link spring.certification.data.q012.IsolationLevels link}<br>
 * 12.2. How many transaction isolation levels do we have and how are they ordered? {@link spring.certification.data.q012.IsolationLevels link}<br>
 * 13. What is @EnableTransactionManagement for? {@link spring.certification.data.q013.EnablingTransactionFunctionality link}<br>
 * 14. What does transaction propagation mean? {@link spring.certification.data.Q014propagation link}<br>
 * 15. What happens if one @Transactional annotated method is calling another @Transactional annotated method on the
 * same object instance? {@link spring.certification.data.Q015innercall link}<br>
 * 16.1. Where can the @Transactional annotation be used? {@link spring.certification.data.Q016transactional link}<br>
 * 16.2. What is a typical usage if you put it at class level? {@link spring.certification.data.Q016transactional link}<br>
 * 17. What does declarative transaction management mean? {@link spring.certification.data.Q017declarative link}<br>
 * 18. What is the default rollback policy? How can you override it? {@link spring.certification.data.Q018rollbackpolicy link}<br>
 * 19. What is the default rollback policy in a JUnit test, when you use the @RunWith(SpringJUnit4ClassRunner.class) in
 * JUnit 4 or @ExtendWith(SpringExtension.class) in JUnit 5, and annotate your @Test annotated method with @Transactional?{@link spring.certification.data.Q019testrollbackpolicy link}<br>
 * 20. Why is the term "unit of work" so important and why does JDBC AutoCommit violate this pattern? {@link spring.certification.data.Q020autocommit link}<br>
 * <p>
 * 21.1. What does JPA stand for - what about ORM? {@link spring.certification.data.Q021jpa link}<br>
 * 21.2. What is the idea behind an ORM? {@link spring.certification.data.Q021jpa link}<br>
 * 21.3. What are benefits/disadvantages or ORM? {@link spring.certification.data.Q021jpa link}<br>
 * 22.1. What is a PersistenceContext and what is an EntityManager. What is the relationship between both? {@link spring.certification.data.Q022entitymanager link}<br>
 * 22.2. Why do you need the @Entity annotation. Where can it be placed? {@link spring.certification.data.Q022entitymanager link}<br>
 * 23. What do you need to do in Spring if you would like to work with JPA? {@link spring.certification.data.Q023entitymanagerfactory link}<br>
 * 24. Are you able to participate in a given transaction in Spring while working with JPA? {@link spring.certification.data.Q024transactionparticipation link}<br>
 * 25. Which PlatformTransactionManager(s) can you use with JPA? {@link spring.certification.data.Q025jpatransaction link}<br>
 * 26. What does @PersistenceContext do? {@link spring.certification.data.Q026persistencecontext link}<br>
 * 27.1. What do you have to configure to use JPA with Spring? {@link spring.certification.data.Q027springbootjpaconfig link}<br>
 * 27.2. How does Spring Boot make this easier? {@link spring.certification.data.Q027springbootjpaconfig link}<br>
 * <p>
 * 28. What is an "instant repository"? (hint: recall Spring Data) {@link spring.certification.data.Q028instantrepository link}<br>
 * 29.1. How do you define an “instant” repository? {@link spring.certification.data.Q029instantrepositoryconfig link}<br>
 * 29.2. Why is it an interface not a class? {@link spring.certification.data.Q029instantrepositoryconfig link}<br>
 * 30. What is the naming convention for finder methods? {@link spring.certification.data.Q030findermethods link}<br>
 * 31. How are Spring Data repositories implemented by Spring at runtime? {@link spring.certification.data.Q031runtimegeneration link}<br>
 * 32. What is @Query used for? {@link spring.certification.data.Q032query link}<br>
 *
 * @author Valentine Shemyako
 * @since December 15, 2018
 */
package spring.certification.data;