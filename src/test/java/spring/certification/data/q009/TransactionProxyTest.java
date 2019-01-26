package spring.certification.data.q009;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.q009.example.TransactionalConfiguration;
import spring.certification.data.q009.example.TransactionalSqlExecutor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.aop.support.AopUtils.isAopProxy;

/**
 * Verifies that transactional functionality is indeed implemented using dynamically created proxies.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EmbeddedDBConfiguration.class, TransactionalConfiguration.class})
public class TransactionProxyTest {

    @Autowired
    private TransactionalSqlExecutor sqlExecutor;

    @Test
    public void shouldBeProxyWrapped() {
        assertThat(isAopProxy(sqlExecutor));
    }
}