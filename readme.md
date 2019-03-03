This document contains homework tasks for `Module 1 - Lambdas & Streams`.



Task 1 - a Bit of Concurrency (Runnable)
=============================

**Cost**: 5 points.

Create several instances of Runnable interface with different behavior using lambda expressions. Run these lambdas via Thread API.



Task 2 - a Person Stream (Comparator)
========================

**Cost**: 5 points.

Create:

1. `Person` class with name and age fields.
1. A collection of `Person`s.
1. Two instances of `Comparator<Person>` interface using lambda expressions: first one for comparing by name, second one – by age.

Then sort them using these comparators. Use `forEach` method for printing information about all the persons. Try to use method reference if it is possible.



Task 3 - Functional Interface Sandbox (Functional interface)
=====================================

**Cost**: 10 points.

1. Implement each of main Java Standard Library functional interfaces (supplier, predicate, etc.) using lambda expressions.
1. Create your own functional interface and add several implementations using both lambda expressions and inner anonymous classes.
1. Add few default methods to it and use them.
1. Add few static methods to it and use them.



Task 4 - Custom Functional Interface (Three function)
====================================

**Cost**: 5 points.

1. Write your own functional interface ThreeFunction (it takes three arguments and produce result).
1. Implement this with two different lambdas.
1. Provide client code with usage of this lambdas.


Task 5 - Collection to Stream (Stream)
=============================

**Cost**: 20 points.

1. Create the following classes:
    * `Author` with fields
        * `String name`
        * `short age`
        * `List<Book> books`
    * `Book` with fields
        * `String title`
        * `List<Author> authors`
        * `int numberOfPages`

2. Create two arrays: `Author[] authors` and `Book[] books`. Their elements must use elements from the neighboring array.

3. Create a stream of books and then:
    1. check if some/all book(s) have more than 200 pages;
    2. find the books with max and min number of pages;
    3. filter books with only single author;
    4. sort the books by number of pages/title;
    5. get list of all titles;
    6. print them using `forEach` method;
    7. get distinct list of all authors.

4. Use `peek` method for debugging intermediate streams during execution the previous task.
5. Use parallel stream with subtask #3.
6. Analyze with mentor results of previous subtask execution, explain him the difference between stream and parallel stream.
7. Use the `Optional` type for determining the title of the biggest book of some author.



Task 6 - Custom Collector (Collector)
=========================

**Cost**: 20 points.

Define a complex class `A` with a few fields with different types. This class will be an item in collection.

Define a few methods which calculates some stat over the fields of the `A` class.

Make stream from the collection of `A`’s instances.

Write custom collector to accumulate the information from elements of your stream.

1. Implement `Collector` interface.
1. Don’t forget the final transformation.
1. Try to use `Characteristics` for the optimization purpose.
1. Add tests for your collector.

Test your `Collector` with the parallel streams for significant amount of items in stream. Look at the `Collector` interface and read about `combine` method if something is going wrong.



Task 7 - Math Collector for the IntStream (Math collector)
=========================================

**Cost**: 15 points.

Write a custom collector for the `IntStream` or integer generator like

```java
Stream.iterate(0, i -> i + 10).limit(1_000_000)
```

This collector should calculate the sum, count, average, min, max over the stream items.

Define your own object to keep math stats.

Add tests for your collector.

Tune performance with Characteristics and collect the results into the small performance report that should be attached to your final solution. Discuss with mentor the given results.

It should support parallel streams.



Task 8 - Magic Tree (Stream flatMap)
===================

**Cost**: 20 points.

You have class `Tree` with a few unsupported operations:

```java
class Tree {

    private int value;
    private List<Tree> children = new LinkedList<>();
    
    public Tree(int value, List<Tree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }
    
    public Tree(int value, Tree... children) {
        this(value, asList(children));
    }

    public int getValue() {
        return value;
    }

    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public Stream<Tree> flattened() {
        // ***
    }
}
```

Implement `flattened()` method. It should return Stream of all children in Pre-order.

E.g. for tree

```
      0
    /   \
   /     \
  1       2
 / \     / \
11 12   21 22
```

it should return

```
0 1 11 12 2 21 22
```

Also, add and implement next methods:

```java
// Get all values in the tree:
List<Integer> getAllValues()

// Get even values:
List<Integer> getEvenValues()

// Sum of even values:
Optional<Integer> sumOfEvenValues()

// Does it contain 13?
Boolean isContains13()
```



Penalties
=========

Penalties are easy:

* `-3` for each task if mentee ignores Java Code Conventions;
* `-4` for each missed first-level feature;
* `-2` for each missed second-level feature.
