package org.study.collection.day01;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Study {
    @Test
    void array() {
        int[] arr = new int[10];
        for (int i : arr) {
            //System.out.println(i); // 0, 0, 0...
        }
    }


    @Test
    void array2() {
        String[] names = new String[]{"lee", "kim", "park"};
        String newName = "yoo"; // names에 새로운 name이 들어가야한다면?
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            names[3] = newName; // ArrayIndexOutOfBoundsException 발생
        });
    }

    @Test
    void someStrangeData() {
        // 사과는 빨갛다. 이 두가지의 의미를 묶어서 저장하고 싶다면
        String name = "APPLE";
        String color = "RED";
    }

    @Test
    void collection_01() {
        Collection collection = new ArrayList();
        collection.add("A");
        collection.add("B");
        assertEquals(2, collection.size());
    }

    public static void doIter(Collection collection) {
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }
    }

    @Test
    void collection_02() {
        Collection<String> names = new ArrayList<>();
        names.add("lee");
        names.add("kim");
        names.add("park");
        doIter(names);  // lee, kim, park

        Collection<Integer> numbers = new LinkedList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        doIter(numbers);  // 2, 3, 4
        
        
        // Collection들은 동적으로 추가해도 문제가 없으며
        assertDoesNotThrow(() -> {
            names.add("yoo");
        });

        // 삭제도 자유롭게 할 수 있디.
        names.remove("yoo");
        assertFalse(names.contains("yoo"));
    }

    @Test
    void collection_03() {
        List<String> koreaNames = new ArrayList<>();
        koreaNames.add("김");
        koreaNames.add("이");
        koreaNames.add("박");
        assertEquals(3, koreaNames.size());

        List<String> japanesNames = new ArrayList<>();
        japanesNames.add("まつだ");
        japanesNames.add("なかむら");
        japanesNames.add("まつもと");

        // addAll 기능 : 특정 컬렉션의 모든 데이터를 추가
        Collection<String> globalNames = new ArrayList<>();
        globalNames.addAll(koreaNames);
        globalNames.addAll(japanesNames);
        assertEquals(6, globalNames.size());

        // retainAll 기능 : 특정 컬렉션의 데이터를 유지
        globalNames.retainAll(japanesNames);    // まつだ, なかむら,まつもと..
        assertEquals(3, globalNames.size());
    }
}
