package spittr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spittr.hessian.config.HessianConfig;
import spittr.service.SpitterService;

@ContextConfiguration(classes = HessianConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HessianTest {
    
    @Autowired
    private SpitterService service;
    
    @Test
    public void serviceTest() {
        service.getAllSpitters();
    }
    
}
