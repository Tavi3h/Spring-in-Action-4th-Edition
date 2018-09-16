package com.myapp;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myapp.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class ShoppingCartTest {
    
    @Autowired
    private StoreService storeService1;

    @Autowired
    private StoreService storeService2;
    
    @Test
    public void shopTest() {
        System.out.println(storeService1);
        System.out.println(storeService2);
        assertNotEquals(storeService1, storeService2);
    }
}
