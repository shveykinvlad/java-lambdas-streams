package com.nx.dev.collector;

import com.nx.dev.model.MathStatistic;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * A mutable reduction operation that accumulates input {@link IntStream} into a mutable result container.
 */
public class MathCollector implements Collector<Integer, MathStatistic, MathStatistic> {

    @Override
    public Supplier<MathStatistic> supplier() {
        return MathStatistic::new;
    }

    @Override
    public BiConsumer<MathStatistic, Integer> accumulator() {
        return MathStatistic::accumulate;
    }

    @Override
    public BinaryOperator<MathStatistic> combiner() {
        return MathStatistic::combine;
    }

    @Override
    public Function<MathStatistic, MathStatistic> finisher() {
        return MathStatistic::finish;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
