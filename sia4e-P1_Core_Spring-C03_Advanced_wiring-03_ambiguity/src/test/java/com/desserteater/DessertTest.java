package com.desserteater;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.desserteater.annotations.Cold;
import com.desserteater.annotations.Fruity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Dessert.class)
public class DessertTest {
    
    private Dessert dessert;
    
    @Autowired
    @Cold
    @Fruity
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
    
    @Test
    public void dessertTest() {
        System.out.println(dessert);
    }
    
}
