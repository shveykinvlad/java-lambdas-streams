package com.nx.dev.model;

import lombok.Data;

import java.util.stream.IntStream;

/**
 * Accumulates input {@link IntStream} into information container.
 */
@Data
public class MathStatistic {

    private int sum;

    private int count;

    private double average;

    private int min;

    private int max;

    /**
     * Get combinations of two math statistics.
     *
     * @param a math statistics one
     * @param b math statistics two
     * @return combination of two math statistics
     */
    public static MathStatistic combine(MathStatistic a, MathStatistic b) {
        a.sum = a.sum + b.sum;
        a.max = a.max > b.max ? a.max : b.max;
        a.min = a.min < b.min ? a.min : b.min;
        a.count = a.count + b.count;
        a.average = (double) a.sum / a.count;

        return a;
    }

    /**
     * Add int value to math statistics.
     *
     * @param a       statistics
     * @param integer value
     * @return Math statistics with added value
     */
    public static MathStatistic accumulate(MathStatistic a, int integer) {
        a.sum = a.sum + integer;
        a.max = a.max > integer ? a.max : integer;
        a.min = a.min < integer ? a.min : integer;
        a.count++;
        a.average = (double) a.sum / a.count;

        return a;
    }

    /**
     * Final statistics calculation.
     */
    public static MathStatistic finish(MathStatistic a) {
        return a;
    }
}
