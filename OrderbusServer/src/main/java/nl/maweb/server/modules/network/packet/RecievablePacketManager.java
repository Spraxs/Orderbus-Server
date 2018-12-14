package nl.maweb.server.modules.network.packet;

import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.network.packet.receivable.*;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

public class RecievablePacketManager {

    public static void handle(Client client, ReceivablePacket packet) {
        switch (packet.readShort()) {
            case 0: {
                    new PingServer(client);
                break;
            }
            case 1: {
                //    new AccountAuthenticationRequest(client, packet);
                break;
            }
            case 2: {
                //    new CharacterSelectionInfoRequest(client, packet);
                break;
            }
            case 3: {
                //    new CharacterCreationRequest(client, packet);
                break;
            }
            case 4: {
                new DoDamage(client, packet);
                break;
            }
            case 5: {
                //    new CharacterSlotUpdate(client, packet);
                break;
            }
            case 6: {
                //new DoDamage(client, packet);
                break;
            }
            case 7: {
                new EnterServerRequest(client, packet);
                break;
            }
            case 8: {
                new ObjectInfoRequest(client, packet);
                break;
            }
            case 9: {
                new LocationUpdate(client, packet);
                break;
            }
        }
    }
}
