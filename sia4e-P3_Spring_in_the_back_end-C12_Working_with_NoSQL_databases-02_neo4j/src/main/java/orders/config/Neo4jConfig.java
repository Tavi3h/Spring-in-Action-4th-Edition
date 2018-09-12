package orders.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("orders.db")
@EnableTransactionManagement
public class Neo4jConfig {
    
    // 注册SessionFactory，指定我们的domain所在包
    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "orders");
    }

    // 配置Neo4j事务管理器
    @Bean
    public Neo4jTransactionManager transactionManager(SessionFactory sessionFactory) throws Exception {
        return new Neo4jTransactionManager(sessionFactory);
    }

    // 配置链接数据库的uri以及用户名和密码
    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new org.neo4j.ogm.config.Configuration.Builder().uri("bolt://localhost").credentials("neo4j", "myNeo4j").build();
    }
}
