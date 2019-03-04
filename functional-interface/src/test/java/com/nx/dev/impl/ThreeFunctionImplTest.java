package com.nx.dev.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link ThreeFunctionImpl}.
 */
class ThreeFunctionImplTest {

    private static final ThreeFunctionImpl THREE_FUNCTION = new ThreeFunctionImpl();

    @Test
    void parallelepipedArea() {
        var parallelepipedArea = THREE_FUNCTION.parallelepipedArea();
        assertEquals(Integer.valueOf(88), parallelepipedArea.apply(2, 4, 6), "Check parallelepiped area");
    }

    @Test
    void tripleStringConcat() {
        var tripleStringConcat = THREE_FUNCTION.tripleStringConcat();
        assertEquals("tripleStringConcatenation", tripleStringConcat.apply("triple", "String", "Concatenation"), "Check string concatenation");
    }
}