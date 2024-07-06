package design_patterns.structural.flyweight;

import java.awt.*;

public class PlayerFW {
    int offencePower;
    int iniHealth;
    Image avatar;

    PlayerFW(int offencePower, int iniHealth, Image avatar) {
        this.offencePower = offencePower;
        this.iniHealth = iniHealth;
        this.avatar = avatar;
    }
}
