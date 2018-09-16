package concert;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
    
//    // 表演之前
//    public void silenceCellPhones() {
//        System.out.println("Silencing cell phones");
//    }
//
//    // 表演之前
//    public void takeSeats() {
//        System.out.println("Taking seats");
//    }
//
//    // 表演之后
//    public void applause() {
//        System.out.println("CLAP CLAP CLAP!!!");
//    }
//
//    // 表演失败之后
//    public void demandRefund() {
//        System.out.println("Demanding a refund");
//    }
    
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
