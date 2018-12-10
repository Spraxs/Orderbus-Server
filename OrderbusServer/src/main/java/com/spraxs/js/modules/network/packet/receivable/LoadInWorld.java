package com.spraxs.js.modules.network.packet.receivable;

import com.spraxs.js.framework.managers.WorldManager;
import com.spraxs.js.modules.worldobjects.creatures.Player;
import com.spraxs.js.modules.network.client.Client;
import com.spraxs.js.modules.network.packet.ReceivablePacket;
import com.spraxs.js.modules.network.packet.sendable.EnterServerInformation;
import com.spraxs.js.modules.network.packet.sendable.PlayerInformation;

/**
 * Created by Spraxs
 * Date: 26-9-2018
 */

public class LoadInWorld {

    public LoadInWorld(Client client, ReceivablePacket packet) {

        // Read data.
        final String characterName = packet.readString();

        // Create a new PlayerInstance.
        final Player player = new Player(client, characterName);

        // Add object to the world.
        WorldManager.addObject(player);

        // Assign this player to client.
        client.setActiveChar(player);

        // Send active player information to client.
        client.channelSend(new EnterServerInformation(player));

        // Send and receive visible object information.
        final PlayerInformation playerInfo = new PlayerInformation(player);

        for (Player nearby : WorldManager.getAllPlayers(player)) {

            // Send the information to the current player.
            client.channelSend(new PlayerInformation(nearby));
            // Send information to the other player as well.
            nearby.channelSend(playerInfo);
        }
    }
}
