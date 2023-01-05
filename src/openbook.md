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

#### 프로그래머스 - (정렬)가장 큰 수 
+ 주어진 수를 뒤에서부터 비교 나열하는 방법
+ 모두 '0'의 값을 가지는 경우의 고려
```
Arrays.sort(num, new Comparator<String>(){
    @Override
    public int compare(String n1, String n2) {
        return (n2+n1).compareTo(n1+n2);
    }
});

// System.out.println(solution(new int[]{3, 30, 34, 5, 9}));     // "9534330"
```