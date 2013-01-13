package io.wix.hamcrest.library;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static io.wix.hamcrest.library.Author.anAuthor;
import static io.wix.hamcrest.library.Book.aBook;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author shaiyallin
 * @since 1/13/13
 */
public class LibraryTest {

    Author vonnegut = new Author("Vonnegut", "Kurt");
    Author adams = new Author("Adams", "Douglas");
    Library library = new Library(ImmutableList.of(
            new Book(vonnegut, "Cat's Cradle", "1234"),
            new Book(vonnegut, "The Sirens of Titan", "2345"),
            new Book(adams, "Dirk Gently's Holistic Detective Agency", "3456"),
            new Book(adams, "Mostly Harmless", "3456")
    ));

    @Test
    public void byAuthorName() throws Exception {

        assertThat(library.byAuthorLastName("von"), containsInAnyOrder(
                aBook()
                    .withAuthor(
                        anAuthor().withLastName(is("Vonnegut")).withFirstName(is("Kurt"))
                    )
                    .withName(is("Cat's Cradle")),

                aBook()
                    .withAuthor(
                        anAuthor().withLastName(is("Vonnegut")).withFirstName(is("Kurt"))
                    )
                    .withName(is("The Sirens of Titan"))

        ));
    }
}
