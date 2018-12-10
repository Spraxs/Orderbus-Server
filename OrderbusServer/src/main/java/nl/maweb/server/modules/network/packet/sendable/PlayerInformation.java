package com.spraxs.js.modules.network.packet.sendable;

import com.spraxs.js.modules.worldobjects.creatures.Player;
import com.spraxs.js.modules.network.packet.SendablePacket;

/**
 * @author Spraxs
 */
public class PlayerInformation extends SendablePacket {

    public PlayerInformation(Player player) {

        // Packet id.
        writeShort(6);

        // Player information.
        writeLong(player.getObjectId());
        writeShort(player.getClassId());
        writeString(player.getName());
        writeFloat(player.getLocation().getX());
        writeFloat(player.getLocation().getY());
        writeFloat(player.getLocation().getZ());
    }
}