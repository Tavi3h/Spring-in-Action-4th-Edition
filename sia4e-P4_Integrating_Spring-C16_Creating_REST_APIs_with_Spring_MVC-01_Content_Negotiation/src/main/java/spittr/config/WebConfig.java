package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration // 表明该类是一个配置类
@EnableWebMvc // 启用Spring MVC
@ComponentScan("spittr.web") // 启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    // 配置Thymeleaf视图解析器
    @Bean
    public ViewResolver viewResolver(TemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    // 配置模板引擎
    @Bean
    public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    // 配置模板解析器
    @Bean
    public ITemplateResolver templateResolver() {

        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
                webApplicationContext.getServletContext());

        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    // 配置静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置content-negotiation
    @Configuration
    public static class ContentNegotiationConfig extends WebMvcConfigurerAdapter {

        @Bean
        public ViewResolver cnViewResolver(ContentNegotiationManager manager) {
            ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
            cnvr.setContentNegotiationManager(manager);
            return cnvr;
        }

        // 默认为HTML
        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.defaultContentType(MediaType.TEXT_HTML);
        }

        // 以bean的形式查找视图
        @Bean
        public ViewResolver beanNameViewResolver() {
            return new BeanNameViewResolver();
        }

        // 将spittles定义为JSON视图
        @Bean
        public View spittles() {
            return new MappingJackson2JsonView();
        }
    }
}
