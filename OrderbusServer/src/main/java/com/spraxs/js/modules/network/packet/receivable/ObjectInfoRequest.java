package com.spraxs.js.modules.network.packet.receivable;

import com.spraxs.js.framework.managers.WorldManager;
import com.spraxs.js.modules.worldobjects.WorldObject;
import com.spraxs.js.modules.worldobjects.creatures.Player;
import com.spraxs.js.modules.network.client.Client;
import com.spraxs.js.modules.network.packet.ReceivablePacket;
import com.spraxs.js.modules.network.packet.sendable.PlayerInformation;

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
		for (WorldObject object : WorldManager.getAllPlayers(player))
		{
			if (object.getObjectId() == objectId)
			{
				if (object.isPlayer())
				{
					client.channelSend(new PlayerInformation(object.asPlayer()));
				}
				// TODO: Other objects - NpcInformation?
				break;
			}
		}
	}
}
