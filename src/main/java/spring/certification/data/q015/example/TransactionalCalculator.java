package spring.certification.data.q015.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Simplistic calculator to verify inner method calls in regard of transaction functionality.
 */
@Getter
@Setter
@Service
public class TransactionalCalculator {

    private List<TransactionStatus> statuses = new ArrayList<>();
    private boolean enableTransactionVerification;
    /**
     * Hack to imitate outer call.
     */
    @Autowired
    private TransactionalCalculator calculator;

    @Transactional
    public long multiplyByInnerCall(long left, long right) {
        return multiply(left, right, false);
    }

    @Transactional
    public long multiplyByOuterCall(long left, long right) {
        return multiply(left, right, true);
    }

    private long multiply(long left, long right, boolean imitateOuterCall) {
        if (enableTransactionVerification) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            statuses.add(status);
        }

        long result = 0;
        long positiveRight = Math.abs(right);
        for (int index = 0; index < positiveRight; index++) {
            if (imitateOuterCall) {
                result += calculator.sum(left, left);
            } else
                result += sum(left, left);
        }
        return result;
    }

    @Transactional
    public long sum(long left, long right) {
        if (enableTransactionVerification) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            statuses.add(status);
        }

        return left + right;
    }
}
