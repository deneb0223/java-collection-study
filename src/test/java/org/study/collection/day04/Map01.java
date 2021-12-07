package org.study.collection.day04;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Map01 {

    @Test
    void create() {
        Map mapA = new HashMap();
        Map mapB = new TreeMap();
    }

    @Test
    void create_with_generic() {
        Map<String, String> map = new HashMap<>();
    }

    @Test
    void put() {
        Map<String, String> map = new HashMap<>();

        map.put("key1", "element 1");
        map.put("key2", "element 2");
        map.put("key3", "element 3");

        map.put(null, "null element");

        Assertions.assertEquals( "null element", map.get(null));
    }

    @Test
    void putAll() {
        Map<String, String> mapA = new HashMap<>();
        mapA.put("key1", "value1");
        mapA.put("key2", "value2");

        Map<String, String> mapB = new HashMap<>();
        mapB.put("key3", "value3");
        mapB.putAll(mapA);

        mapB.entrySet().stream().forEach(System.out::println);
        /*
            key1=value1
            key2=value2
            key3=value3
        * */
    }

    @Test
    void contain() {
        Map<String, String> map = new HashMap<>();

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");

        boolean hasKey = map.containsKey("A");
        assertTrue(hasKey);

        boolean hasValue = map.containsValue("1");
        assertTrue(hasValue);
    }

    @Test
    void sort() {
        Map<String, Integer> map = new HashMap<>();

        map.put("C", 1);
        map.put("B", 1);
        map.put("A", 1);
    
        // 기본적으로 Key를 오름차순 함
        Map<String, Integer> sortedMap = new TreeMap<>(map);
        sortedMap.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }
}
