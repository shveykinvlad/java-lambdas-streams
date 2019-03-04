package com.nx.dev.impl;

import com.nx.dev.functional.ThreeFunction;

/**
 * Examples of {@link ThreeFunction}.
 */
class ThreeFunctionImpl {

    ThreeFunction<Integer, Integer, Integer, Integer> parallelepipedArea() {
        return (a, b, c) -> 2 * (a * b + b * c + a * c);
    }

    ThreeFunction<String, String, String, String> tripleStringConcat() {
        return (a, b, c) -> a + b + c;
    }
}

