package org.study.collection.day10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting01 {
    @Test
    void sort_01() {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(99);
        list.add(98);
        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    void sort_02() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Comparator<Integer> descComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
//        Collections.sort(list, descComp);

        Collections.sort(list, (a, b) -> b -a);
        System.out.println(list);//[3, 2, 1]
    }
}
