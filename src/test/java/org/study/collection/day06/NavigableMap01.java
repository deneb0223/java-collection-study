package org.study.collection.day06;

import org.junit.jupiter.api.Test;

import java.util.*;

public class NavigableMap01 {
    @Test
    void create() {
        NavigableMap navigableMap = new TreeMap();
    }

    @Test
    void createWithComparator() {
        Comparator<Integer> someComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        NavigableMap navigableMap = new TreeMap(someComp);
    }

    @Test
    void descending() {
        NavigableMap<String, String> original = new TreeMap<>();
        original.put("1", "1");
        original.put("2", "2");
        original.put("3", "3");

        NavigableSet<String> descKeySet = original.descendingKeySet();
        for (String key : descKeySet) {
            System.out.println(key);    // 3 ,2 ,1
        }
        NavigableMap<String, String> descMap = original.descendingMap();
        for (Map.Entry<String, String> entry : descMap.entrySet()) {
            // 3, 2, 1
        }

        //headMap()
        Map<String, String> headMap = original.headMap("3");
        System.out.println(headMap);    //{1=1, 2=2}

        //headMap() with "inclusive"=true
        Map<String, String> headMapWithInclusive = original.headMap("3", true);
        System.out.println(headMapWithInclusive);   //{1=1, 2=2, 3=3}
    }

    @Test
    void subMap() {
        NavigableMap<String, String> original = new TreeMap<>();
        original.put("1", "1");
        original.put("2", "2");
        original.put("3", "3");
        original.put("4", "4");
        original.put("5", "5");

        SortedMap<String, String> submap1  = original.subMap("2", "4");

        NavigableMap<String, String> submap2 =
                original.subMap("2", true, "4", true);
    }
}
