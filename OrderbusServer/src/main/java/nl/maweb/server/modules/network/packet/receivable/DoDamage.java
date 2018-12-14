package nl.maweb.server.modules.network.packet.receivable;

import nl.maweb.server.Server;
import nl.maweb.server.modules.network.client.Client;
import nl.maweb.server.modules.network.packet.ReceivablePacket;
import nl.maweb.server.modules.worldobjects.creatures.Customer;

public class DoDamage {

    public DoDamage(Client client, ReceivablePacket packet) {

        long customerObjectId = packet.readLong();

        Customer customer = Server.getLevelModule().getCustomer(customerObjectId);

        if (customer.isActive()) {
            Server.getLevelModule().damage();
        }
    }
}
