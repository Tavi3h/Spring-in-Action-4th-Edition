package orders.test;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import orders.Order;
import orders.Item;
import orders.config.MongoConfig;

@ContextConfiguration(classes = MongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoOperationsTest {
    
    @Autowired
    private MongoOperations mongo;
    
    @Test
    public void saveTest() {
        Order order = new Order();
        
        order.setCustomer("Tavish");

        order.setType("Web");
        
        Set<Item> items = new LinkedHashSet<>();
        
        Item item = new Item();
        item.setPrice(19.99);
        item.setProduct("T-shirt");
        item.setQuantity(3);
        items.add(item);
        
        order.setItems(items);
        
        mongo.save(order);
    }
    
    @Test
    public void findTest() {
        String id = "5b8fba8853933013f4728636";
        Order order = mongo.findById(id, Order.class);
        System.out.println(order);
    }
}
