package spring.certification.data.q015.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TransactionalCalculator.class, EmbeddedDBConfiguration.class})
public class TransactionalCalculatorTest {

    @Autowired
    private TransactionalCalculator calculator;

    @Test
    public void innerCallShouldNotBeIntercepted() {
        calculator.setEnableTransactionVerification(true);
        calculator.multiplyByInnerCall(2, 1);
        List<TransactionStatus> statuses = calculator.getStatuses();

        TransactionStatus firstStatus = statuses.get(0);
        TransactionStatus secondStatus = statuses.get(1);
        assertThat(firstStatus).isSameAs(secondStatus);
    }

    @Test
    public void outerCallShouldBeIntercepted() {
        calculator.setEnableTransactionVerification(true);
        calculator.multiplyByOuterCall(2, 1);
        List<TransactionStatus> statuses = calculator.getStatuses();

        TransactionStatus firstStatus = statuses.get(0);
        TransactionStatus secondStatus = statuses.get(1);
        assertThat(firstStatus).isNotSameAs(secondStatus);
    }
}