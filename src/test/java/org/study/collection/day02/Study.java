package org.study.collection.day02;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Study {

    static final Random random = new Random();

    @Test
    void list_01() {
        // List는 인터페이스다. List는 List 구현체를 생성자로 선언할 수 있다.
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
        List vector = new Vector();
        List stack = new Stack();
    }

    @Test
    void list_02() {
        List someList = new ArrayList();
        while (someList.size() <= 10) {
            someList.add(random.nextInt(100));
        }
        System.out.println(someList); // [82, 25, 36, 85, 54, 14, 19, 70, 77, 50, 70]
    }

    @Test
    void list_03() {
        List elements = new ArrayList();
        elements.add(1);        //Integer
        elements.add(2L);       //Long
        elements.add(3.2F);     //Float
        elements.add(6.443D);   //Double
        elements.add('c');      //Character
        elements.add("Bye");    //String
        elements.forEach(ele -> {
            System.out.println(ele + " : " + ele.getClass().getSimpleName());
        });
    }

    @Test
    void list_04() {
        // 정수타입만 저장하는 List를 생성하였다
        List onlyInteger = new ArrayList();
        onlyInteger.add(1);

        // 하지만 누군가 소수타입을 넣었다
        onlyInteger.add(7.5f);

        System.out.println(onlyInteger);    //[1, 7.5]
    }

    @Test
    void list_05() {
        List<Character> onlyCharacter = new ArrayList<Character>();
        onlyCharacter.add('h');
//        onlyCharacter.add(1);   //add(java.lang.Character)' in 'java.util.List' cannot be applied to '(i

        List<Double> onlyDouble = new ArrayList<>();
    }

    @Test
    void list_06() {
        @SuppressWarnings({"rawtypes"})
        List types = new ArrayList();
        types.add(1);
        types.add(1.2f);
    }
}
