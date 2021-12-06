package org.study.collection.day03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Set01 {
    @Test
    void setExample() {
        // ~JDK 1.8
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        assertTrue(set.contains("A"));

        // JDk 9 ~
        Set<String> set2 = Set.of("A","B","C");
        assertTrue(set2.contains("A"));
    }

    @Test
    void setLooping() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 5);

        // for-each
        for (Integer element : set) {
            // ..element
        }

        // stream
        set.stream().forEach(element -> {
            // ..element
        });

    }

    @Test
    void remove() {
        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");

        Set<String> set2 = new HashSet<>();
        set2.add("three");
        set.removeIf(el -> el.equals("three"));//JDK 1.8부터 지원
        set.removeAll(set2);
    }

    @Test
    void toList() {
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("456");

        // 일반적인 방법
        List<String> list = new ArrayList<>();
        list.addAll(set);

        // Array 기반
        List<String> withArray = new ArrayList<>(set);

        // Stream 사용
        List<String> withStream = set.stream()
                    .collect(Collectors.toList());
    }
}
