package com.myapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean("singletonCart")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ShoppingCart cartSingleton() {
        return new ShoppingCartImpl();
    }

    @Bean("prototypeCart")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ShoppingCart cartPrototype() {
        return new ShoppingCartImpl();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public StoreService getStoreService(@Qualifier("prototypeCart") ShoppingCart shoppingCart) {
        StoreService storeService = new StoreService();
        storeService.setShoppingCart(shoppingCart);
        return storeService;
    }
}
