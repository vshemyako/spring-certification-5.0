package spring.certification.data.q016;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Simple class to verify required method visibility for transaction to be managed.
 */
@Service
public class GreetingMessageGenerator {

    @Transactional
    public String generateGreet() {
        TransactionAspectSupport.currentTransactionStatus();
        return "Greet";
    }

    @Transactional
    protected String generateWelcome() {
        TransactionAspectSupport.currentTransactionStatus();
        return "Welcome";
    }

    @Transactional
    String generateSalute() {
        TransactionAspectSupport.currentTransactionStatus();
        return "Salute";
    }
}
