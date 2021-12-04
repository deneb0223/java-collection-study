package org.study.collection.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Study2 {

    static List<Integer> numbers = new ArrayList<>();

    @BeforeAll
    void init_list() {
        numbers = new Random()
                .ints(10, 1, 11)
                .boxed()
                .collect(toList());
    }

    @Test
    void add_element() {
        numbers.add(10);                      // 가장 끝에 추가(Queue가 생각난다)
        numbers.add(0, 999);    // 0번째 인덱스에 추가

        System.out.println(numbers);

        numbers.addAll(List.of(1000, 1000));

        System.out.println(numbers);        // 1000, 1000을 추가
    }

    @Test
    void get_element() {
        numbers.add(0, 999);

        assertEquals(999, numbers.get(0));

        assertEquals(0, numbers.indexOf(999)); //있으면 해당 index를 반환

        assertEquals(-1, numbers.indexOf(1000));//없으면 -1을 반환

        assertEquals(true, numbers.contains(999));  //해당 값을 자지고 있는지 확인
    }

    @Test
    void remove_element() {
        List<String> someList = new ArrayList<>();
        someList.add("Hello");
        someList.add("Bye");
        someList.add("Fine");

        someList.remove("Hello");      //요소값으로 제거

        someList.remove(0);         //순번으로 제거

        someList.removeIf(str -> str.equals("Fine"));
        // 자바8부터 추가된 removeIf기능 인자값으로 Predicate를 사용한다.
        // 별도의 equals 함수를 내부에 구현하지 않아도 되는 장점이 있다!

        someList.add("Good");
        someList.clear(); //내부의 요소들을 다 지운다
        assertEquals(0, someList.size());
    }

    @Test
    void compare_element() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volvo V40" , "XYZ 201845", 5));
        cars.add(new Car("Citroen C1", "ABC 164521", 4));
        cars.add(new Car("Dodge Ram" , "KLM 845990", 2));

//        Collections.sort(cars);     // Car객체 내부에 Comparable를 상속 받아 구현
//        System.out.println(cars);   // 다만 Collections를 활용하면 원본데이터가 수정된다.
//        원본은 유지한채 정렬된 값을 사용하고자 하는 경우 stream을 활용한 방법도 있다.

        List<Car> sortedByBrandNameCars = cars.stream()
                .sorted((car1, car2)
                        -> car1.brand.compareTo(car2.brand))
                .collect(toList());
        System.out.println(cars);   // 원본은 유지!
        System.out.println(sortedByBrandNameCars);

        //하지만 sorted함수에 매번 Comparator를 넣기 귀찮다면?
        Comparator<Car> orderByBrandName  = (car1, car2) -> car1.brand.compareTo(car2.brand);
        Comparator<Car> orderByNoOfDoors  = (car1, car2) -> car1.noOfDoors - car2.noOfDoors;
        Comparator<Car> orderByNumberPlate  = (car1, car2) -> car1.numberPlate.compareTo(car2. numberPlate);

        // 람다식을 sorted에 넣는 것 보단 의미가 보인다.
        List<Car> sortedByNoOfDoors = cars.stream()
                .sorted(orderByNoOfDoors)
                .collect(toList());
        System.out.println(sortedByNoOfDoors);
    }


    @Test
    void for_loop() {
        List<String> list = new ArrayList();

        list.add("first");
        list.add("second");
        list.add("third");

        // Iterator를 사용한 방법으로 순환한다.
        // Collection은 iterator를 구현했기 때문에 사용가능하다.
        // 순서대로 순환한다.
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
        }

        // index 기반으로 loop를 가장 단순한 방법이다.
        // index 정보가 있기 때문에 index와 관련된 작업일 경우 사용하는 것이 좋다
        for (int i = 0; i < list.size(); i++) {
            String ele = list.get(i);
        }

        // forEach 방식
        // 코드가 가장 단순하며, 요소를 get하는 작업을 하지 않아도 된다.
        // 개인적으로 index가 필요없다면 자주 사용하는 방법이다.
        for (String ele : list) {
            // ele
        }

        // stream 방식
        // 자바 8부터 추가된 순환 방식이다.
        list.stream().forEach(str -> {
            // str..
        });
    }
}
