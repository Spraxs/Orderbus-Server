package nl.maweb.server.modules.worldobjects.creatures;

import lombok.Getter;
import lombok.Setter;
import nl.maweb.server.Server;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.network.packet.SendablePacket;
import nl.maweb.server.modules.worldobjects.WorldObject;

import java.util.logging.Logger;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

public class Player extends WorldObject {
    private static final Logger LOGGER = Logger.getLogger(Player.class.getName());
    private static final String RESTORE_CHARACTER = "SELECT * FROM characters WHERE name=?";
    private static final String STORE_CHARACTER = "UPDATE characters SET name=?, class_id=? WHERE account=? AND name=?";

    private @Getter final Client client;

    private @Getter @Setter boolean pinged;

    public Player(Client client) {
        this.client = client;
    }

    public void remove() {
        Server.getWorldModule().removeClient(this.client);
    }

    public void channelSend(SendablePacket packet)
    {
        client.channelSend(packet);
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public Player asPlayer() {
        return this;
    }
}
