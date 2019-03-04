package com.nx.dev;

import com.nx.dev.data.BookProducer;
import com.nx.dev.model.Author;
import com.nx.dev.model.Book;
import com.nx.dev.service.BookService;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;

/**
 * Application main class.
 */
@Log4j2
public class Application {

    /**
     * Run application.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        var bookService = new BookService();
        var bookProducer = new BookProducer();

        Book[] books = bookProducer.getBooksWithAuthors();

        log.info("1. Check if some book have more than 200 pages.");
        log.info("For some book: {}", bookService.checkIfSomeBooksWithMoreThenNumberOfPages(books, 200));
        log.info("For all books: {} \n", bookService.checkIfAllBooksWithMoreThenNumberOfPages(books, 200));

        log.info("2. Find the books with max and min number of pages.");
        log.info("Min number of pages: {}", bookService.findBookWithMinNumberOfPages(books));
        log.info("Max number of pages: {} \n", bookService.findBookWithMaxNumberOfPages(books));

        log.info("3. Filter books with only single author.");
        log.info("Filtered list: {} \n", Arrays.toString(bookService.filterBySingleAuthor(books)));

        log.info("4. Sort the books by number of pages/title.");
        log.info("Sorted by pages: {}", Arrays.toString(bookService.sortByNumberOfPages(books)));
        log.info("Sorted by title: {} \n", Arrays.toString(bookService.sortByTitle(books)));

        log.info("5. Get list of all titles.");
        List<String> titles = bookService.getAllTitles(books);
        log.info("6. Print them using forEach method.");
        bookService.printTitles(titles);

        log.info("7. Get distinct list of all authors.");
        List<Author> authors = bookService.getAuthors(books);
        log.info(authors + "\n");

        log.info("8. Use peek method for debugging intermediate streams during execution the previous task.");
        log.info("9. Use parallel stream with sub task #3.");
        log.info("Filtered list: {} \n", Arrays.toString(bookService.filterBySingleAuthorWithParallel(books)));

        log.info("10. Use the Optional type for determining the title of the biggest book of some author.");
        Author author = authors.get(5);
        log.info("Biggest book of {} is {} \n", author, bookService.getBiggestBookTitle(author).orElse(null));
    }
}
