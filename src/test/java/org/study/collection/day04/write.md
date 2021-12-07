## Map

----
### 개요
Map은 Collection의 구현 인터페이스 중 하나이다.<br>
Map은 HashMap, Hashtable, EnumMap, TreeMap, Properties, LinkedHashMap 등이 있고
대표적으로 HashMap, TreeMap이 주로 사용된다.<br>
Map은 key, value로 데이터를 저장한다.<br>
내부적으로 순서가 보장되지 않으며, 데이터에 대해 contain(), get() 시 Big O(1)의 성능을 보장하므로 조회에 특화된 컬렉션이라고 할 수 있다.<br> 
자바를 개발하면서 ArrayList와 더불어 가장 많이 사용하는 컬렉션이라고 생각한다.<br>


----
### Map의 생성과 추가

```java
// Generic 미적용
Map mapA = new HashMap();
        Map mapB = new TreeMap();

// Generic 적용
Map<String, String> map = new HashMap<>();
```

데이터 추가는 put()을 사용한다. 만약 중복된 key로 한번 put을 한다면 마지막 값으로 대체된다.
```java
Map<String, String> map = new HashMap<>();

map.put("key1", "element 1");
map.put("key2", "element 2");
map.put("key3", "element 3");
```

특이하게도 key에 null값을 넣을 수 있다.

```java
map.put("key1", "element 1");
map.put("key2", "element 2");
map.put("key3", "element 3");

map.put(null, "null element");

Assertions.assertEquals( "null element", map.get(null));
```

putAll()을 사용하면 모든 값을 대상 Map에 넣는다.
```java
Map<String, String> mapA = new HashMap<>();
mapA.put("key1", "value1");
mapA.put("key2", "value2");

Map<String, String> mapB = new HashMap<>();
mapB.put("key3", "value3");
mapB.putAll(mapA);

mapB.entrySet().stream().forEach(System.out::println);
/*
    key1=value1
    key2=value2
    key3=value3
*/
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
### Map 조회
```java
Map<String, String> map = new HashMap<>();

map.put("A", "1");
map.put("B", "2");
map.put("C", "3");

boolean hasKey = map.containsKey("A");
assertTrue(hasKey);

boolean hasValue = map.containsValue("1");
assertTrue(hasValue);
```


----
### Map 정렬

Map의 정렬은 TreeMap을 이용하여 정렬하면 수월하다.<br>
TreeMap은 데이터를 put할때 마다 자체적으로 정렬을 수행하기 때문이다.<br>
정렬의 경우 List, Set으로 해도 되고 Compartor를 구현해도 되고 방법은 많으니 참고..

```java
Map<String, Integer> map = new HashMap<>();

map.put("C", 1);
map.put("B", 1);
map.put("A", 1);

// 기본적으로 Key를 오름차순 함
Map<String, Integer> sortedMap = new TreeMap<>(map);
sortedMap.forEach((k, v) -> {
    System.out.println(k + " : " + v);
});
```

----
### 마치며
Map은 Key, Value로 데이터를 저장하는 컬렉션이다. 특정 KEY에 해당하는 VALUE를 부여하는 특성 상
많이 이용하고 있다.
