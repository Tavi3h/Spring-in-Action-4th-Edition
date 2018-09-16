package orders.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import orders.Order;
import orders.config.MongoConfig;
import orders.db.OrderRepository;

@ContextConfiguration(classes = MongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository templates;
    
    @Test
    public void customFindByIdTest() {
        Order order = templates.findOrderById("5b8fba8853933013f4728636");
        System.out.println(order);
    }
    
    @Test
    public void customQueryTest() {
        List<Order> orders = templates.findOrderByType("Web");
        System.out.println(orders);
    }
    
    @Test
    public void customMixTest() {
        String type = "NET";
        List<Order> list = templates.findOrdersByType(type);
        System.out.println(list);
    }
}
