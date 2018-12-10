package nl.maweb.server.modules.network.tasks;

import nl.maweb.server.Server;
import nl.maweb.server.modules.network.packet.sendable.PingPlayer;
import nl.maweb.server.modules.worldobjects.creatures.Player;

import java.util.Timer;
import java.util.TimerTask;

public class PingTask {

    public PingTask() {

        Timer timer = new Timer();

        new Thread(() -> timer.schedule(new PingTimer(), 0, 1000 * 10)).start();
    }

    class PingTimer extends TimerTask {
        public void run() {
            for (Player player : Server.getWorldModule().getAllPlayers()) {
                if (player.isPinged()) {
                    player.remove(); //Remove players that are still pinged (in active)
                }

                player.setPinged(true);

                player.channelSend(new PingPlayer());
            }
        }
    }

}