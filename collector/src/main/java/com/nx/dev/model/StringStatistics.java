package com.nx.dev.model;

import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Accumulates input string into information container.
 */
@Data
public class StringStatistics {

    private Map<String, Integer> stringFrequencyMap = new HashMap<>();
    private String mostCommonString;
    private String leastCommonString;
    private String longestString;
    private String shortestString;
    private int count;

    /**
     * Get combinations of two string statistics.
     *
     * @param a string statistics one
     * @param b string statistics two
     * @return combination of two string statistics
     */
    public static StringStatistics combine(StringStatistics a, StringStatistics b) {
        b.stringFrequencyMap.forEach((key, value) -> a.stringFrequencyMap.merge(key, value, Integer::sum));
        a.count = a.count + b.count;

        return a;
    }

    /**
     * Add string value to string statistics.
     *
     * @param a      statistics
     * @param string value
     * @return String statistics with added value
     */
    public static StringStatistics accumulate(StringStatistics a, String string) {
        a.stringFrequencyMap.putIfAbsent(string, 0);
        a.stringFrequencyMap.put(string, a.stringFrequencyMap.get(string) + 1);
        a.count++;

        return a;
    }

    /**
     * Final statistics calculation (calculate most and least common string, longest and shortest string).
     */
    public static StringStatistics finish(StringStatistics a) {
        a.mostCommonString = Collections.max(a.stringFrequencyMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        a.leastCommonString = Collections.min(a.stringFrequencyMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        a.longestString = a.stringFrequencyMap.keySet().stream().max(Comparator.comparing(String::length)).orElse(null);
        a.shortestString = a.stringFrequencyMap.keySet().stream().min(Comparator.comparing(String::length)).orElse(null);

        return a;
    }
}
