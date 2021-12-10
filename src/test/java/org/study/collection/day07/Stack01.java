package org.study.collection.day07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack01 {
    @Test
    void create() {
        Stack stack = new Stack();
        Stack<Integer> intStack = new Stack<>();
        List stackWithList = new Stack();
    }


    @Test
    void action() {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        String ele = stack.pop(); //C

        String peek = stack.peek(); //B
    }

    @Test
    void search() {
        Stack<String> stack = new Stack<String>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        int index = stack.search("3");     //index = 3

        int size = stack.size();        //size = 3

    }

    @Test
    void util() {
        Stack<String> stack = new Stack<String>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        // stack -> list
        List<String> list = new ArrayList<>(stack);

        // list -> stack
        Stack<String> listToStack = new Stack<>();
        while(list.size() > 0) {
            listToStack.push(list.remove(0));
        }
    }
}
