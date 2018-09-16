package com.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ImportResource("classpath:com/soundsystem/config.xml")

/* Environment */
//@PropertySource("classpath:com/soundsystem/app.properties")
public class ExpressiveConfig {

/* Environment */
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public BlankDisc disc() {
//        // 使用Environment检索属性值
//        return new BlankDisc(env.getProperty("disc.title", "Rattle and Hum"), env.getProperty("disc.artist", "U2"));
//    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();

        placeholderConfigurer.setLocations(new Resource[] { new ClassPathResource("/com/soundsystem/app.properties") });

        return placeholderConfigurer;
    }
}
