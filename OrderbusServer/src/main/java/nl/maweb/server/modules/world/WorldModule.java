package nl.maweb.server.modules.world;

import nl.maweb.server.framework.modular.Module;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.worldobjects.WorldObject;
import nl.maweb.server.modules.worldobjects.creatures.Customer;
import nl.maweb.server.modules.worldobjects.creatures.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Spraxs
 * Date: 26-9-2018
 */

public final class WorldModule extends Module {

    private final List<Client> online_clients = new CopyOnWriteArrayList<>();
    private final Map<Long, Player> player_objects = new ConcurrentHashMap<>();
    private final Map<Long, Customer> customer_objects = new ConcurrentHashMap<>();
    private final Map<Long, WorldObject> game_objects = new ConcurrentHashMap<>();

    @Override
    public void onEnable() {
    }


    public void addObject(WorldObject object)
    {
        if (object.isPlayer())
        {
            if (!player_objects.values().contains(object.asPlayer()))
            {
                online_clients.add(object.asPlayer().getClient());
                player_objects.put(object.getObjectId(), object.asPlayer());
            }
        } else

        if (object.isCustomer())
        {
            if (!customer_objects.values().contains(object.asCustomer()))
            {
                customer_objects.put(object.getObjectId(), object.asCustomer());
            }
        }
        else if (!game_objects.values().contains(object))
        {
            game_objects.put(object.getObjectId(), object);
        }
    }

    public void removeObject(WorldObject object) {

        // Remove from list and take necessary actions.
        if (object.isPlayer())
        {
            player_objects.remove(object.getObjectId());
            online_clients.remove(object.asPlayer().getClient());
        }
        else
        {
            game_objects.remove(object.getObjectId());
        }
    }

    public Collection<Player> getAllPlayers() {
        return player_objects.values();
    }

    public List<Player> getAllPlayersExcept(WorldObject object)
    {
        final List<Player> result = new ArrayList<>();
        for (Player player : player_objects.values())
        {
            if (object != null && player == object)
            {
                continue;
            }
            result.add(player);
        }
        return result;
    }

    public Collection<Customer> getAllCustomers() {
        return customer_objects.values();
    }

    public List<Customer> getAllActiveCustomers() {
        final List<Customer> result = new ArrayList<>();
        for (Customer customer : customer_objects.values())
        {
            if (!customer.isActive())
            {
                continue;
            }
            result.add(customer);
        }
        return result;
    }

    public List<Customer> getAllInActiveCustomers() {
        final List<Customer> result = new ArrayList<>();
        for (Customer customer : customer_objects.values())
        {
            if (customer.isActive())
            {
                continue;
            }
            result.add(customer);
        }
        return result;
    }

    public WorldObject getObject(long objectId)
    {
        if (player_objects.containsKey(objectId)) return player_objects.get(objectId);

        if (customer_objects.containsKey(objectId)) return customer_objects.get(objectId);

        return game_objects.get(objectId);
    }

    public int getOnlineCount()
    {
        return online_clients.size();
    }
}
