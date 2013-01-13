package io.wix.hamcrest.library;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

/**
 * @author shaiyallin
 * @since 1/13/13
 */
public class Book {
    public final Author author;
    public final String name;
    public final String isbn;

    public Book(Author author, String name, String isbn) {
        this.author = author;
        this.name = name;
        this.isbn = isbn;
    }

    public static class BookMatcher extends FeatureSetMatcher<Book> {

        public BookMatcher withAuthor(Matcher<Author> author) {
            add(new FeatureMatcher<Book, Author>(author, "book author with", "author") {
                @Override
                protected Author featureValueOf(Book book) {
                    return book.author;
                }
            });
            return this;
        }

        public BookMatcher withName(Matcher<String> name) {
            add(new FeatureMatcher<Book, String>(name, "book nanme", "name") {
                @Override
                protected String featureValueOf(Book book) {
                    return book.name;
                }
            });
            return this;
        }
    }

    public static BookMatcher aBook() {
        return new BookMatcher();
    }
}
