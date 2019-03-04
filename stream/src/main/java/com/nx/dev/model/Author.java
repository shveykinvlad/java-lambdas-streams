package com.nx.dev.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author domain class.
 */
@Data
@EqualsAndHashCode(exclude = "books")
@ToString(exclude = "books")
@RequiredArgsConstructor
public class Author {

    private final String name;
    private final int age;
    private List<Book> books = new ArrayList<>();

    public void addBooks(Book... books) {
        this.books.addAll(Arrays.asList(books));
    }
}
