package nl.maweb.server.modules.network.packet.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum InputAction {

    Left(0),
    Up(1),
    Right(2),
    Down(3),
    Use(4),
    Pause(5);

    private int id;
}
