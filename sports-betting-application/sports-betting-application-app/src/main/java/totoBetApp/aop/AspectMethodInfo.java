package totoBetApp.aop;

import domain.Bet;
import domain.Wager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
public class AspectMethodInfo {

    @Pointcut("execution(* totoBetApp.Toto*.*(..))")
    public void totoBetAppMethods(){}

    @Before("totoBetAppMethods()")
    public void methodParameters(JoinPoint jp){
        System.out.println("********* Aspect Method name, args *******");
        System.out.println("Method name: " + jp.getSignature().getName());
        final Object[] args = jp.getArgs();
        if (args.length > 0){
            System.out.println("Arguments: " + args);
        }
        System.out.println("*************************");
    }

    @AfterReturning(pointcut = "totoBetAppMethods()", returning = "retVal")
    public void methodReturnValue(List<Bet> retVal){
        System.out.println("^^^^^^^^^ Aspect Return Value ^^^^^^^^^^");
        System.out.println("Return value is ..." + retVal);
    }

    @AfterReturning(pointcut = "totoBetAppMethods()", returning = "retVal")
    public void methodReturnValue(Wager retVal){
        System.out.println("^^^^^^^^^ Aspect Return Value ^^^^^^^^^^");
        System.out.println("Return value: " + retVal);
    }

    @Around("totoBetAppMethods()")
    public Object execMethodTime(ProceedingJoinPoint pjp) throws Throwable{
        final long before = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            final long after = System.currentTimeMillis();
            System.out.println(pjp.getSignature().getName() + ". Exec time: " + (after - before) + " ms");
        }
    }

}
