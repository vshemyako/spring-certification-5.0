package spring.certification.data.q016;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.PlatformTransactionManager;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;

/**
 * Verifies method visibility required by {@link PlatformTransactionManager} to manage a transaction.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {GreetingMessageGenerator.class, EmbeddedDBConfiguration.class})
public class TransactionalAnnotationTest {

    @Autowired
    private GreetingMessageGenerator messageGenerator;

    @Test
    public void shouldManageTransactionForPublicMethod() {
        messageGenerator.generateGreet();
    }

    @Test(expected = NoTransactionException.class)
    public void shouldNotManageTransactionForProtectedMethod() {
        messageGenerator.generateWelcome();
    }

    @Test(expected = NoTransactionException.class)
    public void shouldNotManageTransactionForPackagePrivateMethod() {
        messageGenerator.generateSalute();
    }
}