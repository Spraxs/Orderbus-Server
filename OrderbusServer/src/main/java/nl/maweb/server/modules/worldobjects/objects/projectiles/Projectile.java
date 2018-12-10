package nl.maweb.server.modules.worldobjects.objects.projectiles;

import nl.maweb.server.modules.worldobjects.WorldObject;
import nl.maweb.server.modules.worldobjects.objects.projectiles.framework.ProjectileType;
import lombok.Getter;
import lombok.Setter;

public class Projectile extends WorldObject {

    private @Getter @Setter
    ProjectileType projectileType;

}
