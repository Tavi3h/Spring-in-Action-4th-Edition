package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import spittr.service.SpitterService;

@Configuration
public class HttpInvokerConfig {

    @Bean
    public HttpInvokerProxyFactoryBean spitterService() {
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/sia4e-P4_Integrating_Spring-C15_Working_with_remote_services-03_HttpInvokerServer/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }
    
}
