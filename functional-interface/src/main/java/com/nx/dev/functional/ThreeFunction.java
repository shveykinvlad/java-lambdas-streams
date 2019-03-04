package com.nx.dev.functional;

/**
 * Represents a function that accepts three arguments and produces a result.
 * This is the three-arity specialization of {@link java.util.function.Function}.
 *
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function
 * @param <S> the type of the third argument to the function
 * @param <R> the type of the result of the function
 */
@FunctionalInterface
public interface ThreeFunction<T, U, S, R> {

    R apply(T var1, U var2, S var3);
}
