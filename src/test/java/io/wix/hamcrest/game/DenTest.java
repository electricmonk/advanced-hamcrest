package io.wix.hamcrest.game;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author shaiyallin
 * @since 1/13/13
 */
public class DenTest {

    @Test
    public void spawnNoHamcrest() throws Exception {

        Den den = new Den(5);

        // assert between 5 and 10 foes
        List<Foe> foes = den.spawn();
        assertTrue(foes.size() >= 5);
        assertTrue(foes.size() < 10);

        for (Foe foe : foes) {
            assertTrue(foe.life >= Den.BASE_LIFE);
            assertTrue(foe.life < Den.BASE_LIFE * 2);
        }
    }

    @Test
    public void spawnWithHamcrest() throws Exception {

        Den den = new Den(5);
        List<Foe> foes = den.spawn();

        assertThat(foes.size(), allOf(
                greaterThanOrEqualTo(5),
                lessThan(10)
        ));

        assertThat(foes, everyItem(hasLife(allOf(
                greaterThanOrEqualTo(Den.BASE_LIFE),
                lessThan(Den.BASE_LIFE * 2)
        ))));
    }

    @Test
    public void spawnWithCompositeMatchers() throws Exception {

        Den den = new Den(5);
        List<Foe> foes = den.spawn();

        assertThat(foes.size(), between(5, 10));
        assertThat(foes, everyItem(hasLife(between(Den.BASE_LIFE, Den.BASE_LIFE * 2))));
    }

    private Matcher<Integer> between(int low, int high) {
        return allOf(greaterThanOrEqualTo(low), lessThan(high));
    }

    Matcher<Foe> hasLife(Matcher<Integer> lifeMatcher) {
        return new FeatureMatcher<Foe, Integer>(lifeMatcher, "foe life", "lifw") {
            @Override
            protected Integer featureValueOf(Foe foe) {
                return foe.life;
            }
        };
    }
}
