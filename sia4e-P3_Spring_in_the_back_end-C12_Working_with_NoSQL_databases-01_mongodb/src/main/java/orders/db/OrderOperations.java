package orders.db;

import java.util.List;

import orders.Order;

public interface OrderOperations {
    List<Order> findOrdersByType(String type);
}
