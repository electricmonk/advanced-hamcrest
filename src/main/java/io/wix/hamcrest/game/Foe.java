package io.wix.hamcrest.game;

/**
 * @author shaiyallin
 * @since 1/13/13
 */
public class Foe {
    enum Type {Goblin, Orc, Human}

    public final Type type;
    public final int life;

    public Foe(Type type, int life) {
        this.type = type;
        this.life = life;
    }
}
