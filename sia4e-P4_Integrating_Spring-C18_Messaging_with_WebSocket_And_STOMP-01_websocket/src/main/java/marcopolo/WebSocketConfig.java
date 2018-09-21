package marcopolo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    // 将MarcoHandler映射到“/marco”
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(marcoHandler(), "/marco").withSockJS();
    }

    // 声明MarcoHandler bean
    @Bean
    public MarcoHandler marcoHandler() {
        return new MarcoHandler();
    }

}
