package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 启用Web安全性
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
            .and()
                .logout()
                    // 设置使用GET方法进行logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .logoutSuccessUrl("/")
            .and()
                .httpBasic()
                    .realmName("Spittr")
            .and()
                .authorizeRequests()
                    .antMatchers("/spitter/**").authenticated()
                    .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                    .anyRequest().permitAll();
                
    }  
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
        .inMemoryAuthentication()
          .withUser("tavish").password("tavish").roles("USER");
    }
}
