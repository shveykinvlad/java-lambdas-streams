package com.nx.dev.service;

import com.nx.dev.model.Author;
import com.nx.dev.model.Book;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Book service layer.
 */
@Log4j2
public class BookService {

    /**
     * Check if some book have number of pager more than parameter value.
     */
    public Boolean checkIfSomeBooksWithMoreThenNumberOfPages(Book[] books, int numberOfPages) {
        return Arrays.stream(books)
                .anyMatch(book -> book.getNumberOfPages() > numberOfPages);
    }

    /**
     * Check if all books have number of pager more than parameter value.
     */
    public Boolean checkIfAllBooksWithMoreThenNumberOfPages(Book[] books, int numberOfPages) {
        return Arrays.stream(books)
                .allMatch(book -> book.getNumberOfPages() > numberOfPages);
    }

    /**
     * Find the books with max number of pages.
     */
    public Book findBookWithMaxNumberOfPages(Book... books) {
        return Arrays.stream(books)
                .max(Comparator.comparing(Book::getNumberOfPages))
                .orElse(null);
    }

    /**
     * Find the books with min number of pages.
     */
    public Book findBookWithMinNumberOfPages(Book... books) {
        return Arrays.stream(books)
                .min(Comparator.comparing(Book::getNumberOfPages))
                .orElse(null);
    }

    /**
     * Filter books with only single author.
     */
    public Book[] filterBySingleAuthor(Book... books) {
        return Arrays.stream(books)
                .filter(book -> book.getAuthors().size() == 1)
                .toArray(Book[]::new);
    }

    /**
     * Filter books with only single author by parallel stream and peek.
     */
    public Book[] filterBySingleAuthorWithParallel(Book... books) {
        return Arrays.stream(books)
                .parallel()
                .peek(log::debug)
                .filter(book -> book.getAuthors().size() == 1)
                .toArray(Book[]::new);
    }

    /**
     * Sort the books by number of pages.
     */
    public Book[] sortByNumberOfPages(Book... books) {
        return Arrays.stream(books)
                .sorted(Comparator.comparing(Book::getNumberOfPages))
                .toArray(Book[]::new);
    }

    /**
     * Sort the books by title.
     */
    public Book[] sortByTitle(Book... books) {
        return Arrays.stream(books)
                .sorted(Comparator.comparing(Book::getTitle))
                .toArray(Book[]::new);
    }

    /**
     * Get list of all titles.
     */
    public List<String> getAllTitles(Book... books) {
        return Arrays.stream(books)
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    /**
     * Print titles.
     */
    public void printTitles(List<String> titles) {
        titles.forEach(log::info);
    }

    public List<Author> getAuthors(Book... books) {
        return Arrays.stream(books)
                .map(Book::getAuthors)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Use the Optional type for determining the title of the biggest book of some author.
     */
    public Optional<String> getBiggestBookTitle(Author author) {
        return author.getBooks().stream().max(Comparator.comparing(Book::getNumberOfPages)).map(Book::getTitle);
    }
}
