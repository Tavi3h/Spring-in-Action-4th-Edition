package orders.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import orders.Order;

public interface OrderRepository extends MongoRepository<Order, String>, OrderOperations {
    
    Order findOrderById(String id);
    
    @Query("{'customer':'Tavish', 'type':?0}")
    List<Order> findOrderByType(String type); 
}

