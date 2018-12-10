package nl.maweb.server;

import nl.maweb.server.framework.Config;
import nl.maweb.server.modules.level.LevelModule;
import nl.maweb.server.modules.network.ClientInitializer;
import nl.maweb.server.modules.network.packet.Encryption;
import nl.maweb.server.modules.network.tasks.PingTask;
import nl.maweb.server.modules.world.WorldModule;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.Getter;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

public final class Server {

    public static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    private static @Getter WorldModule worldModule;
    private static @Getter LevelModule levelModule;

    public static void main(String[] args) {

        try {
            new Server();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Server() throws InterruptedException {

        // Initialize all Modules
        initializeModules();

        // Keep start time for later.
        final long serverLoadStart = System.currentTimeMillis();

        printSection("Configs");
        Config.load();

        printSection("Encryption");
        Encryption.init();

        // Post info.
        printSection("Info");
        LOGGER.info("Server loaded in " + ((System.currentTimeMillis() - serverLoadStart) / 1000) + " seconds.");
        System.gc();
        LOGGER.info("Started, using " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576) + " of " + (Runtime.getRuntime().maxMemory() / 1048576) + " MB total memory.");


        new ServerBootstrap()
                .group(new NioEventLoopGroup(1), new NioEventLoopGroup(Config.IO_PACKET_THREAD_CORE_SIZE))
                .channel(NioServerSocketChannel.class)
                .childHandler(new ClientInitializer())
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .bind(Config.SERVER_IP, Config.SERVER_PORT)
                .sync();

        LOGGER.info("Listening on " + Config.SERVER_IP + ":" + Config.SERVER_PORT);

        // Notify sound.
        Toolkit.getDefaultToolkit().beep();

        new PingTask();
    }

    private void printSection(String s)
    {
        s = "=[ " + s + " ]";
        while (s.length() < 62)
        {
            s = "-" + s;
        }
        LOGGER.info(s);
    }

    private void initializeModules() {
        worldModule = new WorldModule();

        levelModule = new LevelModule();
    }
}
