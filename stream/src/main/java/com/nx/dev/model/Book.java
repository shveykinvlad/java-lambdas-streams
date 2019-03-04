package com.nx.dev.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Book domain class.
 */
@Data
@EqualsAndHashCode(exclude = "authors")
@ToString(exclude = "authors")
@RequiredArgsConstructor
public class Book {

    private final String title;
    private final int numberOfPages;

    private List<Author> authors = new ArrayList<>();

    public void addAuthors(Author... authors) {
        this.authors.addAll(Arrays.asList(authors));
    }
}
