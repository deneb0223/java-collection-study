package org.study.collection.day09;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Deque01 {

    @Test
    void create() {
        Deque<String> deque = new LinkedList<>();
        Deque<String> deque1 = new ArrayDeque<>();
    }

    @Test
    void add() {
        // Deque는 요약하자면 Queue, Stack 처럼 요소를 제어할 수 있는 Queue이다.

        Deque<String> deque = new LinkedList<>();
        deque.add("1");

        deque.addLast("2");
        deque.addLast("3");     // tail
        deque.addFirst("4");    // head

        deque.offer("1");
        deque.offerLast("3");
        deque.offerFirst("4");

        deque.push("100");      // addFirst, offerFirst와 동일함

        System.out.println(deque);
    }

    @Test
    void peek() {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            deque.add(i);
        }

        int firstEl = deque.peekFirst();
        int lastEl = deque.peekLast();

        System.out.println(firstEl);    // 1
        System.out.println(lastEl);     // 10
    }

    @Test
    void remove() {
    }
}