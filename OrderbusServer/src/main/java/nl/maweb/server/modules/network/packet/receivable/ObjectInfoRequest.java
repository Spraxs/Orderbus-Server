package nl.maweb.server.modules.network.packet.receivable;

import nl.maweb.server.Server;
import nl.maweb.server.modules.worldobjects.WorldObject;
import nl.maweb.server.modules.worldobjects.creatures.Player;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.network.packet.ReceivablePacket;
import nl.maweb.server.modules.network.packet.sendable.PlayerInformation;

/**
 * @author Spraxs
 */
public class ObjectInfoRequest {

	public ObjectInfoRequest(Client client, ReceivablePacket packet) {
		// Read data.
		final long objectId = packet.readLong();
		
		// Get the acting player.
		final Player player = client.getActiveChar();
		// Send the information.
		for (WorldObject object : Server.getWorldModule().getAllPlayersExcept(player))
		{
			if (object.getObjectId() == objectId)
			{
				if (object.isPlayer())
				{
					client.channelSend(new PlayerInformation(object.asPlayer()));
				}
				break;
			}
		}
	}
}
