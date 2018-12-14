package nl.maweb.server.modules.network.packet.sendable;

import nl.maweb.server.modules.worldobjects.WorldObject;
import nl.maweb.server.modules.network.packet.SendablePacket;

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
