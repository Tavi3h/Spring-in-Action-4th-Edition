package orders.test;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import orders.Item;
import orders.Order;
import orders.config.Neo4jConfig;
import orders.db.OrderRepository;

@ContextConfiguration(classes = Neo4jConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryTest {
    
    @Autowired
    private OrderRepository repo;
    
    @Test
    public void saveTest() {
        Order order = new Order();
        
        order.setCustomer("Taco");

        order.setType("Online");
        
        Set<Item> items = new LinkedHashSet<>();
        
        Item item = new Item();
        
        item.setPrice(19.99);
        item.setProduct("T-Rex");
        item.setQuantity(1);
        items.add(item);
        
        order.setItems(items);
        
        repo.save(order);
    }
    
    @Test
    public void findTest() {
        Order order = repo.findById(20L).get();
        System.out.println(order);
    }
    
    @Test
    public void countTest() {
        System.out.println(repo.count());
    }

    @Test
    public void customQueryTest() {
        System.out.println(repo.findTRexOrders());
    }
    
}
