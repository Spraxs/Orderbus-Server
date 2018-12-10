package nl.maweb.server.modules.network.packet.sendable;

import nl.maweb.server.modules.worldobjects.creatures.Player;
import nl.maweb.server.modules.network.packet.SendablePacket;

/**
 * @author Spraxs
 */
public class PlayerInformation extends SendablePacket {

    public PlayerInformation(Player player) {

        // Packet id.
        writeShort(6);

        // Player information.
        writeLong(player.getObjectId());
        writeFloat(player.getLocation().getX());
        writeFloat(player.getLocation().getY());
        writeFloat(player.getLocation().getZ());
    }
}