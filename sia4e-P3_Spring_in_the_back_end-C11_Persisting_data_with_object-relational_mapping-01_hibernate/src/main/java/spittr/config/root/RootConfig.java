package spittr.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spittr.config.hibernate.HibernateConfig;
import spittr.config.security.SecurityConfig;

@Configuration
@ComponentScan(basePackages = { "spittr" }, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@Import({ HibernateConfig.class, SecurityConfig.class })
public class RootConfig {

}
