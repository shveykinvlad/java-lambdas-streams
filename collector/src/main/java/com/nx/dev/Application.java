package com.nx.dev;

import com.google.common.base.Stopwatch;
import com.nx.dev.collector.ToStringStatistics;
import com.nx.dev.data.StringsProducer;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

/**
 * Application main class.
 */
@Log4j2
public class Application {

    private static final int MAX_STRING_LENGTH = 10;
    private static final int ARRAY_LENGTH = 500;

    /**
     * Run application.
     */
    public static void main(String[] args) {
        var stopwatch = new Stopwatch();
        var toStringStatistics = new ToStringStatistics();

        log.info("Use collector in stream of random array: ");
        stopwatch.start();
        log.info(Arrays.stream(StringsProducer.randomArrayOfStrings(ARRAY_LENGTH, MAX_STRING_LENGTH)).collect(toStringStatistics));
        stopwatch.stop();
        log.info("Stream execution time: {} \n", stopwatch.elapsedMillis());
        stopwatch.reset();
        log.info("Use collector in parallel stream of random array: ");
        stopwatch.start();
        log.info(Arrays.stream(StringsProducer.randomArrayOfStrings(ARRAY_LENGTH, MAX_STRING_LENGTH)).parallel().collect(toStringStatistics));
        stopwatch.stop();
        log.info("Parallel stream execution time: {} \n", stopwatch.elapsedMillis());

        log.info("Use collector in stream of static array: ");
        log.info("{}\n", Arrays.stream(StringsProducer.staticArrayOfStrings()).collect(toStringStatistics));

        log.info("Use collector in parallel stream of static array: ");
        log.info("{}\n", Arrays.stream(StringsProducer.staticArrayOfStrings()).parallel().collect(toStringStatistics));
    }
}
