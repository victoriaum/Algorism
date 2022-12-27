package programmers.kit.StackQueue;

import java.util.*;

// 스택/큐 - 기능개발
public class _FunctionDevelopment {
    public static void main(String[] args) {
        // 진행도 %와 1일당 개발되는 진행도 %가 주어진다고 할 때, 배포시 배포되는 기능의 수를 출력하는 문제
        // 진행도는 총 100%가 되었을 때 배포되며, 뒤에 진행도가 100%가 되어도 앞의 진행도가 100%이 되어야 같이 배포될 수 있다.
        // *** 뒷 작업이 작업도가 많이 필요하다면 앞에 작업만 배포한다.

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        //int[] progresses = {95, 90, 99, 99, 80, 99};
        //int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(solution(progresses, speeds));  // 다른 사람 풀이
        //System.out.println(trial(progresses, speeds));
    }

    private static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] remainDays = new int[progresses.length];

        int day;
        for(int i=0; i<progresses.length; i++){
            day = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) day++;
            remainDays[i] = day;
        }

        int cnt =  0, index = 0;

        return answer;
    }

    private static List<Integer> trial(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] remainDays = new int[progresses.length];

        int day;
        for(int i=0; i<progresses.length; i++){
            day = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) day++;
            remainDays[i] = day;
        }

        int cnt =  0, index = 0;

        return answer;
    }
}
