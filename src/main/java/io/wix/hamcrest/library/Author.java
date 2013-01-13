package io.wix.hamcrest.library;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * @author shaiyallin
 * @since 1/13/13
 */
public class Author {
    public final String lastName;
    public final String firstName;

    public Author(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public static class AuthorMatcher extends FeatureSetMatcher<Author> {

        public AuthorMatcher withFirstName(Matcher<String> name) {
            add(new FeatureMatcher<Author, String>(name, "first name", "first name") {
                @Override
                protected String featureValueOf(Author author) {
                    return author.firstName;
                }
            });

            return this;
        }

        public AuthorMatcher withLastName(Matcher<String> name) {
            add(new FeatureMatcher<Author, String>(name, "last name", "last name") {
                @Override
                protected String featureValueOf(Author author) {
                    return author.lastName;
                }
            });

            return this;
        }
    }

    public static AuthorMatcher anAuthor() {
        return new AuthorMatcher();
    }
}
