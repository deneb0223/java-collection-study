package org.study.collection.day05;


import org.junit.jupiter.api.Test;

import java.util.*;

public class SortedSet01 {

    @Test
    void create() {
        Set<String> set = new TreeSet<>();
        SortedSet<String> sortedSet = new TreeSet<>();
    }

    @Test
    void sort() {
        Set<Car> cars = new TreeSet<>();
        cars.add(new Car("Volvo V40" , "XYZ 201845", 5));
        cars.add(new Car("Citroen C1", "ABC 164521", 4));
        cars.add(new Car("Dodge Ram" , "KLM 845990", 2));

        //getNoOfDoors 내림차순
        Set<Car> carWithComp = new TreeSet<>((c1, c2) -> {
            return c2.getNoOfDoors() - c1.getNoOfDoors();
        });

        carWithComp.add(new Car("Volvo V40" , "XYZ 201845", 5));
        carWithComp.add(new Car("Citroen C1", "ABC 164521", 4));
        carWithComp.add(new Car("Dodge Ram" , "KLM 845990", 2));


        carWithComp.forEach(System.out::println);
    }

    @Test
    void tailSet() {
        SortedSet sortedSet = new TreeSet();

        sortedSet.add("a");
        sortedSet.add("b");
        sortedSet.add("c");
        sortedSet.add("d");
        sortedSet.add("e");

        SortedSet tailSet = sortedSet.tailSet("c");
    }

    @Test
    void subSet() {
        SortedSet sortedSet = new TreeSet();

        sortedSet.add("a");
        sortedSet.add("b");
        sortedSet.add("c");
        sortedSet.add("d");
        sortedSet.add("e");

        SortedSet subSet = sortedSet.subSet("c", "e");
    }
}
