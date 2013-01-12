package io.wix.hamcrest;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

import static io.wix.hamcrest.Animal.Trait.*;
import static io.wix.hamcrest.HasTrait.hasTrait;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author shaiyallin
 * @since 1/12/13
 */
public class ZooTest {

    Zoo zoo = new Zoo();

    @Test
    public void mammals() {

        assertThat(zoo.mammals(), containsInAnyOrder(
                a("bat"), a("platypus"), a("cat")
        ));
    }

    @Test
    public void aquaticMammals() {
        assertThat(zoo.aquaticMammals(), containsInAnyOrder(
                a("platypus"), a("whale")
        ));
    }

    @Test
    public void birds() {
        assertThat(zoo.birds(), everyItem(hasTrait(HasFeathers)));
    }

    @Test
    public void fish() {
        assertThat(zoo.fish(), hasItem(a("salmon")));
        assertThat(zoo.fish(), hasItem(an("shark")));
        assertThat(zoo.fish(), hasItem(a("flying fish")));
        assertThat(zoo.fish(), not(hasItem(a("penguin"))));
        assertThat(zoo.fish(), not(hasItem(a("whale"))));
    }

    private Matcher<Animal> an(String name) {
        return a(name);
    }

    private Matcher<Animal> a(String name) {
        return new FeatureMatcher<Animal, String>(is(name), "animal name", "name") {

            @Override
            protected String featureValueOf(Animal actual) {
                return actual.name;
            }
        };
    }


}
