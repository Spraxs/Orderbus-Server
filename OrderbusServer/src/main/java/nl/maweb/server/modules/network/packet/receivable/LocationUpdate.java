package nl.maweb.server.modules.network.packet.receivable;

import nl.maweb.server.Server;
import nl.maweb.server.modules.worldobjects.creatures.Player;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.network.packet.ReceivablePacket;
import nl.maweb.server.modules.network.packet.sendable.MoveToLocation;

/**
 * @author Spraxs
 */

public class LocationUpdate {

    public LocationUpdate(Client client, ReceivablePacket packet) {

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
            for (Player nearby : Server.getWorldModule().getAllPlayersExcept(player))
            {
                nearby.channelSend(new MoveToLocation(player, time));
            }
        }
    }
}
