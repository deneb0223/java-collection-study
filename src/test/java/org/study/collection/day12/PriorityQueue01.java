package org.study.collection.day12;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue01 {
    @Test
    public void crate() {
        Queue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> listWithQueue = new PriorityQueue<>();
    }

    @Test
    public void insert() {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(1);queue.add(2);queue.add(3);queue.add(4);
        System.out.println(queue);
        queue.poll();// 4
    }
}
