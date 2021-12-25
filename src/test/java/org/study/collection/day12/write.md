## PriorityQueue

----
### 개요
 PriorityQueue는 Queue의 구현체다. 이름에서 알다시피 내부요소들에 대한 우선순위를 정할 수 있다.


----
### 생성

자료형은 Queue, PriorityQueue로 지정할 수 있다.
```java
Queue<Integer> queue = new PriorityQueue<>();
PriorityQueue<Integer> listWithQueue = new PriorityQueue<>();
```

----
### 삽입/삭제

Queue와 비슷하므로 생략


----
### 내보내기

PriorityQueue의 특징은 poll()을 할 때 있다.
일반 Queue는 poll을 할 때 가장 처음들어온(tail에 있는) 요소를 내보낸다.
반면, PriorityQueue는 어떠한 요소를 poll할지 우선순위를 정할 수 있다.

```java
Queue<Integer> queue = new PriorityQueue<>();
queue.add(1);queue.add(2);queue.add(3);queue.add(4);
queue.poll();// 1
```
별도의 정렬 기준(Comparator)를 정하지 않으면 우선순위가 가장 낮은 값이 내보내진다.

```java
Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
queue.add(1);queue.add(2);queue.add(3);queue.add(4);
queue.poll();// 4
```
우선순위를 거꾸로 지정하면 가장 우선순위가 높은 값이 내보내진다.
이때, queue의 내부 값을 출력해보면 poll을 하기 전 정렬기준을 바탕으로 
미리 정렬 되어 있음을 확인할 수 있다.

```java
Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
queue.add(1);queue.add(2);queue.add(3);queue.add(4);
System.out.println(queue);
```

