package nl.maweb.server.modules.network.packet.sendable;

import nl.maweb.server.modules.worldobjects.WorldObject;
import nl.maweb.server.modules.network.packet.SendablePacket;

/**
 * @author Spraxs
 */

public class HandleLocation extends SendablePacket {

    public HandleLocation(WorldObject object, float time) {

        // Send the data.
        writeShort(9); // Packet id.

        writeLong(object.getObjectId());
        writeDouble(object.getLocation().getX());
        writeDouble(object.getLocation().getY());
        writeDouble(object.getLocation().getZ());
        writeDouble(time);
    }
}
