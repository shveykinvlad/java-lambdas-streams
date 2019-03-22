package com.nx.dev.collector;

import com.nx.dev.model.StringStatistics;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * A mutable reduction operation that accumulates input string into a mutable result container.
 */
public class ToStringStatistics implements Collector<String, StringStatistics, StringStatistics> {

    @Override
    public Supplier<StringStatistics> supplier() {
        return StringStatistics::new;
    }

    @Override
    public BiConsumer<StringStatistics, String> accumulator() {
        return StringStatistics::accumulate;
    }

    @Override
    public BinaryOperator<StringStatistics> combiner() {
        return StringStatistics::combine;
    }

    @Override
    public Function<StringStatistics, StringStatistics> finisher() {
        return StringStatistics::finish;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
