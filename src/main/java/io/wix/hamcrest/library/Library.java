package io.wix.hamcrest.library;

import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.Iterables.filter;


/**
 * @author shaiyallin
 * @since 1/13/13
 */
public class Library {

    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Iterable<Book> byAuthorLastName(final String prefix) {
        return filter(books, new Predicate<Book>() {
            public boolean apply(Book book) {
                return book.author.lastName.startsWith(prefix);
            }
        });
    }
}
