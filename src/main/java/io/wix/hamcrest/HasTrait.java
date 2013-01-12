package io.wix.hamcrest;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import io.wix.hamcrest.Animal.Trait;

import java.util.Set;

import static org.hamcrest.Matchers.hasItem;

/**
 * @author shaiyallin
 * @since 1/12/13
 */
public class HasTrait extends FeatureMatcher<Animal, Set<Trait>> {

    public HasTrait(Matcher<? super Set<Trait>> subMatcher) {
        super(subMatcher, "an animal with", "with a trait that");
    }

    @Override
    protected Set<Trait> featureValueOf(Animal actual) {
        return actual.traits;
    }

    public static HasTrait hasTrait(Matcher<? super Set<Trait>> matcher) {
        return new HasTrait(matcher);
    }

    public static HasTrait hasTrait(Trait trait) {
        return hasTrait(hasItem(trait));
    }
}
