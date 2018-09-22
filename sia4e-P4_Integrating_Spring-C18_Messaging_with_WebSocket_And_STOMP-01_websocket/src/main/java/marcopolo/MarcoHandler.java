package marcopolo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MarcoHandler extends AbstractWebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarcoHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOGGER.info("Received message: " + message.getPayload());
        TimeUnit.SECONDS.sleep(2);
        session.sendMessage(new TextMessage("Polo!"));
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("Connection established");
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOGGER.info("Connection closed. status: " + status);
    }
}