package com.spraxs.js.modules.network.packet.sendable;

import com.spraxs.js.modules.worldobjects.WorldObject;
import com.spraxs.js.modules.network.packet.SendablePacket;

/**
 * @author Spraxs
 */

public class MoveToLocation extends SendablePacket {

    public MoveToLocation(WorldObject object, float time) {

        // Send the data.
        writeShort(9); // Packet id.

        writeLong(object.getObjectId());
        writeFloat(object.getLocation().getX());
        writeFloat(object.getLocation().getY());
        writeFloat(object.getLocation().getZ());
        writeFloat(time);
    }
}
