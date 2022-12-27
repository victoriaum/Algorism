package programmers.kit.Heap;

import java.util.*;

// 힙 - 이중우선순위큐
public class DualPriorityQueue {
    public static void main(String[] args) {
        // 1. [최대값, 최소값]을 출력하는 문제
        // 2. 명령어	수신 탑(높이)
        //      I 숫자	큐에 주어진 숫자를 삽입합니다.
        //      D 1	큐에서 최댓값을 삭제합니다.
        //      D -1	큐에서 최솟값을 삭제합니다.

        /* 테스트 케이스 */
        //String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        // 정답: [0,0]

        String[] operations = {"I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1"};
        // 정답: [40,40]

        System.out.println(solution(operations));  // 통과
        System.out.println(trial2(operations));    // 정확성 66.7%
        System.out.println(trial(operations));     // 우선순위 큐와 반대의 경우 큐 설정하는 법 봐두기!
    }

    private static int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        for(String str: operations){
            String[] arr = str.split(" ");
            if("I".equals(arr[0])){
                list.add(Integer.parseInt(arr[1]));
            }else{
                if(list.size()>0){
                    if("-1".equals(arr[1])) list.remove(0);
                    else list.remove(list.size()-1);
                }
            }
            Collections.sort(list);                 // 정렬위치 정하는 위치 주의!
        }
        answer[0] = list.size()>0? list.get(list.size()-1) : 0;
        answer[1] = list.size()>0? list.get(0) : 0;
        return answer;
    }

    private static int[] trial2(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        for(String str: operations){
            String[] arr = str.split(" ");
            Collections.sort(list);
            if("I".equals(arr[0])){
                list.add(Integer.parseInt(arr[1]));
            }else{
                if(list.size()>0){
                    if("-1".equals(arr[1])) list.remove(0);
                    else list.remove(list.size()-1);
                }
            }
        }
        answer[0] = list.size()>0? list.get(list.size()-1) : 0;
        answer[1] = list.size()>0? list.get(0) : 0;
        return answer;
    }

    private static int[] trial(String[] operations) {
        int[] answer = new int[2];

        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(String str: operations){
            String[] arr = str.split(" ");
            if("I".equals(arr[0])){
                queue.offer(Integer.parseInt(arr[1]));
                reverseQueue.offer(Integer.parseInt(arr[1]));
            }else{
                if("-1".equals(arr[1])) queue.poll();
                else reverseQueue.poll();
            }
        }

        answer[1] = queue.size()!=0? queue.poll() : 0;
        answer[0] = reverseQueue.size()!=0? reverseQueue.poll() : 0;

        return answer;
    }
}
