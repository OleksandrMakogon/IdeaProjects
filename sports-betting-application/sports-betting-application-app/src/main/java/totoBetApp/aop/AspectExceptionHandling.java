package totoBetApp.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.WeakHashMap;

@Aspect
@Component
//Aspect to handle DataBaseException, if it throws, email sent to dedicated group
//weak map required to send email once for one exception
public class AspectExceptionHandling {
    @Value("${dbaMails}")
    private String[] mails;

    private Map<DataBaseException, Integer> cache = new WeakHashMap<>();

    @Pointcut("execution(* totoBetApp.Toto*.*(..))")
    public void totoBetAppMethods(){}

    @AfterThrowing(pointcut = "totoBetAppMethods()", throwing = "ex")
    public void handleDBException(DataBaseException ex){
        System.out.println("**** handleDBException Aspect Start *****");
        if (cache.containsKey(ex)){
            System.out.println("Email is already sent for this exception.");
        }
        else {
            cache.put(ex, 1);
            for (String mail : mails) {
                System.out.println("**** Sending email to " + mail + ". " + ex.getMessage());
            }
        }
        System.out.println("******  handleDBException Aspect End ***********");
    }

}
