## Queue

----
### 개요
Queue은 List의 구현체다. Queue는 Stack과 반대되는 특성이 있다.<br>

1. 가장 처음 들어온 값이 가장 처음 나간다. (FIFO)
2. Queue는 인터페이스라 LinkedList, PriorityQueue등의 구현체로 선언해야한다.

이 밖에 List에 제공하는 기능은 비슷하다.

----
### 생성

LinkedList, PriorityQueue를 이용하여 선언 가능하다. <br>
이 중 LinkedList가 Queue의 표준구현체에 가깝기 때문에 LinkedList로 많이 사용한다. <br>

```java
Queue<Integer> queue = new LinkedList<>();
Queue<Integer> queue1 = new PriorityQueue<>();
```

----
### 추가

요소를 추가는 add(), offer() 메소드를 사용한다.<br>
둘의 차이는 add()는 추가가 실패할 경우 예외를 offer()는 false를 반환한다.

```java
Queue<Integer> queue = new LinkedList<>();
queue.add(1);       // throw exception
queue.offer(2);     // return false
```

----
### 꺼내기

요소를 꺼내고자 하는 경우 poll(), remove()를 사용한다.<br>
poll()은 요소가 없는 경우 예외를 remove()는 false를 반환한다.

```java
String element1 = queue.poll();     // if null return null

String element2 = queue.remove();   // if null throw exception
```

----
### 최근 요소 탐색

peek() 메소드를 이용해 최신 요소를 확인한다.<br>
이는 Stack과 동일하다. peek()의 반환 값이 poll 대상이다.

```java
String element3 = queue.peek();
```

내부에 요소가 없는 경우 EmptyStackException을 발생시킨다.


----
### 탐색

queue 내부에서 값에 해당하는 요소가 있는지 판별한다.
결과에 따라 true/false가 반환된다.

```java
Queue<String> queue = new LinkedList<>();
queue.add("element 1");
queue.add("element 2");
queue.add("element 3");

boolean isContain = queue.contains("element 3"); 
```

----
### 크기

queue 크기를 구한다.

```java
int size = queue.size();
```

----
### List <-> Stack 변환

List와 Queue 간 변환 코드다.
이 밖에 stream을 사용할 수 있다. 

```java
List<String> list = new ArrayList<>(queue);
```
----