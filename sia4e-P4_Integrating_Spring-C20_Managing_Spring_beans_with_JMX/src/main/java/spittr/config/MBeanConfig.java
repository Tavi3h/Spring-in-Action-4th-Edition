package spittr.config;

import java.util.HashMap;
import java.util.Map;

import javax.management.NotificationListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.support.RegistrationPolicy;

import spittr.jmx.PagingNotificationListener;
import spittr.web.SpittleController;

@Configuration
public class MBeanConfig {

    // MBean Config
    @Bean
    public MBeanExporter mbeanExporter(SpittleController spittleController,
            MBeanInfoAssembler assembler) {
        
        MBeanExporter exporter = new MBeanExporter();
        
        Map<String, Object> beans = new HashMap<>();
        beans.put("spitter:name=SpittleController", spittleController);
        exporter.setBeans(beans);
        exporter.setAssembler(assembler);
        exporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
        
        Map<String, NotificationListener> mappings = new HashMap<>();
        mappings.put("spitter:name=PagingNotificationListener", new PagingNotificationListener());
        exporter.setNotificationListenerMappings(mappings);
        return exporter;
    }
    
//    @Bean
//    public MBeanProxyFactoryBean remoteSpittleControllerMBean(MBeanServerConnection mbeanServerClient) throws MalformedObjectNameException {
//        MBeanProxyFactoryBean proxy = new MBeanProxyFactoryBean();
//        proxy.setObjectName("spitter:name=SpittleController");
//        proxy.setServer(mbeanServerClient);
//        proxy.setProxyInterface(SpittleControllerManagedOperations.class);
//        return proxy;
//    }
    
//    @Bean
//    public MBeanServerConnectionFactoryBean connectionFactoryBean() throws MalformedURLException {
//        MBeanServerConnectionFactoryBean mbscfb = new MBeanServerConnectionFactoryBean();
//        mbscfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/spitter");
//        return mbscfb;
//    }
    
//    @Bean
//    public ConnectorServerFactoryBean connectorServerFactoryBean() {
//        ConnectorServerFactoryBean csfb = new ConnectorServerFactoryBean();
//        csfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/spitter");
//        return csfb;
//    }

//    @Bean
//    public MethodNameBasedMBeanInfoAssembler assembler() {
//        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
//        assembler.setManagedMethods(new String[] { "getSpittlesPerPage", "setSpittlesPerPage" });
//        return assembler;
//    }
    
//    @Bean
//    public MethodExclusionMBeanInfoAssembler assembler() {
//        MethodExclusionMBeanInfoAssembler assembler = new MethodExclusionMBeanInfoAssembler();
//        assembler.setIgnoredMethods(new String[] { "spittles", "showSpittle" });
//        return assembler;
//    }
    
//    @Bean
//    public InterfaceBasedMBeanInfoAssembler assembler() {
//        InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();
//        assembler.setManagedInterfaces(new Class<?>[] { SpittleControllerManagedOperations.class });
//        return assembler;
//    }
}
