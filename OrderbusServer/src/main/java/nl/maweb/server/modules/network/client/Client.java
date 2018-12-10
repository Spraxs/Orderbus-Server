package nl.maweb.server.modules.network.client;

import nl.maweb.server.modules.worldobjects.creatures.Player;
import nl.maweb.server.modules.network.packet.Encryption;
import nl.maweb.server.modules.network.packet.ReceivablePacket;
import nl.maweb.server.modules.network.packet.RecievablePacketManager;
import nl.maweb.server.modules.network.packet.SendablePacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

public class Client extends SimpleChannelInboundHandler<byte[]> {

    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

    private Channel channel;
    private @Getter String ip;
    private @Getter @Setter Player activeChar;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        // Connected.
        channel = ctx.channel();
        ip = channel.remoteAddress().toString();
        ip = ip.substring(1, ip.lastIndexOf(':')); // Trim out /127.0.0.1:12345
    }

    public void channelSend(SendablePacket packet) {
        if (channel.isActive())  {
            channel.writeAndFlush(packet.getSendableBytes());
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] bytes) {
        RecievablePacketManager.handle(this, new ReceivablePacket(Encryption.decrypt(bytes)));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        // Disconnected.
       // WorldManager.removeClient(this);
        LOGGER.finer("Client Disconnected: " + ctx.channel());
    }
}
