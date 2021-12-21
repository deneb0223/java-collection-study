package org.study.collection.day11;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LinkedHashMap01 {

    @Test
    void create() {
        // HashMap을 상속받은 LinkedHashMap
        HashMap<String, String> hashMap = new LinkedHashMap<>();

        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "hello");
        map.put("2", "good");
        map.put("3", "bye");

        System.out.println(map);
    }

    @Test
    void mapToList() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "hello");
        map.put("2", "good");
        map.put("3", "bye");

        // Map의 Value들을 List화 시킨다
        List<String> mapValues = new ArrayList<>(map.values());
        System.out.println(mapValues);

        // Map의 Key들을 List화 시킨다
        List<String> mapKeys = new ArrayList<>(map.keySet());
        System.out.println(mapKeys);

    }
}
