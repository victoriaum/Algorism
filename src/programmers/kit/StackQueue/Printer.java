package programmers.kit.StackQueue;

import java.util.*;

// 스택/큐 - 프린터
public class Printer {
    public static void main(String[] args) {
        // 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
        // 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
        // 3. 그렇지 않으면 J를 인쇄합니다.

        //int[] progresses = {2, 1, 3, 2};
        //int location = 2;

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));  // 우선순위 큐 - PriorityQueue
        System.out.println(trial(priorities, location));     // 런타임에러 발생
    }

    private static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }

    private static int trial(int[] priorities, int location) {
        List<Integer> origin = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int value = priorities[location];
        for(int i=0; i<priorities.length; i++){
            origin.add(priorities[i]);
            list.add(i==location? 0 : priorities[i]);
        }

        int cnt = 0;
        while(true){
            // System.out.println(list);
            int removed = list.get(0);
            int compare = list.get(0);
            if(compare==0) compare=value;

            origin.remove(0);
            list.remove(0);
            if(compare >= Collections.max(origin)){
                cnt++;
                if(removed==0) break;
            }else{
                if(removed==0) list.add(0);
                else list.add(compare);
                origin.add(compare);
            }
        }

        return cnt;
    }
}
