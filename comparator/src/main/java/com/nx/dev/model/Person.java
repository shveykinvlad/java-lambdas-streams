package com.nx.dev.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person domain class.
 */
@Data
@AllArgsConstructor
public class Person {

    private String name;
    private Integer age;
}
