package io.wix.hamcrest;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * @author shaiyallin
 * @since 1/12/13
 */
public class Animal {

    enum Trait {HasMilk, LaysEggs, CanFly, HasFeathers, Aquatic}

    public final String name;
    public final Set<Trait> traits;

    public Animal(String name, Set<Trait> traits) {
        this.traits = traits;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Set<Trait> traits(Trait... traits) {
        return ImmutableSet.copyOf(traits);
    }
}
