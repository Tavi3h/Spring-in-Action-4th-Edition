package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
    
    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance() {}

//    // 表演之前
//    @Before("performance()")
//    public void silenceCellPhones() {
//        System.out.println("Silencing cell phones");
//    }
//
//    // 表演之前
//    @Before("performance()")
//    public void takeSeats() {
//        System.out.println("Taking seats");
//    }
//
//    // 表演之后
//    @AfterReturning("performance()")
//    public void applause() {
//        System.out.println("CLAP CLAP CLAP!!!");
//    }
//
//    // 表演失败之后
//    @AfterThrowing("performance()")
//    public void demandRefund() {
//        System.out.println("Demanding a refund");
//    }
    
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        System.out.println("Silencing cell phones");
        System.out.println("Taking seats");
        try {
            jp.proceed();
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
        System.out.println("CLAP CLAP CLAP!!!");
    }
    
}
