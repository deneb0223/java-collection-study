## SortedSet

----
### 개요
SortedSet은 Set을 구현한 인터페이스다. Set과 다르게 SortedSet은 순서를 보장하는 특징이 있다.

```java
public interface SortedSet<E> extends Set<E> {
```

----
### SortedSet 생성

SortedSet을 구현한 대표적인 구현체로 TreeSet이 있다.
```java
Set<String> set = new TreeSet<>();
SortedSet<String> sortedSet = new TreeSet<>();
```
예제 사이트에서는 SortedSet으로 변수 타입을 지정하였으나 Set으로 생성해도 무관하다.

----
### SortedSet 정렬 기준
SortedSet은 기본적으로 오름차순 정렬이다.
SortedSet은 Comparator 구현체를 바탕으로 정렬 기준을 정의할 수 있다.
혹은 객체의 명확한 정렬 기준이 있으면 Comparable을 구현해도 된다.

```java
Set<Car> cars = new TreeSet<>();
cars.add(new Car("Volvo V40" , "XYZ 201845", 5));
cars.add(new Car("Citroen C1", "ABC 164521", 4));
cars.add(new Car("Dodge Ram" , "KLM 845990", 2));
cars.forEach(System.out::println);


//getNoOfDoors 내림차순
Set<Car> carWithComp = new TreeSet<>((c1, c2) -> {
return c2.getNoOfDoors() - c1.getNoOfDoors();
});
```

----

### SortedSet tailSet

tailSet의 인자를 키값으로 검색한다.
그 후 해당 키값 이후의 값들을 SortedSet형식으로 반환한다.

```java
SortedSet sortedSet = new TreeSet();

sortedSet.add("a");
sortedSet.add("b");
sortedSet.add("c");
sortedSet.add("d");
sortedSet.add("e");

SortedSet tailSet = sortedSet.tailSet("c");
```

----

### SortedSet subSet

subMap은 map에서 부분적인 값을 가져올 때 사용한다.
이는 sortedSet이 정렬을 하여 순번이 보장되기 때문에 가능한 것이다.
sub계열 함수가 그렇듯 subSet(1, n)일 경우 1이상 n 미만의 값을 의미한다.
```java
SortedSet sortedSet = new TreeSet();

sortedSet.add("a");
sortedSet.add("b");
sortedSet.add("c");
sortedSet.add("d");
sortedSet.add("e");

SortedSet subSet = sortedSet.subSet("c", "e");
```

----

### 마치며
Set의 구현체인 SortedSet을 살펴보았다.<br>
기본적인 Set과 동일하지만 정렬이 보장되고 이로인한 tail, sub 관련 함수를 사용할 수 있다.