package io.wix.hamcrest.zoo;

import com.google.common.base.Predicate;
import org.hamcrest.Matcher;

/**
 * @author shaiyallin
 * @since 1/12/13
 */
public class MatcherPredicate<T> implements Predicate<T> {
    private final Matcher<T> matcher;

    public MatcherPredicate(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    public boolean apply(T item) {
        return matcher.matches(item);
    }

    public static <T> MatcherPredicate<T> usingMatcher(Matcher<T> matcher) {
        return new MatcherPredicate<T>(matcher);
    }
}
