## Set

----
### 개요
Set은 Collection의 구현체다.<br>
Set에는 EnumSet, HashSet, LinkedHashSet, TreeSet이 있다.<br>
Set은 내부적으로 HashMap으로 동작하는데 실제 코드를 살펴 보면

```java
public HashSet() {
    map = new HashMap<>();
}
```
실제 데이터를 HashMap을 정의하여 저장하는 것을 확인할 수 있다.<br>

List와의 차이점?<br>
- Set은 중복을 허용하지 않는다.(내부적으로 hashMap이기 때문)
- List와 다르게 Set은 순서를 보장하지 않는다(LinkedHashSet 예외)


----
### Set의 생성과 추가

```java
// ~JDK 1.8
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
assertTrue(set.contains("A"));

// JDk 9 ~ (단 불변타입으로 생성됨)
Set<String> set2 = Set.of("A","B","C");
assertTrue(set2.contains("A"));
```

----
### Set 순환
List와 달리 get() 메소드는 없다.

```java
Set<Integer> set = Set.of(1, 2, 3, 4, 5, 5);

// for-each
for (Integer element : set) {
    // ..element
}

// stream
set.stream().forEach(element -> {
    // ..element
});
```

----
### Set 제거
```java
Set<String> set = new HashSet<>();
set.add("one");
set.add("two");
set.add("three");

Set<String> set2 = new HashSet<>();
set2.add("three");
set.removeIf(el -> el.equals("three"));//JDK 1.8부터 지원
set.removeAll(set2);
```


----
### Set -> List 변환

```java
Set<String> set = new HashSet<>();
set.add("123");
set.add("456");

// 일반적인 방법
List<String> list = new ArrayList<>();
list.addAll(set);

// Array 기반
List<String> withArray = new ArrayList<>(set);

// Stream 사용
List<String> withStream = set.stream()
            .collect(Collectors.toList());
```

----
### 마치며
Set은 List와의 호환성이 좋다. Set은 중복이 없는 자료타입(특히 ENUM)과의 호환이 좋으며
contains를 통한 조회 성능이 List에 비해 우월하다.<br>

- 출저 : https://www.baeldung.com/java-hashset-arraylist-contains-performance
