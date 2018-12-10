package nl.maweb.server.modules.level.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum Difficulty {

    NORMAL(0),
    HARD(1);

    private int id;
}
