package com.spraxs.js.modules.network.packet;

import com.spraxs.js.modules.network.client.Client;
import com.spraxs.js.modules.network.packet.receivable.*;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

public class RecievablePacketManager {

    public static void handle(Client client, ReceivablePacket packet) {
        switch (packet.readShort()) {
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
                //    new CharacterDeletionRequest(client, packet);
                break;
            }
            case 5: {
                //    new CharacterSlotUpdate(client, packet);
                break;
            }
            case 6: {
                //    new CharacterSelectUpdate(client, packet);
                break;
            }
            case 7: {
                new EnterServerRequest(client, packet);
                break;
            }
            case 8: {
                new LocationUpdate(client, packet);
                break;
            }
            case 9: {
                new ObjectInfoRequest(client, packet);
                break;
            }
            case 10: {
                //    new ChatRequest(client, packet);
                break;
            }
            case 11: {
                new LoadInWorld(client, packet);
                break;
            }
            case 12: {
                new ObjectLocationUpdate(client, packet);
                break;
            }

            case 13: {
                new ObjectSpawn(client, packet);
                break;
            }
        }
    }
}
