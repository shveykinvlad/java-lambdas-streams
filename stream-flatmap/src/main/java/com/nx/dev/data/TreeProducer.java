package com.nx.dev.data;

import com.nx.dev.model.Tree;
import lombok.experimental.UtilityClass;

/**
 * Produce complex tree.
 */
@UtilityClass
public class TreeProducer {

    /**
     * Get tree with sub trees.
     */
    public static Tree createTree() {
        var tree11 = new Tree(11);
        var tree12 = new Tree(12);
        var tree21 = new Tree(21);
        var tree22 = new Tree(22);
        var tree1 = new Tree(1, tree11, tree12);
        var tree2 = new Tree(2, tree21, tree22);

        return new Tree(0, tree1, tree2);
    }
}
