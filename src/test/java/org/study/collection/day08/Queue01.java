package org.study.collection.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Queue01 {

    @Test
    void create() {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new PriorityQueue<>();
    }

    @Test
    void add() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2); // 1, 2
    }

    @Test
    void poll() {
        Queue<String> queue = new LinkedList<>();

        queue.add("element 1");
        queue.add("element 2");
        queue.add("element 3");

        String element1 = queue.poll();     // if null return null

        String element2 = queue.remove();   // if null throw exception

        System.out.printf("%s %s\n", element1, element2);

        String element3 = queue.peek();

        System.out.printf("%s\n", element3);
    }

    @Test
    void etc() {
        Queue<String> queue = new LinkedList<>();
        queue.add("element 1");
        queue.add("element 2");
        queue.add("element 3");

        int size = queue.size();

        for (String element : queue) {
            // each element..
        }

        // Queue -> ArrayList
        List<String> list = new ArrayList<>(queue);

        // Queue clear
        queue.clear();
        Assertions.assertEquals(0, queue.size());
    }
}