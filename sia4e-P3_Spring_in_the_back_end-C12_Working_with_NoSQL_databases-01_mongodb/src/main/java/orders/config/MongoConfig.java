package orders.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("orders.db") // 启用MongoDB的Repository功能
public class MongoConfig extends AbstractMongoConfiguration {

    // 指定数据库的名字
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }

    // 创建Mongo客户端
    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }
    
} 
