package com.nx.dev.comparator;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import com.nx.dev.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Unit test for {@link PersonComparator}.
 */
class PersonComparatorTest {

    private static final String PATRICK = "Patrick";
    private static final String MARK = "Mark";
    private static final String BILL = "Bill";

    private static List<Person> persons = Arrays.asList(
            new Person(MARK, 34),
            new Person(BILL, 43),
            new Person(PATRICK, 25));

    @Test
    @DisplayName("Compare by name")
    void compareByName() {
        var expected = Arrays.asList(
                new Person(BILL, 43),
                new Person(MARK, 34),
                new Person(PATRICK, 25));
        Collections.shuffle(persons);
        persons.sort(PersonComparator.compareByName());

        assertIterableEquals(expected, persons);
    }

    @Test
    @DisplayName("Compare by age")
    void compareByAge() {
        var expected = Arrays.asList(
                new Person(PATRICK, 25),
                new Person(MARK, 34),
                new Person(BILL, 43));
        Collections.shuffle(persons);
        persons.sort(PersonComparator.compareByAge());

        assertIterableEquals(expected, persons);
    }
}