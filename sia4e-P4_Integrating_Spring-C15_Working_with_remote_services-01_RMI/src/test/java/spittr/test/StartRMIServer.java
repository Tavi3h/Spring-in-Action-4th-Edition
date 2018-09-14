package spittr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spittr.config.server.RmiServerConfig;

public class StartRMIServer {
    public static void main(String[] args) {
        @SuppressWarnings({ "resource", "unused" })
        ApplicationContext context = new AnnotationConfigApplicationContext(RmiServerConfig.class);
        System.out.println("Server Started ...");
    }
}
