## Stack

----
### 개요
Stack은 List의 구현체다. Stack의 특징은 아래와 같다.<br>

1. 마지막으로 들어가는 요소가 가장 앞 순번(index)에 삽입(push)된다.
2. 요소를 꺼내고자 하는 경우(pop) 가장 마지막에 삽입된 요소를 꺼낸다.

혹은 List처럼 요소들의 순환이 가능하다.

----
### 생성

Stack은 아래와 같이 생성가능하다. List 구현체이기 때문에 자료형을 List로 지정할 수도 있다.<br>

```java
Stack stack = new Stack();
Stack<Integer> intStack = new Stack<>();
List stackWithList = new Stack();
```

----
### 추가

요소를 추가는 push() 메소드를 사용한다.

```java
Stack<String> stack = new Stack<>();
stack.push("A");
stack.push("B");
stack.push("C");
```

----
### 꺼내기

pop() 메소드를 이용해 마지막 요소를 꺼낸다.
pop()은 마지막 요소를 꺼내오기 때문에 stack의 마지막 요소는 제거된다.

내부에 요소가 없는 경우 EmptyStackException을 발생시킨다.

```java
String ele = stack.pop(); //C
```

----
### 최근 요소 탐색

peek() 메소드를 이용해 최신 요소를 확인한다.

```java
String peek = stack.peek(); //B
```

내부에 요소가 없는 경우 EmptyStackException을 발생시킨다.


----
### 탐색

stack 내부의 요소를 탐색한다. 
요소 값이 있는 경우 해당 index를, 없는 경우 -1을 반환한다.

```java
Stack<String> stack = new Stack<String>();

stack.push("1");
stack.push("2");
stack.push("3");

int index = stack.search("3");     //index = 3
```

----
### 크기

stack의 크기를 구한다.

```java
int size = stack.size();        //size = 3
```

----
### List <-> Stack 변환

List와 Stack 간 변환 코드다.

```java
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
```


----