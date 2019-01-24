package spring.certification.aop.q006.example.people;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * A person with big soul.
 */
@Aspect
@Component
public class GenerousMan {

    @After("execution(* askForMoney(..))")
    public void shareMoney() {
        System.out.println("Take my hand and we'll make it I swear");
    }
}
