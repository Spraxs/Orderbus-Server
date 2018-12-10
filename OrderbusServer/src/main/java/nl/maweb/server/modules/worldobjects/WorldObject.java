package nl.maweb.server.modules.worldobjects;

import nl.maweb.server.framework.managers.IdManager;
import nl.maweb.server.modules.worldobjects.creatures.Customer;
import nl.maweb.server.modules.worldobjects.creatures.Player;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

public class WorldObject {

    private @Getter final long objectId = IdManager.getNextId();
    private @Getter final long spawnTime = System.currentTimeMillis();
    private @Getter @Setter Location location = new Location(0, -1000, 0);

    /**
     * Calculates distance between this GameObject and given x, y , z.
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     * @return distance between object and given x, y, z.
     */
    public double calculateDistance(float x, float y, float z)
    {
        return Math.pow(x - location.getX(), 2) + Math.pow(y - location.getY(), 2) + Math.pow(z - location.getZ(), 2);
    }

    /**
     * Calculates distance between this GameObject and another GameObject.
     * @param object GameObject
     * @return distance between object and given x, y, z.
     */
    public double calculateDistance(WorldObject object)
    {
        return calculateDistance(object.getLocation().getX(), object.getLocation().getY(), object.getLocation().getZ());
    }

    /**
     * Verify if object is instance of Player.
     * @return {@code true} if object is instance of Player, {@code false} otherwise.
     */
    public boolean isPlayer()
    {
        return false;
    }

    /**
     * @return {@link Player} instance if current object is such, {@code null} otherwise.
     */
    public Player asPlayer()
    {
        return null;
    }

    /**
     * Verify if object is instance of Customer.
     * @return {@code true} if object is instance of Customer, {@code false} otherwise.
     */
    public boolean isCustomer()
    {
        return false;
    }

    /**
     * @return {@link Customer} instance if current object is such, {@code null} otherwise.
     */
    public Customer asCustomer()
    {
        return null;
    }
}
