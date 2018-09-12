package orders.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import orders.Product;

@Configuration
public class RedisConfig {
    
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        // 设置主机名
        rsc.setHostName("localhost");
        // 设置密码
        rsc.setPassword(RedisPassword.of("myredis"));
        // 设置端口号
        rsc.setPort(6379);
        return new JedisConnectionFactory(rsc);
    }
    
    @Bean
    public RedisOperations<String, Product> templates(RedisConnectionFactory jcf) {
        RedisTemplate<String, Product> template = new RedisTemplate<>();
        template.setConnectionFactory(jcf);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Product.class));
        return template;
    }
    
}
