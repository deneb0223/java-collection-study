## Deque

----
### 개요
 Queue를 구현한 인터페이스 Deque는 Queue와 다른 특성이 있다.<br>

1. Deque는 기본적으로 Queue와 동일하게 FIFO(First In First Out)를 준수한다.
2. Deque는 Queue에 추가적으로 tail 부분에 있는 요소를 poll/peek이 가능하다.

요약하자면 Queue의 특성을 토대로 Stack의 기능이 가미된 컬렉션이다.<br>

----
### 생성

Deque로 선언할 수 있는 인스턴스는 LinkedList, ArrayDeque가 있다.<br>

```java
Deque<String> deque = new LinkedList<>();
Deque<String> deque1 = new ArrayDeque<>();
```

----
### 추가
```java
Deque<String> deque = new LinkedList<>();
deque.add("1");

deque.addLast("2");
deque.addLast("3");     // tail
deque.addFirst("4");    // head

deque.offer("1");
deque.offerLast("3");
deque.offerFirst("4");

deque.push("100");      // addFirst, offerFirst와 동일함
```

----
### 최상단 요소 접근 (peeK)

```java
int firstEl = deque.peekFirst();
int lastEl = deque.peekLast();
```

----
### 요소 제거

remove 역시 first/last 요소를 지정하여 제거할 수 있다.<br>
여타 컬랙션과 더불어 제거할 요소가 없을 경우 null / 예외를 반환하는 기능이  나누어져있다.<br>

```java
Deque<Integer> deque = new LinkedList<>();
for (int i = 1; i <= 10; i++) {
    deque.add(i);
}

int removedElement = deque.remove();
System.out.println("removedElement : " + removedElement);

int removedFirstElement = deque.removeFirst();
System.out.println("removedFirstElement : " + removedFirstElement);

int removedLastElement = deque.removeLast();
System.out.println("removedLastElement : " + removedLastElement);

// return null
int pollElement = deque.poll();
System.out.println("pollElement : " + removedElement);

int pollFirstElement = deque.pollFirst();
System.out.println("pollFirstElement : " + pollFirstElement);

int pollLastElement = deque.removeLast();
System.out.println("pollLa
```