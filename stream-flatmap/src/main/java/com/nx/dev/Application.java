package com.nx.dev;

import com.nx.dev.data.TreeProducer;
import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;

/**
 * Main class.
 */
@Log4j2
public class Application {

    public static void main(String[] args) {
        var tree = TreeProducer.createTree();

        log.info("Flattened result: {}", tree.flattened().collect(Collectors.toList()));
        log.info("All values: {} ", tree.getAllValues());
        log.info("Even values: {} ", tree.getEvenValues());
        log.info("Sum of even values: {}", tree.getSumOfEvenValues());
        log.info("Does tree contains 13: {}", tree.isContains13());
    }
}
