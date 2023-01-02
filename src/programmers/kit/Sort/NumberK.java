package programmers.kit.Sort;

import java.util.*;

// 정렬 - K번째수
public class NumberK {
    public static void main(String[] args) {
        // 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution(array, commands));            // [5,6,3]
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] real = array;
        int i=0;

        for(int[] arr : commands){
            array = Arrays.copyOfRange(array, arr[0]-1, arr[1]);
            Arrays.sort(array);
            answer[i] = array[arr[2]-1];
            i++;
            array = real;
        }
        return answer;
    }
}