package spittr.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 启用Web安全性
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;

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
                    .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                    .anyRequest().permitAll();
                
    }  
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                "select username, password, enabled from spitter where username = ?"
            ).authoritiesByUsernameQuery(
                "select username, role from spitter where username = ?"
            ).passwordEncoder(new Pbkdf2PasswordEncoder("53cr3t"));
    }
}
