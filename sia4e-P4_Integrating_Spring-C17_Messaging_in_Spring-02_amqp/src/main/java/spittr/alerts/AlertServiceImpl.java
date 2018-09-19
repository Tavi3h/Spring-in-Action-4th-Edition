package spittr.alerts;

import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import spittr.domain.Spittle;

public class AlertServiceImpl implements AlertService {

    @Autowired
    private RabbitOperations template;
    
    @Override
    public void sendSpittleAlert(Spittle spittle) {
        template.convertAndSend("spittle.alert.exchange", "spittle.alerts", spittle);
        template.send(new Message("Hello World".getBytes(), new MessageProperties()));
    }
    
}
