package spittr.config.jdbc;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class JdbcConfig {

    // 配置JDBC模板，使用JdbcTemplate
    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // 配置数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("mysql");
        return dataSource;
    }
    
    // 配置JDBC模板，使用NamedParameterJdbcTemplate
    // @Bean
    // public NamedParameterJdbcOperations namedParameterjdbcOperations(DataSource
    // dataSource) {
    // return new NamedParameterJdbcTemplate(dataSource);
    // }
}
