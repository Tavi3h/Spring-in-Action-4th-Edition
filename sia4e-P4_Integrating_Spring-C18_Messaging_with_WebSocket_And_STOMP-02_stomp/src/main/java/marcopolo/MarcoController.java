package marcopolo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MarcoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarcoController.class);

    // 处理发往“/app/marco”目的地的消息
    @MessageMapping("/marco")
    public Shout handleShout(Shout incoming) {
        LOGGER.info("Received message: " + incoming.getMessage());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }

        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");

        return outgoing;
    }
}
