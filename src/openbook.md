## Algorithm Openbook

### 형변환
```java
// Array to List
Arrays.asList(arr);

// List to Array
list.toArray(new String[list.length]);        
        
// List를 int[]로 출력하게 변환
answer.stream().mapToInt(i -> i).toArray();
```
 
#### PriorityQueue 우선순위 큐
```java
PriorityQueue<Integer> heap = new PriorityQueue();
heap.offer(value);  // 추가
heap.poll(); // 가장 작은 값을 빼고, 제거
heap.peek(); // 가장 작은 값을 출력

Queue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());  // 내림차순 우선순위 큐
```

