package orders.db;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import orders.Order;

public interface OrderRepository extends Neo4jRepository<Order, Long> {
    @Query("match (o:Order)-[:HAS_ITEMS]->(i:Item) where i.product='T-Rex' return o, i")
    List<Order> findTRexOrders();
}
