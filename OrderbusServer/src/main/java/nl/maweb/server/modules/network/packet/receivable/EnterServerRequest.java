package nl.maweb.server.modules.network.packet.receivable;

import nl.maweb.server.Server;
import nl.maweb.server.modules.worldobjects.Location;
import nl.maweb.server.modules.worldobjects.creatures.Player;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.network.packet.ReceivablePacket;
import nl.maweb.server.modules.network.packet.sendable.EnterServerInformation;
import nl.maweb.server.modules.network.packet.sendable.PlayerInformation;

/**
 * @author Spraxs
 */
public class EnterServerRequest {

	public EnterServerRequest(Client client, ReceivablePacket packet) {

		float x = (float) packet.readDouble();
		float y = (float) packet.readDouble();
		float z = (float) packet.readDouble();

		// Create a new PlayerInstance.
		final Player player = new Player(client);

		player.setLocation(new Location(x, y, z));

		System.out.println("User connected to the server!");

		// Add object to the world.
		Server.getWorldModule().addObject(player);

		// Assign this player to client.
		client.setActiveChar(player);

		// Send active player information to client.
		client.channelSend(new EnterServerInformation(player));

		// Send and receive visible object information.
		final PlayerInformation playerInfo = new PlayerInformation(player);

		for (Player nearby : Server.getWorldModule().getAllPlayersExcept(player)) {

			// Send the information to the current player.
			client.channelSend(new PlayerInformation(nearby));

			// Send information to the other player as well.
			nearby.channelSend(playerInfo);
		}
	}
}
