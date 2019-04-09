package com.nx.dev.collector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nx.dev.model.MathStatistic;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Unit test for {@link MathCollector}.
 */
class MathCollectorTest {

    private MathCollector mathCollector = new MathCollector();

    @Test
    void supplier() {
        assertEquals(new MathStatistic(), mathCollector.supplier().get());
    }

    @Test
    void accumulator() {
        var mathStatistic = new MathStatistic();
        mathStatistic.setSum(19);
        mathStatistic.setMax(7);
        mathStatistic.setMin(3);
        mathStatistic.setCount(4);
        mathStatistic.setAverage(4.75);

        var accumulatedValue = 9;

        mathCollector.accumulator().accept(mathStatistic, accumulatedValue);

        assertEquals(28, mathStatistic.getSum());
        assertEquals(9, mathStatistic.getMax());
        assertEquals(3, mathStatistic.getMin());
        assertEquals(5, mathStatistic.getCount());
        assertEquals(5.6, mathStatistic.getAverage());
    }

    @Test
    void combiner() {
        MathStatistic firstMathStatistic = new MathStatistic();
        firstMathStatistic.setSum(19);
        firstMathStatistic.setMax(7);
        firstMathStatistic.setMin(3);
        firstMathStatistic.setCount(4);
        firstMathStatistic.setAverage(4.75);

        MathStatistic secondMathStatistic = new MathStatistic();
        secondMathStatistic.setSum(15);
        secondMathStatistic.setMax(5);
        secondMathStatistic.setMin(1);
        secondMathStatistic.setCount(5);
        secondMathStatistic.setAverage(3);

        mathCollector.combiner().apply(firstMathStatistic, secondMathStatistic);

        assertEquals(34, firstMathStatistic.getSum());
        assertEquals(7, firstMathStatistic.getMax());
        assertEquals(1, firstMathStatistic.getMin());
        assertEquals(9, firstMathStatistic.getCount());
        assertEquals(3.77, firstMathStatistic.getAverage(), 0.01);
    }

    @Test
    void finisher() {
        var mathStatistic = new MathStatistic();
        mathStatistic.setSum(19);
        mathStatistic.setMax(7);
        mathStatistic.setMin(3);
        mathStatistic.setCount(4);
        mathStatistic.setAverage(4.75);

        mathCollector.finisher().apply(mathStatistic);

        assertEquals(19, mathStatistic.getSum());
        assertEquals(7, mathStatistic.getMax());
        assertEquals(3, mathStatistic.getMin());
        assertEquals(4, mathStatistic.getCount());
        assertEquals(4.75, mathStatistic.getAverage());
    }

    @Test
    void calculate() {
        MathStatistic mathStatistic = Stream.iterate(0, i -> i + 10).limit(1_000_000).collect(mathCollector);

        assertEquals(653067456, mathStatistic.getSum());
        assertEquals(9999990, mathStatistic.getMax());
        assertEquals(0, mathStatistic.getMin());
        assertEquals(1000000, mathStatistic.getCount());
        assertEquals(653.06, mathStatistic.getAverage(), 0.01);
    }
}