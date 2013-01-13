package io.wix.hamcrest.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import io.wix.hamcrest.game.Foe.Type;

/**
 * @author shaiyallin
 * @since 1/13/13
 */
public class Den {

    static final int BASE_LIFE = 50;

    private final int size;

    Random random = new Random();

    public Den(int size) {
        this.size = size;
    }

    public List<Foe> spawn() {
        int numOfFoes = random.nextInt(size) + size;
        List<Foe> foes = new ArrayList<Foe>(numOfFoes);
        for (int i = 0; i < numOfFoes; i++) {
            foes.add(new Foe(Type.values()[random.nextInt(Type.values().length)], random.nextInt(BASE_LIFE) + BASE_LIFE));
        }

        return foes;

    }
}
