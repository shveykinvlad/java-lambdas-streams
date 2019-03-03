package com.nx.dev.comparator;

import com.nx.dev.model.Person;
import lombok.experimental.UtilityClass;

import java.util.Comparator;

/**
 * Comparator for {@link Person}.
 */
@UtilityClass
class PersonComparator {

    static Comparator<Person> compareByName() {
        return Comparator.comparing(Person::getName);
    }

    static Comparator<Person> compareByAge() {
        return (personOne, personTwo) -> personOne.getAge().compareTo(personTwo.getAge());
    }
}
