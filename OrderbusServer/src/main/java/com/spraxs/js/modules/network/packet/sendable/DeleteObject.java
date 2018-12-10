package com.spraxs.js.modules.network.packet.sendable;

import com.spraxs.js.modules.worldobjects.WorldObject;
import com.spraxs.js.modules.network.packet.SendablePacket;

/**
 * @author Spraxs
 */
public class DeleteObject extends SendablePacket {
	public DeleteObject(WorldObject object)
	{
		// Send the data.
		writeShort(7); // Packet id.
		writeLong(object.getObjectId()); // ID of object to delete.
	}
}
