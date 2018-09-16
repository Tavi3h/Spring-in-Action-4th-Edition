package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
    
    @Bean
    public EncoreableIntroducer introducer() {
        return new EncoreableIntroducer();
    }
    
    @Bean
    public Performance orchestral() {
        return new OrchestralPerformance();
    }
}
