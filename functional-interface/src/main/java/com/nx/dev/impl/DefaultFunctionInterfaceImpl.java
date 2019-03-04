package com.nx.dev.impl;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Implementations of default functional interfaces.
 */
@UtilityClass
@Log4j2
public class DefaultFunctionInterfaceImpl {

    public static Supplier<String> supplier() {
        return () -> "";
    }

    public static Consumer consumer() {
        return log::info;
    }

    public static Predicate predicate() {
        return Objects::nonNull;
    }

    public static UnaryOperator unaryOperator() {
        return object -> {
            log.info(object);
            return object;
        };
    }

    public static BinaryOperator<String> binaryOperator() {
        return (stringOne, stringTwo) -> stringOne + stringTwo;
    }


    public static Function<Object, String> function() {
        return Object::toString;
    }
}
