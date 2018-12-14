package nl.maweb.server.modules.network.packet.sendable;

import nl.maweb.server.Server;
import nl.maweb.server.modules.network.packet.SendablePacket;

public class HandleDamage extends SendablePacket {

    public HandleDamage() {

        writeShort(10); // packet id

        writeInt(Server.getLevelModule().getHealth());
    }
}
