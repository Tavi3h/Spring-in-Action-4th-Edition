package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
    
    @Bean
    public CDPlayer cdPlayer(@Autowired @Qualifier("sgtPeppers") CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
