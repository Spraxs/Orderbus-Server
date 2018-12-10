package nl.maweb.server.modules.network.packet.sendable;

import nl.maweb.server.modules.network.packet.SendablePacket;

public class PingPlayer extends SendablePacket {

    public PingPlayer() {

        // Send the data.
        writeShort(0); // Packet id.
    }
}
