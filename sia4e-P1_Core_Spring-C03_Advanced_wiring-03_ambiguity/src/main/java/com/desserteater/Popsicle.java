package com.desserteater;

import org.springframework.stereotype.Component;

import com.desserteater.annotations.Cold;
import com.desserteater.annotations.Fruity;

@Component
@Cold
@Fruity
public class Popsicle implements Dessert {
    
}
