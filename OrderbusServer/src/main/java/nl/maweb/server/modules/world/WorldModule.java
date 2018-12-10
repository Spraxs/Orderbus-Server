package nl.maweb.server.modules.world;

import nl.maweb.server.framework.Module;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.world.framework.World;
import nl.maweb.server.modules.worldobjects.WorldObject;
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

    private final List<Client> ONLINE_CLIENTS = new CopyOnWriteArrayList<>();
    private final Map<Long, Player> PLAYER_OBJECTS = new ConcurrentHashMap<>();
    private final Map<Long, WorldObject> GAME_OBJECTS = new ConcurrentHashMap<>();

    @Override
    public void onEnable() {
    }


    public void addObject(WorldObject object)
    {
        if (object.isPlayer())
        {
            if (!PLAYER_OBJECTS.values().contains(object))
            {
                ONLINE_CLIENTS.add(object.asPlayer().getClient());
                PLAYER_OBJECTS.put(object.getObjectId(), object.asPlayer());
            }
        }
        else if (!GAME_OBJECTS.values().contains(object))
        {
            GAME_OBJECTS.put(object.getObjectId(), object);
        }
    }

    public void removeObject(WorldObject object) {

        // Remove from list and take necessary actions.
        if (object.isPlayer())
        {
            PLAYER_OBJECTS.remove(object.getObjectId());
        }
        else
        {
            GAME_OBJECTS.remove(object.getObjectId());
        }
    }

    public Collection<Player> getAllPlayers() {
        return PLAYER_OBJECTS.values();
    }

    public List<Player> getAllPlayersExcept(WorldObject object)
    {
        final List<Player> result = new ArrayList<>();
        for (Player player : PLAYER_OBJECTS.values())
        {
            if (object != null && player == object)
            {
                continue;
            }
            result.add(player);
        }
        return result;
    }

    public WorldObject getObject(long objectId)
    {
        if (PLAYER_OBJECTS.containsKey(objectId))
        {
            return PLAYER_OBJECTS.get(objectId);
        }
        return GAME_OBJECTS.get(objectId);
    }

    public int getOnlineCount()
    {
        return ONLINE_CLIENTS.size();
    }

    public void addClient(Client client)
    {
        if (!ONLINE_CLIENTS.contains(client))
        {
            ONLINE_CLIENTS.add(client);
        }
    }

    public void removeClient(Client client)
    {
        // Store and remove player.
        final Player player = client.getActiveChar();
        if (player != null)
        {
            removeObject(player);
        }

        // Remove from list.
        ONLINE_CLIENTS.remove(client);
    }
}
