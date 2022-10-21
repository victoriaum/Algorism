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
            1번째 제출풀이(firstSolution):
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
