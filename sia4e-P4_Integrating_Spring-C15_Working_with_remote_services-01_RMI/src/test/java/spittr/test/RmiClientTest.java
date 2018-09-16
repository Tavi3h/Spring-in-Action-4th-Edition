package spittr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spittr.config.client.RmiClientConfig;
import spittr.service.SpitterService;

@ContextConfiguration(classes = RmiClientConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RmiClientTest {
    
    @Autowired
    private SpitterService service;
    
    @Test
    public void serviceTest() {
        service.getAllSpitters();
    }

}
