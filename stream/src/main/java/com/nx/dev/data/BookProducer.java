package com.nx.dev.data;

import com.nx.dev.model.Author;
import com.nx.dev.model.Book;

/**
 * Produces books with authors.
 */
public class BookProducer {

    /**
     * Get books with authors.
     *
     * @return array of {@link Book}
     */
    public Book[] getBooksWithAuthors() {
        Book[] books = getBooks();
        Author[] authors = getAuthors();

        books[0].addAuthors(authors[0], authors[1], authors[2]);
        authors[0].addBooks(books[0]);
        authors[1].addBooks(books[0]);
        authors[2].addBooks(books[0]);

        books[1].addAuthors(authors[3], authors[4], authors[5]);
        authors[3].addBooks(books[1]);
        authors[4].addBooks(books[1]);
        authors[5].addBooks(books[1]);

        books[2].addAuthors(authors[6], authors[7], authors[8]);
        authors[6].addBooks(books[2]);
        authors[7].addBooks(books[2]);
        authors[8].addBooks(books[2]);

        books[3].addAuthors(authors[9]);
        authors[9].addBooks(books[3]);

        books[4].addAuthors(authors[0], authors[9]);
        authors[0].addBooks(books[4]);
        authors[9].addBooks(books[4]);

        books[5].addAuthors(authors[1], authors[8]);
        authors[1].addBooks(books[5]);
        authors[8].addBooks(books[5]);

        books[6].addAuthors(authors[2], authors[7]);
        authors[2].addBooks(books[6]);
        authors[7].addBooks(books[6]);

        books[7].addAuthors(authors[3], authors[6]);
        authors[3].addBooks(books[5]);
        authors[6].addBooks(books[5]);

        books[8].addAuthors(authors[4], authors[5]);
        authors[4].addBooks(books[8]);
        authors[5].addBooks(books[8]);

        books[9].addAuthors(authors[2]);
        authors[2].addBooks(books[9]);

        return books;
    }

    private Book[] getBooks() {
        return new Book[]{
                new Book("Book 0", 153),
                new Book("Book 1", 144),
                new Book("Book 2", 102),
                new Book("Book 3", 103),
                new Book("Book 4", 255),
                new Book("Book 5", 77),
                new Book("Book 6", 11),
                new Book("Book 7", 192),
                new Book("Book 8", 84),
                new Book("Book 9", 201),
        };
    }

    private Author[] getAuthors() {
        return new Author[]{
                new Author("Author 0", (short) 65),
                new Author("Author 1", (short) 78),
                new Author("Author 2", (short) 44),
                new Author("Author 3", (short) 57),
                new Author("Author 4", (short) 23),
                new Author("Author 5", (short) 68),
                new Author("Author 6", (short) 92),
                new Author("Author 7", (short) 40),
                new Author("Author 8", (short) 33),
                new Author("Author 9", (short) 53),
        };
    }
}
