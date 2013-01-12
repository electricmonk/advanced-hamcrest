package io.wix.hamcrest;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

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
        assertThat(zoo.birds(), hasItem(a("chicken")));
        assertThat(zoo.birds(), hasItem(an("ostrich")));
        assertThat(zoo.birds(), hasItem(a("penguin")));
        assertThat(zoo.birds(), not(hasItem(a("flying fish"))));
    }

    @Test
    public void fish() {
        assertThat(zoo.fish(), containsInAnyOrder(
                a("salmon"), a("shark"), a("flying fish")
        ));
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
