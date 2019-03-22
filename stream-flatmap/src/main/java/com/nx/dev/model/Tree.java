package com.nx.dev.model;

import static java.util.Arrays.asList;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tree domain class.
 */
@Data
public class Tree {

    private int value;
    private List<Tree> children = new LinkedList<>();

    private  Tree(int value, List<Tree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }

    public Tree(int value, Tree... children) {
        this(value, asList(children));
    }

    /**
     * Get flattened view of tree.
     */
    public Stream<Tree> flattened() {
        return Stream.concat(Stream.of(this), getChildren().stream().flatMap(Tree::flattened));
    }

    /**
     * Get all values in the tree.
     */
    public List<Integer> getAllValues() {
        return this.flattened().map(Tree::getValue).collect(Collectors.toList());
    }

    /**
     * Get even values in the tree.
     */
    public List<Integer> getEvenValues() {
        return this.getAllValues().stream().filter(v -> v % 2 == 0).collect(Collectors.toList());
    }

    /**
     * Get sum of even values in the tree.
     */
    public Optional<Integer> getSumOfEvenValues() {
        return this.getEvenValues().stream().reduce(Integer::sum);
    }

    /**
     * Checks for contain value 13 in the tree.
     */
    public Boolean isContains13() {
        return this.getAllValues().contains(13);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

