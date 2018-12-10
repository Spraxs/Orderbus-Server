package com.spraxs.js.modules.network.packet.receivable;

import com.spraxs.js.framework.managers.WorldManager;
import com.spraxs.js.modules.network.client.Client;
import com.spraxs.js.modules.network.packet.ReceivablePacket;
import com.spraxs.js.modules.network.packet.sendable.MoveToLocation;
import com.spraxs.js.modules.worldobjects.Location;
import com.spraxs.js.modules.worldobjects.creatures.Player;
import com.spraxs.js.modules.worldobjects.objects.projectiles.Projectile;

public class ObjectSpawn {

    public ObjectSpawn(Client client, ReceivablePacket packet) {

        // Read data.
        final float posX = (float) packet.readDouble(); // TODO: Client WriteFloat
        final float posY = (float) packet.readDouble(); // TODO: Client WriteFloat
        final float posZ = (float) packet.readDouble(); // TODO: Client WriteFloat
        final float time = (float) packet.readDouble(); // TODO: Client WriteFloat

        Projectile projectile = new Projectile();

        WorldManager.addObject(projectile);

        projectile.setLocation(new Location(posX, posY, posZ));

        // Broadcast movement.
        for (Player nearby : WorldManager.getVisiblePlayers(client.getActiveChar())) {
            nearby.channelSend(new MoveToLocation(projectile, time));
        }

    }
}
