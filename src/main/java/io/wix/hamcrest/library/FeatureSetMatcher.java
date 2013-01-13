package io.wix.hamcrest.library;

import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.AllOf;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.AllOf.allOf;

/**
 * @author shaiyallin
 * @since 1/13/13
 */
public abstract class FeatureSetMatcher<T> extends TypeSafeDiagnosingMatcher<T> {

    private final List<Matcher<? super T>> featureMatchers = newArrayList();

    @Override
    protected boolean matchesSafely(T item, Description mismatchDescription) {
        return combine().matches(item);
    }

    protected <U> void add(FeatureMatcher<T, U> matcher) {
        featureMatchers.add(matcher);
    }

    public void describeTo(Description description) {
        combine().describeTo(description);
    }

    private AllOf<T> combine() {
        return new AllOf<T>(featureMatchers);
    }
}
