package soundsystem;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {

    @Bean("sgtPeppers")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }
}
