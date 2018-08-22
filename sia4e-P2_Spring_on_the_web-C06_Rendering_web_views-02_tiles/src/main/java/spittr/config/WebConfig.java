package spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration // 表明该类是一个配置类
@EnableWebMvc // 启用Spring MVC
@ComponentScan("spittr.web") // 启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    // 配置Tiles视图解析器
    @Bean
    public ViewResolver viewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        return tilesViewResolver;
    }

    // 配置TilesConfigurer来解析Tile定义
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        // 指定Tile定义的位置
        tiles.setDefinitions(new String[] { "/WEB-INF/layout/tiles.xml" });
        // 启用刷新功能
        tiles.setCheckRefresh(true);
        return tiles;
    }

    // 配置信息源
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    // 配置静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
