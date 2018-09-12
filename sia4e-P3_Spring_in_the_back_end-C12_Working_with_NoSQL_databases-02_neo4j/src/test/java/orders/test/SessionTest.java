package orders.test;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.neo4j.ogm.session.Neo4jSession;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import orders.Item;
import orders.Order;
import orders.config.Neo4jConfig;

@ContextConfiguration(classes = Neo4jConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Neo4jSession session;
    
    @Before()
    public void Before() {
        session = (Neo4jSession) sessionFactory.openSession();
    }
    
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
        
        session.save(order);
    }
    
    @Test
    public void findTest() {
        Order order = session.load(Order.class, 0L);
        System.out.println(order);
    }
    
    @Test
    public void countTest() {
        System.out.println(session.countEntitiesOfType(Order.class));
    }
}
