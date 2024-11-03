package tn.esprit.spring.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class CnfigAOP {


    // if exception :
    @AfterThrowing("execution(* tn.esprit.spring.services.*.*(..))")
    public void logMethodExcpetion(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Exception occured in method : " + name);
    }

    @Before("execution(* tn.esprit.spring.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }


    @After("execution(* tn.esprit.spring.services.*.*(..))")
    public void logMethodOut(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out method " + name + " : ");
    }

    @Around("execution(* tn.esprit.spring.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable
    {
        long start= System.currentTimeMillis();

        Object obj= pjp.proceed();

        long elapsedTime= System.currentTimeMillis() -start;

        log.info("Methodexecutiontime: " + elapsedTime+ " milliseconds.");
        return obj;
    }

}
