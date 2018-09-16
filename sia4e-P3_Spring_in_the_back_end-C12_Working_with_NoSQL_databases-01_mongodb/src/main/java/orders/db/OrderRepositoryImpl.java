package orders.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import orders.Order;

public class OrderRepositoryImpl implements OrderOperations {

    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Order> findOrdersByType(String t) {

        String type = t.equals("NET") ? "WEB" : t;

        Criteria where = Criteria.where("type").is(type);

        return mongo.find(Query.query(where), Order.class);
    }

}
