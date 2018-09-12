package orders;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.InternalIdStrategy;

@NodeEntity
public class Order {

    @Id
    @GeneratedValue(strategy = InternalIdStrategy.class)
    private Long id;

    private String customer;

    private String type;

    @Relationship(type = "HAS_ITEMS")
    private Collection<Item> items = new LinkedHashSet<>();

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", type=" + type + ", items=" + items + "]";
    }
}
