package nl.maweb.server.modules.network.packet.receivable;

import nl.maweb.server.Server;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.worldobjects.creatures.Player;

public class PingServer {

    public PingServer(Client client) {

        Player player = client.getActiveChar();

        player.setPinged(false);

        Server.LOGGER.info("Pong");
    }
}
