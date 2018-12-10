package com.spraxs.js.modules.network.packet.sendable;

import com.spraxs.js.modules.worldobjects.creatures.Player;
import com.spraxs.js.modules.network.packet.SendablePacket;

/**
 * @author Spraxs
 */
public class EnterServerInformation extends SendablePacket {

	public EnterServerInformation(Player player) {

		// Packet id.
		writeShort(5);
		// TODO: Send player information.
	}
}
