package io.wix.hamcrest;

import com.google.common.collect.ImmutableList;
import org.hamcrest.Matcher;

import java.util.List;

import static com.google.common.collect.Iterables.filter;
import static io.wix.hamcrest.Animal.traits;
import static io.wix.hamcrest.Animal.Trait.*;
import static io.wix.hamcrest.HasTrait.hasTrait;
import static io.wix.hamcrest.MatcherPredicate.usingMatcher;
import static org.hamcrest.Matchers.allOf;

/**
 * @author shaiyallin
 * @since 1/12/13
 */
public class Zoo {

    public final List<Animal> specimens = ImmutableList.<Animal>builder()
            .add(new Animal("chicken", traits(CanFly, LaysEggs, HasFeathers)))
            .add(new Animal("ostrich", traits(LaysEggs, HasFeathers)))
            .add(new Animal("cat", traits(HasMilk)))
            .add(new Animal("penguin", traits(LaysEggs, Aquatic, HasFeathers)))
            .add(new Animal("bat", traits(HasMilk, CanFly)))
            .add(new Animal("platypus", traits(HasMilk, LaysEggs, Aquatic)))
            .add(new Animal("whale", traits(HasMilk, Aquatic)))
            .add(new Animal("salmon", traits(Aquatic, LaysEggs)))
            .add(new Animal("shark", traits(Aquatic)))
            .add(new Animal("flying fish", traits(CanFly, Aquatic, LaysEggs)))
            .build();

    public Iterable<Animal> mammals() {
        return specimensMatching(hasTrait(HasMilk));
    }

    public Iterable<Animal> aquaticMammals() {
        return specimensMatching(allOf(
                hasTrait(HasMilk),
                hasTrait(Aquatic)
        ));
    }

    public Iterable<Animal> birds() {
        return specimensMatching(allOf(
                hasTrait(LaysEggs),
                hasTrait(CanFly)
        ));
    }

    public Iterable<Animal> fish() {
        return specimensMatching(allOf(
                hasTrait(Aquatic),
                hasTrait(LaysEggs)
        ));
    }

    private Iterable<Animal> specimensMatching(Matcher<Animal> matcher) {
        return filter(specimens, usingMatcher(matcher));
    }

}
