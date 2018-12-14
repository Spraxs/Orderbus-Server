package nl.maweb.server.modules.network.packet.sendable;

import nl.maweb.server.modules.worldobjects.creatures.Player;
import nl.maweb.server.modules.network.packet.SendablePacket;

/**
 * @author Spraxs
 */
public class EnterServerInformation extends SendablePacket {

	public EnterServerInformation(Player player) {

		// Packet id.
		writeShort(5);
		writeLong(player.getObjectId());


	}
}
