package spittr.config.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import spittr.service.SpitterService;

@Configuration
public class RmiClientConfig {
    @Bean
    public RmiProxyFactoryBean rmiProxy() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost/SpitterService");
        rmiProxy.setServiceInterface(SpitterService.class);
        return rmiProxy;
    }
}
