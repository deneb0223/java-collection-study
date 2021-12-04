## List
----
### 개요
List는 Collection을 상속받아 List의 기능을 구현한 인터페이스다.
List의 구체적인 구현체에는 ArrayList, LinkedList, Vector, Stack 등이 있다.

```java
// List는 인터페이스다. List는 List 구현체를 생성자로 선언할 수 있다.
List arrayList = new ArrayList();
// ArrayList로 형(type)을 지정하여 선언해도 되지만..
// 인터페이스가 지닌 다형성을 버리기 때문에 선언은 List로 하는 것이 좋다
// 예외적으로 이 변수는 무조건 ArrayList의 형태만 가능하게 하는 경우에는 고려해봄직하다
ArrayList myList = new ArrayList();
List linkedList = new LinkedList();
List vector = new Vector();
List stack = new Stack();
```
----
### 특성
List는 개인적인 생각으로 가장 Array에 가까운 컬렉션이라고 생각한다.<br>

List가 가지는 특징은 아래와 같다.
1. List 내부의 요소들은 순서를 가진다. (0번 index에서 시작하여 n까지)
2. List는 null, 다양한 Oboject 형태를 넣을 수 있다.

```java
// 들어오는 순서대로 index가 부여된다
List multiTypes = new ArrayList();
while (multiTypes.size() <= 10) {
    multiTypes.add(random.nextInt(100));
}
System.out.println(multiTypes); // [82, 25, 36, 85, 54, 14, 19, 70, 77, 50, 70]
```

```java
List elements = new ArrayList();
elements.add(1);        //Integer
elements.add(2L);       //Long
elements.add(3.2F);     //Float
elements.add(6.443D);   //Double
elements.add('c');      //Character
elements.add("Bye");    //String
elements.forEach(ele -> {
System.out.println(ele + " : " + ele.getClass().getSimpleName());
});
```
위의 코드 처럼 List에는 다양한 형태를 추가할 수 있다.<br><br>

추가적으로, List뿐 아니라 Collection의 구현체들은 내부에 참조타입으로 저장된다.<br>
일반적으로 원시타입으로 데이터를 추가하거나 수정하는데 이때 원시타입은 참조타입(정확히는 Wrapper클래스들로)으로 자동변환(auto-boxing)
한다.<br>
즉, Collection은 내부 데이터를 객체타입으로 가지고 있는 것이다.<br>
따라서 이후 사이트에서 언급되겠지만 정렬, 동일한 값 비교들을 Object 클래스의 매소드(equals, compare)들을 가지고 수행하는 것이다.

### 제너릭(Generic) 관련
다양한 형태를 List에 넣을 수 있는 것은 분명한 장점이 있을 것이다.<br>
하지만 다양한 형태는 코드를 보는 사람에게 하여금 혼란을 일으킨다.<br>
아래의 코드를 보자
```java
// 정수타입만 저장하는 List를 생성하였다
List onlyInteger = new ArrayList();
onlyInteger.add(1);

// 하지만 누군가 소수타입을 넣었다
onlyInteger.add(7.5f);

System.out.println(onlyInteger);    //[1, 7.5]
```
문법적으로 오류는 없고 정상 동작하지만 의도와 빗나간 모습이다.
onlyInteger를 사용하는 개발자들이 모두 정수형만 넣는다고 인지하면 문제는 없겠지만..<br>
근본적인 해결방안은 될 수 없다. 다행히도 Java 5부터 제너릭(Generic)이라는 개념이 도입되어
컴파일러에게 자료의 형태 지정을 알리는 방법이 생겼다.<br>
```java
List<Character> onlyCharacter = new ArrayList<Character>();
onlyCharacter.add('h');
onlyCharacter.add(1);   
//add(java.lang.Character)' in 'java.util.List' cannot be applied to Integer 컴파일러 에러 발생!
```
위와 같이 제너릭을 지정한다면 컴파일러가 미리 에러를 발생시키기 때문에
어플리케이션 동작 전에 미리 혼란을 방지할 수 있다. 자바 7이후로는 new 연산자의 제너릭 타입을 생략할 수 있다.
이를 다이아몬드 연산자라고 칭하고 있다.<br>
```java
List<Double> onlyDouble = new ArrayList<>();
// new 연산자의 제너릭을 공란처리해도 컴파일러는 선언부의 제너릭 타입을 참고하여
// 형태를 추론하기 때문이다
```

이 모든 것을 무시하고 다양한 형태를 List에 담고자하는 경우 컴파일러에게 이를 알려주는 것이 중요한데
컴파일러는 다양한 형태를 사용하는 변수에 대해 경고성 메세지를 알리기 때문에 컴파일러에게 이를 무시하게 처리해주는 것이 좋다.<br>
```java
@SuppressWarnings({"rawtypes"}) //rawtypes은 타입이 지정되지 않는 것을 의미
List types = new ArrayList();
types.add(1);
types.add(1.2f);
```

----
### 기능 (Study2에 구현)
1. 추가
2. 삭제
3. 정렬
4. 순환