package com.spraxs.js.modules.network.packet.receivable;

import com.spraxs.js.framework.managers.WorldManager;
import com.spraxs.js.modules.network.client.Client;
import com.spraxs.js.modules.network.packet.ReceivablePacket;
import com.spraxs.js.modules.network.packet.sendable.MoveToLocation;
import com.spraxs.js.modules.worldobjects.creatures.Player;

public class ObjectLocationUpdate {

    public ObjectLocationUpdate(Client client, ReceivablePacket packet) {

        // Read data.
        final float posX = (float) packet.readDouble(); // TODO: Client WriteFloat
        final float posY = (float) packet.readDouble(); // TODO: Client WriteFloat
        final float posZ = (float) packet.readDouble(); // TODO: Client WriteFloat
        final float time = (float) packet.readDouble(); // TODO: Client WriteFloat

        // Update player location.
        final Player player = client.getActiveChar();

        if (player != null) {

            player.getLocation().setX(posX);
            player.getLocation().setY(posY);
            player.getLocation().setZ(posZ);

            // Broadcast movement.
            for (Player nearby : WorldManager.getVisiblePlayers(player))
            {
                nearby.channelSend(new MoveToLocation(player, time));
            }
        }
    }
}
