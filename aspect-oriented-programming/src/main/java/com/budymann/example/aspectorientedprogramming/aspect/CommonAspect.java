package com.budymann.example.aspectorientedprogramming.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Aspect
@Service
public class CommonAspect {
    private Logger logger = Logger.getLogger(CommonAspect.class.getName());

//    @Pointcut("execution(* com.budymann.example.aspectorientedprogramming.service.*.*(..))")
//    public void allSetters(){
//
//    }
//
//    @Around("allSetters()")
//    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
//        String methodName = thisJoinPoint.getSignature().getName();
//        Object[] methodArgs = thisJoinPoint.getArgs();
//        logger.severe("Call method " + methodName + " with arg " + methodArgs[0]);
//        Object result = thisJoinPoint.proceed();
//        logger.severe(("Method " + methodName + " returns " + result));
//        return result;
//    }

    @Around("@annotation(com.budymann.example.aspectorientedprogramming.aspect.Retry)")
    public Object retry (ProceedingJoinPoint thisJoinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) thisJoinPoint.getSignature();
        var method = signature.getMethod();
        var retryAnnotation = method.getAnnotation(Retry.class);

        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();
        logger.info("Call method " + methodName + " with arg " + methodArgs[0]);
        Object result = thisJoinPoint.proceed();
        logger.info("Method " + methodName + " returns " + result);
        return result;
    }

//    @DeclareParents(value="com.pluralsight.springaop.flightsmanagement.domain.Flight",
//            defaultImpl= FlyerImpl.class)
//    private Flyer flight;

//
//    @Before("execution(public String com.pluralsight.springaop.flightsmanagement.domain.Flight.getId())")
//    public void loggingAdviceGetId(){
//        logger.info("Flight getId method will be called");
//    }
//
//    @AfterReturning("execution(public * *.print())")
//    public void loggingAdvicePrint(){
//        logger.warning("A print method has been called");
//    }
//
//    @Pointcut("within(com.pluralsight.springaop.flightsmanagement.domain.Ticket)")
//    public void allTicketMethods(){
//
//    }
//
//    @After("allTicketMethods()")
//    public void loggingAdvice(JoinPoint jointPoint){
//        logger.info("A ticket method had been called.");
//        logger.info(jointPoint.toString());
//        logger.info("KEK" + jointPoint.getTarget().toString());
//    }
}
