package nl.maweb.server.modules.level;

import lombok.Getter;
import lombok.Setter;
import nl.maweb.server.framework.modular.Module;
import nl.maweb.server.modules.level.framework.Difficulty;
import nl.maweb.server.modules.worldobjects.creatures.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LevelModule extends Module {

    private @Getter @Setter int health;
    private @Getter @Setter Difficulty difficulty;

    private Map<Long, Customer> customers;

    @Override
    public void onEnable() {
        this.health = 5;
        this.difficulty = Difficulty.NORMAL;
        this.customers = new ConcurrentHashMap<>();
    }



    public void addCustomer(Customer customer) {
        this.customers.put(customer.getObjectId(), customer);
    }

    public boolean comtainsCustomer(Customer customer) {
        return this.customers.containsValue(customer);
    }

    public boolean comtainsCustomerId(long objectId) {
        return this.customers.containsKey(objectId);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer.getObjectId());
    }

    public Customer[] getAllCustomers() {
        return (Customer[]) customers.values().toArray();
    }

    public Customer getCustomer(long objectId) {
        for (Customer customer : this.customers.values()) {
            if (objectId == customer.getObjectId()) {
                return customer;
            }
        }

        return null;
    }

    public void damage() {
        health--;

        if (health <= 0) {
            //TODO Game over

        }
    }
}
