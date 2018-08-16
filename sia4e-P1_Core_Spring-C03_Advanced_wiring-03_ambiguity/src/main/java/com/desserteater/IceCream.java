package com.desserteater;

import org.springframework.stereotype.Component;

import com.desserteater.annotations.Cold;
import com.desserteater.annotations.Creamy;

@Component
@Cold
@Creamy
public class IceCream implements Dessert {

}
