package nl.maweb.server.modules.level;

import lombok.Getter;
import lombok.Setter;
import nl.maweb.server.framework.modular.Module;
import nl.maweb.server.modules.level.framework.Difficulty;

public class LevelModule extends Module {

    private @Getter @Setter int health;
    private @Getter @Setter Difficulty difficulty;

    @Override
    public void onEnable() {
        this.health = 5;
        this.difficulty = Difficulty.NORMAL;
    }
}
