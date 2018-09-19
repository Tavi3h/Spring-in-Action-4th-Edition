package spittr.alerts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import spittr.domain.Spittle;

public class AlertServiceImpl implements AlertService {
    
    // 注入JMS模板
    @Autowired
    private JmsOperations jmsTemplate;

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        jmsTemplate.convertAndSend(spittle);
    }
}
