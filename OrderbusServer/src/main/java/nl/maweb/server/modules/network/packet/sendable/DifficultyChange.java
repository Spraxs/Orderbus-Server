package nl.maweb.server.modules.network.packet.sendable;

import nl.maweb.server.Server;
import nl.maweb.server.modules.network.packet.SendablePacket;

public class DifficultyChange extends SendablePacket {

    public DifficultyChange() {

        // Packet id.
        writeShort(8);
        writeInt(Server.getLevelModule().getDifficulty().getId());
    }
}
