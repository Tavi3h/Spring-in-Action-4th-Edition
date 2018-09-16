package spittr.config.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import spittr.service.SpitterService;
import spittr.service.impl.SpitterServiceImpl;

@Configuration
public class RmiServerConfig {
    
    @Bean
    public RmiServiceExporter rmiExporter(SpitterService spitterService) {
        RmiServiceExporter rmiExporter = new RmiServiceExporter();
        rmiExporter.setService(spitterService);
        rmiExporter.setServiceName("SpitterService");
        rmiExporter.setServiceInterface(SpitterService.class);
        return rmiExporter;
    }
    
    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }
}