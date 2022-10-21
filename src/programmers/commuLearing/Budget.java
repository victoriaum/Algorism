package programmers.commuLearing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Budget {
    public static void main(String[] args){
        /*
            1번째 제출풀이(mySolution_1):
                정확성: 100.0 / 100.0
        */

        // d는 부서별로 신청한 예산, budget은 전체 예산
        // 여기서 예산 중 최대 몇 개의 부서를 지원 가능한지 도출

        // case1
        int[] d = {1,2,3,4,5};
        int budget = 9;

        // case2
//        int[] d = {2,2,3,3};
//        int budget = 10;

        System.out.println( mySolution_1(d, budget) );
        //System.out.println( teacherSolution_1(d, budget) );
    }

    // 강의문제가 다름..
    private static int teacherSolution_1(int[] budgets, int M) {
        int min = 0;
        int max = 0;
        for(int b: budgets){
            if(b>max) max = b;
        }

        int answer = 0;
        while(min<=max){
            int mid = (min+max) / 2;
            int sum = 0;
            for(int b: budgets){
                if(b>mid) sum += mid;
                else sum += b;
            }
            if(sum<=M){
                min = mid + 1;
                answer = mid;
            }else{
                max = mid - 1;
            }
        }

        return answer;
    }

    private static int mySolution_1(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for(int i : d){
            if(budget - i >= 0){ budget = budget - i; }
            else{ break; }
            answer++;
        }

        return answer;
    }
}
