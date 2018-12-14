package nl.maweb.server.modules.level.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum Difficulty {

    EASY(0),
    NORMAL(1),
    HARD(2);

    private int id;
}
