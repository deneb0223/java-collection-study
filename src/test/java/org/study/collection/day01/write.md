### 자바 컬렉션(Collection) API란?
Collection은 자바에서 다루는 데이터 형태(List, Map, Set 등)들을 지원하는 프레임워크이다.<br>
Collection에 앞서 자바 혹은 다른 프로그래밍 언어에서 자료를 저장하는데 있어 대표적인 자료구조이다.<br>

배열(Array)은 많은 데이터를 담을 수 있는 자료구조이다. 다양한 언어에서 기본적으로 사용하고 있다.
배열은 기본적으로 타입과 크기를 지정하여 사용한다.
```java
@Test
void array() {
    int[] arr = new int[10];
    for (int i : arr) {
        System.out.println(i); // 0, 0, 0...
    }
}
```
*배열을 선언하여 자료를 저장한다*


하지만 배열은 몇 가지 단점이 존재하는데..<br>
1. 자료를 저장하는 공간을 유연하게 지정하기 어려움
2. 다양한 형태의 자료구조 처리에 대한 어려움

이 존재한다.

```java
@Test
void array2() {
    String[] names = new String[]{"lee", "kim", "park"};
    String newName = "yoo"; // names에 새로운 name이 들어가야한다면?
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
        names[3] = newName; // ArrayIndexOutOfBoundsException 발생
    });
}
```
```java
@Test
void someStrangeData() {
    // 사과는 빨갛다. 이 두가지의 의미를 묶어서 저장하고 싶다면
    String fruit = "APPLE";
    String color = "RED";
}

위의 경우도 Fruit이라는 객체를 만들어서 Fruit을 담는 배열에 저장하면 되겠지만..
객체를 만드는 것은 관리가 늘어나는 번거러움이 존재한다.
```

다행히도 자바에서는 이러한 어려움을 지원해주는 컬렉션프레임워크(Collection Framework)가 있다. <br>
Collection을 구현한 클래스로는 List, Set, Map, Queue, Stack등이 존재한다.

```java
public interface List<E> extends Collection<E> {
// Query Operations
```
실제 List 등의 구현 구조를 보면 Collection은 시작으로 구현되어 있으며 Iteratable(순환가능한 구조)을 가지는 특징이 있다.<br>

```java
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
```
<br>
물론 Collection이 배열에서 벗어난 자료형은 아니다.<br>
Collection은 배열을 토대로 배열의 단점들을 극복한 것이지, 실제로 저장되는 형태는 배열을 기반으로 한다.<br>
아래는 ArrayList에서 add를 한 경우 실행되는 grow 메소드이다.<br>
데이터를 추가할 때 특정 조건에 부합하는 경우 배열의 크기를 늘려 저장공간을 확보하는 모습을 볼 수 있다.<br>

```java
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```
<br>
요약하자면 Collection은 기존의 자료구조(array)가 가지고 있는 단점을 극복하기 위해 만들어진 자료구조들 제공하는
Java의 프레임워크다.<br>

개발자는 