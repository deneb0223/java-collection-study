## Collections Sort

----
### 개요
 컬렉션 프레임워크의 내부 요소를 정렬한다

----
### Collections

Collections 유틸리티에서 제공하는 sort()를 이용한다.


```java
List<Integer> list = new ArrayList<>();
list.add(100);
list.add(99);
list.add(98);
Collections.sort(list);
```

두번째 인자로 Comparator를 명시하여 정렬 기준을 변경할 수 있다.<br>

```java
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
Collections.sort(list, descComp);
```

Java8부터는 람다식을 이용하여 간결하게 표현가능하다.<br>
개인적으로는 람다식으로 표현하는 것을 선호한다

```java
Collections.sort(list, (a, b) -> b -a);
```
----