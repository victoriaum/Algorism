package programmers.kit.Heap;

import java.util.*;

// 힙 - 더 맵게
public class _MoreSpicy {
    public static void main(String[] args) {
        // 1. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
        // 2. 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // 3. 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.


        /* 테스트 케이스 */

        //int[] scoville = {1, 2, 3, 9, 10, 12};
        //int K = 7;
        // 정답: 2

        //int[] scoville = {8, 10, 11};
        //int K = 7;
        // 정답: 0

        //int[] scoville = {1,2,3};
        //int K = 11;
        // 정답: -1

        int[] scoville = {1,2,3};
        int K = 5;
        // 정답: 2


        System.out.println(solution(scoville, K));  // 통과
        System.out.println(others(scoville, K));    // 정확성 80%, 다른 사람 풀이
        System.out.println(trial2(scoville, K));    // 정확성 50%, 효율성 실패
        System.out.println(trial(scoville, K));     // 정확성, 효율성 실패
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int s : scoville){
            heap.offer(s);
        }
        while (heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();
            int result = a + (b * 2);
            heap.offer(result);
            answer ++;
        }
        return answer;
    }

    // 우선순위 큐를 이용한 풀이
    private static int others(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int s : scoville){
            heap.offer(s);
        }
        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();
            int result = a + (b * 2);
            heap.offer(result);
            answer ++;
        }
        return answer;
    }

    private static int trial2(int[] scoville, int K) {
        int answer = 0;
        int new_num;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(scoville);
        for(int s : scoville){
            list.add(s);
        }
        if(scoville[scoville.length-1] + scoville[scoville.length-2]*2 < K) return -1;

        while(list.get(0)<K){
            new_num = list.get(0) + list.get(1)*2;
            list.remove(0);
            list.remove(0);
            list.add(new_num);
            Collections.sort(list);
            answer++;
        }

        return answer;
    }

    private static int trial(int[] scoville, int K) {
        int answer = 0;
        int new_num;
        List<Integer> list = new ArrayList<>();
        for(int s : scoville){
            list.add(s);
        }

        while(list.get(0)<K){
            new_num = list.get(0) + list.get(1)*2;
            list.remove(0);
            list.remove(0);
            list.add(0, new_num);
            Arrays.sort(scoville);
            answer++;
        }

        return answer;
    }
}
