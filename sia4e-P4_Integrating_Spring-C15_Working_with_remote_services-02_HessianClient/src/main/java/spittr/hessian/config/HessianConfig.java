package spittr.hessian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import spittr.service.SpitterService;

@Configuration
public class HessianConfig {
    @Bean
    public HessianProxyFactoryBean spitterService(){
        HessianProxyFactoryBean proxyFactoryBean = new HessianProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("http://localhost:8080/sia4e-P4_Integrating_Spring-C15_Working_with_remote_services-02_HessianServer/spitter.service");
        proxyFactoryBean.setServiceInterface(SpitterService.class);
        return proxyFactoryBean;
    }
}
