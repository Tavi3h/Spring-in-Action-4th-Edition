package orders;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {

    @Id
    private String id;

    @Field("client") // 覆盖默认的域名
    private String customer;

    private String type;

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

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", type=" + type + ", items=" + items + "]";
    }
}
